package com.MirimLotto.LottoBuy;

import javax.swing.*;
import com.MirimLotto.GameMenu.GameMenuFrame;
import com.MirimLotto.System.User;
import java.awt.*;
import java.awt.event.*;

public class CountdownPanel extends JPanel {
    private CardLayout cardLayout;

    public CountdownPanel(GameMenuFrame frame, User user) {
        setLayout(new BorderLayout());
        setSize(800, 500);

        cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // 3개의 패널 생성 (0, 1, 2)
        for (int i = 3; i >= 0; i--) {
            JLabel label = new JLabel(String.valueOf(i));
            label.setFont(new Font("나눔고딕", Font.BOLD, 96));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            cardPanel.add(String.valueOf(i), label);
        }

        add(cardPanel, BorderLayout.CENTER);

        // 1초마다 카드 전환
        new Timer(1000, new ActionListener() {
            private int count = 3;

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
                count--;
                if (count < 0) {
                    ((Timer)e.getSource()).stop(); // 타이머 중지
                    frame.toPrizeCheck();
                }
            }
        }).start();
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("3초 카운트다운");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(200, 100);
//        frame.setLocationRelativeTo(null);
//
//        CountdownPanel panel = new CountdownPanel();
//        frame.add(panel);
//
//        frame.setVisible(true);
//    }
}
