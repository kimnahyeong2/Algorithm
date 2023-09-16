package com.algorism;

import java.awt.Point;
import java.io.*;
import java.util.*;


public class C1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    static int m;
    static int repeatFold;
    static int repeatCut;
    static int[] fold;
    static int[][] cut;
    
    public static void main(String[] args) throws IOException {
    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	repeatFold = Integer.parseInt(br.readLine());
    	repeatCut = Integer.parseInt(br.readLine());
    	fold = new int[repeatFold];
    	cut = new int[repeatCut][2];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<repeatFold; i++) {
    		fold[i] = Integer.parseInt(st.nextToken());
    	}
    	for(int i=0; i<repeatCut; i++) {
        	st = new StringTokenizer(br.readLine());
    		cut[i][0] = Integer.parseInt(st.nextToken());
    		cut[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	int paper[][] = new int[n+1][m+1];
    	for(int[] i : paper) Arrays.fill(i, 1);
    	
    	int width = n;
    	int height = m;
    	
    	for(int i=0; i<fold.length; i++) {
    		if(fold[i] == 1) {
    			height = height/2;
    		}
    		if(fold[i] == -1) {
    			width = width/2;
    		}
    	}
    	
    	for(int i=1; i<=width; i++) {
    		for(int j=1; j<=height; j++) {
    			paper[i][j] = 2;
    		}
    	}
    	System.out.println("width : " + width + " height : " + height);
    	for(int i=0; i<cut.length; i++) {
    		int x = cut[i][0];
    		int y = cut[i][1];
    		int w = width*2;
    		int h = height*2;
    		int count = 1;
    		int rcount = 1;
    		
    		if(paper[x][y] == 2) {
    			Queue<Point> que = new LinkedList<>();
    			paper[x][y] = 0;
    			que.add(new Point(x,y));
    			
    			for(int f = fold.length-1; f >= 0; f--) {
    				if(fold[f] == -1) {
    					System.out.println("세로 접기");
    					while(rcount <= count) {
    						System.out.println("rcount : " + rcount);
    						System.out.println("w : " + w);
    						Point p = que.poll();
    						System.out.println("px, py : " + p.x + " " + p.y);
    						int nx = (w + 1) - p.x;
    						int ny = p.y;

    						System.out.println("nx, ny : " + nx + " " + ny);
    						paper[nx][ny] = 0;
    						que.add(new Point(nx, ny));
    						que.add(p);
    						rcount++;
    					}
    					w *= 2;
    				}
    				if(fold[f] == 1) {
    					System.out.println("가로 접기");
    					while(rcount <= count) {
    						System.out.println("rcount : " + rcount);
    						System.out.println("h : " + h);
    						Point p = que.poll();
    						System.out.println("px, py : " + p.x + " " + p.y);
    						int nx = p.x;
    						int ny = (h + 1) - p.y;

    						System.out.println("nx, ny : " + nx + " " + ny);
    						paper[nx][ny] = 0;
    						que.add(new Point(nx, ny));
    						rcount++;
    					}
    					h *= 2;
    				}
    				rcount = 1;
					count *= 2;
    			}
    		}
    	}
    		
    	for(int i=1; i<=n; i++) {
    		for(int j=1; j<=m; j++) {
    			if(paper[i][j] == 2) {
    				paper[i][j] = 1;
    			}
    			bw.append(paper[i][j] + " ");
    		}
    		bw.append("\n");
    	}
    	
    	bw.flush();
	}

}

