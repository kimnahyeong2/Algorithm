package com.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
	//static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int []num;
	static int []cal;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		cal = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		
		calculator(num[0], 1);
		System.out.println(max);
		System.out.println(min);

	}

	public static void calculator(int number, int idx) {
		if(idx == N) {
			if(number > max) {
				max = number;
			}
			if(number < min) {
				min = number;
			}
			return;
		}
		
		for(int j=0; j<4; j++) {
			if(cal[j] != 0) {
				cal[j]--;
				switch(j) {
					case 0:	calculator(number + num[idx], idx + 1);	break;
					case 1:	calculator(number - num[idx], idx + 1);	break;
					case 2:	calculator(number * num[idx], idx + 1);	break;
					case 3:	calculator(number / num[idx], idx + 1);	break;
				}
				cal[j]++;
			}
		}
	}

}
