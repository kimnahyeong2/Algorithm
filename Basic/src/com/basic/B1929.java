package com.basic;

import java.io.*;
import java.util.*;

public class B1929 {
	static int M;
	static int N;
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		array = new int[N+1];
		
		for(int i=2; i<=N; i++) {
			array[i] = i;
		}
		
		for(int i=2; i<=Math.sqrt(N); i++) { // N의 제곱근까지만 수행
			if(array[i] == 0) {
				continue;
			}
			for(int j=i+1; j<=N; j += i) { // 배수지우기
				array[j] = 0;
			}
		}
		for(int i=M; i<=N; i++) {
			if(array[i] != 0) {
				System.out.println(array[i]);
			}
		}
		
	}
}
