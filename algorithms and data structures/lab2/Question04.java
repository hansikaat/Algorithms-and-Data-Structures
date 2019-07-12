/*README:
 I have created a new function called inversions which increase the counter whenever the 
 first element is greater than the other, which invert the two positions  
 */
import java.util.Scanner;

public class Question04
{
	public static void main(String[] args)
	{ // Read strings from standard input, sort them, and print.'
		
		Scanner s=new Scanner(System.in);
        System.out.println("enter the size of input: ");
        int n=s.nextInt();
        int array[]=new int[n];        
        
        for(int i=0;i<n;i++)
        {//for reading array
        	System.out.println("enter integer "+(i+1)+":");
            array[i]=s.nextInt();            
        }                    
        
        System.out.println("is sorted? "+isSorted(array));     
        inversions(array);
		sort(array);		
		show(array);
	}	
	
	public static void sort(int[] a)
	{ // Sort a[] into increasing order.
		int N = a.length; // array length
		
		for (int i = 0; i < N; i++)
		{ // Exchange a[i] with smallest entry in a[i+1...N).
			int min = i; // index of minimal entr.
			
			for (int j = i+1; j < N; j++)
			if (!less(a[j], a[min])) 
			{
				min = j;				
			}			
			exch(a, i, min);			
		}
		
		
	}
	
	public static void inversions(int[] a) { // counts the number of inversions		
		int count=0;
		for(int i=0;i<a.length;i++)
        {        	 
            for (int j = i+1; j < a.length; j++)
    			if (!less(a[j], a[i])) 
    			{    				  
    				count=count+1;
    				//prints a list of all inversions on the format [i,a[i]], [j, a[j]] 
    				System.out.println("["+i+", "+a[i]+"], ["+j+", "+a[j]+"]");
    			}
        }
		System.out.println("number of inversions: "+count);		
	}
	

	private static boolean less(int v, int w)
	{ 
		int y=v-w;
		if(y<0)
			return true;
		else
			return false;
	}

	private static void exch(int[] a, int i, int j)
	{				
		int t = a[i]; a[i] = a[j]; a[j] = t;		
	}

	private static void show(int[] a)
	{ // Print the array, on a single line.
		System.out.println("sorted array: ");	
		for (int i = 0; i < a.length; i++)
		System.out.println(a[i] + " ");
		System.out.println();
	}
	
	public static boolean isSorted(int[] a)
	{ // Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++)
		if (less(a[i], a[i-1])) return false;
		return true;
	}	
	
}

/*execution
enter the size of input: 
6
enter integer 1:
1
enter integer 2:
2
enter integer 3:
4
enter integer 4:
3
enter integer 5:
5
enter integer 6:
0
is sorted? false
[0, 1], [1, 2]
[0, 1], [2, 4]
[0, 1], [3, 3]
[0, 1], [4, 5]
[1, 2], [2, 4]
[1, 2], [3, 3]
[1, 2], [4, 5]
[2, 4], [4, 5]
[3, 3], [4, 5]
number of inversions: 9
sorted array: 
5 
4 
3 
2 
1 
0 
*/
