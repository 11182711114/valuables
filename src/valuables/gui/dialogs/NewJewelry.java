package valuables.gui.dialogs;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valuables.items.Jewelry;
import valuables.items.Valuable;

public class NewJewelry extends NewValuable{
	
	private JLabel numberOfStonesText = new JLabel("Number of stones:");
	private JTextField numberOfStones = new JTextField(10);
	private JLabel isGoldText = new JLabel("Gold:");
	private JCheckBox isGold = new JCheckBox();
	
	public NewJewelry(Component parent){
		super(parent);
		JPanel mainPanel = getMainPanel();
		mainPanel.add(getNumberOfStonesPanel());
		mainPanel.add(getGoldCheckboxPanel());
	}
	private JPanel getNumberOfStonesPanel(){
		JPanel stonesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		stonesPanel.add(numberOfStonesText);
		stonesPanel.add(numberOfStones);		
		return stonesPanel;
	}
	private JPanel getGoldCheckboxPanel(){
		JPanel goldPanel = new JPanel(new FlowLayout());
		goldPanel.add(isGoldText);
		goldPanel.add(isGold);
		return goldPanel;
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
				this.showError("Number of stones must be an integer >=0!");
			}
		}
		else{
			this.showError("Names cannot be empty!");
		}
		return false;
	}
	private boolean checkStones(){
		boolean isCorrect = false;
		try{
			if(Integer.parseInt(numberOfStones.getText().trim())>=0)
				isCorrect = true;
			}
		catch(NumberFormatException e){}
		return isCorrect;
	}
}
