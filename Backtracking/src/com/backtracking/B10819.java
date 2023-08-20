package com.backtracking;

import java.io.*;
import java.util.*;


public class B10819 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N; // 정수의 개수
    static int[] array;
    static boolean[] visited;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
    	// 입력
    	N = Integer.parseInt(br.readLine());
    	array = new int[N];
    	visited = new boolean[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		array[i] = Integer.parseInt(st.nextToken());
    	}
    	ArrayList<Integer> num = new ArrayList<>();
    	dfs(num, 0);
    	System.out.println(result);
    }
	public static void dfs(ArrayList<Integer> num, int count) {
		if(count == N) {
			result = Math.max(getResult(num), result);
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				num.add(array[i]);
				dfs(num, count+1);
				num.remove(num.size()-1);
				visited[i] = false;
			}
		}
	}
	public static int getResult(ArrayList<Integer> num) {
		int sum = 0;
		for(int i=0; i<N-1; i++) {
			sum += Math.abs(num.get(i)-num.get(i+1));
		}
		return sum;
	}
}
