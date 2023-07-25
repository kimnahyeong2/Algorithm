package com.greedy;

import java.io.*;
import java.util.*;

public class B1715 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int sum = 0;
		int x = 0;
		int y = 0;
		while(pq.size()!=1) {
			x = pq.remove();
			y = pq.remove();
			sum += (x+y);
			System.out.println("더하기 "+x+ " " + y + " "+sum);
			pq.add(x+y);
		}
		System.out.println(sum);
	}
}
