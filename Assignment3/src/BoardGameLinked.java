/**
 *  
 * @author usman Khan
 * This class represents the board game where the snake moves around eating apples.
 */
public class BoardGameLinked {

	int boardLength; //the number of columns of the grid on the game board. •
	
	int boardWidth;  //the number of rows of the grid 
	
	SnakeLinked theSnake; // an object of the class SnakeLinked representing the snake. 

	DoubleList<String>[] board; //an array of doubly linked lists
	
	public BoardGameLinked(String boardFile)
	{
		MyFileReader ReadFile = new MyFileReader(boardFile);
		 ReadFile.readInt(); //object.method (will read first line and will read integer values)
		 ReadFile.readInt(); //read second line
		 boardLength = ReadFile.readInt(); //read third number, assign length
		 boardWidth = ReadFile.readInt(); //read fourth number assign width
		 //todo 5th 6th
		 theSnake = new SnakeLinked(ReadFile.readInt(), ReadFile.readInt());
		 board = new DoubleList  [boardWidth];//array of doublylinked list
		for (int row = 0; row<boardWidth; row++)
		{
			board[row] = new DoubleList<String>();
			
			for(int col = 0; col<boardLength; col++)
			{
			
			board[row].addData(0, "empty");
			}
		}
		
		while (ReadFile.endOfFile()== false) //read until the end of the file
		 {
			int col = ReadFile.readInt();
			int row = ReadFile.readInt();
			String string1 = ReadFile.readString();
			board[col].setData(row, string1);
			
			
			
		 } 

				 
	}
	
	public String getObject(int row, int col) throws InvalidPositionException //returns the string stored in the node with index = col of the doubly linked list referenced by board[row]. 
	{
		if(row<0|| col<0|| row>= boardWidth || col>= boardLength)
		{
			throw new InvalidPositionException("object out of position");
			
			
		}
		
		return board[row].getData(col);
	}
	
	public void setObject(int row, int col, String newObject) throws InvalidPositionException
	{
		if(row<0|| col<0|| row>= boardWidth || col>= boardLength)
		{
		throw new InvalidPositionException("object out of position");	
		}
		board[row].setData(col, newObject);
	}
	
	public SnakeLinked getSnakeLinked()
	{
		return theSnake;
	}
	
	public void setSnakeLinked(SnakeLinked newSnake)  //stores the value of newSnake in instance variable theSnake.
	{
		theSnake = newSnake;
	}
	
	public int getLength() //returns boardLength 
	{
		return boardLength;
	}
	
	public int getWidth() //returns boardWidth
	{
		return boardWidth;
	}
	
	
	
	
	
	
	
	
	
	
	
}

