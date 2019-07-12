package Lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BFSshortestPath {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;  // distTo[v] = number of edges shortest s-v path
    private int s;         // source vertex


    /**
     * Computes the shortest path between the source vertex {@code s}
     * and every other vertex in the graph {@code G}.
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public BFSshortestPath (Graph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);

    }


    // breadth-first search from a single source
    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    /**
     * Is there a path between the source vertex {@code s} (or sources) and vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a path, and {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    
    /**
     * Returns the number of edges in a shortest path between the source vertex {@code s}
     * (or sources) and vertex {@code v}?
     * @param v the vertex
     * @return the number of edges in a shortest path
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int distTo(int v) {
        return distTo[v];
    }

  
    
    
    public Iterable<Integer> pathTo(int v) {
        
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }


    /**
     * Unit tests the {@code BreadthFirstPaths} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
		File inputFile = new File("C:\\Users\\Lenovo-User\\Desktop\\input.txt"); // Include path to file
		Scanner sc = new Scanner(inputFile);		
		
		String filename = inputFile.getAbsolutePath();
		String delimiter = " ";
		String source = "AL";
		String dest = "MS";
        SymbolGraph sg= new SymbolGraph(filename, delimiter);
        Graph G = sg.G();
        if(!sg.contains(source)) {
        	System.out.println("not in the file");
        	return;
        }
        int s=sg.index(source);        
        
       BFSshortestPath bfs = new BFSshortestPath(G, s);
        
        while(sc.hasNextLine()) {
        	
        	String sink=sc.next();
        	if(sink.equals("MS")) {
        	if(sg.contains(sink)) {
        		
        		int t=sg.index(sink);
        		
        		System.out.println("path to " + sink + ": ");
        		
        				if(bfs.hasPathTo(t)) {
        					for (int v: bfs.pathTo(t)) {          						
        						System.out.println("    "+sg.name(v)); 
        						
        					}
        					System.out.println();
        					break;
        				}        				
        				else {System.out.println("not connected");}       				
        	}
        	
        	
        	else {System.out.println("not a vertex");}
        	}
        }
        
    }

    

}


