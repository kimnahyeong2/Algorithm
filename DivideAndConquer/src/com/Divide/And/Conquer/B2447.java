package com.Divide.And.Conquer;

import java.io.*;

public class B2447 {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] array;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new char[N][N];
		
		star(0, 0, N, false);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(array[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	static void star(int x, int y, int N, boolean blank) {
		if(blank) {
			for(int i=x; i<x+N; i++) {
				for(int j=y; j<y+N; j++) {
					array[i][j] = ' ';
				}
			}
			return;
		}
		if(N == 1) {
			array[x][y] = '*';
			return;
		}
		
		int size = N/3;
		int count = 0;
		for(int i=x; i<x+N; i+=size) {
			for(int j=y; j<y+N; j+=size) {
				count++;
				if(count == 5) {
					star(i, j, size, true);
				}
				else {
					star(i, j, size, false);
				}
			}
		}
	}
}
