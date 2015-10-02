package org.meat.gui.factory;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.meat.gui.actions.WindowClose;
import org.meat.gui.utils.GUIUtils;

public class SecondFrameFactory extends AbstractFrameFactory {

	private JFrame frame;

	public SecondFrameFactory(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public JFrame createFrame() {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(3, 1));
		frame.getContentPane().setBackground(GUIUtils.getGUIColor());
		frame.addWindowListener(new WindowClose());
		return frame;
	}

	@Override
	public JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(GUIUtils.getGUIColor());
		return panel;
	}
	public GroupLayout createLayOut() {
		GroupLayout layout = new GroupLayout(frame.getContentPane());
		return layout;
	}

}
