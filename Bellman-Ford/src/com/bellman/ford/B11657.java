package com.bellman.ford;

import java.io.*;
import java.util.*;

public class B11657 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 도시의 수
    static int M; // 버스 개수
    static long dist[]; // 정답 배열
    static Edge edges[]; // 에지 리스트

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M+1];
        dist = new long[N+1];
        
        Arrays.fill(dist, 500 * 100_000);
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int time = Integer.parseInt(st.nextToken());
        	edges[i] = new Edge(start, end, time);
        }
        dist[1] = 0;
        for(int i=1; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		Edge edge = edges[j];
        		if(dist[edge.start] != 500 * 100_000 && dist[edge.end] > dist[edge.start] + edge.time) {
        			dist[edge.end] = dist[edge.start] + edge.time;
        		}
        	}
        }
        
        boolean mCycle = false;
        
    	for(int j=0; j<M; j++) {
    		Edge edge = edges[j];
    		if(dist[edge.start] != 500 * 100_000 && dist[edge.end] > dist[edge.start] + edge.time) {
    			mCycle = true;
    			break;
    		}
    	}
    	
    	if(!mCycle) {
    		for(int i=2; i<=N; i++) {
    			if(dist[i] == 500 * 100_000) {
    				bw.write("-1\n");
    			}
    			else {
    				bw.write(dist[i]+"\n");
    			}
    		}
    	}
    	else {
    		bw.write("-1");
    	}
    	bw.close();
    }

}
class Edge{
	int start, end, time;
	public Edge(int start, int end, int time) {
		this.start = start;
		this.end = end;
		this.time = time;
	}
}