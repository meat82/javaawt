package org.meat.gui.factory;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import org.meat.gui.actions.ButtonNextFrame;
import org.meat.gui.actions.ButtonOKAction;
import org.meat.gui.actions.ButtonSubmitAction;
import org.meat.gui.actions.WindowClose;

public class InitFrameFactory extends AbstractFrameFactory {

	@Override
	public Frame createFrame() {
		Frame frame = new Frame("Java AWT");
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
