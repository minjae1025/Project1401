package Project_2024;

import java.util.*;

public class Main extends Account{

	public static void main(String[] args) throws InterruptedException {
		String[] id_pw;
		String[] tmp;
		 while(true) {
			tmp = loginMenu();
			if (tmp.length > 1) {
				id_pw = tmp;
				break;
			}
		}
		
		Client player = new Client(id_pw[0], id_pw[1]);
		player.console_clear();
		player.game_start_menu();
	}
	
	static String[] loginMenu() throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		int login_menu;
		boolean check = false;
		String id = "";
		String pw = "";
		
		Logo_Print.Print();
		System.out.println("========================================");
		System.out.println(" 1. 로그인");
		System.out.println(" 2. 회원가입");
		System.out.println(" 3. 게임 종료");
		System.out.print("\n입력 : ");
		login_menu = InputMismatchTest();
		Client.console_clear();
		
		if (login_menu == 1) {
			do {
				String[] id_pw = id_pw_input();
				if (id_pw.length < 2) {
					return new String[]{""};
				}
				id = id_pw[0];
				pw = id_pw[1];
				check = login(id, pw);
				if (check == false) {
					Client.console_clear();
					System.out.println("\n아이디 혹은 비밀번호가 틀렸습니다.\n다시 입력하십시오.");
				}
			} while (!check);
			System.out.println("\n 로그인 성공! \n 잠시 후 게임 화면으로 넘어갑니다");
			Thread.sleep(2000);
		}
		else if (login_menu == 2) {
			boolean overlap_check = false;
			do {
				System.out.println("주의 : 비밀번호를 잊을 경우 불러오지 못합니다.");
				String[] id_pw = id_pw_input();
				if (id_pw.length < 2) {
					return new String[]{""};
				}
				id = id_pw[0];
				pw = id_pw[1];
				overlap_check = sign_up(id, pw);
			} while (!overlap_check);
		}
		else {
			System.out.println("게임 종료");
			sc.close();
			System.exit(0);
		}
		return new String[]{id, pw};
	}
	
	static String[] id_pw_input() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		String id, pw;
		System.out.println("돌아가실려면 [B] 입력");
		System.out.println("\n아이디를 입력하시오.");
		id = sc.next();
		if (back_menu(id)) {
			return new String[]{""};
		}
		else {
			System.out.println("\n비밀번호를 입력하시오.");
			pw = sc.next();
			if (back_menu(pw)) {
				return new String[]{""};
			}
			else {
				return new String[]{id, pw};
			}
		}
	}
	
	static boolean back_menu(String str) throws InterruptedException {
		if (str.toUpperCase().equals("B")) {
			Client.console_clear();
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int InputMismatchTest() { 
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		while (true) {
			try {
				menu = sc.nextInt();
		        break;
		    } catch (InputMismatchException e) {
		        sc.nextLine(); // 잘못된 입력을 버퍼에서 제거
		        System.out.println("잘못 입력하셨습니다. 숫자를 입력해 주십시오.");
		        System.out.print("입력 : ");
		    }
		}
		return menu;
	}
}