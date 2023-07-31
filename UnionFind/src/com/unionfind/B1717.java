package com.unionfind;

import java.io.*;
import java.util.*;

public class B1717 {
	static int n; //n개
	static int m; // 연산의 개수
	static int[] parent;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		sb = new StringBuilder();		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int costv = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(costv == 0) {
				union(start, end);
			}
			else {
				search(start,end);
                sb.append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}
	
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(a != b) {
			if(a < b) {
				parent[b] = a;
			}
			else {
				parent[a] = b;
			}
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	static void search(int x, int y) {
		int a = find(x);
		int b = find(y);
		if(a==b) {
			sb.append("YES");
		}
		else {
			sb.append("NO");
		}
	}
}
