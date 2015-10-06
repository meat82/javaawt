package org.meat.gui.factory;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class AbstractFrameFactory {

	private BufferedImage headerPicture;
	private BufferedImage footerPicture;
	
	public AbstractFrameFactory() {
		try {
			headerPicture = ImageIO.read(this.getClass().getResource("header_logo.jpg"));
			footerPicture = ImageIO.read(this.getClass().getResource("footer_logo.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public abstract JFrame createFrame();
	
	public JButton createButton(String label) {
		JButton button = new JButton(label);
		button.setActionCommand(label);
		button.setName(label);
		return button;
	}
	
	public abstract JPanel createPanel();
	
	public JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		return label;
	}
	public JTextField createTextField(String name) {
		JTextField textField = new JTextField();
		textField.setName(name);
		return textField;
	}
	public JLabel createHeaderLabel() {
		JLabel label = new JLabel(new ImageIcon(headerPicture));
		return label;
	}
	public JLabel createFooterLabel() {
		JLabel label = new JLabel(new ImageIcon(footerPicture));
		return label;
	}
}
