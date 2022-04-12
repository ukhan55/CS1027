/**
 *  
 * @author usman Khan
 * This class represents a doubly linked list of nodes of the class DoubleNode.
 */
public class DoubleList <T> {
	//This class represents a doubly linked list of nodes of the class DoubleNode.
	private DoubleNode<T> head; //This is a reference to the first node in the list. •
	private DoubleNode<T> rear; //This is a reference to the last node in the list. • 
	private int numDataItems = 0; //This is the number of nodes in the list. 
	
	public DoubleList() //This creates an empty list with zero nodes. 
	{
		
	}
	
	
	public void addData (int index, T newData) throws InvalidPositionException
	{
		if (index > numDataItems || index<0) // the number of nodes is less than the index, throw position exception
		throw new InvalidPositionException("object out of position");
		DoubleNode<T>newNode = new DoubleNode(newData);
		if (numDataItems == 0) {
			head = newNode;
			rear = newNode;
			
	
			
		}
		
		else if (index == 0)
		{
			newNode.setNext(head); //adding node at index 0, changing pointers of the head position
		head.setPrev(newNode);
		head = newNode;
		
		
	}
			
		else if (index == numDataItems)
		{
			rear.setNext(newNode);
		newNode.setPrev(rear);
		rear = newNode;
		
			
		}
		
		else
		{
			DoubleNode<T>prevNode = getNode(index-1);
				DoubleNode<T>nextNode = getNode(index);
				prevNode.setNext(newNode);
				nextNode.setPrev(newNode);
				newNode.setNext(nextNode);
				newNode.setPrev(prevNode);
				
				
		}
		
		numDataItems += 1;
			
	}
	
	
	public DoubleNode<T> getNode(int index) throws InvalidPositionException
	{
	if (numDataItems <= index|| index<0 	) { 
		throw new InvalidPositionException("object out of position");
	}
	DoubleNode<T>position = head;
	for (int i = 0; i<index;i++)
		position = position.getNext();
	return position;
	}
	
	public void removeData(int index) throws InvalidPositionException 
	{
		if (index >= numDataItems || numDataItems == 0) // the number of nodes is less than the index, throw position exception
			throw new InvalidPositionException("object out of position");
			if (numDataItems == 1) {
				head = null;
				rear = null;
				
		
				
			}
			
			else if (index == 0)
			{
			head = head.getNext();
			head.setPrev(null);
				
		}
				
			else if (index == numDataItems -1)
			{
			
			rear = rear.getPrev();
			rear.setNext(null);
			
				
			}
			
			else
			{
				DoubleNode<T>prevNode = getNode(index-1);
					DoubleNode<T>currentNode = getNode(index);
					currentNode.getNext().setPrev(currentNode.getPrev());
					currentNode.getPrev().setNext(currentNode.getNext());
					
			}
			
			numDataItems -= 1; //removed
				
	}
	
	public T getData(int index) throws InvalidPositionException
	{
		return getNode(index).getData();
		
		
	}
	
	public void setData(int index, T newData) throws InvalidPositionException
	{
		getNode(index).setData(newData);
	}
}
