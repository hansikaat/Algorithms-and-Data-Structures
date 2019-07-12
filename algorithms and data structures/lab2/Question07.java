/*README:
 The program consider four cases:
 1. If there is no element in the list, add the new node as the header
 2. If there are elements in the list, check whether the value inside the node is less than the value inside header
  if it is true, add the new node as the header 
 3. Check whether there is any node with lesser value than the new node inside the list and add the new node 
 before that particular node
 4. If there are no items with lesser values than the new node, add the new node next to header
 */
public class LinkedList{
	
	public Node head; 	
		
	private class Node
	{ 			
		Node next;
		int data =Integer.MIN_VALUE;			
	}
			
	public void insertAscending(int data)
	{
		Node node = new Node();
	    node.data = data;	    
	    
	    //if no elements in the list, add the node as the head
	    if (head == null) {
	        head = node;	        
	    } else if (node.data < head.data) { // else check whether the data inside header is greater than data of node
	        node.next = head;
	        head = node;
	    } else { // else check whether there are any data in the middle of the array which are less than the node data
		    Node p = head;
		    boolean added=false;
		    while (p.next != null)
		    {
		        if (p.next.data > data)
		        { 
		           node.next = p.next;
		           p.next = node;
		           added = true;
		           break;
		        }
		        p = p.next;
		    }
		    if (!added) { // else add the node next to the head
		        p.next = node;
		    }
		}
		}
		
		
		public String toString() {
			Node n = head;
			StringBuilder sb = new StringBuilder("[");
			while(n.next != null) {
				sb.append(n.data+", ");
				n = n.next;
			}
			
			sb.append(n.data+"]");
			return sb.toString();
		}
		
		
		public static void main(String[] args) {
			
			LinkedList list = new LinkedList();		
				
			list.insertAscending(3);
			list.insertAscending(2);
			list.insertAscending(1);
			list.insertAscending(4);
			System.out.println(list);		
			
			
			
		}
	

}

/*execution
[1, 2, 3, 4]
*/