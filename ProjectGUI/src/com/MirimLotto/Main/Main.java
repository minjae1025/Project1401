package com.MirimLotto.Main;

import java.awt.EventQueue;
import javax.swing.JFrame;

import com.MirimLotto.Account.SignUpPanel;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	public MainPanel mainPenal;
	public SignUpPanel signUpPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Main frame = new Main();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		
		this.setBounds(100, 100, 450, 300);
		this.setTitle("Mirim Lotto");
	    this.mainPenal = new MainPanel(this);
	    this.signUpPanel = new SignUpPanel(this);
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.add(this.mainPenal);
	    this.setVisible(true);
	    this.setResizable(false);
	}
	
	public void toSignUp() {
		getContentPane().removeAll();
	    getContentPane().add(signUpPanel);
	    revalidate();
	    repaint();
	}
	
	public void toMain() {
		getContentPane().removeAll();
	    getContentPane().add(mainPenal);
	    revalidate();
	    repaint();
	}
	
	public void close() {
		dispose();
	}

}
