package com.dfs.bfs;

import java.io.*;
import java.util.*;

public class B10026 {
	static int N;
	static char[][] map; 			// 정상
	static boolean[][] checked;
	static int cnt;

	static char[][] map2; 			// 색약
	static boolean[][] checked2;
	static int cnt2;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		map2 = new char[N][N];
		checked = new boolean[N][N];
		checked2 = new boolean[N][N];
		
		// 입력값 받아 map, map2 채워주기
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
				// 색약일 경우 R과 G를 구별하지 못하니 R을 G로 변경해서 통일시켜줌
				if(s.charAt(j)=='R') {
					map2[i][j] = 'G';
				}
				else {
					map2[i][j] = s.charAt(j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 방문하지 않은 map 방문
				if(!checked[i][j]) {
					dfs(i, j, map, checked);
					cnt++;
				}
				if(!checked2[i][j]) {
					dfs(i, j, map2, checked2);
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt + " " + cnt2);
		
	}
	
	public static void dfs(int x, int y, char[][] maps, boolean[][] check) {
		check[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(!check[nx][ny] && maps[nx][ny] == maps[x][y]) {
					dfs(nx, ny, maps, check);
				}
			}
		}
	}

}
