package firstWindowBuilder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowDestroyer extends WindowAdapter {
	
	public void windowClosing(WindowEvent e, JFrame frame) {
		turnOff(frame);
		System.out.println("Turning off...");
		for (int i = 0; i < 10000000; i++) {
			String s = "lslkdjfdjlkafsdljklfjalksdjkfjlksdjkjflaksjdkflsd";
		}
		System.out.println("Delay");
		System.exit(0);
	}
	
	void turnOff(JFrame frame) {
		frame.setVisible(false);
	}
}
