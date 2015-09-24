package org.meat.gui.state;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import org.meat.gui.AWTProgram;
import org.meat.gui.actions.ButtonNextFrame;
import org.meat.gui.actions.ButtonOKAction;
import org.meat.gui.actions.ButtonSubmitAction;
import org.meat.gui.actions.WindowClose;

public class InitFrame implements FrameState {

	private Frame frame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private AWTProgram program;

	public InitFrame(AWTProgram awtProgram) {
		program = awtProgram;
	}

	public Frame changeFrame() {
		frame = new Frame("Java AWT");
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(3, 1));
		frame.addWindowListener(new WindowClose());

		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		headerLabel.setText("AWESOME PROGRAM");

		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350, 100);
		statusLabel.setText("STATUS");

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		Button okButton = new Button("OK");
		Button submitButton = new Button("Submit");
		Button nextFrame = new Button("Next");

		okButton.setActionCommand("OK");
		submitButton.setActionCommand("Submit");
		nextFrame.setActionCommand("Next");

		okButton.addActionListener(new ButtonOKAction());
		submitButton.addActionListener(new ButtonSubmitAction());
		nextFrame.addActionListener(new ButtonNextFrame(frame,program));

		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(nextFrame);

		frame.add(headerLabel);
		frame.add(controlPanel);
		frame.add(statusLabel);
		return frame;
	}

}
