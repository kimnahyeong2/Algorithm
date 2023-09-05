package com.greedy;

import java.io.*;
import java.util.*;

public class B11399 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    static int N;
    static int[] time;
    static int ans;
    
    public static void main(String[] args) throws IOException {
    	N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	time = new int[N+1];
    	for(int i=1; i<=N; i++) {
    		time[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(time);
    	
    	for(int i=1; i<=N; i++) {
    		time[i] = time[i] + time[i-1];
    		ans += time[i];
    	}    	
    	
    	System.out.println(ans);
    	
    }
}
