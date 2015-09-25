package org.meat.gui.state;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import org.meat.gui.actions.ButtonOKAction;
import org.meat.gui.factory.AbstractFrameFactory;
import org.meat.gui.factory.SecondFrameFactory;

public class SecondFrame implements FrameState {

	private static final String HEADER_LABEL = "Second Frame";
	private static final String STATUS_LABEL = "SECOND FRAME STATUS";
	private static final String BACK_BUTTON_LABEL = "Back";
	private Frame frame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private Button backButton;
	private AbstractFrameFactory frameFactory;

	public SecondFrame(Frame frame) {
		this.frame = frame;
		this.frameFactory = new SecondFrameFactory(frame);
	}

	public Frame changeFrame() {
		frame = frameFactory.createFrame();

		headerLabel = frameFactory.createLabel(HEADER_LABEL);

		headerLabel.setAlignment(Label.CENTER);

		statusLabel = frameFactory.createLabel(STATUS_LABEL);

		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350, 100);

		controlPanel = frameFactory.createPanel();

		backButton = frameFactory.createButton(BACK_BUTTON_LABEL);

		backButton.addActionListener(new ButtonOKAction());

		controlPanel.add(backButton);

		frame.add(headerLabel);
		frame.add(controlPanel);
		frame.add(statusLabel);

		return frame;
	}

}
