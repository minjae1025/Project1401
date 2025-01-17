package com.MirimLotto.MiniGame;

import java.util.*;

public class MiniGame {
	final int entry_fee = 3000;
	Scanner sc = new Scanner(System.in);
	public void gameGuide() {
		System.out.println("UP and DOWN 게임입니다.");
		System.out.println("게임 참가비는 1000원입니다.");
		System.out.println("진행하시겠습니까? Y / N");
	}
	int gamePlay() throws InterruptedException {
		int cnt = 10;
		int number = (int)(Math.random() * 45)+1;
		int player;
		int prize_money = 0;
		do {
			System.out.println("1~45 사이의 수를 입력하세요.");
			System.out.println("남은 횟수 : "+cnt);
			player = sc.nextInt();
			cnt--;
			
			if(number>player) {
				System.out.println("UP");
			}
			else if(number<player) {
				System.out.println("DOWN");
			}
			else if (cnt == 0) {
				System.out.println("횟수 초과!");
				Thread.sleep(1000);
				System.out.println("상금은 없습니다...");
				break;
			}
			
			System.out.println();
		} while(number!=player);
		
		if (cnt > 0) {
			System.out.println("정답!");
			Thread.sleep(1000);
			prize_money = cnt * entry_fee;
			System.out.println("상금 "+prize_money+"원을 드립니다!");
			Thread.sleep(1000);
			
		}
		System.out.println("잠시 후 돌아갑니다");
		Thread.sleep(3000);
		
		return prize_money;
	}
}
