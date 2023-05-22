package com.dfs.bfs;
import java.io.*;
import java.util.*;

public class B1260 {
	static StringBuilder sb = new StringBuilder();
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static int V; // 시작 정점 번호
	static int[][] map; // 그래프
	static boolean[] visited; // 방문체크
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1]; // 정점이 1부터 시작하기 때문에
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1; //연결되어있다는 것을 표시 -> 양방향이기 때문에 map[x][y] = map[y][x]
		}
		
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
	}
	
	static void dfs(int node) {
		visited[node] = true;
		sb.append(node + " ");
		
		for(int i=1; i<N+1; i++) {
			if(map[node][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
		
	}
	
	static void bfs(int node) {
		visited[node] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append(x + " ");
			for(int i=1; i<N+1; i++) {
				if(map[x][i]==1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

}
