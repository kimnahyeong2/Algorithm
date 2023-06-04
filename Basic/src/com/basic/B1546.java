package com.basic;
import java.io.*;
import java.util.*;

public class B1546 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		double[] score = new double[N];
		double sum = 0;
		double max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			score[i] = Double.parseDouble(st.nextToken());
			sum += score[i];
			if(score[i] > max) {
				max = score[i];
			}
		}

		System.out.println(sum/max*100/N);

	}

}
