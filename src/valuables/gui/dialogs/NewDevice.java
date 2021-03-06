package valuables.gui.dialogs;

import java.awt.Component;
import java.awt.FlowLayout;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valuables.items.Device;
import valuables.items.Valuable;

public class NewDevice extends NewValuable{
	
	private JLabel originalValueText = new JLabel("Original value:");
	private JTextField originalValueInput = new JTextField(10);
	private JLabel wearText = new JLabel("Condition:");
	private JTextField wearInput = new JTextField(10);
	
	public NewDevice(Component parent){
		super(parent);
		JPanel mainPanel = getMainPanel();
		mainPanel.add(getValuePanel());
		mainPanel.add(getWearPanel());
	}
	private JPanel getValuePanel(){
		JPanel valuePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		valuePanel.add(originalValueText);
		valuePanel.add(originalValueInput);		
		return valuePanel;
	}
	private JPanel getWearPanel(){
		JPanel wearPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		wearPanel.add(wearText);
		wearPanel.add(wearInput);
		return wearPanel;
	}
	public double getOriginalValue(){
		double output = -1;
		try{
			output = Integer.parseInt(originalValueInput.getText());
		}
		catch(NumberFormatException e){
			
		}
		return output;		
	}
	public int getWear(){
		int output = -1;
		try{
			output = Integer.parseInt(wearInput.getText());
		}
		catch(NumberFormatException e){
			
		}
		return output;
	}
	@Override
	public Valuable getValuable() {
		Device device = null;
		String name = getName();
		double originalValue = getOriginalValue();
		int wear = getWear();
		device = new Device(name, originalValue, wear);
		
		return device;
	}
	@Override
	public boolean checkInput() {
		String errors = "";
		boolean isCorrect = true;
		if(!checkName()){
			isCorrect = false;
			errors+="Names cannot be empty! \n";
		}
		if(!checkValue()){
			isCorrect = false;
			errors+="Value must be a number! \n";
		}
		if(!checkWear()){
			isCorrect = false;
			errors+="Wear must be an integer 1-10!";
		}
		if(!isCorrect){
			showError(errors);
		}
		return isCorrect;
	}
	private boolean checkValue(){
		boolean isCorrect = false;
		try{
			if(Double.parseDouble(originalValueInput.getText())>0)
				isCorrect = true;
			}
		catch(NumberFormatException e){}
		return isCorrect;
	}
	private boolean checkWear(){
		boolean isCorrect = false;
		
		try{
			int wear = Integer.parseInt(wearInput.getText());
			if(wear>=1 && wear<=10)
				isCorrect = true;
		}
		catch(NumberFormatException e){}
		
		return isCorrect;
	}
}
