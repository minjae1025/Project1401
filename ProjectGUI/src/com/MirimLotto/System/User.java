package com.MirimLotto.System;

import java.io.*;
import java.util.*;

import javax.swing.SwingUtilities;

import com.MirimLotto.LottoBuy.LottoNumberGUI;

public class User {
	public int week = 1;
	private String id;
	public int[][] my_lotto = new int[5][6];
	public int[] prize_lotto = new int[7];
	public int[] prize_rank = new int[5];
	public int lotto_buy_cnt = 0;
	public int[] end_state = new int[4];
	int money = 30000;
	public int[] rank_cnt = new int[5];
	public int total_rank_cnt;
	public int current_buy_num;
	public String lotto_buy_way;
	public int totalPrizeMoney = 0;
	
	List<String[]> prize_list = new ArrayList<>();
	
	
	public User(String id) {
		this.id = id;
		saveLoad();
	}
	
	//이름 리턴
	public String getId() {
		return id;
	}
	
	public int getMoney() {
		return money;
	}
	
	//출금
	public boolean moneyDraw(int num) {
		if (money - num < 0) {
			return false;
		}
		else {
			money -= num;
			return true;
		}	
	}
	
	//입금
	public void moneyDeposit(int num) {
		money += num;
	}
	
	static int getPrizeAmount(int rank) {
	    switch (rank) {
	        case 1:
	            return 100000000; // 1억
	        case 2:
	            return (int) (Math.random() * 10000000) + 20000000; // 2000만~3000만
	        case 3:
	            return (int) (Math.random() * 5000000) + 2000000;  // 500만~700만
	        case 4:
	            return (int) (Math.random() * 1000000) + 1000000;  // 100만~200만
	        case 5:
	            return (int) (Math.random() * 300000) + 100000;   // 10만~40만
	        default:
	            return 0; // 낙첨
	    }
	}
	
	public void prize_num_sel() {
		for (int i = 0; i<prize_lotto.length; i++) {
			prize_lotto[i] = (int)(Math.random() * 45)+1;
			for (int j = 0; j<i; j++) {
				if (prize_lotto[i] == prize_lotto[j]) {
					i--;
					break;
				}
			}
		}
	}
	
	//엔딩 확인
	boolean end_check() {
		if (money > 100000000) {
			if (end_state[0] == 0)
				end_state[0] = 1;
//				System.out.println("축하드립니다! 로또를 통해 1억원을 얻으셨습니다!");
//				System.out.println("계속 진행하시겠습니까? Y or N");
//				String menu = sc.next();
//					
//				if (menu.toUpperCase().charAt(0) == 'Y') {
//					end_state[0] = 1;
//					return true;
//				}
//				else {
//					return false;
//				}
		}
		else if (money < 1000) {
			if (end_state[1] == 0) {
//				System.out.println("당신은 로또에 중독되어 결국 파산하게 되었습니다.");
//				end_state[3]++;
//				System.out.println("현재까지 파산 횟수 : "+end_state[3]);
//				System.out.println("파산 신청 후 이어서 하시겠습니까? Y or N");
//				String menu = sc.next();
//					
//				if (menu.toUpperCase().charAt(0) == 'Y') {
//					end_state[1] = 1;
//					money = 20000;
//					return true;
//				}
//				else {
//					return false;
//				}
			}
				
		}
		return true;
	}
	
	public boolean gameSave() {
		String Save_file = "userdatas/savefiles/"+id+"_savefile.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Save_file))) {
			writer.write(week + ", " + money + ", " + lotto_buy_cnt + ", " + totalPrizeMoney);
			for (int i = 0; i<4; i++) {
				writer.write(", "+end_state[i]);
			}
			for (int i = 0; i<5; i++) {
				writer.write(", "+rank_cnt[i]);
			}
			writer.newLine();
			System.out.println("\n저장 성공!");
			return true;
		}
		catch (IOException e ) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 저장본 불러오기
	boolean saveLoad() {
		String directoryPath = "userdatas/savefiles"; // 검색할 디렉토리 경로
        String targetFileName = id+"_savefile.txt"; // 찾고자 하는 파일 이름

        File directory = new File(directoryPath);

        // 디렉토리 내에서 특정 파일을 찾기
        File[] files = directory.listFiles((dir, name) -> name.equals(targetFileName));

        // 파일이 발견되었는지 확인
        if (files != null && files.length > 0) {
            File foundFile = files[0]; // 발견된 파일
            System.out.println("파일 찾음: " + foundFile.getAbsolutePath());
            
            // 파일 읽기
            try (BufferedReader reader = new BufferedReader(new FileReader(foundFile))) {
            	String line = reader.readLine(); // 첫 번째 줄 읽기
                if (line == null || line.isEmpty()) { // 파일이 비어 있으면 처리
                    System.out.println("저장된 데이터가 없습니다.");
                    return false;
                }
                else {
                	String[] parts = line.split(", ");
                    week = Integer.parseInt(parts[0]);
                    money = Integer.parseInt(parts[1]);
                    lotto_buy_cnt = Integer.parseInt(parts[2]);
                    totalPrizeMoney = Integer.parseInt(parts[3]);
                    for (int i = 0; i<4; i++) {
    					end_state[i] = Integer.parseInt(parts[i+4]);
    				}
                    for (int i = 0; i<5; i++) {
                    	rank_cnt[i] = Integer.parseInt(parts[i+8]);
                    }
                    System.out.println("로드 성공");
                    return true;
                }
            } catch (IOException e) {
                System.out.println("파일을 찾는 도중 에러 발생: " + e.getMessage());
            }
        } else {
        	return false;
    	}
        return true;
	}

		
		public void firstMenu() {
			int menu = 0;
			do {
				if (money > 100000000 || money < 1000 || week >= 1000) {
					if (end_check()) {
						System.out.println("계속 진행하겠습니다.");
					}
					else {
					}
				}
				if (menu == 1) {
				}
				else if (menu == 2) {
				}
				else if (menu == 3) {
//					MiniGame user = new MiniGame();
//					boolean start = user.gameGuide();
//					if (start) {
//						moneyDraw(1000);
//						int prize_money = user.gamePlay();
//						moneyDeposit(prize_money);
//					}
//					else {
//						System.out.println("잠시 후 돌아갑니다");
//						Thread.sleep(3000);
//					}
				}
			} while (menu != 5);
		}
		
		// 등수 책정 및 당첨 번호 생성
		public void rankCal() {
			for (int i = 0; i<current_buy_num; i++) {
				prize_rank[i] = LottoRankCheck.getLottoRank(my_lotto[i], prize_lotto);
			}
			for (int i = 0; i<prize_rank.length; i++) {
				if (prize_rank[i] > 0) {
					rank_cnt[prize_rank[i]-1]++;
				}
			}
		}
		
		//당첨 결과 출력
		public int rankPrint(){
			int[] week_money = new int[current_buy_num];
			int total_money = 0;
			
			prize_num_sel();
			rankCal();
			for (int i = 0; i<current_buy_num; i++) {
				week_money[i] += getPrizeAmount(prize_rank[i]);
				total_money += week_money[i];
			}
			
			if (total_money > 0) {
				moneyDeposit(total_money);
			}
			else {
			}
			week++;
			lotto_buy_cnt += current_buy_num;
			return total_money;
		}
		
		//당첨 목록에 기록
//		void setRank(int[] week_money, int num) {
//			String bouns_num = Integer.toString(prize_lotto[6]);
//			String prize_num = Arrays.toString(Arrays.copyOfRange(prize_lotto, 0, 6));
//			for (int i = 0; i<num; i++) {
//				if (prize_rank[i] > 0) {
//					prize_list.add(new String[]{Integer.toString(week), Integer.toString(prize_rank[i]), Integer.toString(week_money[i]), prize_num, bouns_num, Arrays.toString(my_lotto[i])});
//				}
//			}
//		}
		
		
		//수동 및 자동 판단 후 숫자 고르기
		public void numberSelSelect(String way, int num) {
			if (way.equals("자동")) {
				for (int j = 0; j<my_lotto[num].length; j++) {
					my_lotto[num][j] = (int)(Math.random() * 45)+1;
					for (int k = 0; k<j; k++) {
						if (my_lotto[num][j] == my_lotto[num][k]) {
							j--;
							break;
						}
					}
				}
			}
			else {
				my_lotto[num] = LottoNumberGUI.inputNum(num);
			}
		}
		
		public void myLottoClear() {
			for (int i = 0; i<5; i++) {
				for (int j = 0; j<6; j++) {
					my_lotto[i][j] = 0;
				}
			}
		}
}
