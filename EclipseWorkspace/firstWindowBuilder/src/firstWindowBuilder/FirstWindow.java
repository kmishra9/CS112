package firstWindowBuilder;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FirstWindow {
	
	static final int WIDTH = 300;
	static final int HEIGHT = 200;

	public static void main(String[] args) {
		//Creating a new window and setting its size 
		JFrame jf = new JFrame();
		jf.setSize(WIDTH, HEIGHT);
		
		//Create a label and add the it to the frame
		JLabel label = new JLabel("Please don't touch click the button");
		jf.getContentPane().add(label);
		
		//Create an object that will listen + close the program when fired
		WindowDestroyer myListener = new WindowDestroyer(); 
		jf.addWindowListener(myListener);
		
		//Make the window visible and closable
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class SecondWindow extends JFrame {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;
	
	public SecondWindow() {
		super();
		setSize(WIDTH, HEIGHT);
		
		//Create a label and add the it to the frame
		JLabel label = new JLabel("Please don't touch click the button");
		getContentPane().add(label);
		
		//Create an object that will listen + close the program when fired
		addWindowListener(new WindowDestroyer());
		
		//Make the window visible 
		setVisible(true);
	}
	
}
