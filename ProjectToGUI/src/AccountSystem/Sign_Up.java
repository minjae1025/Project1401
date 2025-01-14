package AccountSystem;

import javax.swing.*;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import Main.*;
import java.io.*;
import java.awt.event.*;

public class Sign_Up extends JFrame {

	private static final long serialVersionUID = 1L;
	String id;
	String pw;
	private JPanel panel;
	private JLabel lbID;
	private JTextField idField;
	private JLabel lblPw;
	private JPasswordField passwordField;
	private JLabel lblGuide;
	private JButton btnBack;
	private JButton btnSignin;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Sign_Up frame = new Sign_Up();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public boolean CreateAccount(String id, String pw) {
		String directoryPath = "userdatas/accounts";
		String targetFileName = id+"_pw.txt"; // 찾고자 하는 파일 이름
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요", "아이디 공백", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (pw.isEmpty()) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요", "비밀번호 공백", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		File directory = new File(directoryPath);

	        // 디렉토리 내에서 특정 파일을 찾는다
	    File[] files = directory.listFiles((dir, name) -> name.equals(targetFileName));

	        // 파일이 발견되었는지 확인
	    if (files != null && files.length > 0) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다", "아이디 중복", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    else {
	    	String idpw_file = "userdatas/accounts/"+id+"_pw.txt";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(idpw_file))) {
				writer.write(id + ", " + pw);
				writer.newLine();
				JOptionPane.showMessageDialog(null, "회원가입 성공!", "회원가입 완료", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (IOException e ) {
				e.printStackTrace();
			}
			return true;
	    }
	    
	}
	
	void DuplicateError() {
	}

	/**
	 * Create the frame.
	 */
	public Sign_Up() {
		setTitle("Mirim Lotto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 436, 263);
		panel.setLayout(null);
		setContentPane(panel);
		
		lbID = new JLabel("ID");
		lbID.setBounds(52, 97, 23, 25);
		panel.add(lbID);
		lbID.setFont(new Font("Noto Sans KR", Font.PLAIN, 16));
		
		idField = new JTextField();
		idField.setBounds(81, 97, 287, 25);
		panel.add(idField);
		idField.setColumns(10);
		
		lblPw = new JLabel("PW");
		lblPw.setBounds(48, 133, 27, 24);
		panel.add(lblPw);
		lblPw.setFont(new Font("Noto Sans KR", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 132, 285, 25);
		panel.add(passwordField);
		
		lblGuide = new JLabel("사용하실 아이디와 패스워드를 입력해 주세요");
		lblGuide.setBounds(67, 67, 292, 20);
		panel.add(lblGuide);
		lblGuide.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		btnBack = new JButton("돌아가기");
		btnBack.setBounds(10, 10, 89, 25);
		panel.add(btnBack);
		btnBack.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.main(null);
				dispose();
			}
		});
		
		
		btnSignin = new JButton("회원가입");
		btnSignin.setBounds(83, 167, 285, 30);
		panel.add(btnSignin);
		btnSignin.setFont(new Font("나눔고딕", Font.BOLD, 12));
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = String.valueOf(idField.getText());
				pw = String.valueOf(passwordField.getPassword());
				CreateAccount(id, pw);
			}
		});
	}
}
