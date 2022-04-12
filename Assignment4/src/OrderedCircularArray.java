/**
 * 
 * @author usman
 *
 * This class implements an ordered list using a circular array
 */


   public class OrderedCircularArray<T> implements SortedListADT<T> {
	   
	  private CellData<T> [] list;
	  private int front; //This variable stores the position of the first data item in the list; 
	  private int rear; //This is the index of the last data item in the ordered list
	  private int count; //The value of this variable is equal to the number of data items in the list. 
	  
	  public OrderedCircularArray() //Initializes the instance variables as specified above.
	  {
		  list = (CellData<T>[])new CellData[5]; //casted
		  front = 1;
		  rear = 0;
		  count = 0;
		  
	  }
	   
	  /**
	   * in this method, we are doubling the size of the old array
	   */
	  private void resize()
	  {
		  final int oldSize = list.length;
		  CellData[]newArr = new CellData[count*2];
		  for (int i = front ; i< count + front; i++)
			  newArr[i] = list [ i% list.length];
		  
		  
		  rear = count+(front-1) ;
		  list = newArr;
		  
		  
	  }
	  
	  
   
	  /**
	   * we insert into the ordered list and resize if necessary
	   */
			
	  
	  
	  public void insert (T id, int value)//Adds a new CellData object storing the given id and value to the ordered list
	  {
		if (count == list.length)
		{
			resize();
			
		}
		boolean inserted = false;
		CellData<T> swap = new CellData<T>(id, value);
		CellData<T> buffer = null;
		for(int i = front; i < count + front; i++) {
		  buffer = list[i%list.length];
		  if(!inserted) {
		    if(value < buffer.getValue()){
		   inserted = true;
		  list[i%list.length] = swap;
		  swap = buffer;
		  }
		  } else {
		  list[i%list.length] = swap;
		  swap = buffer;
		  }
		}
 list[(count+front) % list.length] = swap;
		
		count= (count +1);
		
		rear = (front + count-1)%list.length;
	  }
   
			 
	  
	  
	  
	  public int getValue(T id) throws InvalidDataItemException //Returns the integer value of the CellData object with the specified id
	  {
		  CellData<T> node = null;
		  for(int i = front; i < front + count; i++) {
		     node = list[i%list.length];
		     if(node.getId().equals(id)) {
		       return node.getValue();
		     }
		  }
		   
		  throw new InvalidDataItemException("valuenotfound");
	  }
   	
	  public void remove(T id) throws InvalidDataItemException //Removes from the ordered list the CellData object with the specified id.
	  {
		  boolean found = false;
		  CellData<T> node = null;
		  for(int i = front; i < front + count; i++) {
		     node = list[i%list.length];
		     if(!found) {
		       if(node.getId().equals(id)) {
		         found = true;
		       }
		     } else {
		         // assign to the index before this one, the current cell
		         list[(i-1 + list.length) %list.length] = list[i%list.length];
		     }
		  }

		  if(found == true) {
		    count = (count - 1 + list.length)%list.length;
		    rear = (front + count-1)%list.length;
		    } else throw new InvalidDataItemException("could not remove");
	  }
	  
	  public void changeValue (T id, int newValue) throws InvalidDataItemException //Changes the value attribute of the CellData object with the given id to the specified newValue
	  {
		  try {
		  getValue(id);
		  remove(id);
		  insert(id,newValue);
		  
		  } catch (InvalidDataItemException e) {
		      throw new InvalidDataItemException("could not change value for id: " + id + " " + e.getMessage());    
	  } 
	  }
	  
	  
	  public T getSmallest() throws EmptyListException //Removes and returns the id or the CellData object in the ordered list with smallest associated value
	  {
		 if (count == 0 )
			 throw new EmptyListException("empty list");
		 CellData<T>smallest = list[front];
		 front = (front +1) % list.length;
		 count--;
		 return smallest.getId();
	  }
	  
	  public boolean isEmpty() //Returns true if the ordered list is empty and it returns false otherwise. 
	  {
		 if (count == 0)
				 return true;
		 return false;
	  }
	  
	  public int size() //Returns the number of data items in the ordered list
	  {
		  return count;
	  }
	  
	  public int getFront() //Returns the value of instance variable front
	  {
		  return front;
	  }
	  
	  public int getRear() //Returns the value of instance variable rear 
	  {
		  return rear;
	  }
	  
	  
   	
   	
   	
   	
   	
	  
  
   }
   
   