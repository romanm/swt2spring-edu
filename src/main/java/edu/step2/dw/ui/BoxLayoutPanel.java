package edu.step2.dw.ui;

import java.awt.Component;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BoxLayoutPanel extends JPanel{
	private List<Component> panelComponents;
	private int axis;

	public void setAxis(int axis) {
		this.axis = axis;
	}

	public void setPanelComponents(List<Component> panelComponents) {
		this.panelComponents = panelComponents;
	}

	public void init() {
		setLayout(new BoxLayout(this, axis));
		for (Component component : panelComponents) 
			add(component);
	}
}
