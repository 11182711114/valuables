package valuables;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerFrameOnDefaultMonitor();
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
}
