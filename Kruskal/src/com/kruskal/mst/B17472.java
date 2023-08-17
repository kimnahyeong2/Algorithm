package com.kruskal.mst;

import java.io.*;
import java.util.*;


public class B17472 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // 세로 
    static int M; // 가로 
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int count;
    
    static int[] parent;
    static ArrayList<ArrayList<int[]>> sumList;
    static ArrayList<int[]> mlist;
    static PriorityQueue<Edges> queue;

    public static void main(String[] args) throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	visited = new boolean[N][M];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	sumList= new ArrayList<>();
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(map[i][j]!=0 && !visited[i][j]) {
        			bfs(i, j);
        			sumList.add(mlist);
    			}
    		}
    	}
    	
    	queue = new PriorityQueue<>();
    	for(int i=0; i<sumList.size(); i++) {
    		ArrayList<int[]> now = sumList.get(i);
    		for(int j=0; j<now.size(); j++) {
    			int x = now.get(j)[0];
    			int y = now.get(j)[1];
    			int location = map[x][y];
    			System.out.println("location : " + location);
    			for(int k=0; k<4; k++) {
    				int nx = x + dx[k];
    				int ny = y + dy[k];
    				int len = 0;
    				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
    					System.out.println(nx + " | " + ny + " | " + map[nx][ny]);
    					if(map[nx][ny] == location) {
    						System.out.println(nx + " 1 " + ny);
    						break;
    					}
    					else if(map[nx][ny] != 0) {
    						System.out.println(nx + " 2 " + ny);
    						if(len > 1) {
    							System.out.println(nx + " 3 " + ny);
        						queue.add(new Edges(location, map[nx][ny], len));
    						}
    						break;
    					}
    					else {
    						len++;
    						System.out.println("len : " + len);
    					}
    				}
    			}
    		}
    	}
    	
    	parent = new int[count];
    	for(int i=0; i<parent.length; i++) {
    		parent[i] = i;
    	}
    	
    	int useEdge = 0;
    	int result = 0;
    	System.out.println(queue);
    	while(!queue.isEmpty()) {
    		Edges now = queue.poll();
    		System.out.println(now);
    		if(find(now.s) != find(now.e)) {
    			union(now.s, now.e);
    			result += now.v;
    			useEdge++;
    		}
    	}
    	
    	System.out.println(useEdge + " " + result);
    	if(useEdge == count-2) {
    		System.out.println(result);
    	} else {
    		System.out.println("-1");
    	}
    		
    		
    	bw.flush();
    	bw.close();
    }
    
    static void bfs(int x, int y) {
    	count++;
    	Queue<int[]> que = new LinkedList<>();
    	mlist = new ArrayList<>();
    	que.add(new int[] {x, y});
    	mlist.add(new int[] {x, y});
    	visited[x][y] = true;
    	map[x][y] = count;
    	while(!que.isEmpty()) {
    		int[] now = que.poll();
    		int x2 = now[0];
    		int y2 = now[1];
    		for(int i=0; i<4; i++) {
    			int nx = x2 + dx[i];
    			int ny = y2 + dy[i];
    			if(nx > -1 && ny > -1 && nx<N && ny<M ) {
    				{
    					if(!visited[nx][ny] && map[nx][ny] != 0) {
    	    				visited[nx][ny] = true;
    	    				map[nx][ny] = count;
    	    				que.add(new int[] {nx, ny});
    	    				mlist.add(new int[] {nx, ny});
    					}
    				}
    			}
    		}
    	}
    }
    
    public static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a!=b) {
    		parent[b] = a;
    	}
    }
    
    public static int find(int a) {
    	if(a==parent[a]) {
    		return a;
    	}
    	else {
    		return parent[a] = find(parent[a]);
    	}
    }
}

class Edges implements Comparable<Edges>{
	int s, e, v;
	Edges(int s, int e, int v){
		this.s = s;
		this.e = e;
		this.v = v;
	}
	
	@Override
	public int compareTo(Edges o) {
		// 가중치를 기준으로 오름차순
		return this.v - o.v;
	}
}
