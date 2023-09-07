package com.tsp;

import java.io.*;
import java.util.*;

public class B2098 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[][] map;
	static int[][] dp;
	static final int INF = 11000000;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][(1<<N)-1];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], INF);
		}
		
		System.out.println(dfs(0,1));
		
	}
	
	private static int dfs(int city, int visitBitmask) {
		if(visitBitmask == (1<<N)-1) {
			if(map[city][0] == 0) {
				return INF;
			}
			return map[city][0];
		}
		
		if(dp[city][visitBitmask] != INF) {
			return dp[city][visitBitmask];
		}
		
		for(int i=0; i<N; i++) {
			if((visitBitmask & (1<<i)) == 0 && map[city][i]!=0) {
				dp[city][visitBitmask] = Math.min(dp[city][visitBitmask], dfs(i, visitBitmask | (1 << i)) + map[city][i]); 
			}
		}
		return dp[city][visitBitmask];
	}

}
