package valuables.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
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
import valuables.gui.dialogs.NewDevice;
import valuables.gui.dialogs.NewJewelry;
import valuables.gui.dialogs.NewStock;
import valuables.items.*;

public class GUI{ //FIXME bad code consistency
	private static final String[] ALLOWED_VALUABLES = {"Device","Jewelry","Stock"};
	private static final String newLine = "\n";
	
	private JFrame mainWindow;
	
	private int frameWidth = 500;
	private int frameHeight = 500;
	
	private JPanel defaultView;
	
	private ValuableHandler valuableHandler;
	
	private JButton showValuables,marketCrash;
	private ButtonGroup radioButtonGroup;
	private JComboBox<String> valuable;
	private JTextArea outputTextArea;
	private JRadioButton sortName, sortValue;
	private JLabel radioGroupLabel, textAreaLabel;
	
	
	public GUI(ValuableHandler valuableHandler){
		this.valuableHandler = valuableHandler;
		mainWindow = new JFrame();
	}
	public void run(){
		initialize();
	}
	
	private void initialize(){
		configureMainWindow();
		mainWindow.setVisible(true);
	}
	private void configureMainWindow(){
		mainWindow.setTitle("Valuable Register");
		mainWindow.setResizable(true);
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainWindow.setSize(frameWidth,frameHeight);
		centerFrameOnDefaultMonitor();
		setDefaultView();
		mainWindow.add(defaultView);	
	}
	private void setDefaultView(){
		GridBagLayout layout = new GridBagLayout();
		defaultView = new JPanel(layout);		
		defaultView.setPreferredSize(new Dimension(frameWidth,frameHeight));
		addFrameLayout(defaultView);
	}
	private void centerFrameOnDefaultMonitor(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		int frameLocationX = (int) ((width - frameWidth)/2); //Center the window on the X axis
		int frameLocationY = (int) ((height - frameHeight)/2); //Center the window on the Y axis		
		mainWindow.setLocation(frameLocationX,frameLocationY);
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
		JPanel radioButtonPanel = new JPanel();
		radioButtonPanel.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		BoxLayout layout = new BoxLayout(radioButtonPanel, BoxLayout.Y_AXIS);
		radioButtonPanel.setLayout(layout);
		
		radioButtonGroup = new ButtonGroup();
		
		radioGroupLabel = new JLabel("Sort by");
		radioButtonPanel.add(radioGroupLabel);
		
		sortName = new JRadioButton("Name");
		sortName.setSelected(true); //start of sorted by name
		radioButtonGroup.add(sortName);
		radioButtonPanel.add(sortName);
		
		sortValue = new JRadioButton("Value");
		radioButtonGroup.add(sortValue);
		radioButtonPanel.add(sortValue);
		
		return radioButtonPanel;
	}
	private JPanel getBottomBar(){
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		JPanel bottom = new JPanel(layout);	
		valuable = new JComboBox<String>(new DefaultComboBoxModel<String>(ALLOWED_VALUABLES));
		valuable.setSelectedIndex(-1);	
		bottom.add(valuable);
		
		showValuables = new JButton("Show");
		bottom.add(showValuables);
		
		marketCrash = new JButton("Market crash");
		bottom.add(marketCrash);
		
		addFunctionality();
		return bottom;
	}
	private void addFunctionality(){
		valuable.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					showNewDialog(e.getItem().toString());
					((JComboBox<String>)e.getSource()).setSelectedIndex(-1);
				}
			}
		});
		
		showValuables.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Enumeration<AbstractButton> buttons = radioButtonGroup.getElements(); buttons.hasMoreElements();){
					AbstractButton button = buttons.nextElement();
					
					if(button.isSelected()){
						switch(button.getText()){
						case "Name":
							valuableHandler.sortValuables(ValuableHandler.SORT_BY_NAME);
							break;
						case "Value":
							valuableHandler.sortValuables(ValuableHandler.SORT_BY_VALUE);
							break;
						}
						break;
					}
				}
				writeToTextArea();
			}
		});
		
		marketCrash.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				valuableHandler.marketCrash();
			}
		});
	}
	private void showNewDialog(String dialogToShow){
		switch(dialogToShow){
		case "Device":
			showNewDeviceDialog();
			break;
		case "Jewelry":
			showNewJewelryDialog();
			break;
		case "Stock":
			showNewStockDialog();
			break;
		}
	}
	private void showNewDeviceDialog(){
		NewDevice newDeviceDialog = new NewDevice(mainWindow);
		if(newDeviceDialog.showDialog()){
			Device d = (Device)newDeviceDialog.getValuable();
			valuableHandler.addValuable(d);			
		}
	}
	private void showNewStockDialog(){
		NewStock newStockDialog = new NewStock(mainWindow);
		if(newStockDialog.showDialog()){
			Stock stock = (Stock)newStockDialog.getValuable();
			valuableHandler.addValuable(stock);
		}
	}	
	private void showNewJewelryDialog(){
		NewJewelry newJewelryDialog = new NewJewelry(mainWindow);
		if(newJewelryDialog.showDialog()){
			Jewelry jewelry = (Jewelry)newJewelryDialog.getValuable();
			valuableHandler.addValuable(jewelry);
		}
	}
	private void writeToTextArea(){
		outputTextArea.setText("");
		for(Valuable var : valuableHandler.getValuables()){
			outputTextArea.append(var.toPrint() + newLine);
		}
		outputTextArea.setCaretPosition(0); //start the scroll bar at the top of the list
	}
	public JFrame getFrame(){
		return mainWindow;
	}	
}
