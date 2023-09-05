package com.greedy;

import java.io.*;
import java.util.*;

public class B1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String expression;
    static int sum = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
    	expression = br.readLine();
    	
    	String[] array = expression.split("\\-");
    	
    	for(int i=0; i<array.length; i++) {
    		int tmp = 0;
    		String[] array2 = array[i].split("\\+");
    		
    		for(int j=0; j<array2.length; j++) {
    			tmp += Integer.parseInt(array2[j]);
    		}
    		if(sum == Integer.MAX_VALUE) {
    			sum = tmp;
    		}
    		else {
    			sum -= tmp;
    		}
    	}
    	
    	System.out.println(sum);
	}

}
