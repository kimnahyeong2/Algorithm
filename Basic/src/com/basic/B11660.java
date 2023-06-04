package com.basic;

import java.io.*;
import java.util.*;

public class B11660 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		/* 이렇게 풀면 시간초과가 발생

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int j=x1; j<=x2; j++) {
				sum += (map[j][y2] - map[j][y1-1]);
			}
			System.out.println(sum);
		}
		*/
		
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a[][] = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
        	st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int d[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
            	// 구간합 구하기 공식
                d[i][j] = d[i][j-1] + d[i-1][j] - d[i-1][j-1] + a[i][j];
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = d[x2][y2] - d[x1-1][y2] - d[x2][y1-1] + d[x1-1][y1-1];
            System.out.println(result);
        }
	}
}
