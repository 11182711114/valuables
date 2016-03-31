package valuables.gui.dialogs;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valuables.items.Valuable;

@SuppressWarnings("serial")
public abstract class NewValuable extends JOptionPane{
	private JLabel nameText = new JLabel("Name:");
	private JTextField nameInput = new JTextField();
	
	public NewValuable(){
		JPanel namePanel = new JPanel(new BoxLayout(this, BoxLayout.Y_AXIS));
		namePanel.add(nameText);
		namePanel.add(nameInput);
	}
	public String getName(){
		return nameInput.getSelectedText();
	}
	public abstract Valuable getValuable();
}
