/*=================================================================
Program name - Mouse
Author - April Li
Date - 2019/11/04
Programming Language, version number - Java 9
=================================================================
Problem Definition – This class stores the attributes of the mouse in the maze
=================================================================
*/

public class Mouse {
	//Variables listed for the attributes of the mouse
	private int positionX;
	private int positionY;
	private String[][] shortestPath = new String[8][12];
	private int shortestSteps=8*12;
	private boolean foundCheese;
	private int currDir;
	private int prevDir;
	
	//initializing the variables
	/**mouse method:
	* This procedural method initializes the variables
	*
	* List of Local Variables
	* none
	*
	* @param none
	* @throws none
	* @return none
	*/
	public void mouse() {
		positionX = 0;
		positionY = 0;
		shortestSteps = 8*12;
		foundCheese = false;
		currDir = 0;
		prevDir = 0;
	}//end mouse method
	
	
	//accessor
	/**getPositionX method:
	* This funcitonal method outputs the current x coordinate of the mouse
	*
	* List of Local Variables
	* none
	*
	* @param none
	* @throws none
	* @return x coordinate of the mouse
	*/
	public int getPositionX() {
		return positionX;
	}//end getPositionX
	//mutator
	/**setPositionX method:
	* This procedural method changes the current x coordinate of the mouse
	*
	* List of Local Variables
	* none
	*
	* @param x - new x coordinate of the mouse
	* @throws none
	* @return none
	*/
	public void setPositionX(int x) {
		this.positionX=x;
	}//end setPositionX method
	
	
	
	//accessor
	/**getPositionY method:
	* This fucntional method outputs the current y coordinate of the mouse
	*
	* List of Local Variables
	* none
	*
	* @param none
	* @throws none
	* @return y coordinate of the mouse
	*/
	public int getPositionY() {
		return positionY;
	}//end getPositionY method
	//mutator
	/**setPositionY method:
	* This procedural method changes the current y coordinate of the mouse
	*
	* List of Local Variables
	* none
	*
	* @param y - new y coordinate of the mouse
	* @throws none
	* @return none
	*/
	public void setPositionY(int y) {
		this.positionY=y;
	}//end setPositionY method
	
	
	
	//accessor
	/**getShortestPath method:
	* This functional method outputs the specific object on the maze that records the shortest path
	*
	* List of Local Variables
	* none
	*
	* @param y - the row of maze
	*        x - the column of maze
	* @throws none
	* @return y coordinate of the mouse
	*/
	public String getShortestPath(int y, int x) {
		return shortestPath[y][x];
	}//end getShortestPath method
	//accessor
	/**getShortestPathAR method:
	* This function method outputs the whole array on the maze that records the shortest path
	*
	* List of Local Variables
	* none
	*
	* @param y - the row of maze
	*        x - the column of maze
	* @throws none
	* @return y coordinate of the mouse
	*/
	public String[][] getShortestPathAr() {
		return shortestPath;
	}//end getShortestPathAr method
	//mutator
	/**setShortestPathAr method:
	* This procedural method updates the possible shortestPath
	*
	* List of Local Variables
	* none
	*
	* @param shortestPath - the new shortest path
	* @throws none
	* @return none
	*/
	public void setShortestPathAr(String[][] shortestPath) {
		this.shortestPath = shortestPath;
	}//end setShortestPathAr method
	
	//accessor
	/**getShortestSteps method:
	* This functional method outputs the shortest pace taken to reach the cheese or exit
	*
	* List of Local Variables
	* none
	*
	* @param none
	* @throws none
	* @return shortest possible steps to reach the cheese or exit
	*/
	public int getShortestSteps() {
		return shortestSteps;
	}//end getShortestSteps method
	//mutator
	/**setShortestSteps method:
	* This procedural method updates the shortest pace taken to reach the cheese or exit
	*
	* List of Local Variables
	* none
	*
	* @param shortestSteps - the new shortest steps to reach the cheese or exit
	* @throws none
	* @return none
	*/
	public void setShortestSteps(int shortestSteps) {
		this.shortestSteps = shortestSteps;
	}//end setShortestSteps method
	
	//accessor
	/**getFoundCheese method:
	* This functional method outputs if the mouse found the cheese or not
	*
	* List of Local Variables
	* none
	*
	* @param none
	* @throws none
	* @return if the mouse found the cheese or not
	*/
	public boolean getFoundCheese() {
		return foundCheese;
	}//end getFoundCheese method
	//mutator
	/**setFoundCheese method:
	* This procedural method updates the if the mouse found the cheese or not
	*
	* List of Local Variables
	* none
	*
	* @param foundCheese - if the mouse found the cheese or not
	* @throws none
	* @return none
	*/
	public void setFoundCheese(boolean foundCheese) {
		this.foundCheese = foundCheese;
	}//end setFoundCheese method
	
	
	
	
	//accessor
	/**getCurrDir method:
	* This functional method outputs the current direction of the mouse is going
	* (1 if up,2 is down, 3 is left, 4 is right)
	*
	* List of Local Variables
	* none
	*
	* @param none
	* @throws none
	* @return the current direction of the mouse is going
	*/
	public int getCurrDir() {
		return currDir;
	}//end getCurrDir method
	//mutator
	/**setCurrDir method:
	* This functional method updates the current direction of the mouse is going
	* (1 if up,2 is down, 3 is left, 4 is right)
	*
	* List of Local Variables
	* none
	*
	* @param currDir - the current direction of the mouse is going
	* @throws none
	* @return none
	*/
	public void setCurrDir(int currDir) {
		this.currDir = currDir;
	}//end setCurrDir method
	
	//accessor
	/**getPrevDir method:
	* This functional method outputs the previous direction of the mouse was going
	* (1 if up,2 is down, 3 is left, 4 is right)
	*
	* List of Local Variables
	* none
	*
	* @param none
	* @throws none
	* @return the previous direction of the mouse was going
	*/
	public int getPrevDir() {
		return prevDir;
	}//end getPreDir method
	//mutator
	/**setCurrDir method:
	* This functional method updates the current direction of the mouse is going
	* (1 if up,2 is down, 3 is left, 4 is right)
	*
	* List of Local Variables
	* none
	*
	* @param preDir - the previous direction of the mouse was going
	* @throws none
	* @return none
	*/
	public void setPrevDir(int prevDir) {
		this.prevDir = prevDir;
	}//end setPrevDir method
	
}//end Mouse class
