package com.dp;

import java.io.*;
import java.util.*;

public class B15681 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, R, Q;
    static ArrayList<Integer>[] list;
    static boolean visit[];
    static int dp[];
    
    public static void main(String[] args) throws IOException {
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	Q = Integer.parseInt(st.nextToken());
    	
    	list = new ArrayList[N+1];
    	dp = new int[N+1];
    	visit = new boolean[N+1];
    	
    	for(int i=0; i<list.length; i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	for(int i=1; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		list[u].add(v);
    		list[v].add(u);
    	}
    	dfs(R);
    	
    	StringBuffer sb = new StringBuffer();
    	while(Q-->0) {
    		int query = Integer.parseInt(br.readLine());
    		sb.append(dp[query]).append("\n");
    	}
    	System.out.println(sb);
	}
    
    public static int dfs(int now) {
    	if(dp[now] != 0) {
    		return dp[now];
    	}
    	visit[now] = true;
    	int count = 1;
    	
    	for(int node : list[now]) {
    		if(visit[node]) {
    			continue;
    		}
    		count += dfs(node);
    	}
    	dp[now] = count;
    	return dp[now];
    }

}
