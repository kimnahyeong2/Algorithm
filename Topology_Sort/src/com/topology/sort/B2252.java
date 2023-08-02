package com.topology.sort;

import java.io.*;
import java.util.*;

public class B2252 {
	static int M;
	static int N;
	static ArrayList<ArrayList<Integer>> array = new ArrayList<>();
	static int[] inDegree;
	static int[] topology;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {
			array.add(new ArrayList<>());
		}
		
		inDegree = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			array.get(x).add(y);
			inDegree[y]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0) {
				que.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!que.isEmpty()) {
			int now = que.poll();
			sb.append(now).append(" ");
			for(int next : array.get(now)) {
				inDegree[next]--;
				if(inDegree[next] == 0) {
					que.add(next);
				}
			}
		}
		System.out.println(sb);
	
	}
}
