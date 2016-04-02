package valuables.gui.dialogs;

import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valuables.items.Jewelry;
import valuables.items.Valuable;

@SuppressWarnings("serial")
public class NewJewelry extends NewValuable{
	
	private JLabel numberOfStonesText = new JLabel("Number of stones:");
	private JTextField numberOfStones = new JTextField(10);
	private JLabel isGoldText = new JLabel("Gold:");
	private JCheckBox isGold = new JCheckBox();
	
	public NewJewelry(){
		super();
		JPanel mainPanel = getMainPanel();
		mainPanel.add(getNumberOfStonesPanel());
		mainPanel.add(getGoldCheckboxPanel());
		mainPanel.setVisible(true);
	}
	private JPanel getNumberOfStonesPanel(){
		JPanel valuePanel = new JPanel(new FlowLayout());
		valuePanel.add(numberOfStonesText);
		valuePanel.add(numberOfStones);		
		return valuePanel;
	}
	private JPanel getGoldCheckboxPanel(){
		JPanel wearPanel = new JPanel(new FlowLayout());
		wearPanel.add(isGoldText);
		wearPanel.add(isGold);
		return wearPanel;
	}
	public int getOriginalValue(){
		int output = -1;
		try{
			output = Integer.parseInt(numberOfStones.getText());
		}
		catch(NumberFormatException e){}
		return output;		
	}
	public boolean isGold(){		
		return isGold.isSelected();
	}
	@Override
	public Valuable getValuable() {
		Jewelry jewelry = null;
		String name = getName();
		int originalValue = getOriginalValue();
		jewelry = new Jewelry(name, originalValue, isGold());
		
		return jewelry;
	}
	@Override
	public boolean checkInput() {
		
		if(checkName()){
			if(checkStones()){
				return true;
			}
			else{
				this.setError(numberOfStonesText, "Number of stones must be an integer!");
			}
		}
		else{
			this.setError(getNameLabel(), "Names cannot be empty!");
		}
		return false;
	}
	private boolean checkStones(){
		boolean isCorrect = false;
		try{
			if(Integer.parseInt(numberOfStones.getText().trim())>0)
				isCorrect = true;
			}
		catch(NumberFormatException e){}
		return isCorrect;
	}
}
