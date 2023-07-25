package com.greedy;

import java.io.*;
import java.util.*;

public class B1931 {
	static int N;
	static int [][] time;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		time = new int[N][2];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());	
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) { // 종료시간이 같을 경우 시작 시간이 빠른순으로 정렬
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int count = 0;
		int endTime = 0;
		
		for(int i=0; i<N; i++) {
			if(endTime <= time[i][0]) {
				endTime = time[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
