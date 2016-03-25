package valuables;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	private int frameWidth = 1200;
	private int frameHeight = 500;
	
	public Frame(){
		frameInit();
	}
	
	public void frameInit(){
		setTitle("Valuables Register");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(frameWidth,frameHeight);
		centerFrameOnDefaultMonitor();
		
		
		GridBagLayout layout = new GridBagLayout(); //debug border for GBL cells
		JPanel panel = new JPanel(layout);
		panel.setPreferredSize(new Dimension(frameWidth,frameHeight));
		//panel.setBackground(Color.green); //debugging
		addFrameLayout(panel);
		add(panel);
		
		setVisible(true);
	}
	private void centerFrameOnDefaultMonitor(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		int frameLocationX = (int) ((width - frameWidth)/2); //Center the window on the X axis
		int frameLocationY = (int) ((height - frameHeight)/2); //Center the window on the Y axis		
		setLocation(frameLocationX,frameLocationY);
	}
	private void addFrameLayout(JPanel panel){	
		
		JLabel textAreaLabel = new JLabel("Valuables");
		
		GridBagConstraints textAreaLabelConstraints = new GridBagConstraints();
		textAreaLabelConstraints.anchor = GridBagConstraints.CENTER;
		textAreaLabelConstraints.fill = GridBagConstraints.NONE;
		textAreaLabelConstraints.gridy = 0;
		textAreaLabelConstraints.gridx = 0;
		textAreaLabelConstraints.gridwidth = 5;
		textAreaLabelConstraints.gridheight = 1;
		textAreaLabelConstraints.weightx = 1;
		panel.add(textAreaLabel, textAreaLabelConstraints);

		
		JTextArea textArea = new JTextArea();
		textArea.setMinimumSize(new Dimension(500,100));
		textArea.setEditable(false);
		
		GridBagConstraints textAreaConstraints = new GridBagConstraints();
		textAreaConstraints.anchor = GridBagConstraints.WEST;
		textAreaConstraints.fill = GridBagConstraints.BOTH;
		textAreaConstraints.gridy = 1;
		textAreaConstraints.gridx = 0;
		textAreaConstraints.gridwidth = 5;
		textAreaConstraints.gridheight = 10;
		textAreaConstraints.weightx = 1;
		textAreaConstraints.weighty = 1;
		//textAreaConstraints.ipady = 40;
		panel.add(textArea, textAreaConstraints);
		
		
		JLabel radioButtonLabel = new JLabel("Sort by");
		
		GridBagConstraints radioButtonLabelConstraints = new GridBagConstraints();
		radioButtonLabelConstraints.fill = GridBagConstraints.NONE;
		radioButtonLabelConstraints.anchor = GridBagConstraints.SOUTHEAST;
		radioButtonLabelConstraints.gridy = 8;
		radioButtonLabelConstraints.gridx = 5;
		radioButtonLabelConstraints.gridwidth = 1;
		radioButtonLabelConstraints.gridheight = 1;
		radioButtonLabelConstraints.weightx = 0;
		radioButtonLabelConstraints.weighty = 0;
		panel.add(radioButtonLabel, radioButtonLabelConstraints);
		

		ButtonGroup radioButtonGroup = new ButtonGroup();		
		
		JRadioButton radioButtonSortByName = new JRadioButton("Name");
		radioButtonGroup.add(radioButtonSortByName);
		
		GridBagConstraints radioButtonNameConstraints = new GridBagConstraints();
		radioButtonNameConstraints.fill = GridBagConstraints.NONE;
		radioButtonLabelConstraints.anchor = GridBagConstraints.SOUTHEAST;
		radioButtonNameConstraints.gridy = 9;
		radioButtonNameConstraints.gridx = 5;
		radioButtonNameConstraints.gridwidth = 1;
		radioButtonNameConstraints.gridheight = 1;
		radioButtonNameConstraints.weightx = 0;
		radioButtonNameConstraints.weighty = 0;
		panel.add(radioButtonSortByName, radioButtonNameConstraints);
		
		
		JRadioButton radioButtonSortByValue = new JRadioButton("Value");
		radioButtonGroup.add(radioButtonSortByValue);
		
		GridBagConstraints radioButtonValueConstraints = new GridBagConstraints();
		radioButtonValueConstraints.fill = GridBagConstraints.NONE;
		radioButtonLabelConstraints.anchor = GridBagConstraints.SOUTHEAST;
		radioButtonValueConstraints.gridy = 10;
		radioButtonValueConstraints.gridx = 5;
		radioButtonValueConstraints.gridwidth = 1;
		radioButtonValueConstraints.gridheight = 1;
		radioButtonValueConstraints.weightx = 0;
		radioButtonValueConstraints.weighty = 0;
		panel.add(radioButtonSortByValue, radioButtonValueConstraints);
		
	
		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"asföd", "sdfsd", "f"}));
		
		GridBagConstraints comboBoxConstraints = new GridBagConstraints();
		comboBoxConstraints.fill = GridBagConstraints.HORIZONTAL;
		comboBoxConstraints.gridy = 12;
		comboBoxConstraints.gridx = 0;
		comboBoxConstraints.gridwidth = 1;
		comboBoxConstraints.gridheight = 1;
		comboBoxConstraints.weightx = 0;
		comboBoxConstraints.weighty = 0;
		panel.add(comboBox, comboBoxConstraints);
		
		
		JButton buttonShow = new JButton("Show");
		
		GridBagConstraints buttonShowConstrains = new GridBagConstraints();
		buttonShowConstrains.fill = GridBagConstraints.HORIZONTAL;
		buttonShowConstrains.gridy = 12;
		buttonShowConstrains.gridx = 2;
		buttonShowConstrains.gridwidth = 1;
		buttonShowConstrains.gridheight = 1;
		buttonShowConstrains.weightx = 0;
		buttonShowConstrains.weighty = 0;
		panel.add(buttonShow, buttonShowConstrains);
		
		
		JButton buttonMarketCrash = new JButton("Market crash");
		
		GridBagConstraints buttonMarketCrashConstraints = new GridBagConstraints();
		buttonMarketCrashConstraints.fill = GridBagConstraints.HORIZONTAL;
		buttonMarketCrashConstraints.gridy = 12;
		buttonMarketCrashConstraints.gridx = 4;
		buttonMarketCrashConstraints.gridwidth = 1;
		buttonMarketCrashConstraints.gridheight = 1;
		buttonMarketCrashConstraints.weightx = 0;
		buttonMarketCrashConstraints.weighty = 0;
		panel.add(buttonMarketCrash, buttonMarketCrashConstraints);
	}
}
