package com.basic;

import java.io.*;
import java.util.*;

public class B1929 {
	static int M;
	static int N;
	static int[] array;
	static boolean[] prime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		array = new int[N+1];
		prime = new boolean[N + 1];
		get_prime();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=M; i<=N; i++) {
			if(!prime[i]) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
	// 에라토스테네스의 체 알고리즘
	public static void get_prime() {
		// true = 소수아님 , false = 소수 
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}

