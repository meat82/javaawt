package org.meat.gui.factory;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class AbstractFrameFactory {

	public AbstractFrameFactory() {
		
	}
	public abstract JFrame createFrame();
	
	public JButton createButton(String label) {
		JButton button = new JButton(label);
		button.setActionCommand(label);
		button.setLabel(label);
		return button;
	}
	
	public abstract JPanel createPanel();
	
	public JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		return label;
	}
	public JTextField createTextField(String name) {
		JTextField textField = new JTextField();
		textField.setName(name);
		return textField;
	}

}
