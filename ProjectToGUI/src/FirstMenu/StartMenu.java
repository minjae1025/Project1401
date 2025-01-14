package FirstMenu;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	String id;
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public StartMenu(String id) {
		this.id = id;
		setTitle("Mirim Lotto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 786, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("Mirim Lotto");
		lblLogo.setBounds(186, 20, 398, 63);
		lblLogo.setFont(new Font("HY견고딕", Font.PLAIN, 64));
		panel.add(lblLogo);
		
		JLabel lblWelcome = new JLabel("오신걸 환영합니다!");
		lblWelcome.setBounds(260, 78, 261, 20);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		panel.add(lblWelcome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 110, 786, 2);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDeveloper = new JLabel("개발자");
		lblDeveloper.setForeground(new Color(128, 128, 128));
		lblDeveloper.setBounds(698, 120, 39, 15);
		lblDeveloper.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		panel.add(lblDeveloper);
		
		JLabel lblNewLabel = new JLabel("김민재");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		lblNewLabel.setBounds(690, 139, 51, 20);
		panel.add(lblNewLabel);
		
		JButton btnGameStart = new JButton("게임 시작");
		btnGameStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGameStart.setFont(new Font("나눔고딕", Font.BOLD, 24));
		btnGameStart.setBounds(186, 179, 398, 72);
		panel.add(btnGameStart);
		
		JButton btnGameExplain = new JButton("게임 설명");
		btnGameExplain.setFont(new Font("나눔고딕", Font.BOLD, 24));
		btnGameExplain.setBounds(186, 264, 398, 72);
		panel.add(btnGameExplain);
		
		JButton btnGameExit = new JButton("게임 종료");
		btnGameExit.setFont(new Font("나눔고딕", Font.BOLD, 24));
		btnGameExit.setBounds(186, 348, 398, 72);
		panel.add(btnGameExit);
	}
}
