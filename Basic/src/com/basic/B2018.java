package com.basic;

import java.io.*;
import java.util.*;

public class B2018 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int start = 1;
		int end = 1;
		int sum = 1;
		int count = 1;
		
		while(end != N) {
			if(sum == N) {
				count++;
				end++;
				sum += end;
			}
			else if(sum > N){
				sum -= start;
				start++;
			}
			else {
				end++;
				sum += end;
			}
		}
		
		System.out.println(count);
	}

}
