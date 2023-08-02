package com.topology.sort;

import java.io.*;
import java.util.*;

public class B1516 {
	static int N; // 건물의 종류수
	static ArrayList<ArrayList<Integer>> array = new ArrayList<>(); //그래프
	static int[] Build; // 건물을 짓는데 걸리는 시간
	static int[] topology; // 진입차수배열
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Build = new int[N+2];
		topology = new int[N+2];
		result = new int[N+2];
		for(int i=0; i<=N; i++) {
			array.add(new ArrayList<>());
		}
		StringTokenizer st;
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			Build[i] = Integer.parseInt(st.nextToken());//해당건물을 짓는데 걸리는 시간 입력
			
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) { // -1이 들어오면 다음 건물로 이동
					break;
				}
				array.get(num).add(i); // i가 지어진 후에 num이 지어져야함
				topology[i]++; // i의 진입차수 더해주기
			}
		}
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(topology[i] == 0) {
				que.add(i);
			}
		}
		
		while(!que.isEmpty()) {
			int now = que.poll(); // que에 저장된 진입차수가 0인 애들 하나씩 꺼내기
			for(int next : array.get(now)) { // 해당 건물 배열에 저장된 다른 건물 꺼내기
				topology[next]--;
				result[next] = Math.max(result[next], result[now]+Build[now]);
				if(topology[next]==0) {
					que.add(next);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(result[i] + Build[i]);
		}


	}
}
