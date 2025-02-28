package com.MirimLotto.GameMenu;

import java.awt.*;
import javax.swing.*;

import com.MirimLotto.StartMenu.StartMenuFrame;
import com.MirimLotto.System.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;

public class GameMenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	User user;
	String id;
	JLabel lblWeek = new JLabel();
	JLabel lblMoney = new JLabel();

	/**
	 * Create the panel.
	 */
	public GameMenuPanel(GameMenuFrame frame, User user, String id) {
		setBackground(new Color(255, 255, 255));
		this.id = id;
		this.user = user;
		setBounds(100, 100, 800, 500);
		setLayout(null);
		
		
		JPanel LogoText = new JPanel();
		LogoText.setBounds(0, 0, 800, 70);
		LogoText.setBackground(new Color(128, 255, 128));
		add(LogoText);
		LogoText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMirimLottoMenu = new JLabel("Mirim Lotto Menu");
		lblMirimLottoMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMirimLottoMenu.setFont(new Font("HY견고딕", Font.PLAIN, 64));
		LogoText.add(lblMirimLottoMenu);
		
		JPanel WelcomeText = new JPanel();
		WelcomeText.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		WelcomeText.setBounds(0, 70, 800, 45);
		WelcomeText.setBackground(new Color(196, 255, 196));
		add(WelcomeText);
		WelcomeText.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWelcome = new JLabel(user.getId()+"님 환영합니다!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		WelcomeText.add(lblWelcome);
		
		JButton btnLottoBuy = new JButton("로또 구매");
		btnLottoBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.toBuy();
			}
		});
		btnLottoBuy.setBounds(275, 142, 250, 70);
		btnLottoBuy.setForeground(Color.WHITE);
		btnLottoBuy.setFont(new Font("나눔고딕", Font.BOLD, 24));
		btnLottoBuy.setBackground(new Color(0, 128, 0));
		add(btnLottoBuy);
		
		JButton btnLottoStats = new JButton("로또 통계");
		btnLottoStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.toStats();
			}
		});
		btnLottoStats.setBounds(275, 227, 250, 70);
		btnLottoStats.setForeground(Color.WHITE);
		btnLottoStats.setFont(new Font("나눔고딕", Font.BOLD, 24));
		btnLottoStats.setBackground(new Color(0, 128, 0));
		add(btnLottoStats);
		
		JButton btnMiniGame = new JButton("미니게임 하기");
		btnMiniGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = JOptionPane.showConfirmDialog(frame, "UP & DOWN 게임입니다. 참가비는 1000원입니다.\n1~45 숫자중에서 고른 랜덤 숫자입니다. 진행하시겠습니까?", "UP & Down 미니게임", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (num == 0) {
					frame.toMini();
					user.moneyDraw(1000);
				}
				
			}
		});
		btnMiniGame.setBounds(275, 312, 250, 70);
		btnMiniGame.setForeground(Color.WHITE);
		btnMiniGame.setFont(new Font("나눔고딕", Font.BOLD, 24));
		btnMiniGame.setBackground(new Color(0, 128, 0));
		add(btnMiniGame);
		
		JButton btnGameExit = new JButton("메인 화면 및 저장");
		btnGameExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = user.gameSave();
				if (check) {
					JOptionPane.showMessageDialog(frame, "저장에 성공했습니다.", "메인화면 및 저장", JOptionPane.INFORMATION_MESSAGE);
					new StartMenuFrame(id);
					frame.close();
				}
				else {
					JOptionPane.showMessageDialog(frame, "저장에 실패했습니다.", "메인화면 및 저장", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGameExit.setBounds(275, 397, 250, 70);
		btnGameExit.setForeground(Color.WHITE);
		btnGameExit.setFont(new Font("나눔고딕", Font.BOLD, 24));
		btnGameExit.setBackground(new Color(0, 128, 0));
		add(btnGameExit);
		
		JPanel ImgPanel = new JPanel();
		ImgPanel.setBackground(new Color(255, 255, 255));
		ImgPanel.setBounds(0, 115, 275, 385);
		ImgPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(ImgPanel);
		
		JLabel img1 = new JLabel(new ImageIcon("lottoimg.png"));
		img1.setSize(100, 150);
		ImgPanel.add(img1);
	}
	
	void refresh(GameMenuFrame frame) {
		remove(lblWeek);
		remove(lblMoney);
		lblWeek = new JLabel(String.format("%10d주차", user.week));
		lblWeek.setBounds(600, 125, 190, 20);
		add(lblWeek);
		lblWeek.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeek.setFont(new Font("나눔고딕", Font.BOLD, 15));
		lblWeek.setBackground(Color.WHITE);
		
		lblMoney = new JLabel(String.format("잔액 : %10d원", user.getMoney()));
		lblMoney.setBounds(600, 150, 190, 20);
		add(lblMoney);
		lblMoney.setBackground(new Color(255, 255, 255));
		lblMoney.setFont(new Font("나눔고딕", Font.BOLD, 15));
		lblMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
	}
	
	void endCheck() {
		if (user.getMoney() > 100000000) {
			int num = JOptionPane.showConfirmDialog(this, "축하드립니다! 1억을 모으셨습니다! 게임을 계속해서 진행하시겠습니까?", "성공 엔딩", JOptionPane.YES_NO_OPTION);
			if (num == 1) {
				int exit = JOptionPane.showConfirmDialog(this, "게임을 정말 종료하시겠습니까?", "게임 종료", JOptionPane.YES_NO_OPTION);
				if (exit == 0) {
					user.gameSave();
					System.exit(0);
				}
			}
		}
		else if (user.getMoney() < 1000) {
			int num = JOptionPane.showConfirmDialog(this, "아쉽지만 이제 라면 살 돈도 없습니다... 파산 신청되었습니다... 초기화 후 다시 진행하시겠습니까?", "파산 엔딩", JOptionPane.YES_NO_OPTION);
			if (num == 0) {
				user.end_state[1]++;
				user.moneySet(20000);
				user.week = 1;
			}
			else {
				int exit = JOptionPane.showConfirmDialog(this, "게임을 정말 종료하시겠습니까?", "게임 종료", JOptionPane.YES_NO_OPTION);
				if (exit == 0) {
					user.gameSave();
					System.exit(0);
				}
			}
		}
		else if (user.week >= 1000) {
			int num = JOptionPane.showConfirmDialog(this, "당신은 로또에 중독되었습니다. 1000회 이상 진행하셨습니다. 계속 진행하시겠습니까?", "중독 엔딩", JOptionPane.YES_NO_OPTION);
			if (num == 1) {
				int exit = JOptionPane.showConfirmDialog(this, "게임을 정말 종료하시겠습니까?", "게임 종료", JOptionPane.YES_NO_OPTION);
				if (exit == 0) {
					user.gameSave();
					System.exit(0);
				}
			}
		}
	}
}
