package com.bruteforce;
import java.io.*;
import java.util.*;
public class B7568 {
	static int N; // 사람수
	static int[][] member; // 몸무게와 키를 담을 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		member = new int[N+1][2];
		
		for(int i=1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			member[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
			member[i][1] = Integer.parseInt(st.nextToken()); // 키
		}
		
		for(int i=1 ;i<N+1; i++) {
			int rank = 1;
			for(int j=1; j<N+1; j++) {
				if(i == j) continue;
				if(member[i][0] < member[j][0] && member[i][1] < member[j][1]) {
					rank++;
				}
			}
			System.out.print(rank +" " );
		}
		
		

	}

}
