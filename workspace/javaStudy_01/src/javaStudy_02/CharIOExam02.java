package javaStudy_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;

public class CharIOExam02 {

	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new FileReader("src/javaStudy_02/CharIOExam02.java"));
			pw = new PrintWriter(new FileWriter("test.txt"));
			String line = null;
			while((line = br.readLine()) != null) {
				pw.println(line);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

}
