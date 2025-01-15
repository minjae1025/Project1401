package com.MirimLotto.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.MirimLotto.AccountSys.Login;
import com.MirimLotto.StartMenu.StartMenuFrame;

public class MainPenal extends JPanel {

	private static final long serialVersionUID = 1L;
	String id, pw;
	private JTextField idField;
	private JPasswordField passwordField;
	/**
	 * Create the panel.
	 */
	public MainPenal(Main mainFrame) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 440, 265);
		JPanel LogoTextPanel = new JPanel();
		LogoTextPanel.setBackground(new Color(174, 255, 174));
		LogoTextPanel.setBounds(0, 0, 440, 90);
		add(LogoTextPanel);
		LogoTextPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("Mirim Lotto");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(124, 24, 198, 32);
		lblLogo.setFont(new Font("HY견고딕", Font.PLAIN, 32));
		LogoTextPanel.add(lblLogo);
		
		JLabel lblWelcome = new JLabel("로또를 게임으로 즐기자!");
		lblWelcome.setBounds(145, 60, 157, 20);
		lblWelcome.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		LogoTextPanel.add(lblWelcome);
		JPanel Fotter = new JPanel();
		Fotter.setBackground(new Color(255, 255, 255));
		Fotter.setBounds(0, 217, 440, 46);
		add(Fotter);
		Fotter.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("개발문의 : s2455@e-mirim.hs.kr");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(5, 25, 175, 18);
		Fotter.add(lblNewLabel);
		setLayout(null);
		
		JPanel MainPenal = new JPanel();
		MainPenal.setBackground(new Color(238, 255, 238));
		MainPenal.setBounds(0, 90, 440, 127);
		add(MainPenal);
		MainPenal.setLayout(null);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBackground(new Color(234, 255, 234));
		idField.setBounds(79, 4, 285, 25);
		MainPenal.add(idField);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(234, 255, 234));
		passwordField.setBounds(79, 32, 285, 25);
		MainPenal.add(passwordField);
		
		JButton btnSingin = new JButton("로그인");
		btnSingin.setForeground(new Color(255, 255, 255));
		btnSingin.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnSingin.setBackground(new Color(0, 128, 0));
		btnSingin.setBounds(79, 60, 285, 30);
		btnSingin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = String.valueOf(idField.getText());
				pw = String.valueOf(passwordField.getPassword());
				boolean login_check = Login.run(id, pw);
				if (login_check) {
					JOptionPane.showMessageDialog(MainPenal, "로그인 성공!", "로그인 완료", JOptionPane.INFORMATION_MESSAGE);
					StartMenuFrame frame = new StartMenuFrame(id);
					frame.setVisible(true);
					mainFrame.close();
				}
				else {
					JOptionPane.showMessageDialog(MainPenal, "아이디 또는 비밀번호가 틀렸습니다.", "로그인 오류", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		MainPenal.add(btnSingin);
		
		JButton btnSingUp = new JButton("회원가입");
		btnSingUp.setForeground(new Color(255, 255, 255));
		btnSingUp.setBounds(79, 93, 141, 25);
		MainPenal.add(btnSingUp);
		btnSingUp.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnSingUp.setBackground(new Color(0, 128, 0));
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.toSignUp();
			}
		});
		
		JButton btnGameExit = new JButton("게임 종료");
		btnGameExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = JOptionPane.showConfirmDialog(MainPenal, "게임을 정말 종료하시겠습니까?", "게임 종료", JOptionPane.YES_NO_OPTION);
				if (num == 0) System.exit(0);
			}
		});
		btnGameExit.setForeground(new Color(255, 255, 255));
		btnGameExit.setBounds(224, 93, 141, 25);
		MainPenal.add(btnGameExit);
		btnGameExit.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnGameExit.setBackground(new Color(0, 128, 0));
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("Noto Sans KR", Font.PLAIN, 16));
		lblPw.setBounds(50, 32, 27, 24);
		MainPenal.add(lblPw);
		
		JLabel lbID = new JLabel("ID");
		lbID.setFont(new Font("Noto Sans KR", Font.PLAIN, 16));
		lbID.setBounds(54, 4, 21, 25);
		MainPenal.add(lbID);
	}

}
