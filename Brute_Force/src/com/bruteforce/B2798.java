package com.bruteforce;

import java.io.*;
import java.util.*;

public class B2798 {
	static int N, M; // 카드의 갯수, 기준이 되는 숫자
	static int[] card; // 카드 숫자
	static int max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		card = new int[N];
		
		// 카드 숫자 입력받기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		max = 0;
		for(int i=0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					int sum = card[i] + card[j] + card[k];
					if(sum <= M && sum > max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}

}
