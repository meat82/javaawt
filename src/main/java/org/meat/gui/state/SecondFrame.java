package org.meat.gui.state;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.meat.gui.AWTProgram;
import org.meat.gui.actions.ButtonBackAction;
import org.meat.gui.factory.AbstractFrameFactory;
import org.meat.gui.factory.SecondFrameFactory;

public class SecondFrame implements FrameState {

	private static final String HEADER_LABEL = "Second Frame";
	private static final String STATUS_LABEL = "SECOND FRAME STATUS";
	private static final String BACK_BUTTON_LABEL = "Back";
	private JFrame frame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JButton backButton;
	private AbstractFrameFactory frameFactory;
	private AWTProgram program;
	private JTextField textField1;
	private JLabel labelField1;

	public SecondFrame(JFrame frame, AWTProgram program) {
		this.frame = frame;
		this.frameFactory = new SecondFrameFactory(frame);
		this.program = program;
	}

	public JFrame changeFrame() {
		
		frame.setVisible(false);
		Point point = frame.getLocation();
		
		frame = frameFactory.createFrame();
		frame.setLocation(point);
		
		headerLabel = frameFactory.createLabel(HEADER_LABEL);

		statusLabel = frameFactory.createLabel(STATUS_LABEL);
		statusLabel.setSize(350, 100);

		controlPanel = frameFactory.createPanel();
		
		backButton = frameFactory.createButton(BACK_BUTTON_LABEL);
		backButton.addActionListener(new ButtonBackAction(frame,this.program));
		
		
		textField1 = frameFactory.createTextField("Name");
		textField1.setColumns(6);
		labelField1 = frameFactory.createLabel("Name: ");
		
		controlPanel.add(backButton);

		frame.add(headerLabel);
		frame.add(controlPanel);
		frame.add(statusLabel);

		return frame;
	}

}
