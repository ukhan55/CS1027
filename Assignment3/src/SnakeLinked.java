/**
 *  
 * @author usman Khan
 *The class stores the information about the snake as it moves around the board.
 */

public class SnakeLinked {

	int snakeLength; //this is the number of tiles of the game board occupied by the snake
	
	DoubleList <Position> snakeBody;
	
	public SnakeLinked(int row, int col)//this is the constructor for the class; the parameters are the coordinates of the head of the snake
	{
		snakeLength = 1;
		snakeBody = new DoubleList<Position>();
		Position head = new Position(row, col);
		snakeBody.addData(0, head);
	}
	
	public int getLength() //returns the value of instance variable snakeLength. 
	{
		return snakeLength;
	}
	
	
	public Position getPosition(int index) // returns the Position object stored in the node of the doubly linked list with the given index
	{
		if (index<0||index>= snakeLength)
		return null;
		return snakeBody.getData(index);
	}
	
	
	public boolean snakePosition(Position pos) //returns true if pos is in the doubly linked list of snakeBody, and it returns false otherwise
	{
		DoubleNode<Position> cell = snakeBody.getNode(0);
		for (int i=0; i<snakeLength; i++)
		{
		
		if (cell.getData().equals(pos))
			return true;
		cell = cell.getNext();
		
		}
		
		return false;
			
	}
	
	public Position newHeadPosition(String direction) // returns the new position that the head of the snake would occupy if the snake moved in the direction specified by the parameter
	{
		
		Position head = getPosition(0);
		int row = head.getRow();
		int col = head.getCol();
		if ("up".equals(direction))
		{
		row = row-1;
		}
		
		else if ("down".equals(direction))
		{
			row = row+1;
		}
		
		else if ("right".equals(direction))
		{
			col = col +1;
		}
		
		else if ("left".equals(direction))
		{
			col = col-1;
		}

		return new Position (row,col);
	}
	

	
	
	public void moveSnakeLinked(String direction)
	{
		snakeBody.addData(0,newHeadPosition(direction)); //adding new head position to head of snake
		snakeBody.removeData(snakeLength); //removing the last position
	}
	
	public void shrink() //decreases the value of snakeLength by 1 and deletes the last node in the doubly linked list of snakeBody. 
	{
		snakeLength -=1;
		snakeBody.removeData(snakeLength);
				
	}
	
	void grow(String direction) // increases the length of the snake by 1 and moves the snake’s head in the direction specified
	{
		snakeBody.addData(0, newHeadPosition(direction));
		snakeLength +=1;
		
	}
}
