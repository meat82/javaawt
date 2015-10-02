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
import org.meat.gui.factory.AbstractFrameFactory;
import org.meat.gui.factory.SecondFrameFactory;

public class SecondFrame implements FrameState {

	private static final String HEADER_LABEL = "Second Frame";
	private static final String STATUS_LABEL = "SECOND FRAME STATUS";
	private static final String BACK_BUTTON_LABEL = "Back";
	private JFrame frame;
	private JLabel headerLabel;
	private JLabel footerLabel;
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
		Dimension dimension = frame.getSize();
		Point point = frame.getLocation();
		frame.dispose();

		frame = frameFactory.createFrame();
		frame.setLocation(point);
		frame.setSize(dimension);

		headerLabel = frameFactory.createHeaderLabel();
		footerLabel = frameFactory.createFooterLabel();

		controlPanel = frameFactory.createPanel();
		backButton = frameFactory.createButton(BACK_BUTTON_LABEL);
		backButton.addActionListener(new ButtonBackAction(frame, this.program));

		textField1 = frameFactory.createTextField("Name");
		textField1.setColumns(6);
		labelField1 = frameFactory.createLabel("Name: ");

		GroupLayout layout = new GroupLayout(controlPanel);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(labelField1).addComponent(textField1));
		layout.setVerticalGroup(
				layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(labelField1).addComponent(textField1)));
		controlPanel.setLayout(layout);
		
		//controlPanel.add(backButton);
		controlPanel.setLayout(layout);
		frame.add(headerLabel);
		frame.add(controlPanel);
		frame.add(footerLabel);

		return frame;
	}

}
