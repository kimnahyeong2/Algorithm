package com.unionfind;

import java.io.*;
import java.util.*;


public class B1043 {
	static int N; // 사람 수
	static int M; // 파티 수
	static int truePeople; // 진실을 아는 사람수
	static int[] tPeople;
	static ArrayList<Integer>[] party;
	static int[] parent;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		truePeople = Integer.parseInt(st.nextToken());
		tPeople = new int[truePeople];
		for(int i=0; i<truePeople; i++) {
			tPeople[i] = Integer.parseInt(st.nextToken());
		}
		
		party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int cPeople = Integer.parseInt(st.nextToken());
			for(int j=0; j<cPeople; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		answer = 0;
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			int firstPeople = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		for(int i=0; i<M; i++) {
			boolean possible = true;
			int opeople = party[i].get(0);
			for(int j=0; j<truePeople; j++) {
				if(find(opeople) == find(tPeople[j])) {
					possible = false;
					break;
				}
			}
			if(possible) {
				answer++;
			}
		}
		
		System.out.println(answer);

	}
	
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(x != y) {
			if(a>b) {
				parent[a] = b;
			}
			else {
				parent[b] = a;
			}
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}
