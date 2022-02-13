package main.java.gui;

import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraAlgorithm {
	public String stringPath;
	// store shortest path
	public ArrayList<Integer> path;
	// store Shortest distance
	public int distance;

	public DijkstraAlgorithm(){
		path = new ArrayList<>();
		distance = 0;	
		stringPath = "";
	}

	/**
	 *	<H1>Dijkstra Algorithm</H1>
	 * @param graph - 2d int matrix form of graph
	 * @param source - the source node
	 * @param destination - the destination node
	 */
	public void Dijkstra(int[][] graph, int source, int destination){
		int size = graph[0].length;

		path.add(source);
		
		// stores previous vertexes of the path
		int[] parent = new int[size];
		
		// It will mark if a vertex is selected in path or not
		Boolean[] markedVertex = new Boolean[size];
	
		// It will store all the distance
		int[] distances = new int[size];
			
		// Initialize all markedVertex as false and all distances to be MAXIMUM
		// and parent of all vertices as -1
		Arrays.fill(markedVertex, false);
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		
		// source  -> source = 0
		distances[source] = 0;
		
		for (int i=0; i<size-1; i++){
			
			int mini = getMinimumDistance(distances, markedVertex, size);
			//  marked the minimum distance vertex true
			markedVertex[mini] = true;
			// change distance of adjacent vertices of the selected vertex if ...
			// not marked yet
			// there is an edge connecting those two vertices
			//distance btn them is !infinite
			for (int j=0; j<size; j++){
				if( !markedVertex[j] &&
						graph[mini][j]!=0 &&
							distances[mini]!=Integer.MAX_VALUE &&
								distances[mini] + graph[mini][j] < distances[j] ){
					parent[j] = mini;
					distances[j] = distances[mini] + graph[mini][j];
				}
			}
		}
		
		getActualDistance(distances, parent, destination, size);
	}
	
	// find the vertex with minimum distance which are not marked
	private int getMinimumDistance(int[] distances, Boolean[] markedVertex, int size){
		//compare
		int maximum = Integer.MAX_VALUE;
		int min_index = -1;
		
		for (int i=0; i<size; i++)
			if (!markedVertex[i] && distances[i] <= maximum){
				maximum = distances[i];
				min_index = i;
        }
		return min_index;
	}

	// get the distance from source to destination
	private void getActualDistance(int[] distances, int[] parent, int destination, int size){
		
		for (int k=0; k<size; k++){
			if (k == destination){
				distance = distances[k];
				printPath(parent, k, destination);
			}
		}
		printIt(path, destination);
	}

	// add path to ArrayList excluding the destination
	private void printPath(int[] parent, int x, int destination){
		
		// vertex -> no parent?
		if(parent[x] == -1)
			return;
		
		printPath(parent, parent[x], destination);
		if (x == destination)
			return;
		// add vertices
		path.add(x);
	}
	// To verify the path and to add destination in it
	private void printIt(ArrayList<Integer> path, int destination){
		// add the destination in path
		path.add(destination);
		// print path to verify
		for (Integer integer : path) stringPath += " " + integer;
	}
	// for the reset
	public void reset(){
		path.clear();
		distance = 0;	
		stringPath = "";
	}
}
