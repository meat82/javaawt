package org.meat.gui.factory;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

import org.meat.gui.actions.WindowClose;

public class SecondFrameFactory extends AbstractFrameFactory {

	private Frame frame;
	
	public SecondFrameFactory(Frame frame) {
		this.frame = frame;
	}
	@Override
	public Frame createFrame() {
		frame.removeAll();
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(3, 1));
		frame.addWindowListener(new WindowClose());
		return frame;
	}

	@Override
	public Panel createPanel() {
		Panel panel = new Panel();
		panel.setLayout(new FlowLayout());
		return panel;
	}

}
