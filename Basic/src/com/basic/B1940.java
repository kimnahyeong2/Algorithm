package com.basic;

import java.io.*;
import java.util.*;

public class B1940 {
	static int N; // 재료의 수
	static int M; // 원하는 값
	static int[] num; // 재료 고유번호
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		// 정렬된 상태로 두개의 값을 포인터로 설정하며 비교
		Arrays.sort(num);
		// 연속해서 포인터가 있는 것이 아닌 처음과 끝에 위치해있음
		int start = 0;
		int end = num.length-1;
		int count = 0;
		
		while(start < end) {
			if(num[start]+num[end] < M) {
				start++;
			}
			else if(num[start]+num[end] > M) {
				end--;
			}
			else {
				count++;
				start++;
				end--;
			}
		}
		System.out.println(count);
	}
}
