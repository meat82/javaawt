package org.meat.gui.factory;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import org.meat.gui.actions.ButtonOKAction;

public abstract class AbstractFrameFactory {

	public AbstractFrameFactory() {
		
	}
	public abstract Frame createFrame();
	
	public Button createButton(String label) {
		Button button = new Button(label);
		button.setActionCommand(label);
		button.setLabel(label);
		return button;
	}
	
	public abstract Panel createPanel();
	
	public Label createLabel(String text) {
		Label label = new Label(text);
		return label;
	}

}
