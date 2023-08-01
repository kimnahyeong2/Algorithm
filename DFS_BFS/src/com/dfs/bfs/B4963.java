package com.dfs.bfs;

import java.io.*;
import java.util.*;

public class B4963 {
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			 st = new StringTokenizer(br.readLine());
			 w = Integer.parseInt(st.nextToken());
			 h = Integer.parseInt(st.nextToken());
			 
			 if(w == 0 && h == 0) {
				 break;
			 }
			 
			 map = new int[h][w];
			 visited = new boolean[h][w];
			 
			 for(int i=0; i<h; i++) {
				 st = new StringTokenizer(br.readLine());
				 for(int j=0; j<w; j++) {
					 map[i][j] = Integer.parseInt(st.nextToken());
				 }
			 }
			 int ans = 0;
			 for(int i=0; i<h; i++) {
				 for(int j=0; j<w; j++) {
					 if(map[i][j]==1 && !visited[i][j]) {
						 bfs(i,j);
						 ans++;
					 }
				 }
			 }
			 sb.append(ans).append('\n');
		}
		System.out.println(sb);

	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int[] a = que.poll();
			int x2 = a[0];
			int y2 = a[1];
			for(int i=0; i<8; i++) {
				int nx = x2 + dx[i];
				int ny = y2 + dy[i];
				if(nx>=0 && ny>=0 && nx<h && ny<w) {
					if(!visited[nx][ny] && map[nx][ny] == 1) {
						que.add(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
}
