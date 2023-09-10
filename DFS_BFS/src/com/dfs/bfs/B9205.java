package com.dfs.bfs;

import java.io.*;
import java.util.*;

public class B9205 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int t;
    static int n;
    static int[][] position;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
    	t = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	for(int T=0; T<t; T++) {
    		n = Integer.parseInt(br.readLine());
    		position = new int[n+2][2];
    		visited = new boolean[n+2];
    		visited[0] = true;
    		Queue<Integer> que = new LinkedList<>();
    		
    		for(int i=0; i<n+2; i++) {
    			st = new StringTokenizer(br.readLine());
    			position[i][0] = Integer.parseInt(st.nextToken());
    			position[i][1] = Integer.parseInt(st.nextToken());
    			if((Math.abs(position[i][0] - position[0][0]) + Math.abs(position[i][1] - position[0][1]) <= 1000)) {
    				que.add(i);
    				visited[i] = true;
    			}
    		}

    		while(!que.isEmpty() && !visited[n+1]) {
    			int index = que.poll();
    			for(int i=1; i<n+2; i++) {
    				if(!visited[i] && (Math.abs(position[i][0] - position[index][0]) + Math.abs(position[i][1] - position[index][1]) <= 1000)) {
    					que.add(i);
    					visited[i] = true;
    				}
    			}
    		}
    		
    		if(visited[n+1]) {
    			bw.write("happy\n");
    		}
    		else {
    			bw.write("sad\n");
    		}
    		
    	}
    	bw.flush();
    	bw.close();
    	
	}

}
