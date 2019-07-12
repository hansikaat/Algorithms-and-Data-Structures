package Lab04;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


import edu.princeton.cs.algs4.StdOut;



public class DFSpath {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex

    /**
     * Computes a path between {@code s} and every other vertex in graph {@code G}.
     * @param g the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DFSpath(Graph g, int s) {
        this.s = s;
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    // depth first search from v
    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Returns a path between the source vertex {@code s} and vertex {@code v}, or
     * {@code null} if no such path.
     * @param  v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *         {@code s} and vertex {@code v}, as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> pathTo(int v) {
       
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

  

    /**
     * Unit tests the {@code DepthFirstPaths} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
		File inputFile = new File("C:\\Users\\Lenovo-User\\Desktop\\input.txt"); // Include path to file
		Scanner sc = new Scanner(inputFile);		
		
		String filename = inputFile.getAbsolutePath();
		String delimiter = " ";
		String source = "AL";
		//String dest = "MS";
        SymbolGraph sg= new SymbolGraph(filename, delimiter);
        Graph G = sg.G();
        if(!sg.contains(source)) {
        	System.out.println("not in the file");
        	return;
        }
        int s=sg.index(source);        
        
        DFSpath dfs = new DFSpath(G, s);
        
        while(sc.hasNextLine()) {
        	
        	String sink=sc.next();
        	if(sink.equals("MS")) {
        	if(sg.contains(sink)) {
        		
        		int t=sg.index(sink);
        		
        		System.out.println("path to " + sink + ": ");
        		
        				if(dfs.hasPathTo(t)) {
        					for (int v: dfs.pathTo(t)) {          						
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