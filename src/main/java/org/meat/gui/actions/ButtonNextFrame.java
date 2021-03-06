package org.meat.gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.meat.gui.AWTProgram;
import org.meat.gui.FrameSetContext;
import org.meat.gui.state.FrameState;
import org.meat.gui.state.SecondFrame;

public class ButtonNextFrame implements ActionListener {

	private AWTProgram program;
	private FrameState frameState;
	private FrameSetContext frameContext;
	
	public ButtonNextFrame(JFrame frame, AWTProgram program) {
		frameState = new SecondFrame(frame,program);
		frameContext = new FrameSetContext();
		this.program = program;
	}

	public void actionPerformed(ActionEvent e) {
		frameContext.setFrame(frameState);
		program.setFrame(frameContext);
	}

}
