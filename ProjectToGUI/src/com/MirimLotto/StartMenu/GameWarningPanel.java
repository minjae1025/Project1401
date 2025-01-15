package com.MirimLotto.StartMenu;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Canvas;

public class GameWarningPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	String id;

	/**
	 * Create the panel.
	 */
	public GameWarningPanel(StartMenuFrame frame, String id) {
		this.id = id;
		setBounds(0, 0, 800,500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 800, 500);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblGuide1 = new JLabel("1. 본 게임은 가상의 머니로 실행됩니다.");
		lblGuide1.setBounds(237, 180, 305, 22);
		lblGuide1.setFont(new Font("나눔고딕", Font.BOLD, 18));
		panel.add(lblGuide1);
		
		JLabel lblGuide2 = new JLabel("2. 게임 소요시간은 사용자의 따라 다릅니다.");
		lblGuide2.setBounds(237, 220, 339, 22);
		lblGuide2.setFont(new Font("나눔고딕", Font.BOLD, 18));
		panel.add(lblGuide2);
		
		JLabel lblGuide3 = new JLabel("3. 강제종료 시 저장이 안되므로 유의 바랍니다.");
		lblGuide3.setBounds(237, 260, 362, 22);
		lblGuide3.setFont(new Font("나눔고딕", Font.BOLD, 18));
		panel.add(lblGuide3);
		
		JButton btnOK = new JButton("확인");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnOK.setForeground(new Color(255, 255, 255));
		btnOK.setBackground(new Color(0, 128, 0));
		btnOK.setBounds(237, 350, 150, 50);
		btnOK.setFont(new Font("나눔고딕", Font.BOLD, 18));
		panel.add(btnOK);
		
		JButton btnBack = new JButton("돌아가기");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(0, 128, 0));
		btnBack.setBounds(449, 350, 150, 50);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.toMenu();
			}
		});
		btnBack.setFont(new Font("나눔고딕", Font.BOLD, 18));
		panel.add(btnBack);
		
		JPanel WarningPanel = new JPanel();
		WarningPanel.setBackground(new Color(255, 232, 232));
		WarningPanel.setBounds(0, 80, 800, 60);
		panel.add(WarningPanel);
		WarningPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWarning = new JLabel("※주의※");
		WarningPanel.add(lblWarning);
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("HY견고딕", Font.PLAIN, 40));
	}
}
