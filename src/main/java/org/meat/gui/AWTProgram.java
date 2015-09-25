package org.meat.gui;

import java.awt.Frame;

import javax.swing.JFrame;

import org.meat.gui.state.FrameState;
import org.meat.gui.state.InitFrame;

public class AWTProgram {

	private JFrame frame;
	private FrameState frameState;
	private FrameSetContext frameContext;

	public AWTProgram() {
		prepare();
	}

	public void setFrame(FrameSetContext frameSetContext) {
		frame = frameSetContext.changeFrame();
		frame.setVisible(true);
	}

	private void prepare() {
		frameState = new InitFrame(this);
		frameContext = new FrameSetContext();
	}

	public void show() {
		frameContext.setFrame(frameState);
		setFrame(frameContext);
	}
	public Frame getFrame() {
		return this.frame;
	}

}
