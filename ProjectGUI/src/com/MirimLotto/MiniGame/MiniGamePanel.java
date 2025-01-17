package com.MirimLotto.MiniGame;

import javax.swing.*;
import java.awt.*;

import com.MirimLotto.GameMenu.GameMenuFrame;
import com.MirimLotto.System.User;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiniGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	User user;
	int answer;
	int num;
	JLabel lblUpDown;
	int cnt;
	JLabel lblCnt;
	JSpinner NumSpinner;
	/**
	 * Create the panel.
	 */
	public MiniGamePanel(GameMenuFrame frame, User user) {
		setBackground(new Color(255, 255, 255));
		this.user = user;
		setSize(800, 500);
		setLayout(null);
		
		JPanel WelcomeText = new JPanel();
		WelcomeText.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		WelcomeText.setBackground(new Color(196, 255, 196));
		WelcomeText.setBounds(0, 70, 800, 50);
		add(WelcomeText);
		WelcomeText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblGameRule = new JLabel("숫자를 맞춰보세요!");
		lblGameRule.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameRule.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		WelcomeText.add(lblGameRule);
		
		lblCnt = new JLabel();
		lblCnt.setHorizontalAlignment(SwingConstants.CENTER);
		lblCnt.setForeground(new Color(0, 255, 0));
		WelcomeText.add(lblCnt);
		
		JPanel LogoText = new JPanel();
		LogoText.setBackground(new Color(128, 255, 128));
		LogoText.setBounds(0, 0, 800, 70);
		add(LogoText);
		LogoText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMirimLotto = new JLabel("Mirim Lotto");
		lblMirimLotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblMirimLotto.setFont(new Font("HY견고딕", Font.PLAIN, 64));
		LogoText.add(lblMirimLotto);
		
		JPanel OKandBACKbtn = new JPanel();
		OKandBACKbtn.setLayout(null);
		OKandBACKbtn.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		OKandBACKbtn.setBackground(new Color(196, 255, 196));
		OKandBACKbtn.setBounds(0, 366, 800, 134);
		add(OKandBACKbtn);
		
		JButton btnBack = new JButton("메인으로 나가기");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.toMenu();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnBack.setBackground(new Color(0, 128, 0));
		btnBack.setBounds(320, 40, 160, 50);
		OKandBACKbtn.add(btnBack);
		
		JPanel UPandDown = new JPanel();
		UPandDown.setBackground(new Color(241, 241, 241));
		UPandDown.setBounds(355, 120, 80, 50);
		add(UPandDown);
		UPandDown.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblUpDown = new JLabel();
		lblUpDown.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpDown.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		UPandDown.add(lblUpDown);
		
		JPanel BuyNumber = new JPanel();
		BuyNumber.setLayout(null);
		BuyNumber.setBackground(new Color(210, 255, 210));
		BuyNumber.setBounds(325, 200, 150, 105);
		add(BuyNumber);
		
		NumSpinner = new JSpinner();
		NumSpinner.setFont(new Font("나눔고딕", Font.BOLD, 16));
		NumSpinner.setBounds(12, 29, 126, 43);
		BuyNumber.add(NumSpinner);
		
		JButton btnBuy = new JButton("숫자 맞추기");
		btnBuy.setBounds(325, 304, 150, 50);
		add(btnBuy);
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = (int)NumSpinner.getValue();
				numCheck(frame, user);
			}
		});
		btnBuy.setForeground(Color.WHITE);
		btnBuy.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnBuy.setBackground(new Color(0, 128, 0));
	}
	
	public void gameStart() {
		answer = (int)(Math.random() * 45)+1;
		cnt = 10;
		lblUpDown.setText("시작!");
		lblUpDown.setForeground(new Color(51, 51, 51));
		NumSpinner.setModel(new SpinnerNumberModel(1, 1, 45, 1));
	}
	
	void numCheck(GameMenuFrame frame, User user) {
		cnt--;
		String gameCnt = String.format("남은 횟수 : %2d", cnt);
		lblCnt.setText("남은 횟수 : "+gameCnt);
		if (cnt < 0) {
			JOptionPane.showMessageDialog(frame, "실패했습니다! 메뉴로 돌아갑니다.", "실패...", JOptionPane.INFORMATION_MESSAGE);
			frame.toMenu();
		}
		if (num < answer) {
			lblUpDown.setText("UP");
			lblUpDown.setForeground(new Color(255, 0, 0));
		}
		else if (num > answer){
			lblUpDown.setText("Down");
			lblUpDown.setForeground(new Color(0, 0, 255));
		}
		else if (num == answer){
			int prizeMoney = cnt * 3000;
			user.moneyDeposit(prizeMoney);
			JOptionPane.showMessageDialog(frame, "정답입니다! 상금"+prizeMoney+"원이 지급됩니다!", "정답!", JOptionPane.INFORMATION_MESSAGE);
			frame.toMenu();
			
		}
	}
}
