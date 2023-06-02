package com.dfs.bfs;
import java.io.*;
import java.util.*;
public class B1260_v2 {
	// 인접리스트로 DFS/BFS 풀이하기
	// 1. 간선 리스트 배열 생성 -> 초기화
	// 2. 간선 리스트에 양방향으로 노드 넣기
	
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static int V; // 시작 정점 번호
	static ArrayList<Integer>[] map; // 그래프
	static boolean[] visited; // 방문체크
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1]; // 정점이 1부터 시작하기 때문에
		visited = new boolean[N+1];
		
		// 1번 정점부터 리스트를 만들어 map에 저장
		for(int i=1; i<=N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x].add(y);
			map[y].add(x);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(map[i]);
		}
		dfs(V);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(V);
	}

	private static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + " ");
		
		for(int e : map[node]) {
			if(!visited[e]) {
				dfs(e);
			}
		}
	}
	
	private static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		visited[node] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x + " ");
			for(int e : map[x]) {
				if(!visited[e]) {
					q.add(e);
					visited[e] = true;
				}
			}
		}
	}

}
