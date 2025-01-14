package Main;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import AccountSystem.*;
import java.awt.event.*;
import java.io.*;
import FirstMenu.*;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	String id = "";
	String pw = "";
	private JTextField idField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	 * Create the frame.
	 */
	public Main() {
		setTitle("Mirim Lotto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(82, 92, 285, 25);
		panel.add(idField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(82, 126, 285, 25);
		panel.add(passwordField);
		
		JButton btnSingin = new JButton("로그인");
		btnSingin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = String.valueOf(idField.getText());
				pw = String.valueOf(passwordField.getPassword());
				boolean login_check = Login.run(id, pw);
				if (login_check) {
					JOptionPane.showMessageDialog(null, "로그인 성공!", "로그인 완료", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					StartMenu frame = new StartMenu(id);
					frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렸습니다.", "로그인 오류", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSingin.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnSingin.setBounds(82, 161, 285, 30);
		panel.add(btnSingin);
		
		JButton btnSingUp = new JButton("회원가입");
		btnSingUp.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnSingUp.setBounds(82, 195, 143, 25);
		panel.add(btnSingUp);
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sign_Up frame = new Sign_Up();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel lbID = new JLabel("ID");
		lbID.setFont(new Font("Noto Sans KR", Font.PLAIN, 16));
		lbID.setBounds(59, 92, 21, 25);
		panel.add(lbID);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("Noto Sans KR", Font.PLAIN, 16));
		lblPw.setBounds(53, 127, 27, 24);
		panel.add(lblPw);
		
		JLabel lblLogo = new JLabel("Mirim Lotto");
		lblLogo.setFont(new Font("HY견고딕", Font.PLAIN, 32));
		lblLogo.setBounds(119, 51, 198, 38);
		panel.add(lblLogo);
		
		JButton btnGameExit = new JButton("게임 종료");
		btnGameExit.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnGameExit.setBounds(226, 195, 141, 25);
		btnGameExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExitCheck exit = new ExitCheck();
				exit.setVisible(true);
			}
		});
		panel.add(btnGameExit);
		
		JLabel lblWelcome = new JLabel("로또를 게임으로 즐기자!");
		lblWelcome.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblWelcome.setBounds(136, 28, 158, 25);
		panel.add(lblWelcome);
		getContentPane().setLayout(null);
		
		
	}
}
