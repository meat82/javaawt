package org.meat.gui.factory;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.meat.gui.actions.WindowClose;

public class InitFrameFactory extends AbstractFrameFactory {

	private JFrame frame;
	
	public InitFrameFactory() {
		
	}
	public InitFrameFactory(JFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public JFrame createFrame() {
		if(frame != null){
			frame.removeAll();
		}
		else {
			frame = new JFrame("Java AWT");
		}
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

}
