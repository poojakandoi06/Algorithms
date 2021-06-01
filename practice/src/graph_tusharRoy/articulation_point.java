package graph_tusharRoy;

import java.util.LinkedList;

public class articulation_point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static class Graph{
		int v;
		static LinkedList<Integer>[] adj;
		public  Graph(int v) {
			this.v=v;
			adj=new LinkedList[v];
			for(int i=0;i<v;i++) {
				adj[i]=new LinkedList();
			}
		}
		public static void addedge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
		}
		static void articulation_point(int u,boolean visited[], int[] disc,int[]low, int[] parent, boolean ap[]) {
			int children=0;
			visited[u]=true;
			
		}
		
	}
	//tarjan's algo to find articulation point-- removing the vertex graph becomes disconnected
		public static int articulationPoint(Graph)

}
