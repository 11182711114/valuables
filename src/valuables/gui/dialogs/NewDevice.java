package valuables.gui.dialogs;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valuables.items.Device;
import valuables.items.Valuable;

@SuppressWarnings("serial")
public class NewDevice extends NewValuable{
	
	private JLabel originalValueText = new JLabel("Original value:");
	private JTextField originalValueInput = new JTextField(10);
	private JLabel wearText = new JLabel("Condition:");
	private JTextField wearInput = new JTextField(10);
	
	public NewDevice(){
		super();
		JPanel mainPanel = getMainPanel();
		mainPanel.add(getValuePanel());
		mainPanel.add(getWearPanel());
		mainPanel.setVisible(true);
	}
	private JPanel getValuePanel(){
		JPanel valuePanel = new JPanel(new FlowLayout());
		valuePanel.add(originalValueText);
		valuePanel.add(originalValueInput);		
		return valuePanel;
	}
	private JPanel getWearPanel(){
		JPanel wearPanel = new JPanel(new FlowLayout());
		wearPanel.add(wearText);
		wearPanel.add(wearInput);
		return wearPanel;
	}
	public double getOriginalValue(){
		double output = -1;
		try{
			output = Integer.parseInt(originalValueInput.getSelectedText());
		}
		catch(NumberFormatException e){
			
		}
		return output;		
	}
	public int getWear(){
		int output = -1;
		try{
			output = Integer.parseInt(wearInput.getSelectedText());
		}
		catch(NumberFormatException e){
			
		}
		return output;
	}
	@Override
	public Valuable getValuable() {
		Device device = null;
		try{
			String name = getName();
			device = new Device(name, getOriginalValue(), getWear());
		}catch(Exception e){
			
		}
		return device;
	}
	

}
