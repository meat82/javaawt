package org.meat.gui.state;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.meat.gui.AWTProgram;
import org.meat.gui.actions.ButtonNextFrame;
import org.meat.gui.actions.ButtonOKAction;
import org.meat.gui.actions.ButtonSubmitAction;
import org.meat.gui.factory.InitFrameFactory;

public class InitFrame implements FrameState {

	private static final String OK = "OK";
	private static final String SUBMIT = "Submit";
	private static final String NEXT = "Next";
	private JFrame frame;
	private JFrame currentFrame;
	private JLabel headerLabel;
	private JLabel footer;
	private JPanel controlPanel;
	private JButton okButton;
	private JButton submitButton;
	private JButton nextButton;
	private AWTProgram program;
	private InitFrameFactory frameFactory;

	public InitFrame(AWTProgram program) {
		this.program = program;
		frameFactory = new InitFrameFactory();
	}

	public InitFrame(AWTProgram program, JFrame frame) {
		this.program = program;
		frameFactory = new InitFrameFactory(frame);
		this.frame = frame;
	}

	public InitFrame(AWTProgram program, JFrame previousFrame, JFrame currentFrame) {
		this.program = program;
		this.frame = previousFrame;
		this.currentFrame = currentFrame;

	}

	public JFrame changeFrame() {
		if (frame != null) {
			currentFrame.setVisible(false);
			Point point = currentFrame.getLocation();
			Dimension dimension = currentFrame.getSize();
			frame.setLocation(point);
			frame.setSize(dimension);
			frame.setVisible(true);

		} else {
			frame = frameFactory.createFrame();

			headerLabel = frameFactory.createHeaderLabel();
			footer = frameFactory.createFooterLabel();

			controlPanel = frameFactory.createPanel();

			okButton = frameFactory.createButton(OK);
			submitButton = frameFactory.createButton(SUBMIT);
			nextButton = frameFactory.createButton(NEXT);
			okButton.addActionListener(new ButtonOKAction());
			submitButton.addActionListener(new ButtonSubmitAction(this));
			nextButton.addActionListener(new ButtonNextFrame(frame, program));

			controlPanel.add(okButton);
			controlPanel.add(submitButton);
			controlPanel.add(nextButton);

			frame.add(headerLabel);
			frame.add(controlPanel);
			frame.add(footer);
		}
		return frame;
	}

}
