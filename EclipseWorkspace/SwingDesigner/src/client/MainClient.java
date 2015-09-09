package client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import logic.MainLogic;

import javax.swing.Action;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class MainClient implements ActionListener{

	private JFrame frame;
	private MainLogic mlogic;
	private JLabel lblNewLabel;
	private JButton btnNextLine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClient window = new MainClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public MainClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creates a new logic class 
		mlogic = new MainLogic();
		
		//Creates a button for the next line
		btnNextLine = new JButton("Next Line");
		frame.getContentPane().add(btnNextLine, BorderLayout.EAST);
		btnNextLine.addActionListener(this);
		
		//Creates a label that displays a random string from the logic class
		lblNewLabel = new JLabel(mlogic.getRandom());
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lblNewLabel.setText(mlogic.getRandom());
	}

}
