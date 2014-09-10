package java.iswings.components;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.iswings.components.IConstants.CompType;
import java.iswings.core.UIUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface IContainer extends IComponent {

	public Component add(IComponent comp);
	
	public Component add(IComponent comp, int index);
	
	public void add(IComponent comp, Object constraints);
	
	public void add(IComponent comp, Object constraints, int index);
	
	public class IContainerBase {
		private Map<IConstants.CompType, List<IComponent>> _typeToComponentsMap;
		private IComponent _focussedComponent = null;

		public IContainerBase() {
			this._typeToComponentsMap = new HashMap<IConstants.CompType, List<IComponent>>();
		}

		public void dispatchEvent(String ID, IConstants.EventType event) {

		}

		public void dispatchEvent(IConstants.CompType compType, String ID,
				IConstants.EventType event) {
			IComponent comp = getComponentFromMap(compType, ID);
			if (comp != null && event != null) {
				UIUtils.dispatchEvent(comp, event);
				this._focussedComponent = comp;
			}
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
