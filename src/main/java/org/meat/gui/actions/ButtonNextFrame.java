package org.meat.gui.actions;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.meat.gui.AWTProgram;
import org.meat.gui.FrameSetContext;
import org.meat.gui.state.FrameState;
import org.meat.gui.state.InitFrame;
import org.meat.gui.state.SecondFrame;

public class ButtonNextFrame implements ActionListener {

	private Frame frame;
	private AWTProgram program;
	private FrameState frameState;
	private FrameSetContext frameContext;
	
	public ButtonNextFrame(Frame frame, AWTProgram program) {
		this.frame = frame;
		frameState = new SecondFrame(frame);
		frameContext = new FrameSetContext();
		this.program = program;
	}

	public void actionPerformed(ActionEvent e) {
		frameContext.setFrame(frameState);
		program.setFrame(frameContext);
	}

}
