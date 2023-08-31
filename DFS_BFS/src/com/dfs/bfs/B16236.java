package com.dfs.bfs;

import java.util.*;
import java.io.*;

public class B16236 {
	static int N; // map의 크기
	static int[][] map; // 물고기들의 위치
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int sharkSize;
	static int sharkEat;
	static int sharkFinish;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		sharkSize = 2;
		sharkEat = 0;
		sharkFinish = 0;
		Queue<fish> que = new LinkedList<>();
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					que.add(new fish(i, j, 0));
					map[i][j] = 0;
				}
			}
		}
		while(true) {
			ArrayList<fish> eatFish = new ArrayList<>();
			int[][] dist = new int[N][N];
			while(!que.isEmpty()) {
				fish target = que.poll();
				int targetX = target.x;
				int targetY = target.y;
				
				for(int i=0; i<4; i++) {
					int nx = targetX + dx[i];
					int ny = targetY + dy[i];
					
					if(nx>=0 && ny>=0 && nx<N && ny<N) {
						if(dist[nx][ny]==0 && map[nx][ny] <= sharkSize) {
							dist[nx][ny] = dist[targetX][targetY] + 1;
							que.add(new fish(nx, ny, dist[nx][ny]));
							if(map[nx][ny] >= 1 && map[nx][ny] <= 6 && map[nx][ny] < sharkSize) {
								eatFish.add(new fish(nx, ny, dist[nx][ny]));
							}
						}
					}
				}
			}
			if(eatFish.size() == 0) {
				System.out.println(sharkFinish);
				break;
			}
			
			fish nowFish = eatFish.get(0);
			for(int i=1; i<eatFish.size(); i++) {
				if(nowFish.distance > eatFish.get(i).distance) {
					nowFish = eatFish.get(i);
				}
				else if(nowFish.distance == eatFish.get(i).distance) {
					if(nowFish.x > eatFish.get(i).x) {
						nowFish = eatFish.get(i);
					}
					else if(nowFish.x == eatFish.get(i).x) {
						if(nowFish.y > eatFish.get(i).y) {
							nowFish = eatFish.get(i);
						}
					}
				}
			}
			
			map[nowFish.x][nowFish.y] = 0;
			sharkFinish+=nowFish.distance;
			sharkEat++;
			if(sharkEat == sharkSize) {
				sharkEat = 0;
				sharkSize++;
			}
			que.add(nowFish);
			
		}

	}
}
class fish{
	int x, y, distance;
	public fish(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
	}
}
