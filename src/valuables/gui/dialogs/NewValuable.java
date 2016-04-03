package valuables.gui.dialogs;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valuables.items.Valuable;

public abstract class NewValuable{
	private JLabel nameText = new JLabel("Name:");
	private JTextField nameInput = new JTextField(10);
	JPanel mainPanel = new JPanel();
	
	private String fullClassName = this.getClass().getName(); //gets the full class path as string
	private String className = fullClassName.substring(fullClassName.lastIndexOf(".New")+4); //trims fullClassName to after last '.'(i.e. only the class name)
	
	public NewValuable(){
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(nameText);
		namePanel.add(nameInput);
		mainPanel.add(namePanel);
	}
	public String getTitleName(){
		return "New " + className;
	}
	protected boolean checkName(){
		boolean isCorrect = false;
		nameInput.setText(nameInput.getText().trim());
		if(!nameInput.getText().isEmpty()){
			isCorrect = true;
		}
		
		return isCorrect;
	}
	public String getName(){
		return nameInput.getText();
	}
	protected JLabel getNameLabel(){
		return nameText;
	}
	public JPanel getMainPanel(){
		return mainPanel;
	}
	protected void setError(Component p,String error){
		if(p instanceof JLabel){
			((JLabel)p).setForeground(Color.RED);
		}
		showErrorPane(p,error);
	}
	private void showErrorPane(Component p,String error){
		JOptionPane.showMessageDialog(p, error);
	}
	public abstract Valuable getValuable();
	
	public abstract boolean checkInput();
}
