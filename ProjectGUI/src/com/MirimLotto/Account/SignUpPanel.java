package com.MirimLotto.Account;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import com.MirimLotto.Main.*;

public class SignUpPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	String id;
	String pw;
	private JLabel lbID;
	private JTextField idField;
	private JLabel lblPw;
	private JPasswordField passwordField;
	private JLabel lblGuide;
	private JButton btnBack;
	private JButton btnSignin;

	
	public boolean CreateAccount(String id, String pw, Main mainFrame) {
		String directoryPath = "userdatas/accounts";
		String targetFileName = id+"_pw.txt"; // 찾고자 하는 파일 이름
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(mainFrame, "아이디를 입력해 주세요", "아이디 공백", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (pw.isEmpty()) {
			JOptionPane.showMessageDialog(mainFrame, "비밀번호를 입력해 주세요", "비밀번호 공백", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		File directory = new File(directoryPath);

	        // 디렉토리 내에서 특정 파일을 찾는다
	    File[] files = directory.listFiles((dir, name) -> name.equals(targetFileName));

	        // 파일이 발견되었는지 확인
	    if (files != null && files.length > 0) {
			JOptionPane.showMessageDialog(mainFrame, "이미 사용중인 아이디입니다", "아이디 중복", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    else {
	    	String idpw_file = "userdatas/accounts/"+id+"_pw.txt";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(idpw_file))) {
				writer.write(id + ", " + pw);
				writer.newLine();
				JOptionPane.showMessageDialog(mainFrame, "회원가입 성공!", "회원가입 완료", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (IOException e ) {
				e.printStackTrace();
			}
			return true;
	    }
	    
	}
	public SignUpPanel(Main mainFrame) {
		setLayout(null);
		
		lbID = new JLabel("ID");
		lbID.setBounds(52, 97, 23, 25);
		add(lbID);
		lbID.setFont(new Font("Noto Sans KR", Font.PLAIN, 16));
		
		idField = new JTextField();
		idField.setBackground(new Color(232, 255, 232));
		idField.setBounds(83, 97, 285, 25);
		add(idField);
		idField.setColumns(10);
		
		lblPw = new JLabel("PW");
		lblPw.setBounds(48, 133, 27, 24);
		add(lblPw);
		lblPw.setFont(new Font("Noto Sans KR", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(232, 255, 232));
		passwordField.setBounds(83, 132, 285, 25);
		add(passwordField);
		
		lblGuide = new JLabel("사용하실 아이디와 비밀번호를 입력해 주세요");
		lblGuide.setBounds(76, 67, 292, 20);
		add(lblGuide);
		lblGuide.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		btnBack = new JButton("돌아가기");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(0, 128, 0));
		btnBack.setBounds(10, 10, 89, 25);
		add(btnBack);
		btnBack.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.toMain();
			}
		});
		
		
		btnSignin = new JButton("회원가입");
		btnSignin.setForeground(new Color(255, 255, 255));
		btnSignin.setBackground(new Color(0, 128, 0));
		btnSignin.setBounds(83, 167, 285, 30);
		add(btnSignin);
		btnSignin.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = String.valueOf(idField.getText());
				pw = String.valueOf(passwordField.getPassword());
				CreateAccount(id, pw, mainFrame);
			}
		});
	}

}
