package com.dfs.bfs;

import java.io.*;
import java.util.*;

public class B1012 {
	// 모든 경로를 찾아봐야하기 때문에 DFS를 이용
	static int T; // 테스트 케이스
	static int M; // 가로길이
	static int N; // 세로길이
	static int K; // 배추가 심어진 갯수
	static int[][] map; // 배추밭
	static int bug; // 벌레 갯수
	static boolean[][] visited; // 방문여부
	static int[] dx = {-1, 1, 0, 0}; // x축 이동
	static int[] dy = {0, 0, -1, 1}; // y축 이동
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			visited = new boolean[M][N];
			
			bug = 0;
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			for(int m=0; m<M; m++) {
				for(int n=0; n<N; n++) {
					if(map[m][n]==1 && !visited[m][n]) {
						bug++;
						dfs(m,n);
					}
				}
			}
			System.out.println(bug);
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>=0 && nx<M && ny<N) {
				if(map[nx][ny]==1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}

		}
	}

}
