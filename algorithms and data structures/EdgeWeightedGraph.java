package Lab04;

import java.io.File;
import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class EdgeWeightedGraph
{
 private final int V; // number of vertices
 private int E; // number of edges
 private Bag<Edge>[] adj; // adjacency lists
 public EdgeWeightedGraph(int V)
 {
 this.V = V;
 this.E = 0;
 adj = (Bag<Edge>[]) new Bag[V];
 for (int v = 0; v < V; v++)
 adj[v] = new Bag<Edge>();
 }
 public EdgeWeightedGraph(File in) {
     this.ha;
     int E = in.readInt();
     if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
     for (int i = 0; i < E; i++) {
         int v = in.readInt();
         int w = in.readInt();
         double weight = in.readDouble();
         Edge e = new Edge(v, w, weight);
         addEdge(e);
     }
 }
 // See Exercise 4.3.9.
 public int V() { return V; }
 public int E() { return E; }
 public void addEdge(Edge e)
 {
 int v = e.either(), w = e.other(v);
 adj[v].add(e);
 adj[w].add(e);
 E++;
 }
 public Iterable<Edge> adj(int v)
 { return adj[v]; }
 
 
 public Iterable<Edge> edges()
 {
  Bag<Edge> b = new Bag<Edge>();
  for (int v = 0; v < V; v++)
  for (Edge e : adj[v])
  if (e.other(v) > v) b.add(e);
  return b;
 }

 public String toString() {
     StringBuilder s = new StringBuilder();
     s.append(V + " " + E + "\n");
     for (int v = 0; v < V; v++) {
         s.append(v + ": ");
         for (Edge e : adj[v]) {
             s.append(e + "  ");
         }
         s.append("\n");
     }
     return s.toString();
 }

 /**
  * Unit tests the {@code EdgeWeightedGraph} data type.
  *
  * @param args the command-line arguments
  */
 public static void main(String[] args) {
	 File inputFile = new File("C:\\Users\\Lenovo-User\\Desktop\\input.txt"); // Include path to file
		Scanner sc = new Scanner(inputFile);		
		
		String filename = inputFile.getAbsolutePath();
		String delimiter = " ";
		String source = "AL";
		String dest = "MS";
		 SymbolGraph sg= new SymbolGraph(filename, delimiter);
		 EdgeWeightedGraph G = sg.G();
	        if(!sg.contains(source)) {
	        	System.out.println("not in the file");
	        	return;
	        }
     
     StdOut.println(G);
 }
 
 
}
