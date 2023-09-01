package com.Dijkstra;

import java.util.*;
import java.io.*;

public class B13549 {
	static int N, K;
	static boolean[] visited;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100_001];
		
		PriorityQueue<Hide> que = new PriorityQueue<>((o1, o2)->o1.cost-o2.cost);
		que.add(new Hide(N, 0));
		
		int time = 0;
		
		while(!que.isEmpty()) {
			Hide start = que.poll();
			
			int position = start.point;
			time = start.cost;
			
			if(position == K) {
				break;
			}
			
			visited[position] = true;
						
			if(position*2 <= 100_000 && position < K && !visited[position*2]) {
				que.add(new Hide(position*2, time));
			}
			if(position < K && position+1 <= 100_000 && !visited[position+1]) {
				que.add(new Hide(position+1, time+1));
			}
			if(position-1 >= 0 && !visited[position-1]) {
				que.add(new Hide(position-1, time+1));
			}
		}
		
		System.out.println(time);
		
	}
}
class Hide{
	int point;
	int cost;
	public Hide(int point, int cost) {
		this.point = point;
		this.cost = cost;
	}
}
