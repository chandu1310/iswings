package java.iswings.components;

import java.awt.Component;

import javax.swing.JFrame;


public final class IFrame extends JFrame implements IContainer {
	private static final long serialVersionUID = -9118121238720470863L;
	private String ID;
	private IContainer.IContainerBase _containerBase;
	public IFrame(String ID, String title) {
		super(title);
		this.ID = ID;
		this._containerBase = new IContainer.IContainerBase();
	}
	
	@Override
	public String getID() {
		return this.ID;
	}
	
	@Override
	public Component getComponent() {
		return this;
	}
	
	@Override
	public Component add(IComponent comp) {
		_containerBase.add(comp);
		return super.add(comp.getComponent());		
	}
	
	@Override
	public Component add(IComponent comp, int index) {
		_containerBase.add(comp);
		return super.add(comp.getComponent(), index);
	}
	
	@Override
	public void add(IComponent comp, Object constraints) {
		_containerBase.add(comp);
		super.add(comp.getComponent(), constraints);
	}
	
	@Override
	public void add(IComponent comp, Object constraints, int index) {
		_containerBase.add(comp);
		super.add(comp.getComponent(), constraints, index);
	}
}
