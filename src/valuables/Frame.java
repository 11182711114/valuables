package valuables;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	private int frameWidth = 1000;
	private int frameHeight = 500;
	
	public Frame(){
		frameInit();
	}
	
	public void frameInit(){
		setTitle("Valuables Register");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centerFrameOnDefaultMonitor();
		
		JPanel panel = new JPanel();
		fixLayout(panel);
		add(panel);
		
		setVisible(true);
	}
	private void centerFrameOnDefaultMonitor(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		int frameLocationX = (int) ((width - frameWidth)/2); //Center the window on the X axis
		int frameLocationY = (int) ((height - frameHeight)/2); //Center the window on the Y axis
		setSize(frameWidth,frameHeight);		
		setLocation(frameLocationX,frameLocationY);
	}
	private void fixLayout(JPanel panel){
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		JTextArea c1 = new JTextArea("c1");
		c1.setEditable(false);
		JRadioButton r1 = new JRadioButton("r1");
		JRadioButton r2 = new JRadioButton("r2");
		ButtonGroup c2 = new ButtonGroup();
		c2.add(r1);
		c2.add(r2);
		JButton c3 = new JButton("c3");
		JComboBox c4 = new JComboBox();
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addComponent(c1)
					.addComponent(c3)
					.addComponent(c4)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(r1)
							.addComponent(r2))
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(r1)
				.addComponent(r2)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(c1))
					.addComponent(c4)
					.addComponent(c3)
		);
	}
}
