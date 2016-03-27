package valuables.gui.dialogs;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewValuable{
	
	private int frameWidth = 300;
	private int frameHeight = 300;
	
	private JDialog window;
	private JPanel panel;
	private JLabel nameLabel;
	private JTextField nameInput;
	private JButton ok,cancel;
	private GridBagLayout panelLayout;
	private GridBagConstraints textConstraints,inputConstraints;
	
	public NewValuable(JFrame frame){
		initialize(frame);		
	}
	private void initialize(JFrame frame){
		JDialog.setDefaultLookAndFeelDecorated(true);
		window = new JDialog(frame);
		setWindowOptions();
		panelLayout = new GridBagLayout();
		panel = new JPanel(panelLayout){
			
			        @Override
			        public void paint(Graphics g){
			            super.paint(g);
			            int[][] dims = panelLayout.getLayoutDimensions();
			            g.setColor(Color.RED);
			            int x = 0;
			            for (int add : dims[0]){
			                x += add;
			                g.drawLine(x, 0, x, getHeight());
			            }
			            int y = 0;
			            for (int add : dims[1]){
			                y += add;
			                g.drawLine(0, y, getWidth(), y);
			            }
			        }
			
			    };
		addFields();
		panel.setBackground(Color.GREEN);
		window.setContentPane(panel);
	}
	private void setWindowOptions(){
		window.setTitle("New "+ getClassName());
		window.setSize(frameWidth, frameHeight);
		window.setResizable(false);
		window.setModalityType(ModalityType.APPLICATION_MODAL);
		window.setVisible(true);
		
	}
	private String getClassName(){
		String fullClassName = this.getClass().getName();
		return fullClassName.substring(fullClassName.lastIndexOf(".New")+4).toLowerCase();
	}
	private void addFields(){
		setConstraints();
		addNameField();
	}
	private void addNameField(){		
		nameLabel = new JLabel("Name:");
		panel.add(nameLabel,textConstraints);
		
		nameInput = new JTextField();
		panel.add(nameInput,inputConstraints);
	}
	private void setConstraints(){
		textConstraints = new GridBagConstraints();
		textConstraints.anchor = GridBagConstraints.EAST;
		textConstraints.insets = new Insets(0,0,5,2);
		
		inputConstraints = new GridBagConstraints();
		inputConstraints.insets = new Insets(0,2,5,0);
		inputConstraints.anchor = GridBagConstraints.WEST;
		inputConstraints.fill = GridBagConstraints.EAST;
		inputConstraints.gridx = 1;
		inputConstraints.weightx = 1;
	}	
}