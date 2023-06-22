package com.basic;

import java.io.*;
import java.util.*;

public class B1920 {
	static int N, M;
	static int[] A;
	static int target;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			target = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(target, 0, N-1));
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	public static int binarySearch(int target, int left, int right) {

		if(left > right) {
			return 0;
		}
		
		int mid = (left + right) / 2;
		
		if(A[mid] == target) {
			return 1;
		}
		else if(A[mid] > target) {
			return binarySearch(target, left, mid-1);
		}
		else {
			return binarySearch(target, mid+1, right);
		}
	}

}
