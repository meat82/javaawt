package org.meat.gui.factory;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.meat.gui.actions.WindowClose;
import org.meat.gui.components.PicturePanel;
import org.meat.gui.utils.GUIUtils;

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
		frame.getContentPane().setBackground(GUIUtils.getGUIColor());
		return frame;
	}

	@Override
	public JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(GUIUtils.getGUIColor());
		return panel;
	}
	public PicturePanel createPicturePanel() {
		PicturePanel panel = new PicturePanel();
		panel.setLayout(new FlowLayout());
		return panel;
	}

}
