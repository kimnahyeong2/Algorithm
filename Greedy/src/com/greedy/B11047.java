package com.greedy;

import java.io.*;
import java.util.*;

public class B11047 {
	static int N;
	static int K;
	static int[] array;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for(int i=N-1; i>=0; i--) {
			if(K >= array[i]) {
				count += K/array[i];
				K = K % array[i];
			}
		}
		System.out.println(count);
	}

}
