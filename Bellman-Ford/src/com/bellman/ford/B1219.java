package com.bellman.ford;

import java.io.*;
import java.util.*;

public class B1219 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 도시의 수
    static int startCity; // 시작 도시
    static int endCity; // 도착 도시
    static int M; // 교통 수단의 개수
    static long[] dist;
    static long[] money;
    static Edges[] edges;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dist = new long[N];
        money = new long[N];
        edges = new Edges[M];
        Arrays.fill(dist, Long.MIN_VALUE);
        
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int time = Integer.parseInt(st.nextToken());
        	edges[i] = new Edges(start, end, time);
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	money[i] = Long.parseLong(st.nextToken());
        }
        
        dist[startCity] = money[startCity];
        
        for(int i=0; i<= N+100; i++) {
        	for(int j=0; j<M; j++) {
        		int start = edges[j].start;
        		int end = edges[j].end;
        		int price = edges[j].price;
        		
        		if(dist[start] == Long.MIN_VALUE) continue;
        		else if(dist[start] == Long.MAX_VALUE) dist[end] = Long.MAX_VALUE;
        		else if(dist[end] < dist[start] + money[end] - price) {
        			dist[end] = dist[start] + money[end] - price;
        			if(i >= N-1) dist[end] = Long.MAX_VALUE;
        		}
        	}
        }
        if(dist[endCity] == Long.MIN_VALUE) bw.write("gg");
        else if(dist[endCity] == Long.MAX_VALUE) bw.write("Gee");
        else bw.write(dist[endCity]+"");
        bw.flush();
        bw.close();
    }
}
class Edges{
	int start, end, price;
	public Edges(int start, int end, int price) {
		this.start = start;
		this.end = end;
		this.price = price;
	}
}