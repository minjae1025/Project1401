package com.MirimLotto.StartMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class StartMenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	String id;

	/**
	 * Create the panel.
	 */
	public StartMenuPanel(StartMenuFrame frame, String id) {
		this.id = id;
		setLayout(null);
		setSize(800, 465);
		
		JPanel LogoText = new JPanel();
		LogoText.setBackground(new Color(128, 255, 128));
		LogoText.setBounds(1, 0, 800, 70);
		add(LogoText);
		LogoText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblLogo = new JLabel("Mirim Lotto");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("HY견고딕", Font.PLAIN, 64));
		LogoText.add(lblLogo);
		
		JPanel WelcomeText = new JPanel();
		WelcomeText.setBackground(new Color(196, 255, 196));
		WelcomeText.setBounds(1, 70, 800, 30);
		add(WelcomeText);
		WelcomeText.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWelcome = new JLabel("오신걸 환영합니다!");
		WelcomeText.add(lblWelcome);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 100, 800, 330);
		add(panel);
		
		JButton btnGameStart = new JButton("게임 시작");
		btnGameStart.setForeground(new Color(255, 255, 255));
		btnGameStart.setBackground(new Color(0, 128, 0));
		btnGameStart.setBounds(269, 40, 250, 70);
		btnGameStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.toWarning();
			}
		});
		panel.setLayout(null);
		btnGameStart.setFont(new Font("나눔고딕", Font.BOLD, 24));
		panel.add(btnGameStart);
		
		JButton btnGameExplain = new JButton("게임 설명");
		btnGameExplain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.toGuide();
			}
		});
		btnGameExplain.setForeground(new Color(255, 255, 255));
		btnGameExplain.setBackground(new Color(0, 128, 0));
		btnGameExplain.setBounds(269, 125, 250, 70);
		btnGameExplain.setFont(new Font("나눔고딕", Font.BOLD, 24));
		panel.add(btnGameExplain);
		
		JButton btnGameExit = new JButton("게임 종료");
		btnGameExit.setForeground(new Color(255, 255, 255));
		btnGameExit.setBackground(new Color(0, 128, 0));
		btnGameExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = JOptionPane.showConfirmDialog(frame, "게임을 정말 종료하시겠습니까?", "게임 종료", JOptionPane.YES_NO_OPTION);
				if (num == 0) System.exit(0);
			}
		});
		btnGameExit.setBounds(269, 210, 250, 70);
		btnGameExit.setFont(new Font("나눔고딕", Font.BOLD, 24));
		panel.add(btnGameExit);
		
		
		
		JPanel Developer = new JPanel();
		Developer.setBackground(new Color(196, 255, 196));
		Developer.setBounds(0, 430, 800, 35);
		add(Developer);
		Developer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDeveloper = new JLabel("개발자");
		lblDeveloper.setHorizontalAlignment(SwingConstants.CENTER);
		Developer.add(lblDeveloper);
		lblDeveloper.setForeground(new Color(128, 128, 128));
		lblDeveloper.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("김민재");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Developer.add(lblNewLabel);
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
	}
}
