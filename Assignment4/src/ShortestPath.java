/** 
 * 
 * @author usman
 *this class finds the shortest path to the destination on the map
 */
public class ShortestPath {
	
	/**
	 * constructor for the class
	 * 
	 * @param theMap
	 */
	
	private OrderedCircularArray<MapCell> distances = new OrderedCircularArray<MapCell>(); //empty ordered circular array

	CityMap cityMap; 
	
	 public ShortestPath (CityMap theMap) //This is the constructor for the class It receives as input a reference to a CityMap object representing the city map.
	 {
		cityMap = theMap; 
	 }

	 
	 /**
		 * This method will look for a path using minimum number of map cells 
		 * 
		 * 
		 */
	 public void findShortestPath()  //This method will look for a path with the minimum number of map cells from the starting cell to the destination cell
	 {
		 {
			   

			  MapCell start = cityMap.getStart(); //get the starting cell
			  start.setDistanceToStart(0);
			  distances.insert(start, 0); //inserting starting cell in ordered list

			  start.markInList(); // mark the cell as in the ordered list
			  boolean destinationIsReached = false;

			  MapCell closest = null; // ORIGINALLY NULL
			  try {  
			  while(!distances.isEmpty() && !destinationIsReached) {
			    // whatever step 4 says;
			     closest = distances.getSmallest(); // the map cell S with smallest distance
			     closest.markOutList();
			     if(closest.isDestination()) break; 
			  
			  }

			  } catch(EmptyListException empty) {
			    // print appropriate message    
			  }
		 }
			}
	 

		/**
		 * returns the first neighbouring map cell 
		 * @param cell
		 * @return
		 */

	private MapCell nextCell(MapCell cell)        
			        {
				// get each neighbor
                int maxNeighborDistance = cell.getDistanceToStart() + 1;
                MapCell n0 = cell.getNeighbour(0) ;
                MapCell n1 = cell.getNeighbour(1); 
                MapCell n2 = cell.getNeighbour(2); 
                MapCell n3 = cell.getNeighbour(3);
                
                if(n0.getDistanceToStart() > maxNeighborDistance) {
                  n0.setDistanceToStart(maxNeighborDistance);
                  n0.setPredecessor(cell);
                }
                int n0distance = n0.getDistanceToStart(); //setting p= distance from c to the starting cell
				if(n0.isMarkedInList() && n0distance < distances.getValue(n0)) {
                    distances.changeValue(n0, n0distance);
                } else {
                    distances.insert(n0, n0distance);    
                }
                
                if ((cell.isStart() || cell.isNorthRoad() || cell.isIntersection())&& n0 != null && ! n0.isMarked() && (n0.isDestination() || n0.isIntersection() || n0.isNorthRoad())) //only one of condiitions has to be true
                        return n0;
                if ((cell.isStart() || cell.isEastRoad() || cell.isIntersection())&& n1 != null && ! n1.isMarked() && (n1.isDestination() || n1.isIntersection() || n1.isEastRoad())) //only one of condiitions has to be true
                        return n1;
                if ((cell.isStart() || cell.isSouthRoad() || cell.isIntersection())&& n2 != null && ! n2.isMarked() && (n2.isDestination() || n2.isIntersection() || n2.isSouthRoad())) //only one of condiitions has to be true
                        return n2;
                if ((cell.isStart() || cell.isWestRoad() || cell.isIntersection())&& n3 != null && ! n3.isMarked() && (n3.isDestination() || n3.isIntersection() || n3.isWestRoad())) //only one of condiitions has to be true
                        return n3;
                
                return null;
} 


			        }
			        
			        
			            