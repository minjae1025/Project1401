package com.MirimLotto.GameMenu;

import java.awt.Color;
import javax.swing.*;
import com.MirimLotto.System.User;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;

public class GameStatistics extends JPanel {

	private static final long serialVersionUID = 1L;
	User user;
	JLabel lblWeek;
	JLabel lblLottoBuyCnt;
	JLabel lblLottoBuyMoney;
	JLabel lblTotalNetProfit;
	JLabel lblNetProfit;
	JLabel lblBankruptcy;
	JLabel lblFirst;
	JLabel lblSecond;
	JLabel lblThird;
	JLabel lblFourth;
	JLabel lblFifth;
	JLabel lblTotalPrizeCnt;
	JLabel lblTotalPrizeProbability;
	/**
	 * Create the panel.
	 */
	public GameStatistics(GameMenuFrame frame, User user) {
		setBackground(new Color(255, 255, 255));
		this.user = user;
		setSize(800, 500);
		setLayout(null);
		
		JPanel Center = new JPanel();
		Center.setLayout(null);
		Center.setBackground(Color.WHITE);
		Center.setBounds(0, 121, 800, 270);
		add(Center);
		
		lblWeek = new JLabel();
		lblWeek.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblWeek.setBounds(40, 40, 300, 30);
		Center.add(lblWeek);
		
		lblLottoBuyCnt = new JLabel("구매한 로또");
		lblLottoBuyCnt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblLottoBuyCnt.setBounds(40, 70, 300, 30);
		Center.add(lblLottoBuyCnt);
		
		lblLottoBuyMoney = new JLabel("쓴 금액");
		lblLottoBuyMoney.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblLottoBuyMoney.setBounds(40, 100, 300, 30);
		Center.add(lblLottoBuyMoney);
		
		lblTotalNetProfit = new JLabel("총이익");
		lblTotalNetProfit.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblTotalNetProfit.setBounds(40, 130, 300, 30);
		Center.add(lblTotalNetProfit);
		
		lblNetProfit = new JLabel("순이익");
		lblNetProfit.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNetProfit.setBounds(40, 161, 300, 30);
		Center.add(lblNetProfit);
		
		lblBankruptcy = new JLabel("파산 횟수");
		lblBankruptcy.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblBankruptcy.setBounds(40, 192, 300, 30);
		Center.add(lblBankruptcy);
		
		lblFirst = new JLabel("1등");
		lblFirst.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblFirst.setBounds(440, 20, 300, 30);
		Center.add(lblFirst);
		
		lblSecond = new JLabel("2등");
		lblSecond.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblSecond.setBounds(440, 50, 300, 30);
		Center.add(lblSecond);
		
		lblThird = new JLabel("3등");
		lblThird.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblThird.setBounds(440, 80, 300, 30);
		Center.add(lblThird);
		
		lblFourth = new JLabel("4등");
		lblFourth.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblFourth.setBounds(440, 110, 300, 30);
		Center.add(lblFourth);
		
		lblFifth = new JLabel("5등");
		lblFifth.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblFifth.setBounds(440, 140, 300, 30);
		Center.add(lblFifth);
		
		lblTotalPrizeCnt = new JLabel("총 당첨 횟수");
		lblTotalPrizeCnt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblTotalPrizeCnt.setBounds(440, 170, 300, 30);
		Center.add(lblTotalPrizeCnt);
		
		lblTotalPrizeProbability = new JLabel("총 당첨 확률");
		lblTotalPrizeProbability.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblTotalPrizeProbability.setBounds(440, 200, 300, 30);
		Center.add(lblTotalPrizeProbability);
		
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
		
		JLabel lblDnjs = new JLabel(user.getId()+"님의 로또 통계");
		lblDnjs.setHorizontalAlignment(SwingConstants.CENTER);
		lblDnjs.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		WelcomeText.add(lblDnjs);
		
		JPanel OKandBACKbtn = new JPanel();
		OKandBACKbtn.setLayout(null);
		OKandBACKbtn.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		OKandBACKbtn.setBackground(new Color(196, 255, 196));
		OKandBACKbtn.setBounds(0, 390, 800, 130);
		add(OKandBACKbtn);
		
		JButton btnBack = new JButton("확인 및 돌아가기");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnBack.setBackground(new Color(0, 128, 0));
		btnBack.setBounds(310, 20, 180, 50);
		OKandBACKbtn.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.toMenu();
			}
		});
	}
	
	public void refresh() {
		double[] lotto_probability = new double[5];
		for (int i = 0; i<5; i++) {
			lotto_probability[i] = (user.rank_cnt[i]==0 || user.lotto_buy_cnt==0? 0: ((double)user.rank_cnt[i]/(double)user.lotto_buy_cnt)*100);
		}
		double total_prize_probability = (user.total_rank_cnt==0 || user.lotto_buy_cnt==0? 0: ((double)user.total_rank_cnt/(double)user.lotto_buy_cnt)*100);
		String week = String.format("진행한 회차 : %5d회\n", user.week);
		String lotto_buy_cnt = String.format("구매한 로또 : %5d개\n", user.lotto_buy_cnt);
		String lottoBuyMoney = String.format("로또 투자금액 : %6d원\n", (user.lotto_buy_cnt*1000));
		String totalPrizeMoney = String.format("총이익 : %10d원\n", user.totalPrizeMoney);
		String totalNetProfit = String.format("순이익 : %10d원\n", user.totalPrizeMoney - (user.lotto_buy_cnt*1000));
		String bankruptcy = String.format("파산 횟수 : %7d번\n", user.end_state[3]);
		System.out.println("&");
		String First = String.format("1등 : %3d번 | %.2f%%", user.rank_cnt[0], (double)lotto_probability[0]);
		String Second = String.format("2등 : %3d번 | %.2f%%", user.rank_cnt[1], (double)lotto_probability[1]);
		String Third = String.format("3등 : %3d번 | %.2f%%", user.rank_cnt[2], (double)lotto_probability[2]);
		String Fourth = String.format("4등 : %3d번 | %.2f%%", user.rank_cnt[3], (double)lotto_probability[3]);
		String Fifth = String.format("5등 : %3d번 | %.2f%%", user.rank_cnt[4], (double)lotto_probability[4]);
		String TotalPrizeCnt = String.format("총 당첨 횟수 : "+user.total_rank_cnt);
		String TotalPrizeProbability = String.format("로또 총 당첨 확률 : %.2f", (double)total_prize_probability);
		lblWeek.setText(week);
		lblLottoBuyCnt.setText(lotto_buy_cnt);
		lblLottoBuyMoney.setText(lottoBuyMoney);
		lblTotalNetProfit.setText(totalPrizeMoney);
		lblNetProfit.setText(totalNetProfit);
		lblBankruptcy.setText(bankruptcy);
		lblFirst.setText(First);
		lblSecond.setText(Second);
		lblThird.setText(Third);
		lblFourth.setText(Fourth);
		lblFifth.setText(Fifth);
		lblTotalPrizeCnt.setText(TotalPrizeCnt);
		lblTotalPrizeProbability.setText(TotalPrizeProbability);
	}
}
