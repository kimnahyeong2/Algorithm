package com.Dijkstra;

import java.io.*;
import java.util.*;

public class B1753 {
	static class Node{
		int v; // 간선
		int cost; // 가중치
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
	static int V; // 노드의 개수
	static int E; // 에지의 개수
	static int K; // 시작 노드
	// u -> v 사이 가중치 w
	static ArrayList<Node>[] graph; // 각 노드에 연결되어 있는 노드에 대한 정보
	static boolean[] visited; // 방문 여부 체크
	static int[] dist; // 최단 거리 테이블
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V+1];
		visited = new boolean[V+1];
		dist = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int inputU = Integer.parseInt(st.nextToken());
			int inputV = Integer.parseInt(st.nextToken());
			int inputW = Integer.parseInt(st.nextToken());
			graph[inputU].add(new Node(inputV, inputW));
		}
		
		dijkstra(K);
		
		for(int i=1; i<V+1; i++) {
        	System.out.println(dist[i] == Integer.MAX_VALUE? "INF" : dist[i]);
		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(!visited[now.v]) {
				visited[now.v] = true;
			}
			for(Node next : graph[now.v]) {
				if(!visited[next.v] && dist[next.v]>now.cost+next.cost) {
					dist[next.v] = now.cost + next.cost;
					q.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
}
