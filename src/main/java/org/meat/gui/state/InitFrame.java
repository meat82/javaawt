package org.meat.gui.state;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.meat.gui.AWTProgram;
import org.meat.gui.actions.ButtonNextFrame;
import org.meat.gui.actions.ButtonOKAction;
import org.meat.gui.actions.ButtonSubmitAction;
import org.meat.gui.factory.AbstractFrameFactory;
import org.meat.gui.factory.InitFrameFactory;

public class InitFrame implements FrameState {

	private static final String HEADER_LABEL = "AWESOME PROGRAM";
	private static final String STATUS_LABEL = "STATUS";
	private static final String OK = "OK";
	private static final String SUBMIT = "Submit";
	private static final String NEXT = "Next";
	private JFrame frame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JButton okButton;
	private JButton submitButton;
	private JButton nextButton;
	private AWTProgram program;
	private AbstractFrameFactory frameFactory;

	public InitFrame(AWTProgram program) {
		this.program = program;
		frameFactory = new InitFrameFactory();
	}
	public InitFrame(AWTProgram program, JFrame frame) {
		this.program = program;
		frameFactory = new InitFrameFactory(frame);
		this.frame = frame;
	}
	public JFrame changeFrame() {
		frame = frameFactory.createFrame();
		
		headerLabel = frameFactory.createLabel(HEADER_LABEL);
		//headerLabel.setAlignment(Label.CENTER);

		statusLabel = frameFactory.createLabel(STATUS_LABEL);
		//statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350, 100);

		controlPanel = frameFactory.createPanel();

		okButton = frameFactory.createButton(OK);
		submitButton = frameFactory.createButton(SUBMIT);
		nextButton = frameFactory.createButton(NEXT);

		okButton.addActionListener(new ButtonOKAction());
		submitButton.addActionListener(new ButtonSubmitAction());
		nextButton.addActionListener(new ButtonNextFrame(frame,program));

		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(nextButton);

		frame.add(headerLabel);
		frame.add(controlPanel);
		frame.add(statusLabel);
		return frame;
	}

}
