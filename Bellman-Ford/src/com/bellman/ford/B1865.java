package com.bellman.ford;

import java.io.*;
import java.util.*;

public class B1865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int TC, N, M, W;
    static int dist[];
    static ArrayList<ArrayList<WarmHole>> edges;
    static final int INF = 987654321;
    
    public static void main(String[] args) throws IOException {
    	TC = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	for(int test=0; test<TC; test++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		W = Integer.parseInt(st.nextToken());
    		
    		edges = new ArrayList<>();
    		for(int i=0; i<=N; i++) {
    			edges.add(new ArrayList<>());
    		}
    		dist = new int[N+1];

    		
    		for(int i=0; i<M+W; i++) {
    			st = new StringTokenizer(br.readLine());
        		int s = Integer.parseInt(st.nextToken());
        		int e = Integer.parseInt(st.nextToken());
        		int t = Integer.parseInt(st.nextToken());
        		if(i < M) {
            		edges.get(s).add(new WarmHole(e, t));
            		edges.get(e).add(new WarmHole(s, t));
        		}
        		else {
            		edges.get(s).add(new WarmHole(e, -t));
        		}

    		}
    		boolean truth = false;
    		for(int i=1; i<=N; i++) {
    			if(bellmanFord(i)) {
    				truth = true;
    				bw.write("Yes\n");
    				break;
    			}
    		}
    		
    		if(!truth) {
    			bw.write("No\n");
    		}
    	}
    	
    	bw.flush();
    	bw.close();
        
    }
    
    public static boolean bellmanFord(int start) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean update = false;
		
		// 최단 거리 배열에서 업데이트 반복 횟수는 노드 개수 - 1
		for(int i=1; i<N; i++) {
			update = false;
			for(int j=1; j<=N; j++) { // 1-N까지 최단거리횟수 + 1번은 음의 사이클 유무 확인
				for(WarmHole hole : edges.get(j)) {
					if(dist[j] != INF && dist[hole.end] > dist[j] + hole.time) {
						dist[hole.end] = dist[j] + hole.time;
						update = true;
					}
				}
			}
			// 음의 사이클이 없는 경우
			if(!update) {
				break;
			}
		}
		
        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
        // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (WarmHole hole : edges.get(i)) {
                	if(dist[i] != INF && dist[hole.end] > dist[i] + hole.time) {
                        return true;
                    }
                }
            }
        }
		return false;
    }
}

class WarmHole{
	int end, time;
	public WarmHole(int end, int time) {
		this.end = end;
		this.time = time;
	}
}
