package com.floyd.warshell;

import java.io.*;
import java.util.*;


public class B11404 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 도시의 수
    static int M; // 버스 개수
    static int dist[][]; // 정답 배열

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=N; j++) {
        		if(i==j) {
        			dist[i][j] = 0;
        		}
        		else {
        			dist[i][j] = 10000001;
        		}
        	}
        }
        
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            if(dist[start][end] > money) {
            	dist[start][end] = money;
            }
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
        		if(dist[i][j] == 10000001) {
        			bw.write("0 ");
        		}
        		else {
        			bw.write(dist[i][j] + " ");
        		}
        	}
        	bw.write("\n");
        }
        
        bw.flush();
        bw.close();

    }
}
