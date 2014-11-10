package jix.components;

import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.JFrame;


public final class IFrame extends JFrame implements IContainer {
	private static final long serialVersionUID = -9118121238720470863L;
	private IContainer.IContainerBase _containerBase;
	public IFrame(String ID, String title) {
		super(title);
		this._containerBase = new IContainer.IContainerBase(ID);
	}
	
	public String getID() {
		return this._containerBase.getID();
	}
	
	@Override
	public Component getComponent() {
		return this;
	}
	
	@Override
	public Component add(IComponent comp) {
		_containerBase.add(comp);
		return super.getContentPane().add(comp.getComponent());		
	}
	
	@Override
	public Component add(IComponent comp, int index) {
		_containerBase.add(comp);
		return super.getContentPane().add(comp.getComponent(), index);
	}
	
	@Override
	public void add(IComponent comp, Object constraints) {
		_containerBase.add(comp);
		super.getContentPane().add(comp.getComponent(), constraints);
	}
	
	@Override
	public void add(IComponent comp, Object constraints, int index) {
		_containerBase.add(comp);
		super.getContentPane().add(comp.getComponent(), constraints, index);
	}
}
