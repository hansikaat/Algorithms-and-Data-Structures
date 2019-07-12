package Lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;


public class Topological
{
 private Iterable<Integer> order;// topological order
 
 public Topological(Digraph G)
 {
 DirectedCycle cyclefinder = new DirectedCycle(G);
 if (!cyclefinder.hasCycle())
 {
 DepthFirstOrder dfs = new DepthFirstOrder(G);
 order = dfs.reversePost();
 }
 }
 
 public Iterable<Integer> order()
 { return order; }
 
 
 public boolean isDAG()
 { return order == null; }
 
 
 public static void main(String[] args) throws FileNotFoundException
 {
	 File inputFile = new File("C:\\Users\\Lenovo-User\\Desktop\\topology.txt"); // Include path to file
		Scanner sc = new Scanner(inputFile);		
		
     // read in digraph from command-line argument
		
 	String filename = inputFile.getAbsolutePath();
 	String separator = " ";
 SymbolDigraph sg = new SymbolDigraph(filename, separator);
 Topological top = new Topological(sg.G());
 for (int v : top.order())
 StdOut.println(sg.name(v));
 }
}