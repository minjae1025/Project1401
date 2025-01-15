package com.MirimLotto.StartMenu;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameGuidePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	String id;
	/**
	 * Create the panel.
	 */
	public GameGuidePanel(StartMenuFrame frame) {
		setBackground(new Color(255, 255, 255));
		this.id = id;
		setBounds(0, 0, 800,500);
		setLayout(null);
		
		JPanel RulePanel = new JPanel();
		RulePanel.setBackground(new Color(181, 255, 181));
		RulePanel.setBounds(0, 0, 800, 60);
		add(RulePanel);
		RulePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRuleTitle = new JLabel("기본 규칙");
		lblRuleTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRuleTitle.setFont(new Font("나눔고딕", Font.BOLD, 28));
		RulePanel.add(lblRuleTitle, BorderLayout.CENTER);
		
		JPanel RuleListPanel = new JPanel();
		RuleListPanel.setBackground(new Color(230, 255, 230));
		RuleListPanel.setBounds(0, 60, 799, 150);
		add(RuleListPanel);
		RuleListPanel.setLayout(null);
		
		JLabel lblRule1 = new JLabel("1. 자금은 30000원으로 시작합니다");
		lblRule1.setBounds(273, 20, 275, 20);
		lblRule1.setFont(new Font("나눔고딕", Font.BOLD, 16));
		RuleListPanel.add(lblRule1);
		
		JLabel lblRule2 = new JLabel("2. 로또 가격은 1000원입니다");
		lblRule2.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblRule2.setBounds(273, 50, 275, 20);
		RuleListPanel.add(lblRule2);
		
		JLabel lblRule3 = new JLabel("3. 1회 당 5장 까지 구매가 가능합니다");
		lblRule3.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblRule3.setBounds(273, 80, 275, 20);
		RuleListPanel.add(lblRule3);
		
		JLabel lblRule4 = new JLabel("4. 수동과 자동 방법이 존재합니다");
		lblRule4.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblRule4.setBounds(273, 110, 275, 20);
		RuleListPanel.add(lblRule4);
		
		JPanel EndPanel = new JPanel();
		EndPanel.setBackground(new Color(181, 255, 181));
		EndPanel.setBounds(0, 210, 800, 60);
		add(EndPanel);
		EndPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEndTitle = new JLabel("엔딩 종류");
		lblEndTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndTitle.setFont(new Font("나눔고딕", Font.BOLD, 28));
		EndPanel.add(lblEndTitle, BorderLayout.CENTER);
		
		JPanel RuleListPanel_1 = new JPanel();
		RuleListPanel_1.setBackground(new Color(230, 255, 230));
		RuleListPanel_1.setLayout(null);
		RuleListPanel_1.setBounds(0, 270, 800, 90);
		add(RuleListPanel_1);
		
		JLabel lblRule1_1 = new JLabel("1. 1억원 이상 시 : 부자엔딩");
		lblRule1_1.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblRule1_1.setBounds(284, 20, 275, 20);
		RuleListPanel_1.add(lblRule1_1);
		
		JLabel lblRule2_1 = new JLabel("2. 0원 이하 시 : 파산엔딩");
		lblRule2_1.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblRule2_1.setBounds(284, 50, 275, 20);
		RuleListPanel_1.add(lblRule2_1);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBackground(new Color(255, 255, 255));
		ButtonPanel.setBounds(0, 360, 800, 100);
		add(ButtonPanel);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(250, 25, 300, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.toMenu();
			}
		});
		ButtonPanel.setLayout(null);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 153, 77));
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 18));
		ButtonPanel.add(btnNewButton);
	}
}
