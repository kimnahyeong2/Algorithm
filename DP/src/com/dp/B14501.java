package com.dp;

import java.io.*;
import java.util.*;

public class B14501 {
	static int N;
	static int[] Time;
	static int[] Pay;
	static int[] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		Time = new int[N+2];
		Pay = new int[N+2];
		D = new int[N+2];
		
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			Time[i] = Integer.parseInt(st.nextToken());
			Pay[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=N; i>0; i--) {
			if(i + Time[i] > N+1) {
				D[i] = D[i+1];
			}
			else {
				D[i] = Math.max(D[i+1], Pay[i] + D[i + Time[i]]);
			}
		}
		System.out.println(D[1]);
		
		
	}
}
