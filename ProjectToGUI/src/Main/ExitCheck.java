package Main;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class ExitCheck extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ExitCheck() {
		setTitle("주의!");
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 250, 150);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnYes = new JButton("예");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnYes.setBounds(21, 62, 85, 41);
		btnYes.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		
		JLabel lblRealExit = new JLabel("게임을 정말 종료하겠습니까?");
		lblRealExit.setBounds(10, 11, 216, 41);
		lblRealExit.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JButton btnNo = new JButton("아니오");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNo.setBounds(125, 62, 85, 41);
		btnNo.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		contentPane.setLayout(null);
		contentPane.add(btnYes);
		contentPane.add(lblRealExit);
		contentPane.add(btnNo);
	}
}
