package com.MirimLotto.LottoBuy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import com.MirimLotto.GameMenu.GameMenuFrame;
import com.MirimLotto.System.*;

public class PrizeCheckPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	User user;
	int num;
	JLabel[] lblLottoCnt = new JLabel[5];
	JPanel Center;
	JPanel PrizeNum;
	JLabel lblPrizeNum;
	
	/**
	 * Create the panel.
	 */
	public PrizeCheckPanel(GameMenuFrame frame, User user) {
		setBackground(new Color(255, 255, 255));
		this.user = user;
		setSize(800, 500);
		setLayout(null);
		
		PrizeNum = new JPanel();
		PrizeNum.setBounds(0, 120, 800, 60);
		add(PrizeNum);
		PrizeNum.setLayout(new BorderLayout(0, 0));
		
		Center = new JPanel();
		Center.setBackground(new Color(255, 255, 255));
		Center.setBounds(0, 180, 800, 210);
		add(Center);
		Center.setLayout(null);
		
		lblPrizeNum = new JLabel();
		lblPrizeNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrizeNum.setFont(new Font("나눔고딕", Font.BOLD, 24));
		PrizeNum.add(lblPrizeNum);
		
		JPanel LogoText = new JPanel();
		LogoText.setBackground(new Color(128, 255, 128));
		LogoText.setBounds(0, 0, 800, 70);
		add(LogoText);
		LogoText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMirimLotto = new JLabel("Mirim Lotto");
		lblMirimLotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblMirimLotto.setFont(new Font("HY견고딕", Font.PLAIN, 64));
		LogoText.add(lblMirimLotto);
		
		JPanel WelcomeText = new JPanel();
		WelcomeText.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		WelcomeText.setBackground(new Color(196, 255, 196));
		WelcomeText.setBounds(0, 70, 800, 50);
		add(WelcomeText);
		WelcomeText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDnjs = new JLabel(user.week+"주차 로또 결과");
		lblDnjs.setHorizontalAlignment(SwingConstants.CENTER);
		lblDnjs.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		WelcomeText.add(lblDnjs);
		
		JPanel OKandBACKbtn = new JPanel();
		OKandBACKbtn.setLayout(null);
		OKandBACKbtn.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		OKandBACKbtn.setBackground(new Color(196, 255, 196));
		OKandBACKbtn.setBounds(0, 390, 800, 130);
		add(OKandBACKbtn);
		
		JButton btnCheck = new JButton("확인 및 돌아가기");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.toMenu();
			}
		});
		btnCheck.setForeground(Color.WHITE);
		btnCheck.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnCheck.setBackground(new Color(0, 128, 0));
		btnCheck.setBounds(310, 20, 180, 50);
		OKandBACKbtn.add(btnCheck);
		
		
		
		
	}
	
	public void PrintLottoNum(User user) {
		int total_money = user.rankPrint();
		
		int[] prizenNum = user.prize_lotto;
		String prizeText = String.format(" 당첨 번호 : |%3d |, |%3d |, |%3d |, |%3d |, |%3d |, |%3d | + |%3d |", prizenNum[0], prizenNum[1], prizenNum[2], prizenNum[3], prizenNum[4], prizenNum[5], prizenNum[6]);
		lblPrizeNum.setText(prizeText);
		
		int startY = 10;      // 시작 y 좌표

		for (int i = 0; i < user.current_buy_num; i++) {
		    //System.out.println("레이블 생성 시도: " + i); // 레이블 생성 시도 확인
			int[] mynum = user.my_lotto[i];
			String lottoNumStr = String.format("|%3d |, |%3d |, |%3d |, |%3d |, |%3d |, |%3d |	", mynum[0], mynum[1], mynum[2], mynum[3], mynum[4], mynum[5]);
		    lblLottoCnt[i] = new JLabel((i + 1) + "번째 장 : "+lottoNumStr+" ▶ "+(user.prize_rank[i] == 0? "낙첨": user.prize_rank[i]+"등!")); // 레이블 생성
		    lblLottoCnt[i].setFont(new Font("나눔고딕", Font.BOLD, 14));
		    lblLottoCnt[i].setHorizontalAlignment(SwingConstants.CENTER);

		    int y = startY + (i * 35);
		    lblLottoCnt[i].setBounds(220, y, 400, 50); // 크기 임시 조정
		    //System.out.println("레이블 위치: x=" + 30 + ", y=" + y); // 레이블 위치 확인
		    Center.add(lblLottoCnt[i]);
		    lblLottoCnt[i].setHorizontalAlignment(SwingConstants.LEFT);
		    
		}
		
		if (total_money > 0) {
			JOptionPane.showMessageDialog(null, "축하드립니다! 상금 "+total_money+"원이 지급되었습니다!", "로또 당첨!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void refresh() {
		
		Center.removeAll();
		lblLottoCnt = new JLabel[5];
	}
}
