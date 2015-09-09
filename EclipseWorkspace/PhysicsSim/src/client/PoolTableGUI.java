package client;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.PlainDocument;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.omg.PortableInterceptor.IORInterceptor;

import objects.PoolTable;

public class PoolTableGUI implements MouseListener{

	private JFrame frame;
	private Point clicked;
	private PoolTable board;
	
	private static int WIDTH = 450;
	private static int HEIGHT = 300;
	private static int BALLRADIUS = 25;	
	private static int LOOPTIME = 1; 		//(Seconds/loop)
	private static int CLICKFORCE = 25; 		//The amount of force generated on ball per click

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoolTableGUI window = new PoolTableGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public PoolTableGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Creating a new window
		frame = new JFrame();
		frame.setBounds(WIDTH, HEIGHT, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creating a new Pool Table of the same length
		board = new PoolTable(WIDTH, HEIGHT, BALLRADIUS, LOOPTIME);
		
		//Creating a panel that will monitor mouseclicks
		JPanel panel = new JPanel() {
		    public void paintComponent(Graphics g) {
		    	super.paintComponent(g); 
		    	
		        Point p = board.ballPosition();
		        int radius = board.ballRadius();
		        g.setColor(Color.BLACK);
		    	g.drawOval(p.x, p.y, WIDTH - radius, HEIGHT - radius);
		    	this.setVisible(true);
		    }
		};
		frame.getContentPane().add(panel);		
		
		//Add it to the panel
		panel.addMouseListener(this);
	    
	    //Make it visible
	    frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		clicked = e.getPoint();
		board.applyForce(CLICKFORCE, clicked.x, clicked.y);
		frame.repaint();		//Yeah I have no idea why this wouldn't work
		
		//UNCOMMENT ME FOR USEFUL OUTPUT
		//System.out.println(clicked);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}