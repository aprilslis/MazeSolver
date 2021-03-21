/*=================================================================
Program name - Maze
Author - April Li
Date - 2019/11/04
Programming Language, version number - Java 9
=================================================================
Problem Definition – The mouse in the given maze needs to find the cheese then exit
Input – setting of the maze
Output – the shortest path of getting the cheese then exit
Process – using recursion to go through every possible path to find the shortest path of getting the cheese and exit
=================================================================
*/


import java.io.*;


public class Maze {
	
	public static Mouse m = new Mouse();//object to access the mouse class where attributes of mouse is stored
	public static int row = 8;//the dimension of the maze (row)
	public static int column = 12;//the dimension of the maze (column)
	
	
	/**main method:
	* This procedural method is called automatically and is used to organize the calling of other methods defined in the class
	*
	* List of Local Variables
	* maze - the 2D array that stores the setting of the given maze
	*
	* @param args &lt;type String&gt;
	* @throws IO Exception
	* @return void
	*/
	public static void main(String[] args) throws IOException {//\\C:\Users\April\Desktop\mazefile2.txt
		
		String[][] maze = new String[row][column];
		maze = findFile(); 
		findPosition(maze,"M");
		m.setShortestSteps(row*column);
		pathFinder(maze,m.getPositionY(),m.getPositionX());
		System.out.println("Path of finding cheese: ");
		output();
		m.setFoundCheese(true);
		
		
		m.setShortestSteps(row*column);
		findPosition(m.getShortestPathAr(),"O");
		pathFinder(m.getShortestPathAr(),m.getPositionY(),m.getPositionX());
		System.out.println("Path of finding Exit: ");
		output();
		
	
	}//end main method

	
	/**findFile method:
	* This functional method reads user input of the maze file address, and returns the 2D array of the maze
	*
	* List of Local Variables
	* br - a BufferedReader object used for keyboard input &lt;type BufferedReader&gt
	* input - a BufferedReader object used for reading file address
	* fileName - a string used for storing the user input
	* line - a string used for storing each line of maze
	* maze - a 2D array used for storing the setting of the maze
	* count - an integer used for counting the rows of array 
	* 
	*
	* @param none
	* @throws IO Exception
	* @return maze - the given maze
	*/
	public static String[][] findFile() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader input;
		
		while(true) {
		    try {
		        System.out.println("Please input the maze file");
		    	String fileName = br.readLine();
		        input = new BufferedReader (new FileReader(fileName));
		        break;
		    } catch (Exception e) {
		        System.err.println("Not a valid address. Please try again");
		        continue;
		    }
		}
		
		
		String line = input.readLine ();  
		String[][] maze = new String[row][column];
		int count = 0;
		while (line != null) {
		maze[count]= line.split(" ");
		   count++;
		   line = input.readLine (); 
		}
		
		m.setShortestPathAr(maze);
		return maze;
		
	}//end findFile method
	
	
	/**findPosition method:
	* This procedural method finds the initial position of the mouse
	*
	* List of Local Variables
	* none
	* 
	* @param maze - a 2D array used to store the setting of the maze
	* 		 positionVariable - a string used to store the variable representing where the mouse is
	* * @throws none
	* @return none
	*/
	public static void findPosition(String[][] maze,String positionVariable) {//maze[8][12]
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(maze[i][j].equals(positionVariable)){
					m.setPositionY(i);
					m.setPositionX(j);
					break;
				}
			}
		}
	}//end findPosition method
	
	
	/**copyPath method:
	* This functional method gives a copy of the path array
	*
	* List of Local Variables
	* copy - 2D array used for storing the copy of the path array
	*
	* @param none
	* @throws none
	* @return copy - the copy of the path array
	*/
	public static String[][] copyPath(String[][] path){
		String[][] copy = new String[row][column];
		for(int i=0;i<row;i++) {
			copy[i] = path[i].clone();
		}
		return copy;
	}//end copyPath method
	
	
	/**pathFinder method:
	* This procedural method uses recursion to check every possible route for finding the cheese and finding the exit
	* then calls the shortestPath method to check for the shortest possible route for completing the task
	*
	* List of Local Variables
	* temp - an integer used for temporary storage of the objects in every direction of the mouse
	* 
	*
	* @param path - 2D array used for storing the path of the mouse
	*        y - an integer used for storing the vertical coordinate of the mouse
	*        x - an integer used for storing the horizontal coordinate of the mouse
	* @throws none
	* @return none
	*/
	public static void pathFinder(String [][] path, int y, int x) {
		int temp;
		
//		//test!!!!!!!!!!!
//			for(int i=0;i<row;i++) {
//				for(int j=0;j<column;j++) {
//					System.out.print(path[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println("end");
//			System.out.println();
//			///test!!!!!!!!
//				
		m.setCurrDir(1);//up
		temp=checkPath(path,y-1,x);
		if(temp==1) {
			m.setPrevDir(1);
			if(!m.getFoundCheese()) {
				path[y-1][x]= "o";
			}
			else {
				path[y-1][x]= "O";
			}
			pathFinder(copyPath(path),y-1,x);
			path[y-1][x]= ".";
		}
		else if(temp==2){
			path[y-1][x]= "O";
			findShortest(path);
		}
		else if(temp==3) {
			if(m.getFoundCheese()) {
				path[y-1][x]= "O";
				findShortest(path);
			}
		}
		
		
		
		
		
		
		m.setCurrDir(2);//down
		temp=checkPath(path,y+1,x);
		if(temp==1) {
			m.setPrevDir(2);
			if(!m.getFoundCheese()) {
				path[y+1][x]= "o";
			}
			else {
				path[y+1][x]= "O";
			}
			pathFinder(copyPath(path),y+1,x);
			path[y+1][x]= ".";
		}
		else if(temp==2){
			path[y+1][x]= "O";
			findShortest(path);
		}
		else if(temp==3) {
			if(m.getFoundCheese()) {
				path[y+1][x]= "O";
				findShortest(path);
			}
		}
		
		
		
		
		
		
		m.setCurrDir(3);//left
		temp=checkPath(path,y,x-1);
		if(temp==1) {
			m.setPrevDir(3);
			if(!m.getFoundCheese()) {
				path[y][x-1]= "o";
			}
			else {
				path[y][x-1]= "O";
			}
			pathFinder(copyPath(path),y,x-1);
			path[y][x-1]= ".";
		}
		else if(temp==2){
			path[y][x-1]= "O";
			findShortest(path);
		}
		else if(temp==3) {
			if(m.getFoundCheese()) {
				path[y][x-1]= "O";
				findShortest(path);
			}
		}
		
		
		 
		


		m.setCurrDir(4);//right
		temp=checkPath(path,y,x+1);
		if(temp==1) {
			m.setPrevDir(4);
			if(!m.getFoundCheese()) {
				path[y][x+1]= "o";
			}
			else {
				path[y][x+1]= "O";
			}
			pathFinder(copyPath(path),y,x+1);
			path[y][x+1]= ".";
		}
		else if(temp==2){
			path[y][x+1]= "O";
			findShortest(path);
		}
		else if(temp==3) {
			if(m.getFoundCheese()) {
				path[y][x+1]= "O";
				findShortest(path);
			}
		}
		
		
		m.setPrevDir(0);
	}//end pathFinder method
	
	
	/**checkPath method:
	* This functional method checks what is the surrounding of the mouse
	*
	* List of Local Variables
	* temp - a String used for temporary storage of the objects at the current coordinate
	*
	* @param path - 2D array used for storing the path of the mouse
	*        y - an integer used for storing the vertical coordinate of the mouse
	*        x - an integer used for storing the horizontal coordinate of the mouse 
	* @throws none
	* @return an integer that represents different objects around the mouse
	* 		  (if not accessible returns 0, if accessible returns 1, if found cheese returns 2, if found exit returns 3)
	*/
	public static int checkPath(String[][] path, int y, int x) {
		
		if(y<0||y>row||x<0||x>column) {
			return 0;
		}
		if(y==row||x==column) {
			return 0;
		}
		
		
		if(m.getCurrDir()==1&&m.getPrevDir()==2) {
			return 0;
		}
		if(m.getCurrDir()==2&&m.getPrevDir()==1) {
			return 0;
		}
		if(m.getCurrDir()==3&&m.getPrevDir()==4) {
			return 0;
		}
		if(m.getCurrDir()==4&&m.getPrevDir()==3) {
			return 0;
		}
		
		
		
		String temp = path[y][x];
		if(temp.equals(".")) {
			return 1;
		}
		else if(temp.equals("C")) {
			return 2;
		}
		
		if(m.getFoundCheese()) {
			if(temp.equals("o")) {
				return 1;
			}
			else if(temp.equals("X")) {
				return 3;
			}
		}

		return 0;
	
	}//end checkPath method
	
	
	/**findShortest method:
	* This procedural method checks if the current pathway is the shortest possible path
	*
	* List of Local Variables
	* count - an integer used for counting how many steps has been taken
	* 
	*
	* @param path - 2D array used for storing the path of the mouse
	*        check - an integer that checks if the mouse has found the cheese yet
	* @throws none
	* @return none
	*/
	public static void findShortest(String[][] path) {//array[row][column]
		int count=0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				if(path[i][j].equalsIgnoreCase("o")) {
					count++;
				}
			}
		}
		
		System.out.println();

		if(count<m.getShortestSteps()) {
			m.setShortestSteps(count);
			m.setShortestPathAr(path);
		}
	}//end findShortest method
	
	
	/**output method:
	* This procedural method outputs the solution found
	*
	* List of Local Variables
	* none
	*
	* @param none
	* @throws none
	* @return none
	*/
	public static void output() {
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				System.out.print(m.getShortestPath(i, j));
			}
			System.out.println();
		}
		System.out.println();
	}//end output method
}//end Maze class
