/**
 *  
 * @author usman Khan
 *This class represents the nodes in a doubly linked list.
 */
public class DoubleNode<T> {
	

	private DoubleNode<T> next;//A reference to the next node in the list. 

	private DoubleNode <T> prev;//A reference to the previous node in the list. •

	private T data; //The data stored in this node. 

	
	public DoubleNode () // Creates an empty node, where all instance variables are null
	{
		next = null;
		prev = null;
		data = null;
	}



	public DoubleNode (T newData) //Creates a node storing the given data in which next and prev are null.
	{
		next = null;
		prev = null;
		data = newData;
	}
	
 
	public DoubleNode<T> getNext () //Returns the value of next. 
	{
	 return next;
	}
 	
	
	public DoubleNode<T> getPrev () // Returns the value of prev. 
	{
		return prev;
	}
	
	public T getData() //Returns the value of data.
	{
		return data;
	}
	
	public void setNext (DoubleNode<T> nextNode) //Stores nextNode in next. 
	{
		next = nextNode;	
	}
	
	public void setPrev (DoubleNode<T> prevNode) //Stores prevNode in prev. 
	{
		prev = prevNode;
	}
	
	public void setData (T newData) //Stores newData in data.
	{
		data = newData;
	}

}
