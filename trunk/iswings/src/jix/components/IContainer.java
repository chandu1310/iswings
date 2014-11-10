package jix.components;

import java.awt.Component;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jix.components.IConstants.CompType;
import jix.components.IConstants.EventType;
import jix.core.JIXMessage;
import jix.core.JIXRMITarget;
import jix.core.UIUtils;

public interface IContainer extends IComponent{

	public Component add(IComponent comp);
	
	public Component add(IComponent comp, int index);
	
	public void add(IComponent comp, Object constraints);
	
	public void add(IComponent comp, Object constraints, int index);
	
	public class IContainerBase implements JIXRMITarget {
		private String ID;
		private Map<IConstants.CompType, List<IComponent>> _typeToComponentsMap;
		private IComponent _focussedComponent = null;

		public IContainerBase(String ID) {
			this.ID = ID.toUpperCase();
			this._typeToComponentsMap = new HashMap<IConstants.CompType, List<IComponent>>();
			
			try{
			JIXRMITarget stub = (JIXRMITarget) UnicastRemoteObject.exportObject(this, 0);
			Naming.rebind(this.ID, stub);
			}catch(Exception er){
				System.err.println("JIX: Unable to bind application window for JIX functionality.");
				er.printStackTrace();
			}
		}

		public String getID() {
			return this.ID;
		}

		
		@Override
		public String invoke(JIXMessage message) throws RemoteException {
			IConstants.EventType event = EventType.ACTION;
			switch (message.getEventType()) {
			case 0:
				event = EventType.MOUSE;
				break;
			case 1:
				event = EventType.TEXT;
				break;
			case 2:
				event = EventType.DRAG;
				break;
			case 3:
				event = EventType.WINDOW;
				break;
			default:
				break;
			}
			dispatchEvent(message.getID(), event);
			return null;
		}
		
		public void dispatchEvent(String ID, IConstants.EventType event) {
			Set<IConstants.CompType> compTypes = _typeToComponentsMap.keySet();
			for(IConstants.CompType ct: compTypes){
				if(dispatchEvent(ct, ID, event))
					return;
			}			
		}

		public boolean dispatchEvent(IConstants.CompType compType, String ID,
				IConstants.EventType event) {
			IComponent comp = getComponentFromMap(compType, ID);
			if (comp != null && event != null) {
				boolean result = UIUtils.dispatchEvent(comp, event);
				if(result){
					this._focussedComponent = comp;
					return result;
				}				
			}
			return false;
		}

		private IComponent getComponentFromMap(IConstants.CompType compType,
				String ID) {
			if (ID != null && !"".equals(ID)) {
				List<IComponent> compsList = this._typeToComponentsMap
						.get(compType);
				if (compsList != null && !compsList.isEmpty()) {
					for (IComponent co : compsList) {
						if (co.getID().equalsIgnoreCase(ID))
							return co;
					}
				}
			}
			return null;
		}

		public void add(IComponent comp) {
			// super.add(comp.getComponent(), constraints, index);
			CompType compTypeValue = getCompType(comp);
			List<IComponent> compsList = this._typeToComponentsMap
					.get(compTypeValue);
			if (compsList == null)
				compsList = new ArrayList<IComponent>();
			compsList.add(comp);
			this._typeToComponentsMap.put(compTypeValue, compsList);
		}

		public void remove(IComponent comp) {
			// super.remove(comp.getComponent());
			CompType compTypeValue = getCompType(comp);
			List<IComponent> compsList = this._typeToComponentsMap
					.get(compTypeValue);
			if (compsList != null && !compsList.isEmpty()) {
				compsList.remove(comp);
				this._typeToComponentsMap.put(compTypeValue, compsList);
			}
		}

		private IConstants.CompType getCompType(IComponent comp) {
			IConstants.CompType compTypeValue;
			if (comp instanceof JButton) {
				compTypeValue = CompType.BUTTON;
			} else if (comp instanceof JTextField) {
				compTypeValue = CompType.TEXTFIELD;
			} else if (comp instanceof JTextArea) {
				compTypeValue = CompType.TEXTAREA;
			} else if (comp instanceof JComboBox) {
				compTypeValue = CompType.COMBOBOX;
			} else {
				compTypeValue = CompType.OTHER;
			}
			return compTypeValue;
		}
	}

}
