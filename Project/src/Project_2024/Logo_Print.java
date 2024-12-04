package Project_2024;

import java.io.*;

public class Logo_Print {
	//로고 출력
	static void Print(){
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("title.txt"));
			String line;
	        while ((line = reader.readLine()) != null) {
	        	System.out.println(line);
	        }
		} catch (IOException e) {
			System.err.println("파일을 읽는 중 에러 발생");
			e.printStackTrace();
		}
        
	}
}
