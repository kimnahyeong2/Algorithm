package com.unionfind;

import java.io.*;
import java.util.*;

public class B4195 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int F;
	static Map<String, String> friend;
	static Map<String, Integer> number;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;	
		for(int t=0; t<T; t++) {
			F = Integer.parseInt(br.readLine());
			friend = new HashMap<String, String>();
			number = new HashMap<String, Integer>();
			for(int f=0; f<F; f++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				
				friend.putIfAbsent(f1, f1);
				friend.putIfAbsent(f2, f2);
				number.putIfAbsent(f1, 1);
				number.putIfAbsent(f2, 1);
				
				union(f1, f2);
				
			}
		}
		
		System.out.println(sb);

	}
	
	private static void union(String f1, String f2) {
		f1 = find(f1);
		f2 = find(f2);
		
		if(f1 != f2) {
			friend.put(f2, f1);
			int n = number.get(f1);
			number.replace(f1, number.get(f2)+n);
		}
		sb.append(number.get(f1) + "\n");
	}
	
	private static String find(String f) {
		if(friend.get(f) == f) {
			return f;
		}
		else {
			String p = find(friend.get(f));
			friend.replace(f, p);
			return p;
		}
	}
}
