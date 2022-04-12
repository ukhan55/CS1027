/**
 *  
 * @author usman Khan
 *
 */
public class Position {
		
		private int positionRow;
		private int positionCol;
		
		
		
		

		
		public Position(int row, int col)
	    { 
	        this.positionRow = row; 
	        this.positionCol = col; 
	    } 
	
		public int getCol() 
		{
		
			return positionCol;		
		}
		
		
		public int getRow()
		{
			
			return positionRow;
		}
		
		public void setRow (int newRow)
		{
			positionRow = newRow;
			
		}
	
		public void setCol(int newCol)
		{
			positionCol = newCol;
		}
		
		public boolean equals( Position otherPosition) {
			if(otherPosition.positionRow == this.positionRow){ 
					if (otherPosition.positionCol == this.positionCol) {
						return true;
					}
					else {
						return false;
						
					}
					
			}
			
			else {
				return false;
			
		}
		

}

}

					
			
			
		
			
				

		
		
		
	
	


