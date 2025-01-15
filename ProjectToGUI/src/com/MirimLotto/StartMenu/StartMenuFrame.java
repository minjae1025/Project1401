package com.MirimLotto.StartMenu;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartMenuFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	String id;
	
	public StartMenuPanel menuPanel;
	public GameWarningPanel warningPanel;
	public GameGuidePanel guidePanel;
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public StartMenuFrame(String id) {
		this.id = id;
		run();
		
	}
	
	public void run() {
		this.setTitle("Mirim Lotto");
	    this.menuPanel = new StartMenuPanel(this, id);
	    this.warningPanel = new GameWarningPanel(this, id);
	    this.guidePanel = new GameGuidePanel(this);
	    getContentPane().setLayout(null);
	    
	    getContentPane().add(this.menuPanel);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setBounds(100, 100, 800, 500);
	    this.setVisible(true);
	    this.setResizable(false);
	}
	
	public void toWarning() {
		getContentPane().removeAll();
        getContentPane().add(warningPanel);
        revalidate();
        repaint();
	}
	
	public void toMenu() {
		getContentPane().removeAll();
        getContentPane().add(menuPanel);
        revalidate();
        repaint();
	}
	
	public void toGuide() {
		getContentPane().removeAll();
        getContentPane().add(guidePanel);
        revalidate();
        repaint();
	}
}
