package Project_2024;

import java.util.*;
import java.math.*;
import java.io.*;

class Client extends Save_Sys{
	Scanner sc = new Scanner(System.in);
	
	Client(String id, String pw) {
		super(id, pw);
	}
	
	// 게임 시작 후 메뉴
	int gameMenu() throws InterruptedException { 
		console_clear();
		int menu = 0;
		System.out.println("===========================================");
		System.out.println("             Mirim Lotto Menu");
		System.out.println("===========================================");
		System.out.printf("                       금액 : %10d원\n", money);
		System.out.println(" 1. 로또 구매");
		System.out.println(" 2. 로또 당첨 내역");
		System.out.println(" 3. 로또 통계");
		System.out.println(" 4. 알바하기");
		System.out.println(" 5. 메인 화면");
		menu = InputMismatchTest();
				
		return menu;
	}
		
	public void firstMenu() throws InterruptedException {
		int menu = 0;
		do {
			if (money > 100000000 || money < 1000 || week >= 1000) {
				if (end_check()) {
					System.out.println("계속 진행하겠습니다.");
					Thread.sleep(1500);
				}
				else {
					if (realExit()) {
						System.exit(0);
					}
					else {
						firstMenu();
					}
				}
				}
			menu = gameMenu();
			console_clear();
			if (menu == 1) {
				menuOne();
			}
			else if (menu == 2) {
				menuTwo();
			}
			else if (menu == 3) {
				stats();
			}
			else if (menu == 4) {
				menuFour();
			}
			else if (menu == 5){
				gameSave();
				System.out.println("\n잠시 후 이동됩니다.");
				Thread.sleep(1500);
				console_clear();
				game_start_menu();
			}
			console_clear();
		} while (menu != 5);
	}
	
	// 등수 책정 및 당첨 번호 생성
	void rankCal(int num) {
		prize_lotto = Lotto_System.prize_num_sel();
		for (int i = 0; i<num; i++) {
			prize_rank[i] = LottoRankCheck.getLottoRank(my_lotto[i], prize_lotto);
		}
		for (int i = 0; i<prize_rank.length; i++) {
			if (prize_rank[i] > 0) {
				rank_cnt[prize_rank[i]-1]++;
			}
		}
	}
	
	//당첨 결과 출력
	void rankPrint(int num) throws InterruptedException {
		String key_input;
		int[] week_money = new int[num];
		String check = " ";
		int total_money = 0;
		
		System.out.println("당첨을 확인하려면 [엔터]를 누르세요.");
		Enter_Check();
		console_clear();
		
		for (int i = 3; i>=1; i--) {
			System.out.println("\t"+i);
			Thread.sleep(1000);
			console_clear();
		}
		
		rankCal(num);
		Lotto_System.prizeNumPrint(prize_lotto);
		System.out.println(" ["+week+"주차 로또 결과]");
		for (int i = 0; i<num; i++) {
			Lotto_System.numberPrint(i, my_lotto);
			System.out.println(" -> "+(prize_rank[i] == 0? "낙첨": prize_rank[i]+"등!"));
			week_money[i] += Lotto_System.getPrizeAmount(prize_rank[i]);
			total_money += week_money[i];
		}
		
		if (total_money > 0) {
			System.out.println("축하드립니다! 상금 "+total_money+"원 지금되었습니다!\n로또 당첨 내역에서 다시 확인할 수 있습니다!");
			moneyDeposit(total_money);
			setRank(week_money, num);
		}
		else {
			System.out.println("아쉽지만 다음 기회에~");
		}
		
		check = " ";
		System.out.println("\n계속하시려면 [엔터]를 누르세요.");
		Enter_Check();
		week++;
		lotto_buy_cnt += num;
		firstMenu();
	}
	
	//당첨 목록에 기록
	void setRank(int[] week_money, int num) {
		String bouns_num = Integer.toString(prize_lotto[6]);
		String prize_num = Arrays.toString(Arrays.copyOfRange(prize_lotto, 0, 6));
		for (int i = 0; i<num; i++) {
			if (prize_rank[i] > 0) {
				prize_list.add(new String[]{Integer.toString(week), Integer.toString(prize_rank[i]), Integer.toString(week_money[i]), prize_num, bouns_num, Arrays.toString(my_lotto[i])});
			}
		}
	}
	
	//게임 시작 후 첫번째 메뉴 선택
	
	
	
	
	
	//로또 구매 메뉴
	void menuOne () throws InterruptedException { 
		int num = 0;
		int menu = 0;
		System.out.println("=========================================");
		System.out.println("  원하시는 구매 수를 입력해 주십시오. (최대 5장)");
		System.out.println("=========================================");		
		System.out.printf("                       잔액 : %10d원\n", money);
		System.out.println("0. 돌아가기");
		num = InputMismatchTest();
		if (!moneyDraw(num * 1000)) {
			System.out.println("잔액이 부족하여 돌아갑니다.");
			Thread.sleep(1500);
			num = 0;
		}
		
		if (num <= 5 && num > 0) {
			console_clear();
			System.out.println("=======================================");
			System.out.println("       원하시는 방법을 선택해 주세요. ("+num+"장)");
			System.out.println("=======================================");
			System.out.printf("                      잔액 : %10d원\n", money);
			System.out.println(" 1. 자동");
			System.out.println(" 2. 수동");
			System.out.println(" 3. 돌아가기");
			menu = InputMismatchTest();
			console_clear();
			if (menu == 1) {
				System.out.println("자동을 선택하셨습니다.");
				Thread.sleep(1000);
				
				for (int i = 0; i<num; i++) {
					for (int j = 0; j<my_lotto[i].length; j++) {
						my_lotto[i][j] = (int)(Math.random() * 45)+1;
						for (int k = 0; k<j; k++) {
							if (my_lotto[i][j] == my_lotto[i][k]) {
								j--;
								break;
							}
						}
					}
					Lotto_System.numberPrint(i, my_lotto);
				}
			}
			else if (menu == 2) {
				System.out.println("수동을 선택하셨습니다.");
				Thread.sleep(1000);
				
				for (int i = 0; i<num; i++) {
					my_lotto[i] = LottoNumberGUI.inputNum(i);
					Lotto_System.numberPrint(i, my_lotto);
				}
			}
			else {
				return;
			}
			System.out.println();
			rankPrint(num);
		}
		else if (num == 0) {
			return;
		}
		else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오.\n");
			console_clear();
			menuOne();
		}
	}
	
	//당첨 내역 확인
	void menuTwo() {
		String check = " ";
		if (prize_list != null && !prize_list.isEmpty() && !prize_list.get(0)[0].equals(" ")) {
			for (String[] list : prize_list) {
				System.out.println("===============================================");
				System.out.println(list[0]+"회차 | "+list[1]+"등 | 상금 "+list[2]+"원");
				System.out.println("당첨 번호 : "+list[3]+" + ["+list[4]+"]");
				System.out.println("내 번호 : "+list[5]);
			}
		}
		else {
			System.out.println("당첨 내역이 없습니다.");
		}
		System.out.println("\n돌아가려면 [엔터]를 누르세요.");
		while (!check.isEmpty()) { //엔터를 누르면 넘어감
			check = sc.nextLine();
		}
		console_clear();
	}
	
	void menuFour() {
		Job_MiniGame game = new Job_MiniGame();
        game.show();

        try {
            game.awaitGameEnd(); // 게임 종료 신호를 기다림
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 게임 결과 출력
        if (game.isGameWon()) {
            moneyDeposit(10000);
        } else {
            moneyDraw(10000);
        }
	}
	
	//게임 시작 안내
	public void startGame() throws InterruptedException {
		if (saveLoad()) {
			System.out.println("다시 오신걸 환영합니다 "+getName()+"님!");
		}
		else {
			System.out.println("\n반갑습니다 "+getName()+"님!");
		}
		System.out.println("\n잠시 후 게임을 시작하겠습니다.");
		Thread.sleep(3000);
		console_clear();
	}
	
	//게임 시작 및 설명 메뉴
	void game_start_menu() throws InterruptedException { 
		Scanner sc = new Scanner(System.in);
		StartMenu menu = new StartMenu();
		int menu_num;
		while (true) {
			menu.menuPrint();
			menu_num = InputMismatchTest();
			console_clear();
			if (menu_num == 1) {
				if (menu.One()) {
					saveLoad();
					firstMenu();
				}
				else {
					game_start_menu();
				}
			}
			else if (menu_num == 2) {
				menu.Two();
				console_clear();
			}
			else if (menu_num == 3) {
				if (Initialization()) {
					console_clear();
				}
				else {
					game_start_menu();
				}
			}
			else if (menu_num == 4) {
				if (realExit()) {
					menu.Four();
				}
				else {
					console_clear();
					game_start_menu();
				}
			}
		}
	}
}