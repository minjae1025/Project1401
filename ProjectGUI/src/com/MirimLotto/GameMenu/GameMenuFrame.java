package com.MirimLotto.GameMenu;

import javax.swing.*;

import com.MirimLotto.LottoBuy.LottoBuyPanel;
import com.MirimLotto.LottoBuy.PrizeCheckPanel;
import com.MirimLotto.LottoBuy.SelectNumberPanel;
import com.MirimLotto.MiniGame.MiniGamePanel;
import com.MirimLotto.System.*;

public class GameMenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private GameMenuPanel menuPanel;
	private LottoBuyPanel lottoBuy;
	private SelectNumberPanel selNum;
	private PrizeCheckPanel Pcheck;
	private GameStatistics stats;
	private MiniGamePanel mini;
	String id;
	User user;

	/**
	 * Create the frame.
	 */
	public GameMenuFrame(String id) {
		this.id = id;
		user = new User(this.id);
		System.out.println(user.getMoney());
		run();
	}
	
	public void run() {
		this.setTitle("Mirim Lotto");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 810, 520);
		this.menuPanel = new GameMenuPanel(this, user, id);
		this.lottoBuy = new LottoBuyPanel(this, user);
		this.selNum = new SelectNumberPanel(this, user);
		this.Pcheck = new PrizeCheckPanel(this, user);
		this.stats = new GameStatistics(this, user);
		this.mini = new MiniGamePanel(this, user);
		menuPanel.setLocation(0, 0);
		menuPanel.refresh(this);
		getContentPane().setLayout(null);
	    
	    getContentPane().add(menuPanel);
	    this.setVisible(true);
	    this.setResizable(false);
	}
	
	public void toMenu() {
		getContentPane().removeAll();
        getContentPane().add(menuPanel);
        menuPanel.refresh(this);
        revalidate();
        repaint();
        menuPanel.endCheck();
	}
	
	public void toBuy() {
		getContentPane().removeAll();
        getContentPane().add(lottoBuy);
        lottoBuy.refresh(this);
        revalidate();
        repaint();
	}
	
	public void toSelNum() {
		getContentPane().removeAll();
        getContentPane().add(selNum);
        selNum.refresh();
        revalidate();
        repaint();
	}
	
	public void toPrizeCheck() {
		getContentPane().removeAll();
        getContentPane().add(Pcheck);
        Pcheck.refresh();
        Pcheck.PrintLottoNum(user);
        revalidate();
        repaint();
	}
	
	public void toStats() {
		getContentPane().removeAll();
        getContentPane().add(stats);
        stats.refresh();
        revalidate();
        repaint();
	}
	
	public void toMini() {
		getContentPane().removeAll();
        getContentPane().add(mini);
        mini.gameStart();
        revalidate();
        repaint();
	}
	
	public void close() {
		dispose();
	}
}
