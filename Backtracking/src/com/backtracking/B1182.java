package com.backtracking;

import java.io.*;
import java.util.*;

// <고려해야할 점>
// 부분수열은 중복은 불가능하지만 배열의 순서에 상관없이 선택이 가능하다!
// 처음엔 순서를 신경써서 문제를 풀이했더니 오답이 나왔다..!
public class B1182 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N; // 정수의 개수
    static int S; // 더한 값이 되어야 할 정수
    static int[] array;
    static int count;
    public static void main(String[] args) throws IOException {
    	// 입력
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());
    	
    	array = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		array[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	count = 0;
    	dfs(0, 0);
    	// S가 0일 경우 공집합도 포함이 되기 때문에 하나 빼준다.
    	if(S==0) count--;
    	System.out.println(count);
	}

	static void dfs(int num, int sum) {
		// 배열의 끝에 도달했을 때
		if(num == N) {
			if(sum == S) {
				count++;
			}
			return;
		}
		
		dfs(num+1, sum); // 자신은 더하지 않고 다음 수로 넘어가는 경우
		dfs(num+1, sum + array[num]); // 자기 자신을 더한 후 다음 수로 넘어가는 경우
	}

}
