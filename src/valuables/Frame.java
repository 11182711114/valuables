package valuables;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	private int frameWidth = 500;
	private int frameHeight = 500;
	
//	private JButton showValuables,marketCrash;
//	private JComboBox valuable;
//	private JTextArea outputTextArea;
//	private JRadioButton sortName, sortValue;
//	private JLabel radioGroupLabel, textAreaLabel;
	
	
	public Frame(){
		frameInit();
	}
	
	public void frameInit(){
		setTitle("Valuables Register");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(frameWidth,frameHeight);
		centerFrameOnDefaultMonitor();

		JPanel panel = new JPanel();
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
//	private void addFrameLayout(JPanel panel){
//		
//		GroupLayout layout = new GroupLayout(panel);
//		panel.setLayout(layout);
//		
//		layout.setAutoCreateContainerGaps(true);
//		layout.setAutoCreateGaps(true);
//		
//		textAreaLabel = new JLabel("Valuables");
//		outputTextArea = new JTextArea();
//		outputTextArea.setEditable(false);
//		
//		radioGroupLabel = new JLabel("Sort by");
//		sortName = new JRadioButton("Name");
//		sortValue = new JRadioButton("Value");
//		
//		valuable = new JComboBox(new DefaultComboBoxModel(new String[] {"asföd", "sdfsd", "f"}) );
//		showValuables = new JButton("Show");
//		marketCrash = new JButton("Market Crash");
//		
//		layout.setHorizontalGroup(
//				layout.createSequentialGroup()
//				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
//					.addComponent(textAreaLabel)
//					.addComponent(outputTextArea)
//					.addGroup(layout.createSequentialGroup()
//						.addComponent(valuable)
//						.addComponent(showValuables)
//						.addComponent(marketCrash)))
//				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
//					.addComponent(radioGroupLabel)
//					.addComponent(sortName)
//					.addComponent(sortValue))
//		);
//		
//		layout.setVerticalGroup(
//				layout.createParallelGroup()
//				.addGroup(layout.createSequentialGroup()
//						.addComponent(textAreaLabel)
//						.addComponent(outputTextArea)
//						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//							.addComponent(valuable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//							.addComponent(showValuables)
//							.addComponent(marketCrash)))
//				.addGroup(layout.createSequentialGroup()
//					.addComponent(radioGroupLabel)
//					.addComponent(sortName)
//					.addComponent(sortValue))
//		);
//		layout.linkSize(valuable,showValuables,marketCrash);
//		
//	}
	private void addFrameLayout(JPanel panel){
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
	
		JLabel textAreaLabel = new JLabel("Valuables");
		GridBagConstraints textAreaLabelConstraints = new GridBagConstraints();
		textAreaLabelConstraints.anchor = GridBagConstraints.CENTER;
		textAreaLabelConstraints.fill = GridBagConstraints.NONE;
		textAreaLabelConstraints.gridy = 0;
		textAreaLabelConstraints.gridx = 0;
		textAreaLabelConstraints.gridwidth = 1;
		textAreaLabelConstraints.gridheight = 1;
		textAreaLabelConstraints.weightx = 1;
		panel.add(textAreaLabel, textAreaLabelConstraints);

		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		GridBagConstraints textAreaConstraints = new GridBagConstraints();
		textAreaConstraints.anchor = GridBagConstraints.WEST;
		textAreaConstraints.fill = GridBagConstraints.BOTH;
		textAreaConstraints.gridy = 1;
		textAreaConstraints.gridx = 0;
		textAreaConstraints.gridwidth = 1;
		textAreaConstraints.gridheight = 1;
		textAreaConstraints.weightx = 1;
		textAreaConstraints.weighty = 1;
		panel.add(textArea, textAreaConstraints);
		
		
		JLabel radioButtonLabel = new JLabel("Sort by");
		GridBagConstraints radioButtonLabelConstraints = new GridBagConstraints();
		radioButtonLabelConstraints.fill = GridBagConstraints.NONE;
		radioButtonLabelConstraints.anchor = GridBagConstraints.SOUTH;
		radioButtonLabelConstraints.gridy = 0;
		radioButtonLabelConstraints.gridx = 0;
		radioButtonLabelConstraints.gridwidth = 1;
		radioButtonLabelConstraints.gridheight = 1;
		radioButtonLabelConstraints.weightx = 0;
		radioButtonLabelConstraints.weighty = 0;
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
		
		JRadioButton radioButtonSortByName = new JRadioButton("Name");
		radioButtonGroup.add(radioButtonSortByName);
		GridBagConstraints radioButtonNameConstraints = new GridBagConstraints();
		radioButtonNameConstraints.fill = GridBagConstraints.NONE;
		radioButtonNameConstraints.anchor = GridBagConstraints.SOUTH;
		radioButtonNameConstraints.gridy = 1;
		radioButtonNameConstraints.gridx = 0;
		radioButtonNameConstraints.gridwidth = 1;
		radioButtonNameConstraints.gridheight = 1;
		radioButtonNameConstraints.weightx = 0;
		radioButtonNameConstraints.weighty = 0;
		
		JRadioButton radioButtonSortByValue = new JRadioButton("Value");
		radioButtonGroup.add(radioButtonSortByValue);
		GridBagConstraints radioButtonValueConstraints = new GridBagConstraints();
		radioButtonValueConstraints.fill = GridBagConstraints.NONE;
		radioButtonLabelConstraints.anchor = GridBagConstraints.SOUTH;
		radioButtonValueConstraints.gridy = 2;
		radioButtonValueConstraints.gridx = 0;
		radioButtonValueConstraints.gridwidth = 1;
		radioButtonValueConstraints.gridheight = 1;
		radioButtonValueConstraints.weightx = 0;
		radioButtonValueConstraints.weighty = 0;
		JPanel radioButtonPanel = new JPanel();
		GridBagLayout radioButtonLayout = new GridBagLayout();
		radioButtonPanel.setLayout(radioButtonLayout);
		
		radioButtonPanel.add(radioButtonLabel,radioButtonLabelConstraints);
		radioButtonPanel.add(radioButtonSortByName,radioButtonNameConstraints);
		radioButtonPanel.add(radioButtonSortByValue,radioButtonValueConstraints);
		
		GridBagConstraints radioButtonPanelConstraints = new GridBagConstraints();
		radioButtonPanelConstraints.fill = GridBagConstraints.NONE;
		radioButtonPanelConstraints.anchor = GridBagConstraints.SOUTH;
		radioButtonPanelConstraints.gridy = 1;
		radioButtonPanelConstraints.gridx = 1;
		radioButtonPanelConstraints.gridwidth = 1;
		radioButtonPanelConstraints.gridheight = 1;
		radioButtonPanelConstraints.weightx = 0;
		radioButtonPanelConstraints.weighty = 0;
		panel.add(radioButtonPanel, radioButtonPanelConstraints);
		
	
		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"asföd", "sdfsd", "f"}));		
		GridBagConstraints comboBoxConstraints = new GridBagConstraints();
		comboBoxConstraints.fill = GridBagConstraints.NONE;
		comboBoxConstraints.insets = new Insets(3,5,3,5);
		comboBoxConstraints.gridy = 0;
		comboBoxConstraints.gridx = 0;
		comboBoxConstraints.gridwidth = 1;
		comboBoxConstraints.gridheight = 1;
		comboBoxConstraints.weightx = 0;
		comboBoxConstraints.weighty = 0;		
		
		JButton buttonShow = new JButton("Show");		
		GridBagConstraints buttonShowConstrains = new GridBagConstraints();
		buttonShowConstrains.fill = GridBagConstraints.NONE;
		buttonShowConstrains.insets = new Insets(3,5,3,5);
		buttonShowConstrains.gridy = 0;
		buttonShowConstrains.gridx = 1;
		buttonShowConstrains.gridwidth = 1;
		buttonShowConstrains.gridheight = 1;
		buttonShowConstrains.weightx = 0;
		buttonShowConstrains.weighty = 0;
		
		
		JButton buttonMarketCrash = new JButton("Market crash");		
		GridBagConstraints buttonMarketCrashConstraints = new GridBagConstraints();
		buttonMarketCrashConstraints.fill = GridBagConstraints.NONE;
		buttonMarketCrashConstraints.insets = new Insets(3,5,3,5);
		buttonMarketCrashConstraints.gridy = 0;
		buttonMarketCrashConstraints.gridx = 2;
		buttonMarketCrashConstraints.gridwidth = 1;
		buttonMarketCrashConstraints.gridheight = 1;
		buttonMarketCrashConstraints.weightx = 0;
		buttonMarketCrashConstraints.weighty = 0;
		
		JPanel bottom = new JPanel(new GridBagLayout());
		bottom.add(comboBox,comboBoxConstraints);
		bottom.add(buttonShow,buttonShowConstrains);
		bottom.add(buttonMarketCrash,buttonMarketCrashConstraints);

		GridBagConstraints bottomConstraints = new GridBagConstraints();
		bottomConstraints.fill = GridBagConstraints.NONE;
		bottomConstraints.anchor = GridBagConstraints.EAST;
		bottomConstraints.gridy = 2;
		bottomConstraints.gridx = 0;
		bottomConstraints.gridwidth = 1;
		bottomConstraints.gridheight = 1;
		bottomConstraints.weightx = 0;
		bottomConstraints.weighty = 0;
		
		panel.add(bottom, bottomConstraints);
		
	}
}
