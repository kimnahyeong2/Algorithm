package com.bellman.ford;

import java.io.*;
import java.util.*;

public class B1865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int TC;
    static long dist[];
    static WarmHole edges[];
    
    public static void main(String[] args) throws IOException {
    	TC = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	for(int test=0; test<TC; test++) {
    		st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
    		int M = Integer.parseInt(st.nextToken());
    		int W = Integer.parseInt(st.nextToken());
    		
    		edges = new WarmHole[M+1];
    		dist = new long[N+1];
    		Arrays.fill(dist, 500*100_000);
    		
    		for(int i=0; i<M; i++) {
    			st = new StringTokenizer(br.readLine());
        		int s = Integer.parseInt(st.nextToken());
        		int e = Integer.parseInt(st.nextToken());
        		int t = Integer.parseInt(st.nextToken());
        		edges[i] = new WarmHole(s, e, t);
    		}
    		for(int i=0; i<W; i++) {
    			st = new StringTokenizer(br.readLine());
        		int s = Integer.parseInt(st.nextToken());
        		int e = Integer.parseInt(st.nextToken());
        		int t = Integer.parseInt(st.nextToken());
    		}
    	}
        
    }
}

class WarmHole{
	int start, end, time;
	public WarmHole(int start, int end, int time) {
		this.start = start;
		this.end = end;
		this.time = time;
	}
}
