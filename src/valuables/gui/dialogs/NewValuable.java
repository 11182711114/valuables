package valuables.gui.dialogs;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valuables.gui.GUI;

public class NewValuable{//FIXME Rewrite - use JOption?Dialog?
	
	private int frameWidth = 300;
	private int frameHeight = 300;
	
	private GUI gui;
	
	private JDialog window;
	private JPanel panel;
	private JLabel nameLabel;
	private JTextField nameInput;
	private JButton ok,cancel;
	private GridBagLayout panelLayout;
	private GridBagConstraints textConstraints,inputConstraints;
	
	public NewValuable(GUI gui){
		this.gui = gui;
		initialize();		
	}
	private void initialize(){
		JDialog.setDefaultLookAndFeelDecorated(true);
		window = new JDialog(gui.getFrame());
		panelLayout = new GridBagLayout();
		panel = new JPanel(panelLayout);
		addFields();
		window.add(panel);
		window.pack();
		setWindowOptions();
	}
	private void setWindowOptions(){
		window.setTitle("New "+ getClassName());
		window.setSize(frameWidth, frameHeight);
		window.setResizable(false);
		window.setModalityType(ModalityType.APPLICATION_MODAL);
		window.setVisible(true);
		centerFrameOnDefaultMonitor();		
	}
	private void centerFrameOnDefaultMonitor(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		int frameLocationX = (int) ((width - frameWidth)/2); //Center the window on the X axis
		int frameLocationY = (int) ((height - frameHeight)/2); //Center the window on the Y axis		
		window.setLocation(frameLocationX,frameLocationY);
	}
	private String getClassName(){
		String fullClassName = this.getClass().getName();
		return fullClassName.substring(fullClassName.lastIndexOf(".New")+4).toLowerCase();
	}
	private void addFields(){
		setConstraints();
		addNameField();
	}
	private void addNameField(){		
		nameLabel = new JLabel("Name:");
		panel.add(nameLabel,textConstraints);
		nameInput = new JTextField();
		nameInput.setPreferredSize(new Dimension(150,20));
		panel.add(nameInput,inputConstraints);
	}
	private void setConstraints(){
		textConstraints = new GridBagConstraints();
		textConstraints.anchor = GridBagConstraints.EAST;
		textConstraints.insets = new Insets(0,0,5,2);
		
		inputConstraints = new GridBagConstraints();
		inputConstraints.insets = new Insets(0,2,5,0);
		inputConstraints.anchor = GridBagConstraints.WEST;
		inputConstraints.fill = GridBagConstraints.EAST;
		inputConstraints.gridx = 1;
		inputConstraints.weightx = 1;
	}	
}
