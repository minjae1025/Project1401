package Project_2024;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GameInitialization {
	String id;
	public GameInitialization(String id) {
		this.id = id;
		Initialization();
	}
	void Initialization() {
		String Save_file = "userdatas/savefiles/"+id+"_savefile.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Save_file))) {
			writer.write(1 + ", " + 20000 + ", " + 0);
			for (int i = 0; i<4; i++) {
				writer.write(", "+0);
			}
			for (int i = 0; i<5; i++) {
				writer.write(", "+0);
			}
			writer.newLine();
		}
		catch (IOException e ) {
			e.printStackTrace();
		}
		
		String Lotto_history_file = "userdatas/lotto_history/"+id+"_prize_lotto_list.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Lotto_history_file))) {
			writer.newLine();
		}
		catch (IOException e ) {
			e.printStackTrace();
		}
		
		System.out.println("\n초기화 성공!");
		
	}
}
