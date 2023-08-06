package com.Dijkstra;

import java.io.*;
import java.util.*;

public class B1916 {
	static int N; //도시개수
	static int M; // 버스 개수
	static ArrayList<Node>[] graph;
	static int[] dist;
	static boolean[] visit;
	static int start;
	static int end;
	
	static class Node{
		int v;
		int cost;
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		dist = new int[N+1];
		visit = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int startBus = Integer.parseInt(st.nextToken());
			int endBus = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[startBus].add(new Node(endBus, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		System.out.println(dist[end]);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2)->o1.cost-o2.cost);
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(!visit[now.v]) {
				visit[now.v] = true;
			}
			if(now.v == end) {
				break;
			}
			for(Node next : graph[now.v]) {
				if(!visit[next.v] && dist[next.v] > now.cost+next.cost) {
					dist[next.v] = now.cost + next.cost;
					q.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

}
