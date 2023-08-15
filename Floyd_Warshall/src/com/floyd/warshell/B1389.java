package com.floyd.warshell;

import java.io.*;
import java.util.*;


public class B1389 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N; // 유저의 수
    static int M; // 친구 관계의 수
    static int dist[][]; // 정답 배열

    public static void main(String[] args) throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1][N+1];
        
    	for(int i=1; i<=N; i++) {
    		for(int j=1; j<=N; j++) {
    			if(i == j) {
    				dist[i][j] = 0;
    			}
    			else {
    				dist[i][j] = 1000000001;
    			}
    		}
    	}
    	
        for(int k=1; k<=M; k++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	dist[x][y] = dist[y][x] = 1;
        }
        
        for(int k=1; k<=N; k++) {
        	for(int i=1; i<=N; i++) {
        		for(int j=1; j<=N; j++) {
        			if(dist[i][j] > dist[i][k] + dist[k][j]) {
        				dist[i][j] = dist[i][k] + dist[k][j];
        			}
        		}
        	}
        }
        
    	for(int i=1; i<=N; i++) {
    		for(int j=1; j<=N; j++) {
    			System.out.print(dist[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
        int min = Integer.MAX_VALUE;
        int answer = -1;
        
        for(int i=1; i<=N; i++) {
        	int tmp = 0;
        	for(int j=1; j<=N; j++) {
        		tmp = tmp + dist[i][j];
        	}
        	System.out.println(i + " " + tmp);
        	if(min > tmp) {
        		min = tmp;
        		answer = i;
        	}
        }
        System.out.println(answer);
    }
}
