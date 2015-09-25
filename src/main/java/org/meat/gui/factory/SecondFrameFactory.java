package org.meat.gui.factory;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.meat.gui.actions.WindowClose;

public class SecondFrameFactory extends AbstractFrameFactory {

	private JFrame frame;

	public SecondFrameFactory(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public JFrame createFrame() {
		//frame.removeAll();
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(3, 1));
		frame.addWindowListener(new WindowClose());
		return frame;
	}

	@Override
	public JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		return panel;
	}
	public GroupLayout createLayOut() {
		GroupLayout layout = new GroupLayout(frame.getContentPane());
		return layout;
	}

}
