package com.datastructure.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Prim最小生成树算法
 * @author admin
 *
 */
public class Prim {
	
	private boolean[] marked;//最小生成树的顶点
	private Queue<Edge> mst;//最小生成树的边
	private PriorityQueue<Edge> pq;//横切边优先队列
	
	public static void main(String[] args) {
		TinyEWG ewg = new TinyEWG();
		Prim test = new Prim(ewg.G);
	}
	
	/**
	 * 从任意一个顶点开始(这里从0开始)
	 * 1、访问当前顶点0，记录marked[0] = true
	 * 2、检查0连接的顶点是否已经marked，如果没有，就将边加入优先队列pq
	 * 3、循环取出pq中的最小元素，加入最小生成树队列中，
	 * 判断该边的两个顶点是否访问过，如果没有访问，则分别访问两个顶点
	 * @param G
	 */
	public Prim(EdgeWeightedGraph G){
		marked = new boolean[G.V()];
		mst = new LinkedList<>();
		pq = new PriorityQueue<>();
		visit(G, 0);
		while(!pq.isEmpty()){
			Edge e = pq.poll();//取最短边
			mst.add(e);
			System.out.println(e);
			int v = e.either();
			int w = e.other(v);
			if(marked[v] && marked[w]) continue;
			if(!marked[v]) visit(G, v);
			if(!marked[w]) visit(G, w);
		}
	}
	
	private void visit(EdgeWeightedGraph G,int v){
		marked[v] = true;
		if(G.adj(v) != null){
			for(Edge e : G.adj(v)){
				if(!marked[e.other(v)]){
					pq.add(e);
				}
			}
		}
	}

}
