package com.backtracking;

import java.io.*;
import java.util.*;


public class B10819 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N; // 정수의 개수
    static int[] array;
    static int count;
    public static void main(String[] args) throws IOException {
    	// 입력
    	N = Integer.parseInt(br.readLine());
    	array = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		array[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int max = 0;
    	
    	for(int i=0; i<N; i++) {
    		for(int j=i+1; j<N; j++) {
    			if(array[i] > array[j]) {
    				max = array[j];
    				array[j] = array[i];
    				array[i] = max;
    			}
    		}
    	}
    	count = array[0] + array[1];
    	for(int i=2; i<N; i++) {
    		count += array[i]*2;
    	}
    	System.out.println(count);
    }
}
