package com.floyd.warshell;

import java.io.*;
import java.util.*;

public class B2660 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] friend;
	static int[][] member;
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		friend = new int[N+1];
		member = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
            	if(i==j) member[i][j] = 0;
            	else member[i][j] = INF;
            }
        }
        
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x == -1 && y == -1) {
				break;
			}
			
			member[x][y] = member[y][x] = 1;
		}
		
		floyd();
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			int max = 0;
			for(int j=1; j<=N; j++) {
				if(max < member[i][j]) {
					max = member[i][j];
				}
			}
			friend[i] = max;
			if(min > max) {
				min = max;
			}
		}
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(friend[i] == min) {
				count++;
				sb.append(i + " ");
			}
		}
		
		System.out.println(min + " " + count);
		System.out.println(sb);
		
	}
	
	private static void floyd() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					member[i][j] = Math.min(member[i][k] + member[k][j], member[i][j]);
				}
			}
		}
	}
}