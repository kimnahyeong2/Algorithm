package com.dfs.bfs;

import java.io.*;
import java.util.*;

// 미로 탐색
// 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
// 1,1에서 출발해서 N,M의 위치로 이동할 때 지나야 하는 최소의 칸 ㅅ수를 구하는 프로그램

public class B2178 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] checked;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		checked = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		bfs(0,0);
		System.out.println(map[N-1][M-1]);

	}
	public static void bfs(int x, int y) {
		q.add(new int[] {x, y});
		checked[x][y] = true;
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int x2 = a[0];
			int y2 = a[1];
			for(int i=0; i<4; i++) {
				int nx = x2 + dx[i];
				int ny = y2 + dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(!checked[nx][ny] && map[nx][ny] == 1) {
						q.add(new int[] {nx, ny});
						map[nx][ny] = map[x2][y2] + 1;
						checked[nx][ny] = true;
					}
				}
			}
		}
	}
}
