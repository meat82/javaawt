package org.meat.gui;

import javax.swing.JFrame;

import org.meat.gui.state.FrameState;

public class FrameSetContext implements FrameState{
	
	private FrameState frameState;
	
	public FrameState getFrame() {
		return frameState;
	}

	public void setFrame(FrameState frameState) {
		this.frameState = frameState;
	}
	
	public JFrame changeFrame() {
		return this.frameState.changeFrame();		
	}

}
