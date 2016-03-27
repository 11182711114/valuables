package valuables.gui;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import valuables.ValuableHandler;
import valuables.items.*;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	private static final String[] ALLOWED_VALUABLES = {"Device","Jewelry","Stock"};
	private static final String newLine = "\n";
	
	private int frameWidth = 500;
	private int frameHeight = 500;
	
	private JPanel defaultView;
	
	private ValuableHandler valuableHandler;
	
	private JButton showValuables,marketCrash;
	private ButtonGroup radioButtonGroup;
	private JComboBox valuable;
	private JTextArea outputTextArea;
	private JRadioButton sortName, sortValue;
	private JLabel radioGroupLabel, textAreaLabel;
	
	
	public Frame(ValuableHandler valuableHandler){
		this.valuableHandler = valuableHandler;
		initialize();
	}
	
	public void initialize(){
		setTitle("Valuables Register");
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(frameWidth,frameHeight);
		centerFrameOnDefaultMonitor();
		setDefaultView();
		add(defaultView);
		setVisible(true);
	}
	private void setDefaultView(){
		GridBagLayout layout = new GridBagLayout();
		defaultView = new JPanel(layout);
	//	{
	//
	//        @Override
	//        public void paint(Graphics g){
	//            super.paint(g);
	//            int[][] dims = layout.getLayoutDimensions();
	//            g.setColor(Color.RED);
	//            int x = 0;
	//            for (int add : dims[0]){
	//                x += add;
	//                g.drawLine(x, 0, x, getHeight());
	//            }
	//            int y = 0;
	//            for (int add : dims[1]){
	//                y += add;
	//                g.drawLine(0, y, getWidth(), y);
	//            }
	//        }
	//
	//    };
		//panel.setBackground(Color.green); //debugging
		
		defaultView.setPreferredSize(new Dimension(frameWidth,frameHeight));
		addFrameLayout(defaultView);
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
		GridBagConstraints textAreaPanelConstraints = new GridBagConstraints();
		
		textAreaLabel = new JLabel("Valuables");
		textAreaPanelConstraints.anchor = GridBagConstraints.CENTER;
		textAreaPanelConstraints.gridx = 0;
		textAreaPanelConstraints.gridy = 0;
		panel.add(textAreaLabel, textAreaPanelConstraints);

		
		outputTextArea = new JTextArea();
		outputTextArea.setEditable(false);
		textAreaPanelConstraints.anchor = GridBagConstraints.WEST;
		textAreaPanelConstraints.fill = GridBagConstraints.BOTH;
		textAreaPanelConstraints.gridy = 1;
		textAreaPanelConstraints.weightx = 1;
		textAreaPanelConstraints.weighty = 1;
		
		JScrollPane textAreaScrollPane = new JScrollPane(outputTextArea);
		textAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		panel.add(textAreaScrollPane, textAreaPanelConstraints);
		
		return panel;
	}
	private JPanel getRadioButtons(){
		JPanel radioButtonPanel = new JPanel(new GridBagLayout());
		radioButtonGroup = new ButtonGroup();
		
		radioGroupLabel = new JLabel("Sort by");
		GridBagConstraints radioButtonConstraints = new GridBagConstraints();
		radioButtonConstraints.fill = GridBagConstraints.NONE;
		radioButtonConstraints.anchor = GridBagConstraints.SOUTH;
		radioButtonConstraints.gridx = 0;
		radioButtonConstraints.gridy = 0;
		radioButtonPanel.add(radioGroupLabel,radioButtonConstraints);
		
		sortName = new JRadioButton("Name");
		sortName.setSelected(true); //start of sorted by name
		radioButtonGroup.add(sortName);
		radioButtonConstraints.gridy = 1;
		radioButtonPanel.add(sortName,radioButtonConstraints);
		
		sortValue = new JRadioButton("Value");
		radioButtonGroup.add(sortValue);
		radioButtonConstraints.gridy = 2;
		radioButtonPanel.add(sortValue,radioButtonConstraints);
		
		return radioButtonPanel;
	}
	private JPanel getBottomBar(){
		GridBagLayout layout = new GridBagLayout();
		JPanel bottom = new JPanel(layout);
		
		valuable = new JComboBox(new DefaultComboBoxModel(ALLOWED_VALUABLES));		
		GridBagConstraints comboBoxConstraints = new GridBagConstraints();
		comboBoxConstraints.fill = GridBagConstraints.NONE;
		comboBoxConstraints.insets = new Insets(3,5,3,5);
		comboBoxConstraints.gridx = 0;
		comboBoxConstraints.gridy = 0;
		bottom.add(valuable,comboBoxConstraints);
		
		showValuables = new JButton("Show");
		GridBagConstraints buttonShowConstrains = new GridBagConstraints();
		buttonShowConstrains.fill = GridBagConstraints.NONE;
		buttonShowConstrains.insets = new Insets(3,5,3,5);
		buttonShowConstrains.gridx = 1;
		buttonShowConstrains.gridy = 0;
		bottom.add(showValuables,buttonShowConstrains);
		
		marketCrash = new JButton("Market crash");		
		GridBagConstraints buttonMarketCrashConstraints = new GridBagConstraints();
		buttonMarketCrashConstraints.fill = GridBagConstraints.NONE;
		buttonMarketCrashConstraints.insets = new Insets(3,5,3,5);
		buttonMarketCrashConstraints.gridx = 2;
		buttonMarketCrashConstraints.gridy = 0;
		bottom.add(marketCrash,buttonMarketCrashConstraints);
		
		addFunctionality();
		return bottom;
	}
	private void addFunctionality(){
		valuable.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
				System.out.println(e.getItem());
			}
		});
		
//		sortValue.addItemListener(new ItemListener(){
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(e.getStateChange() == ItemEvent.SELECTED){
//					valuableHandler.sortArray(1);
//				}
//				else{
//					valuableHandler.sortArray(0);
//				}
//				
//			}
//		});
		
		showValuables.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Enumeration<AbstractButton> buttons = radioButtonGroup.getElements(); buttons.hasMoreElements();){
					AbstractButton button = buttons.nextElement();
					
					if(button.isSelected()){
						switch(button.getText()){
						case "Name":
							valuableHandler.sortValuables(0);
							break;
						case "Value":
							valuableHandler.sortValuables(1);
							break;
						}
						break;
					}
				}
				addTextToTextArea();
			}
		});
		
		marketCrash.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				valuableHandler.marketCrash();
			}
		});
	}
	private void addTextToTextArea(){
		outputTextArea.setText("");
		for(Valuable var : valuableHandler.getValuables()){
			outputTextArea.append(var.toPrint() + newLine);
		}
		outputTextArea.setCaretPosition(0); //start the scroll bar at the top of the list
	}
	
	
}
