/**
 * 
 * @author usman
 *
 * This class represents the data items that will be stored in the circular array. Each object of this class stores
two things: an identifier and a value.
 */
public class CellData <T>{
	
private T id; //A reference to the identifier stored in this object 
private int value; //This is the value of the data item stored in this object. 

	public CellData(T theId, int theValue) //Constructor for the class. Initializes id to theId and value to theValue
	{
	
	id = theId;
	value = theValue;
			
	}
	
	public int getValue() // Returns instance variable value.
	{
	
		return value;
	}
	
	public T getId() // Returns instance variable id. 
	{
	
		return id;
	}
	
	public void setValue(int newValue) //Assigns newValue to instance variable value.
	{
	
		value = newValue;
	}
	
	public void setId(T newId) // Assigns the value of newId to instance variable id. 
	{
	
		id = newId;
	}

	

	}
