package Project_2024;

import java.util.*;

public class Variables {
	Scanner sc = new Scanner(System.in);
	int week = 1;
	private String id;
	private String password;
	int[][] my_lotto = new int[5][6];
	int[] prize_lotto = new int[7];
	int[] prize_rank = new int[5];
	int lotto_buy_cnt = 0;
	int[] end_state = new int[4];
	int money = 20000;
	int[] rank_cnt = new int[5];
	int total_rank_cnt;
	int net_profit = 0;
	
	List<String[]> prize_list = new ArrayList<>();
	
	
	Variables(String id, String pw) {
		this.id = id;
		this.password = pw;
	}
	
	//이름 리턴
	String getName() {
		return id;
	}
	
	//출금
	boolean moneyDraw(int num) {
		if (money - num < 0) {
			System.out.println("금액이 부족합니다.");
			return false;
		}
		else {
			money -= num;
			return true;
		}	
	}
	
	//입금
	void moneyDeposit(int num) {
		money += num;
	}
	
	String getID () {
		return id;
	}
	
	boolean Initialization() {
		Scanner sc = new Scanner(System.in);
		String menu = "";
		System.out.println("정말 초기화하시겠습니까?");
		System.out.println(" Y. 예");
		System.out.println(" N. 아니오");
		System.out.print("\n입력 : ");
		menu = sc.next();
		if (menu.toUpperCase().charAt(0) == 'Y') {
			GameInitialization zero = new GameInitialization(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	//정수 입력해서 문자 입력시 캐치
	public static int InputMismatchTest() { 
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		while (true) {
			System.out.print("\n입력 : ");
			try {
				menu = sc.nextInt();
		        break;
		    } catch (InputMismatchException e) {
		        sc.nextLine();
		        System.out.println("잘못 입력하셨습니다. 숫자를 입력해 주십시오.");
		    }
		}
		return menu;
	}
	
	//엔딩 확인
	boolean end_check() {
		console_clear();
		if (money > 100000000) {
			if (end_state[0] == 0)
				end_state[0] = 1;
				System.out.println("축하드립니다! 로또를 통해 1억원을 얻으셨습니다!");
				System.out.println("계속 진행하시겠습니까? Y or N");
				String menu = sc.next();
					
				if (menu.toUpperCase().charAt(0) == 'Y') {
					end_state[0] = 1;
					return true;
				}
				else {
					return false;
				}
		}
		else if (money < 1000) {
			if (end_state[1] == 0) {
				System.out.println("당신은 로또에 중독되어 결국 파산하게 되었습니다.");
				end_state[3]++;
				System.out.println("현재까지 파산 횟수 : "+end_state[3]);
				System.out.println("파산 신청 후 이어서 하시겠습니까? Y or N");
				String menu = sc.next();
					
				if (menu.toUpperCase().charAt(0) == 'Y') {
					end_state[1] = 1;
					money = 20000;
					return true;
				}
				else {
					return false;
				}
			}
				
		}
		else if (week >= 1000) {
			if (end_state[2] == 0) {
				end_state[2] = 1;
				System.out.println("당신은 1000회 구매하였고, 로또를 "+lotto_buy_cnt+"개 구매했습니다.");
				System.out.println("이어서 하시겠습니까? Y or N");
				String menu = sc.next();
					
				if (menu.toUpperCase().charAt(0) == 'Y') {
					end_state[2] = 1;
					return true;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	//현재 통계(상태) 출력
	void stats() {
		total_rank_cnt = Arrays.stream(rank_cnt).sum();
		double total_prize_probability = (total_rank_cnt==0 || lotto_buy_cnt==0? 0: ((double)total_rank_cnt/(double)lotto_buy_cnt)*100);
		double[] lotto_probability = new double[5];
		int lottoBuyMoney = lotto_buy_cnt*1000;
		for (int i = 0; i<5; i++) {
			lotto_probability[i] = (rank_cnt[i]==0 || lotto_buy_cnt==0? 0: ((double)rank_cnt[i]/(double)lotto_buy_cnt)*100);
		}
		int totalPrizeMoney = 0;
		if (prize_list != null && !prize_list.isEmpty() && !prize_list.get(0)[0].equals(" ")) {
			for (int i = 0; i<prize_list.size(); i++) {
				totalPrizeMoney += Integer.parseInt(prize_list.get(i)[2]);
			}
		}
		System.out.println("[ "+id+" ]님의 통계는 다음과 같습니다\n");
		System.out.printf("진행한 회차 : %5d회\n", week);
		System.out.printf("구매한 로또 : %5d개\n", lotto_buy_cnt);
		System.out.printf("로또 투자금액 : %6d원\n", lottoBuyMoney);
		System.out.printf("총이익 : %8d원\n", totalPrizeMoney);
		System.out.printf("순이익 : %8d원\n", totalPrizeMoney-lottoBuyMoney);
		System.out.printf("파산 횟수 : %7d번\n", end_state[3]);
		System.out.println("\n<당첨 횟수 및 확률>");
		for (int i = 0; i<5; i++) {
			System.out.printf("%d등 : %3d번 | %.2f%%\n", i+1, rank_cnt[i], lotto_probability[i]);
		}
		System.out.println("총 당첨 횟수 : "+total_rank_cnt);
		System.out.printf("로또 총 당첨 확률 : %.2f%%", total_prize_probability);
		System.out.println("\n\n확인이 끝나셨다면 [엔터]를 누르세요");
		Enter_Check();
		console_clear();
	}
	
	//엔터 누르면 넘어가기
	void Enter_Check() {
		String check = " ";
		while (!check.isEmpty()) {
			check = sc.nextLine();
		}
	}
	
	//콘솔 창 클리어
	static void console_clear(){ 
		for (int i = 0; i<40; i++) {
			System.out.println();
		}
	}
}
