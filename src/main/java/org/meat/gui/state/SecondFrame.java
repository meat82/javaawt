package org.meat.gui.state;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.meat.gui.AWTProgram;
import org.meat.gui.actions.ButtonBackAction;
import org.meat.gui.actions.ProcessAction;
import org.meat.gui.factory.AbstractFrameFactory;
import org.meat.gui.factory.SecondFrameFactory;

public class SecondFrame implements FrameState {

	private static final String BACK_BUTTON_LABEL = "Back";
	private static final String SUBMIT_BUTTON_LABEL = "Submit";
	private JFrame previousFrame;
	private JFrame currentFrame;
	private JLabel headerLabel;
	private JLabel footerLabel;
	private JPanel controlPanel;
	private JButton backButton;
	private JButton submitButton;
	private AbstractFrameFactory frameFactory;
	private AWTProgram program;
	public JTextField textField1;
	private JLabel labelField1;
	public JTextField textField2;
	private JLabel labelField2;

	public SecondFrame(JFrame frame, AWTProgram program) {
		this.previousFrame = frame;
		this.frameFactory = new SecondFrameFactory(frame);
		this.program = program;
	}

	public JFrame changeFrame() {

		previousFrame.setVisible(false);
		Dimension dimension = previousFrame.getSize();
		Point point = previousFrame.getLocation();

		currentFrame = frameFactory.createFrame();
		currentFrame.setLocation(point);
		currentFrame.setSize(dimension);

		headerLabel = frameFactory.createHeaderLabel();
		footerLabel = frameFactory.createFooterLabel();

		controlPanel = frameFactory.createPanel();
		backButton = frameFactory.createButton(BACK_BUTTON_LABEL);
		submitButton = frameFactory.createButton(SUBMIT_BUTTON_LABEL);
		backButton.addActionListener(new ButtonBackAction(previousFrame, currentFrame, this.program));
		submitButton.addActionListener(new ProcessAction(this));
		textField1 = frameFactory.createTextField("name");
		textField1.setColumns(6);
		labelField1 = frameFactory.createLabel("Name: ");

		textField2 = frameFactory.createTextField("address");
		textField2.setColumns(6);
		labelField2 = frameFactory.createLabel("Address: ");

		GroupLayout layout = new GroupLayout(controlPanel);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(labelField1)
						.addComponent(labelField2).addComponent(backButton))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(textField1)
						.addComponent(textField2).addComponent(submitButton)));

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelField1)
						.addComponent(textField1))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelField2)
						.addComponent(textField2))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(backButton)
						.addComponent(submitButton)));
		controlPanel.setLayout(layout);
		controlPanel.setLayout(layout);
		currentFrame.add(headerLabel);
		currentFrame.add(controlPanel);
		currentFrame.add(footerLabel);

		return currentFrame;
	}

}
