package com.MirimLotto.LottoBuy;

import com.MirimLotto.GameMenu.GameMenuFrame;
import com.MirimLotto.System.User;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectNumberPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	protected static final String Lotto_System = null;
	User user;
	int num;
	JLabel[] lblLottoCnt = new JLabel[5];
	JPanel Center;
	int cnt = 0;
	int numCheck = 0;
	JButton btnNext;
	JButton btnNextNum;
	int current_buy_num;
	String lotto_buy_way;
	JLabel lblBuyNumWay;
	/**
	 * Create the panel.
	 */
	public SelectNumberPanel(GameMenuFrame frame, User user) {
		setBackground(new Color(255, 255, 255));
		this.user = user;
		setSize(800, 500);
		setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 320, 800, 70);
		add(panel);
		
		Center = new JPanel();
		Center.setBackground(new Color(255, 255, 255));
		Center.setBounds(0, 120, 800, 200);
		add(Center);
		Center.setLayout(null);
		panel.setLayout(null);
		
		btnNextNum = new JButton("다음 장 추첨하기");
		btnNextNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.numberSelSelect(user.lotto_buy_way, cnt++);
				if (cnt == user.current_buy_num) {
					btnNextNum.setEnabled(false);
				}
				remove(Center);
				Center = new JPanel();
				Center.setBackground(new Color(255, 255, 255));
				Center.setBounds(0, 120, 800, 245);
				add(Center);
				Center.setLayout(null);
				PrintLottoNum(user);
			}
		});
		btnNextNum.setForeground(Color.WHITE);
		btnNextNum.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnNextNum.setBackground(new Color(0, 128, 0));
		btnNextNum.setBounds(310, 15, 164, 40);
		panel.add(btnNextNum);
		
		
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
		
		JLabel lblDnjs = new JLabel("로또 번호를 확인하십시오");
		lblDnjs.setHorizontalAlignment(SwingConstants.CENTER);
		lblDnjs.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		WelcomeText.add(lblDnjs);
		
		lblBuyNumWay = new JLabel();
		lblBuyNumWay.setForeground(new Color(0, 0, 255));
		lblBuyNumWay.setFont(new Font("나눔고딕", Font.BOLD, 12));
		WelcomeText.add(lblBuyNumWay);
		
		JPanel OKandBACKbtn = new JPanel();
		OKandBACKbtn.setLayout(null);
		OKandBACKbtn.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		OKandBACKbtn.setBackground(new Color(196, 255, 196));
		OKandBACKbtn.setBounds(0, 390, 800, 130);
		add(OKandBACKbtn);
		
		btnNext = new JButton("당첨 확인하기");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CountdownPanel countdown = new CountdownPanel(frame, user);
				frame.getContentPane().removeAll();
		        frame.getContentPane().add(countdown);
		        frame.revalidate();
		        frame.repaint();
			}
		});
		btnNext.setEnabled(false);
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnNext.setBackground(new Color(0, 128, 0));
		btnNext.setBounds(160, 20, 150, 50);
		OKandBACKbtn.add(btnNext);
		
		JButton btnAgain = new JButton("다시하기");
		btnAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.myLottoClear();
				remove(Center);
				Center = new JPanel();
				Center.setBackground(new Color(255, 255, 255));
				Center.setBounds(0, 120, 800, 245);
				add(Center);
				Center.setLayout(null);
				btnNextNum.setEnabled(true);
				btnNext.setEnabled(false);
				cnt = 0;
				numCheck = 0;
				frame.toSelNum();
			}
		});
		btnAgain.setForeground(Color.WHITE);
		btnAgain.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnAgain.setBackground(new Color(0, 128, 0));
		btnAgain.setBounds(480, 20, 150, 50);
		OKandBACKbtn.add(btnAgain);
		
		
		
		JButton btnCheck = new JButton("번호 확인하기");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(Center);
				Center = new JPanel();
				Center.setBackground(new Color(255, 255, 255));
				Center.setBounds(0, 120, 800, 245);
				add(Center);
				Center.setLayout(null);
				
				PrintLottoNum(user);
			}
		});
		btnCheck.setForeground(Color.WHITE);
		btnCheck.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnCheck.setBackground(new Color(0, 128, 0));
		btnCheck.setBounds(321, 20, 150, 50);
		OKandBACKbtn.add(btnCheck);
	}
	
	public void PrintLottoNum(User user) {
		
		
		numCheck++;
		if (numCheck == user.current_buy_num) {
			btnNext.setEnabled(true);
		}
		
		int startY = 10;      // 시작 y 좌표

		//System.out.println("current_buy_num: " + user.current_buy_num); // current_buy_num 값 확인

		for (int i = 0; i < user.current_buy_num; i++) {
		    //System.out.println("레이블 생성 시도: " + i); // 레이블 생성 시도 확인
			int[] mynum = user.my_lotto[i];
			String lottoNumStr = String.format("|%3d |, |%3d |, |%3d |, |%3d |, |%3d |, |%3d |	", mynum[0], mynum[1], mynum[2], mynum[3], mynum[4], mynum[5]);
		    lblLottoCnt[i] = new JLabel(); // 레이블 생성
		    lblLottoCnt[i].setFont(new Font("나눔고딕", Font.BOLD, 14));
		    lblLottoCnt[i].setHorizontalAlignment(SwingConstants.CENTER);

		    lblLottoCnt[i].setText((i + 1) + "번째 장 : "+lottoNumStr); // 텍스트 설정 (임시 텍스트로 테스트 가능)
		    // lblLottoCnt[i].setText("테스트"); // 임시 텍스트 설정

		    int y = startY + (i * 35);
		    lblLottoCnt[i].setBounds(250, y, 350, 50); // 크기 임시 조정
		    //System.out.println("레이블 위치: x=" + 30 + ", y=" + y); // 레이블 위치 확인
		    Center.add(lblLottoCnt[i]);
		    lblLottoCnt[i].setHorizontalAlignment(SwingConstants.LEFT);
		    
		}
	}
	
	public void refresh() {
		lblBuyNumWay.setText("(구매한 수량 : "+user.current_buy_num+", "+user.lotto_buy_way+")");
		Center.removeAll();
		user.my_lotto = new int[5][6];
		lblLottoCnt = new JLabel[5];
		cnt = 0; 
		numCheck = 0;
		btnNextNum.setEnabled(true);
		btnNext.setEnabled(false);
	}
}
