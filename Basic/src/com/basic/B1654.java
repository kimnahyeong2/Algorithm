package com.basic;

import java.util.*;
import java.io.*;

public class B1654 {	
	static int K, N;
	static int[] ren;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ren = new int[K];
		
		long end = 0;
		for(int i=0; i<K; i++) {
			ren[i] = Integer.parseInt(br.readLine());
			if(ren[i] > end) {
				end = ren[i];
			}
		}
		end++;
		long start = 0;
		long mid = 0;
		
		while(start < end) {
			System.out.println(start + " " + mid + " " + end);
			mid = (start+end)/2;
			long count = 0;
			for(int i=0; i<K; i++) {
				count += ren[i]/mid;
			}
			
			if(count < N) {
				end = mid;
			}
			else {
				start = mid+1;
			}
		}
		System.out.println(start-1);
	}
}
