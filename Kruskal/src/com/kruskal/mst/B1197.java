package com.kruskal.mst;

import java.io.*;
import java.util.*;


public class B1197 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V; // 정점의 개수
    static int E; // 간선의 개수
    static int[] parent;
    static PriorityQueue<Edge> queue;

    public static void main(String[] args) throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
    	queue = new PriorityQueue<>();
    	parent = new int[V+1];
    	for(int i=0; i<=V; i++) {
    		parent[i] = i;
    	}
    	
    	for(int i=0; i<E; i++) {
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		queue.add(new Edge(s, e, v));
    	}
    	
    	int useEdge = 0;
    	int result = 0;
    	while(useEdge < V-1) {
    		Edge now = queue.poll();
    		if(find(now.s) != find(now.e)) {
    			union(now.s, now.e);
    			result = result + now.v;
    			useEdge++;
    		}
    	}
    	System.out.println(result);
    }
    public static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a!=b) {
    		parent[b] = a;
    	}
    }
    public static int find(int a) {
    	if(a==parent[a]) {
    		return a;
    	}
    	else {
    		return parent[a] = find(parent[a]);
    	}
    }
}

class Edge implements Comparable<Edge>{
	int s, e, v;
	Edge(int s, int e, int v){
		this.s = s;
		this.e = e;
		this.v = v;
	}
	
	@Override
	public int compareTo(Edge o) {
		// 가중치를 기준으로 오름차순
		return this.v - o.v;
	}
}
