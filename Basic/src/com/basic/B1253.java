package com.basic;

import java.io.*;
import java.util.*;

public class B1253 {
	static int N; // 수의 개수
	static int[] num; // 숫자들
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int count = 0;
		for(int i=0; i<num.length; i++) {
			int target = num[i];
			int start = 0;
			int end = N-1;
			 while(start < end) {
				 if(num[start]+num[end] == target) {
					 if(start != i && end != i) {
						 count++;
						 break;		 
					 }
					 else if(start == i) {
						 start++;
					 }
					 else {
						 end--;
					 }

				 }
				 else if(num[start]+num[end] > target) {
					 end--;
				 }
				 else {
					 start++;
				 }
			 }
		}
		System.out.println(count);
	}
}
