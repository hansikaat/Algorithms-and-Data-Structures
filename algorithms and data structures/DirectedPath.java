package Lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedPath {
    private boolean[] marked;  // marked[v] = true iff v is reachable from source(s)
    private int count;
    private int[] edgeTo;// number of vertices reachable from source(s)
    

    /**
     * Computes the vertices in digraph {@code G} that are
     * reachable from the source vertex {@code s}.
     * @param G the digraph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DirectedPath(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * Computes the vertices in digraph {@code G} that are
     * connected to any of the source vertices {@code sources}.
     * @param G the graph
     * @param sources the source vertices
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     *         for each vertex {@code s} in {@code sources}
     */
    public DirectedPath(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int v : sources) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) { 
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    /**
     * Is there a directed path from the source vertex (or any
     * of the source vertices) and vertex {@code v}?
     * @param  v the vertex
     * @return {@code true} if there is a directed path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean marked(int v) {
        return marked[v];
    }

    /**
     * Returns the number of vertices reachable from the source vertex
     * (or source vertices).
     * @return the number of vertices reachable from the source vertex
     *   (or source vertices)
     */
    public int count() {
        return count;
    }

  

    /**
     * Unit tests the {@code DirectedDFS} data type.
     *
     * @param args the command-line arguments
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {

    	File inputFile = new File("C:\\Users\\Lenovo-User\\Desktop\\input.txt"); // Include path to file
		Scanner sc = new Scanner(inputFile);		
		
        // read in digraph from command-line argument
		
    	String filename = inputFile.getAbsolutePath();
    	String delimiter = " ";
		String source = "AL";
	    SymbolDigraph sg= new SymbolDigraph(filename, delimiter);
        Digraph G = sg.G();
        if(!sg.contains(source)) {
        	System.out.println("not in the file");
        	return;
        }
        int s=sg.index(source);        
        
        DirectedPath dfs = new DirectedPath(G, s);
        
        while(sc.hasNextLine()) {
        	
        	String sink=sc.next();
        	if(sink.equals("MS")) {
        	if(sg.contains(sink)) {
        		
        		int t=sg.index(sink);
        		
        		System.out.println("path to " + sink + ": ");
        		
        				if(dfs.marked(t)) {
        					//for (int v: dfs.marked(t)) {          						
        						System.out.println("path exists"); 
        						
        					}
        					System.out.println();
        					break;
        					
        	       }
        	   }
        	}	
        

      
       }
    

}
