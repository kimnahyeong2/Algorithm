package com.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//중복조합 : 중복O, 순서O

public class B15651 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<=N; i++) {
			arr[depth] = i;
			dfs(depth+1);
		}
	}
}
