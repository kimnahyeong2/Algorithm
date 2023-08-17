package com.dfs.bfs;

import java.io.*;
import java.util.*;


public class B14502 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 세로 
    static int M; // 가로 
    static int[][] map;
    static int[][] virus;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int safe = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        
        System.out.println(safe);
    }
    
    static void dfs(int count) {
    	if(count == 3) {
    		bfs();
    		return;
    	}
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	if(map[i][j]==0) {
            		map[i][j]=1;
            		dfs(count+1);
            		map[i][j]=0;
            	}
            }
        }
    }
    
    static void bfs() {
    	Queue<int[]> que = new LinkedList<>();
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(map[i][j] == 2) {
    				que.add(new int[] {i, j});
    			}
    		}
    	}
        //원본 연구소를 바꾸지 않기 위한 카피맵 사용
        int copyMap[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }
    	while(!que.isEmpty()) {
    		int[] tmp = que.poll();
    		int x = tmp[0];
    		int y = tmp[1];
    		for(int i=0; i<4; i++) {
    			int nx = x + dx[i];
    			int ny = y + dy[i];
    			
    			if(nx>=0 && ny>=0 && nx<N && ny<M) {
    				if(copyMap[nx][ny] == 0) {
    					copyMap[nx][ny] = 2;
    					que.add(new int[] {nx, ny});
    				}
    			}
    		}
    	}
		int countSafe = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j]==0) {
					countSafe++;
				}
			}
		}
		if(safe < countSafe) {
			safe = countSafe;
		}
    }
}
