package com.basic;
import java.io.*;
public class B11720 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String number = br.readLine();
		// String으로 입력받은 숫자를 charAt(i)를 이용해 int 배열에 넣어주면서 합계를 구하는 방식을 사용
		// char[] num = number.toCharArray();를 이용해 charAt(i)없이 바로 String을 char배열에 넣어줄 수 있음
		int[] num = new int[number.length()];
		int sum = 0;
		
		for(int i=0; i<number.length(); i++) {
			num[i] = number.charAt(i)-'0'; // char로 변형 후 '0'을 빼줌으로써 int로 변형
			sum += num[i];
		}
		
		System.out.println(sum);
	}

}
