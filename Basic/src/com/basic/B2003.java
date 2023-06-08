package com.basic;

import java.io.*;
import java.util.*;

public class B2003 {

	static int N, M; // N:숫자의 갯수   M:원하는 값
	static int[] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0; // 시작
		int end = 0; // 끝
		int count = 0; // 경우의 수
		int sum = 0;
		
		while(start < array.length) { // start가 끝에 도달하기 전까지 반복
			if(sum > M || end == array.length) { // sum이 목표값보다 크거나 end가 끝까지 도달하였을 경우
				sum -= array[start]; // start 한칸 이동 ( 예) 더해진 수가 3개에서 2개가 되는 것 )
				start++;
			}
			else { // sum이 목표값보다 작거나 같을 경우
				sum += array[end]; // end 한칸 이동 ( 예) 더해진 수가 2개에서 3개가 되는것 )
				end++;
			}
			if(sum == M) { // 목표값과 같을 경우 더해주기
				count++;
			}
		}
		System.out.println(count);		
	}

}
