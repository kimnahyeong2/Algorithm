package com.topology.sort;

import java.io.*;
import java.util.*;

public class B2056 {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> array = new ArrayList<>();
	static int N;
	static int[] time; // 작업에 걸리는 시간
	static int[] topology; // 진입차수배열	
	static int[] result;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N+1; i++) {
			array.add(new ArrayList<>());
		}
		
		time = new int[N+1];
		topology = new int[N+1];
		result = new int[N+1];
		
		StringTokenizer st;
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			topology[i] = Integer.parseInt(st.nextToken());
			for(int j=0; j<topology[i]; j++) {
				array.get(Integer.parseInt(st.nextToken())).add(i);
			}
		}
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1; i<N+1; i++) {
			if(topology[i] == 0) {
				que.add(i);
			}
		}
		
		while(!que.isEmpty()) {
			int now = que.poll();
			if(array.get(now).size()==0) {
				result[now] += time[now];
			}
			for(int next : array.get(now)) {
				topology[next]--;
				result[next] = Math.max(result[next], result[now] + time[now]);
				if(topology[next] == 0) {
					que.add(next);
				}
			}
			
		}
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<N+1; i++) {
			ans = Math.max(ans, result[i]);
		}
		System.out.println(ans);
	}
}
