package com.topology.sort;

import java.io.*;
import java.util.*;

public class B1948 {
	static int N; // 도시의 개수
	static int M; // 도로의 개수
	static ArrayList<ArrayList<node>> map = new ArrayList<>(); //그래프
	static ArrayList<ArrayList<node>> mapReverse = new ArrayList<>(); //그래프
	static int[] topology; // 진입차수배열
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=N; i++) {
			map.add(new ArrayList<>());
			mapReverse.add(new ArrayList<>());
		}
		topology = new int[N+1];
		result = new int[N+1];
		
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map.get(s).add(new node(e, v));
			mapReverse.get(e).add(new node(s,v));
			topology[e]++;
		}

		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new LinkedList<>();
		que.add(startCity);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(node next : map.get(now)) {
				topology[next.target]--;
				result[next.target] = Math.max(result[next.target], result[now]+next.value);
				if(topology[next.target]==0) {
					que.add(next.target);
				}
			}
		}
		
		int resultCount = 0;
		boolean visited[] = new boolean[N+1];
		que = new LinkedList<>();
		que.add(endCity);
		visited[endCity] = true;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(node next : mapReverse.get(now)) {
				if(result[next.target] + next.value == result[now]) {
					resultCount++;
					if(visited[next.target] == false) {
						visited[next.target] = true;
						que.add(next.target);
					}
				}
			}
		}
		
		System.out.println(result[endCity]);
		System.out.println(resultCount);
	}
}

class node{
	int target;
	int value;
	node(int target, int value){
		this.target = target;
		this.value = value;
	}
}
