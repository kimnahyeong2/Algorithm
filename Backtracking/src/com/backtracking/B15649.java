package com.backtracking;

import java.util.*;
import java.io.*;

// 순열 : 중복X, 순서O
public class B15649 {
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N];
		
		permutation(0);
		System.out.println(sb);
	}
	
	public static void permutation(int depth) {
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				permutation(depth+1);
				visit[i] = false;
			}
		}
	}
}
