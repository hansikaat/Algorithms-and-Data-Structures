package Lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedCycle{
    private boolean[] marked;        // marked[v] = has vertex v been marked?
    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)

    /**
     * Determines whether the digraph {@code G} has a directed cycle and, if so,
     * finds such a cycle.
     * @param G the digraph
     */
    public DirectedCycle(Digraph G) {
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v] && cycle == null) dfs(G, v);
    }

   
	// check that algorithm computes either the topological order or finds a directed cycle
    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) return;

            // found new vertex, so recur
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }

            // trace back directed cycle
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                
            }
        }
        onStack[v] = false;
    }

    /**
     * Does the digraph have a directed cycle?
     * @return {@code true} if the digraph has a directed cycle, {@code false} otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * Returns a directed cycle if the digraph has a directed cycle, and {@code null} otherwise.
     * @return a directed cycle (as an iterable) if the digraph has a directed cycle,
     *    and {@code null} otherwise
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }


    /**
     * Unit tests the {@code DirectedCycle} data type.
     *
     * @param args the command-line arguments
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
    	File inputFile = new File("C:\\Users\\Lenovo-User\\Desktop\\DC.txt"); // Include path to file
		Scanner sc = new Scanner(inputFile);		
		
        // read in digraph from command-line argument
		
    	String filename = inputFile.getAbsolutePath();
    	String delimiter = " ";
		String source = "AL";
	    SymbolDigraph sg= new SymbolDigraph(filename, delimiter);
        Digraph G = sg.G();
        
        
        

        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Directed cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(sg.name(v) + " ");
            }
            StdOut.println();
        }

        else {
            StdOut.println("No directed cycle");
        }
        StdOut.println();
    }

}
