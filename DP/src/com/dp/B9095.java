package com.dp;

import java.io.*;
import java.util.*;

public class B9095 {
	static int T;
	static int[] answer;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		answer = new int[11];
		answer[1] = 1;
		answer[2] = 2;
		answer[3] = 4;
		
		for(int j=4;j<=10;j++) { // 4부터 반복
			answer[j] = answer[j-3] + answer[j-2] + answer[j-1]; // 점화식
		}
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(answer[N]);
		}
	}

}
