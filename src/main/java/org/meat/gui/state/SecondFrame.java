package org.meat.gui.state;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import org.meat.gui.actions.ButtonOKAction;
import org.meat.gui.actions.WindowClose;

public class SecondFrame implements FrameState {

	
	private Frame frame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public SecondFrame(Frame frame) {
		this.frame = frame;
	}

	public Frame changeFrame() {

		frame.removeAll();
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(3, 1));
		frame.addWindowListener(new WindowClose());

		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		headerLabel.setText("SECOND FRAME");

		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350, 100);
		statusLabel.setText("SECOND FRAME STATUS");

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		Button backButton = new Button("Back");

		backButton.setActionCommand("Back");

		backButton.addActionListener(new ButtonOKAction());

		controlPanel.add(backButton);

		frame.add(headerLabel);
		frame.add(controlPanel);
		frame.add(statusLabel);
		
		return frame;
	}

}
