package com.MirimLotto.AccountSys;

import java.io.*;

public class Login {
	public static boolean run(String id, String pw) {
		String directoryPath = "userdatas/accounts"; // 검색할 디렉토리 경로
		String targetFileName = id+"_pw.txt"; // 찾고자 하는 파일 이름

		File directory = new File(directoryPath);

	        // 디렉토리 내에서 특정 파일을 찾는다
	    File[] files = directory.listFiles((dir, name) -> name.equals(targetFileName));

	        // 파일이 발견되었는지 확인
	    if (files != null && files.length > 0) {
	        File foundFile = files[0]; // 발견된 파일
	            
	            // 파일 읽기
	        try (BufferedReader reader = new BufferedReader(new FileReader(foundFile))) {
	        	String[] line = (reader.readLine()).split(", ");
	                // 파일의 각 줄을 읽고 출력
	            if (line[0].equals(id) && line[1].equals(pw)) {
	            	return true;
	            }
	            else {
	            	return false;
	            }
	        } catch (IOException e) {
	        	System.out.println("파일을 찾는 도중 에러 발생: " + e.getMessage());
	        }
	    
	    }
	    return false;
	}
}
