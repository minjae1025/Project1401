package com.MirimLotto.LottoBuy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class LottoNumberGUI {

	public static int idx = 0;

	public static int[] inputNum(int cnt) {
		// 메인 프레임 생성

		JFrame frame = new JFrame((cnt+1)+"번째 장 번호 선택");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(500, 300);
		frame.getContentPane().setLayout(new GridLayout(5, 9)); // 5행 9열의 그리드 레이아웃

		// 선택된 번호를 저장할 배열
		int[] selNumber = new int[6];

		// 버튼 생성 및 추가
		for (int i = 1; i <= 45; i++) {
			idx = 0;
			JButton button = new JButton(String.valueOf(i)); // 버튼에 숫자 표시
			frame.getContentPane().add(button);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (idx < 6) {
						// 클릭한 번호 추가
						selNumber[idx] = Integer.parseInt(button.getText());
						button.setVisible(false); // 버튼 숨기기
						idx++;
						// 6개 선택 완료 시 알림 표시 및 종료
						if (idx == 6) {
							JOptionPane.showMessageDialog(frame, "입력 완료!");
							frame.dispose();
						}
					}
				}
			});
		}
		// 프레임 표시
		frame.setVisible(true);
		return selNumber; // 선택된 숫자 반환

	}

}