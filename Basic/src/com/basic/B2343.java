package com.basic;

import java.io.*;
import java.util.*;

public class B2343 {
	static int N;
	static int M;
	static int[] array;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N];
		
	    int left = 0;
	    int right = 0;
	    
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			if(array[i] > left) {
				left = array[i];
			}
			right += array[i];
		}
		
		while(left <= right) {
			int mid = (left + right) / 2;
			System.out.println(left + " " + right + " " + mid);
			int sum = 0;
			int count = 0;
			for(int i=0; i<N; i++) {
				if(sum + array[i] > mid) {
					count++;
					sum = 0;
				}
				sum = sum + array[i];
			}
			if(sum != 0) {
				count++;
			}
			if(count > M) {
				left = mid +1;
			}
			else {
				right = mid -1;
			}
		}
		
		System.out.println(left);
	}

}
