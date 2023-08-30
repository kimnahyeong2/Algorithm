package com.kruskal.mst;

import java.util.*;
import java.io.*;

public class B13905 {
	static int N, M, s, e;
	static int[] parent;
	static PriorityQueue<EdgeHome> queue;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i=0; i<N+1; i++) {
			parent[i] = i;
		}
		queue = new PriorityQueue<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			queue.add(new EdgeHome(h1, h2, k));
		}
		
		int answer = 0;
		
		while(!queue.isEmpty()) {
			EdgeHome edge = queue.poll();
			if(find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				if(find(s) == find(e)) {
					answer = edge.weight;
					break;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
		}
		
	}
	public static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
}
class EdgeHome implements Comparable<EdgeHome>{
	int start, end, weight;
	EdgeHome(int start, int end, int weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(EdgeHome o) {
		return o.weight - this.weight;
	}
}