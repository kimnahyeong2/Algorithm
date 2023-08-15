package com.floyd.warshell;

import java.io.*;
import java.util.*;


public class B11403 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 노드의 개수
    static int[][] dist;

    public static void main(String[] args) throws IOException {
    	N = Integer.parseInt(br.readLine());
    	dist = new int[N][N];
    	
    	for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
            	dist[i][j] = Integer.parseInt(st.nextToken());
        	}
    	}
    	
    	for(int k=0; k<N; k++) {
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<N; j++) {
    				if(dist[i][k] == 1 && dist[k][j] == 1) {
    					dist[i][j] = 1;
    				}
    			}
    		}
    	}
    	
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				bw.write(dist[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
    	
    }
}
