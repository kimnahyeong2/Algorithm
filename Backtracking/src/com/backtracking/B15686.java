package com.backtracking;

import java.io.*;
import java.util.*;

public class B15686 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[][] map;
	static ArrayList<position> home = new ArrayList<>();
	static ArrayList<position> chicken = new ArrayList<>();
	static boolean[] emp;
	static int cityChickenDistance = Integer.MAX_VALUE;;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home.add(new position(i, j));
				}
				if(map[i][j] == 2) {
					chicken.add(new position(i, j));
				}
			}
		}

		emp = new boolean[chicken.size()];		
		chickenHome(0, 0);
		
		System.out.println(cityChickenDistance);
	}
	
	private static void chickenHome(int x, int cnt) {
		if(cnt == M) {
			int res = 0;
			
			for(int i=0; i<home.size(); i++) {
				int tmp = Integer.MAX_VALUE;
				
				for(int j=0; j<chicken.size(); j++) {
					if(emp[j] == true) {
						int distance = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
						tmp = Math.min(tmp, distance);
					}
				}
				res += tmp;
			}
			cityChickenDistance = Math.min(cityChickenDistance, res);
			return;
		}
		
		for(int i=x; i<chicken.size(); i++) {
			if(emp[i] == false) {
				emp[i] = true;
				chickenHome(i+1, cnt+1);
				emp[i] = false;
			}
		}
	}
}
class position{
	int x, y;
	public position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}