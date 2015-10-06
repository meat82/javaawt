package org.meat.gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.meat.gui.state.FrameState;
import org.meat.gui.state.SecondFrame;

public class ProcessAction implements ActionListener {

	private FrameState frameState;
	private SecondFrame secondFrame;
	
	public ProcessAction(FrameState frameState) {
		this.frameState = frameState;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(frameState instanceof SecondFrame) {
			secondFrame = (SecondFrame)frameState;
			System.out.println("Text1: " + secondFrame.textField1.getText());
			System.out.println("Text2: " + secondFrame.textField2.getText());
		}

	}

}
