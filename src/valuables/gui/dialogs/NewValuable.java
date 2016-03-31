package valuables.gui.dialogs;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valuables.items.Valuable;

@SuppressWarnings("serial")
public abstract class NewValuable extends JOptionPane{
	private JLabel nameText = new JLabel("Name:");
	private JTextField nameInput = new JTextField(10);
	JPanel mainPanel = new JPanel();
	
	private String fullClassName = this.getClass().getName();								//gets the full class path as string
	private String className = fullClassName.substring(fullClassName.lastIndexOf(".New")+4);	//trims fullClassName to after last '.'(i.e. only the class name)
	
	public NewValuable(){
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel namePanel = new JPanel(new FlowLayout());
		namePanel.add(nameText);
		namePanel.add(nameInput);
		mainPanel.add(namePanel);
	}
	public String getTitleName(){
		return "New " + className;
	}
	public String getName(){
		return nameInput.getText();
	}
	public JPanel getMainPanel(){
		return mainPanel;
	}
	public abstract Valuable getValuable();
}
