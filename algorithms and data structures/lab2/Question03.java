/*README:
 I have added a variable called count inside sort function to increment the count whenever the 
 exchange function is called
 */
import java.util.Scanner;

public class Question03 {
	public static void main(String[] args)
	{ 				
		Scanner s=new Scanner(System.in);
		//Define the size of the input (N)  
        System.out.println("enter the size of input: ");
        int n=s.nextInt();
        int array[]=new int[n];        
        
        //Input (N) integers from the command line which is to be sorted
        for(int i=0;i<n;i++)
        {
        	System.out.println("enter integer "+(i+1)+":");
            array[i]=s.nextInt();            
        }                    
        
        System.out.println("is sorted? "+isSorted(array));     
        //content of the array is sorted and printed
		sort(array);		
		show(array);
	}	
	
	public static void sort(int[] a)
	{ // Sort a[] into increasing order.
		int N = a.length; // array length
		int count=0; // initiate the swap count variable
		for (int i = 0; i < N; i++)
		{ // Exchange a[i] with smallest entry in a[i+1...N).
			int min = i; // index of minimal entr.
			
			for (int j = i+1; j < N; j++)
			if (!less(a[j], a[min])) 
			{
				min = j;				
			}			
			exch(a, i, min);
			count=count+1;
		}
		System.out.println("number of swaps: "+count);
	}
	
	private static boolean less(int v, int w)
	{ 
		//check whether v - w is less than zero to identify whether v is less than w
		int y=v-w;
		if(y<0)
			return true;
		else
			return false;
	}

	private static void exch(int[] a, int i, int j)
	{				
		//swap the elements
		int t = a[i]; a[i] = a[j]; a[j] = t;		
	}

	private static void show(int[] a)
	{ // Print the array
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
number of swaps: 6
sorted array: 
5 
4 
3 
2 
1 
0 
*/