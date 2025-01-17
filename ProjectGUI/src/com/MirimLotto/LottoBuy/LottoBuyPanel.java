package com.MirimLotto.LottoBuy;

import com.MirimLotto.GameMenu.GameMenuFrame;
import com.MirimLotto.System.User;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LottoBuyPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	User user;
	String id;
	JLabel lblWeek = new JLabel();
	JLabel lblMoney = new JLabel();
	
	/**
	 * Create the panel.
	 */
	public LottoBuyPanel(GameMenuFrame frame, User user) {
		setBackground(new Color(255, 255, 255));
		this.user = user;
		setSize(800, 500);
		setLayout(null);
		
		JPanel LogoText = new JPanel();
		LogoText.setBounds(0, 0, 800, 70);
		LogoText.setBackground(new Color(128, 255, 128));
		add(LogoText);
		LogoText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMirimLotto = new JLabel("Mirim Lotto");
		lblMirimLotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblMirimLotto.setFont(new Font("HY견고딕", Font.PLAIN, 64));
		LogoText.add(lblMirimLotto);
		
		JPanel WelcomeText = new JPanel();
		WelcomeText.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		WelcomeText.setBounds(0, 70, 800, 50);
		WelcomeText.setBackground(new Color(196, 255, 196));
		add(WelcomeText);
		WelcomeText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDnjs = new JLabel("원하시는 수량과 방법을 입력해 주십시오");
		lblDnjs.setHorizontalAlignment(SwingConstants.CENTER);
		lblDnjs.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		WelcomeText.add(lblDnjs);
		
		JLabel lblNewLabel = new JLabel("(최대 5장)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		WelcomeText.add(lblNewLabel);
		
		JPanel OKandBACKbtn = new JPanel();
		OKandBACKbtn.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		OKandBACKbtn.setBackground(new Color(196, 255, 196));
		OKandBACKbtn.setBounds(0, 365, 800, 134);
		add(OKandBACKbtn);
		OKandBACKbtn.setLayout(null);
		
		JButton btnBack = new JButton("돌아가기");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.toMenu();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnBack.setBackground(new Color(0, 128, 0));
		btnBack.setBounds(428, 40, 150, 50);
		OKandBACKbtn.add(btnBack);
		
		JPanel BuyNumber = new JPanel();
		BuyNumber.setBackground(new Color(210, 255, 210));
		BuyNumber.setBounds(212, 179, 150, 105);
		add(BuyNumber);
		BuyNumber.setLayout(null);
		
		JSpinner BuyNumSpinner = new JSpinner();
		BuyNumSpinner.setFont(new Font("나눔고딕", Font.BOLD, 16));
		BuyNumSpinner.setBounds(12, 29, 126, 43);
		BuyNumSpinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		BuyNumber.add(BuyNumSpinner);
		
		JPanel BuyWay = new JPanel();
		BuyWay.setBackground(new Color(210, 255, 210));
		BuyWay.setLayout(null);
		BuyWay.setBounds(426, 179, 150, 105);
		add(BuyWay);
		
		ButtonGroup gruop = new ButtonGroup();
		
		
		JRadioButton rdbtnManual = new JRadioButton("수동");
		rdbtnManual.setSelected(true);
		rdbtnManual.setBackground(new Color(255, 255, 255));
		rdbtnManual.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		rdbtnManual.setBounds(16, 26, 122, 20);
		BuyWay.add(rdbtnManual);
		
		JRadioButton rdbtnAuto = new JRadioButton("자동");
		rdbtnAuto.setForeground(new Color(51, 51, 51));
		rdbtnAuto.setBackground(new Color(255, 255, 255));
		rdbtnAuto.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		rdbtnAuto.setBounds(16, 50, 122, 20);
		BuyWay.add(rdbtnAuto);
		
		gruop.add(rdbtnManual);
		gruop.add(rdbtnAuto);
		
		JButton btnBuy = new JButton("구매");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.current_buy_num = (int)BuyNumSpinner.getValue();
				//System.out.println(num);
				if (rdbtnManual.isSelected()) {
					user.lotto_buy_way = rdbtnManual.getText();
				}
				else {
					user.lotto_buy_way = rdbtnAuto.getText();
				}
				System.out.println(user.lotto_buy_way);
				boolean drawCheck = user.moneyDraw(1000 * user.current_buy_num);
				if (drawCheck) {
					frame.toSelNum();
					
				}
				else {
					JOptionPane.showMessageDialog(frame, "금액이 부족합니다", "구매", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnBuy.setForeground(Color.WHITE);
		btnBuy.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btnBuy.setBackground(new Color(0, 128, 0));
		btnBuy.setBounds(216, 40, 150, 50);
		OKandBACKbtn.add(btnBuy);
		
		JLabel lblBuyWay = new JLabel("구매할 방법");
		lblBuyWay.setBounds(436, 296, 126, 18);
		add(lblBuyWay);
		lblBuyWay.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyWay.setFont(new Font("나눔고딕", Font.BOLD, 18));
		
		JLabel lblBuyNum = new JLabel("구매할 수량");
		lblBuyNum.setBounds(222, 296, 126, 18);
		add(lblBuyNum);
		lblBuyNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyNum.setFont(new Font("나눔고딕", Font.BOLD, 18));
	}
	
	public void refresh(GameMenuFrame frame) {
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
}
