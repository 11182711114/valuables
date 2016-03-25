package valuables;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(frameWidth,frameHeight);
		centerFrameOnDefaultMonitor();
		
		GridBagLayout layout = new GridBagLayout();
		JPanel panel = new JPanel(layout);
//		{
//
//	        @Override
//	        public void paint(Graphics g){
//	            super.paint(g);
//	            int[][] dims = layout.getLayoutDimensions();
//	            g.setColor(Color.RED);
//	            int x = 0;
//	            for (int add : dims[0]){
//	                x += add;
//	                g.drawLine(x, 0, x, getHeight());
//	            }
//	            int y = 0;
//	            for (int add : dims[1]){
//	                y += add;
//	                g.drawLine(0, y, getWidth(), y);
//	            }
//	        }
//
//	    };
		
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
		
		GridBagConstraints textAreaConstraints = new GridBagConstraints();
		textAreaConstraints.fill = GridBagConstraints.BOTH;
		textAreaConstraints.anchor = GridBagConstraints.NORTHWEST;
		textAreaConstraints.gridx = 0;
		textAreaConstraints.gridy = 0;
		textAreaConstraints.weightx = 1;
		textAreaConstraints.weighty = 1;
		panel.add(getTextArea(), textAreaConstraints);
		
		GridBagConstraints radioButtonPanelConstraints = new GridBagConstraints();
		radioButtonPanelConstraints.fill = GridBagConstraints.NONE;
		radioButtonPanelConstraints.anchor = GridBagConstraints.SOUTH;
		radioButtonPanelConstraints.gridx = 1;
		radioButtonPanelConstraints.gridy = 0;
		panel.add(getRadioButtons(), radioButtonPanelConstraints);

		GridBagConstraints bottomConstraints = new GridBagConstraints();
		bottomConstraints.fill = GridBagConstraints.NONE;
		bottomConstraints.anchor = GridBagConstraints.EAST;
		bottomConstraints.gridx = 0;
		bottomConstraints.gridy = 1;
		panel.add(getBottomBar(), bottomConstraints);
		
	}
	private JPanel getTextArea(){
		GridBagLayout layout = new GridBagLayout();
		JPanel panel = new JPanel(layout);
		
		JLabel textAreaLabel = new JLabel("Valuables");
		GridBagConstraints textAreaLabelConstraints = new GridBagConstraints();
		textAreaLabelConstraints.anchor = GridBagConstraints.CENTER;
		textAreaLabelConstraints.gridx = 0;
		textAreaLabelConstraints.gridy = 0;
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
		
		return panel;
	}
	private JPanel getRadioButtons(){
		JPanel radioButtonPanel = new JPanel(new GridBagLayout());
		ButtonGroup radioButtonGroup = new ButtonGroup();
		
		JLabel radioButtonLabel = new JLabel("Sort by");
		GridBagConstraints radioButtonLabelConstraints = new GridBagConstraints();
		radioButtonLabelConstraints.fill = GridBagConstraints.NONE;
		radioButtonLabelConstraints.anchor = GridBagConstraints.SOUTH;
		radioButtonLabelConstraints.gridx = 0;
		radioButtonLabelConstraints.gridy = 0;
		
		JRadioButton radioButtonSortByName = new JRadioButton("Name");
		radioButtonGroup.add(radioButtonSortByName);
		GridBagConstraints radioButtonNameConstraints = new GridBagConstraints();
		radioButtonNameConstraints.fill = GridBagConstraints.NONE;
		radioButtonNameConstraints.anchor = GridBagConstraints.SOUTH;
		radioButtonNameConstraints.gridx = 0;
		radioButtonNameConstraints.gridy = 1;
		
		JRadioButton radioButtonSortByValue = new JRadioButton("Value");
		radioButtonGroup.add(radioButtonSortByValue);
		GridBagConstraints radioButtonValueConstraints = new GridBagConstraints();
		radioButtonValueConstraints.fill = GridBagConstraints.NONE;
		radioButtonLabelConstraints.anchor = GridBagConstraints.SOUTH;
		radioButtonValueConstraints.gridx = 0;
		radioButtonValueConstraints.gridy = 2;
		
		
		radioButtonPanel.add(radioButtonLabel,radioButtonLabelConstraints);
		radioButtonPanel.add(radioButtonSortByName,radioButtonNameConstraints);
		radioButtonPanel.add(radioButtonSortByValue,radioButtonValueConstraints);
		
		return radioButtonPanel;
	}
	private JPanel getBottomBar(){
		GridBagLayout layout = new GridBagLayout();
		JPanel bottom = new JPanel(layout);
		
		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"asföd", "sdfsd", "f"}));		
		GridBagConstraints comboBoxConstraints = new GridBagConstraints();
		comboBoxConstraints.fill = GridBagConstraints.NONE;
		comboBoxConstraints.insets = new Insets(3,5,3,5);
		comboBoxConstraints.gridx = 0;
		comboBoxConstraints.gridy = 0;
		
		JButton buttonShow = new JButton("Show");
		GridBagConstraints buttonShowConstrains = new GridBagConstraints();
		buttonShowConstrains.fill = GridBagConstraints.NONE;
		buttonShowConstrains.insets = new Insets(3,5,3,5);
		buttonShowConstrains.gridx = 1;
		buttonShowConstrains.gridy = 0;
		
		buttonShow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("show");
			}
		});
		
		JButton buttonMarketCrash = new JButton("Market crash");		
		GridBagConstraints buttonMarketCrashConstraints = new GridBagConstraints();
		buttonMarketCrashConstraints.fill = GridBagConstraints.NONE;
		buttonMarketCrashConstraints.insets = new Insets(3,5,3,5);
		buttonMarketCrashConstraints.gridx = 2;
		buttonMarketCrashConstraints.gridy = 0;
		
		buttonMarketCrash.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("market crash");
			}
		});
		
		bottom.add(comboBox,comboBoxConstraints);
		bottom.add(buttonShow,buttonShowConstrains);
		bottom.add(buttonMarketCrash,buttonMarketCrashConstraints);
		
		return bottom;
	}
}
