package com.unionfind;

import java.io.*;
import java.util.*;

public class B1976 {
	static int N;
	static int M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i] = i;
		}
		
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x==1) {
					union(i,j);
				}
			}
		}
		boolean ans = true;
		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		for(int i=1; i<M; i++) {
			int now = find(Integer.parseInt(st.nextToken()));
			if(start != now) {
				System.out.println("NO");
				ans = false;
				break;
			}
		}
		if(ans == true) {
			System.out.println("YES");
		}
	}
	
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(a != b) {
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
