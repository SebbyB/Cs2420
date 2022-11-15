//package assign08;
//
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.LinkedList;
//
//
///**
// *
// * @author Daniel Kopta, Sebastian Barney, Amelia Neilson
// * This Graph class acts as a starting point for your maze path finder.
// * Add to this class as needed.
// */
//public class Graphbroke {
//
//	// The graph itself is just a 2D array of nodes
//	private Node[][] nodes;
//
//	// The node to start the path finding from
//	private Node start;
//	private Node goal;
//
//	// The size of the maze
//	private int width;
//	private int height;
//
//	/**
//	 *Changes the Mode for DFS Search - Initialized to mode0 in the Graph Constructor.
//	 *mode0 (Left -> Top -> Right -> Down)
//	 *mode1 (Down -> Left -> Top -> Right)
//	 *mode2 (Right -> Down -> Left -> Top)
//	 *mode3 (Top -> Right -> Down -> Left)
//	 *mode4 (Top -> Bottom -> Right -> Left)
//	 *mode5 (Right -> Left -> Top -> Bottom)
//	 */
//	public int mode = 2;
//
//
//
//	/**
//	 * Constructs a maze graph from the given text file.
//	 * @param filename - the file containing the maze
//	 * @throws Exception
//	 */
//	public Graph(String filename) throws Exception
//	{
//		BufferedReader input;
//		input = new BufferedReader(new FileReader(filename));
//
//		if(!input.ready())
//		{
//			input.close();
//			throw new FileNotFoundException();
//		}
//
//		// read the maze size from the file
//		String[] dimensions = input.readLine().split(" ");
//		height = Integer.parseInt(dimensions[0]);
//		width = Integer.parseInt(dimensions[1]);
//
//		// instantiate and populate the nodes
//		nodes = new Node[height][width];
//		for(int i=0; i < height; i++)
//		{
//			String row = input.readLine().trim();
//
//			for(int j=0; j < row.length(); j++)
//				switch(row.charAt(j))
//				{
//				case 'X':
//					nodes[i][j] = new Node(i, j);
//					nodes[i][j].isWall = true;
//					break;
//				case ' ':
//					nodes[i][j] = new Node(i, j);
//					break;
//				case 'S':
//					nodes[i][j] = new Node(i, j);
//					nodes[i][j].isStart = true;
//					start = nodes[i][j];
//					break;
//				case 'G':
//					nodes[i][j] = new Node(i, j);
//					goal = nodes[i][j];
//					nodes[i][j].isGoal = true;
//					break;
//				default:
//					throw new IllegalArgumentException("maze contains unknown character: \'" + row.charAt(j) + "\'");
//				}
//		}
//		input.close();
//	}
//
//	/**
//	 * Outputs this graph to the specified file.
//	 * Use this method after you have found a path to one of the goals.
//	 * Before using this method, for the nodes on the path, you will need
//	 * to set their isOnPath value to true.
//	 *
//	 * @param filename - the file to write to
//	 */
//	public void printGraph(String filename)
//	{
//		try
//		{
//			PrintWriter output = new PrintWriter(new FileWriter(filename));
//			output.println(height + " " + width);
//			for(int i=0; i < height; i++)
//			{
//				for(int j=0; j < width; j++)
//				{
//					output.print(nodes[i][j]);
//				}
//				output.println();
//			}
//			output.close();
//		}
//		catch(Exception e){e.printStackTrace();}
//	}
//
//
//
//
//
//
//	private void initNodes(Node node){
//
//
//		int row = node.row;
//		int col = node.col;
//
//
//		node.topNode = this.nodes[row-1][col];
//		node.bottomNode = this.nodes[row+1][col];
//		node.rightNode = this.nodes[row][col + 1];
//		node.leftNode = this.nodes[row][col - 1];
//	}
//
//	private boolean skipNode(Node node){
//
//		if(node.isVisited || node.isWall)
//			return true;
//
//		return false;
//
//	}
//
//
//
//	private int returnPath(Node currentNode){
//		int pathLength = 0;
//
//			while(!currentNode.previousInPath.isStart){
//				currentNode = currentNode.previousInPath;
//				pathLength++;
//				currentNode.isOnPath = true;
//
////				if(printMaze) {
////					String string = "mazeFromPath " + Integer.toString(pathLength) + ".txt";
////					printGraph(string);
////				}
//
//			}
//		return pathLength;
//	}
//
//	/**
//	 * Traverse the graph with BFS (shortest path to closest goal)
//	 * A side-effect of this method should be that the nodes on the path
//	 * have had their isOnPath member set to true.
//	 * @return - the length of the path
//	 */
//
//	/**
//	 * Traverse the graph with BFS (shortest path to closest goal)
//	 * A side-effect of this method should be that the nodes on the path
//	 * have had their isOnPath member set to true.
//	 * @return - the length of the path
//	 */
//	public int CalculateShortestPath()
//	{
//		int pathLength = 0;
//		LinkedList<Node> checkQueue = new LinkedList<Node>();
//		checkQueue.offer(this.start);
//		start.isVisited = true;
//		while(checkQueue.size() > 0){
//			Graph.Node checkNode = checkQueue.poll();
//			initNodes(checkNode);
//			if(checkNode.isGoal){
//				while(!checkNode.previousInPath.isStart){
//					checkNode = checkNode.previousInPath;
//					pathLength++;
//					checkNode.isOnPath = true;
//
//				}
//				return pathLength;
//			}
//
//			if(!checkNode.topNode.isWall && !checkNode.topNode.isVisited){
//				checkQueue.offer(checkNode.topNode);
//				checkNode.topNode.previousInPath = checkNode;
//				checkNode.topNode.isVisited = true;
//			}
//			if(!checkNode.bottomNode.isWall && !checkNode.bottomNode.isVisited){
//				checkQueue.offer(checkNode.bottomNode);
//				checkNode.bottomNode.previousInPath = checkNode;
//				checkNode.bottomNode.isVisited = true;
//			}
//			if(!checkNode.rightNode.isWall && !checkNode.rightNode.isVisited){
//				checkQueue.offer(checkNode.rightNode);
//				checkNode.rightNode.previousInPath = checkNode;
//				checkNode.rightNode.isVisited = true;
//
//			}
//			if(!checkNode.leftNode.isWall && !checkNode.leftNode.isVisited){
//				checkQueue.offer(checkNode.leftNode);
//				checkNode.leftNode.previousInPath = checkNode;
//				checkNode.leftNode.isVisited = true;
//
//			}
//
//		}
//		return -1;
//	}
//
//	/**
//	 * Traverse the graph with DFS (any path to any goal)
//	 * A side-effect of this method should be that the nodes on the path
//	 * have had their isOnPath member set to true.
//	 * @return - the length of the path
//	 */
//	public int CalculateAPath()
//	{
//		int pathLength = recursiveCalculateAPath(this.start);
//		return pathLength;
//	}
//
//	/**
//	 * Recursively traverses a graph using DFS to find a path length. Has 6 different modes...
//	 * @param currentNode - Node whose graph is being DFSd.
//	 * @return path length.
//	 *mode0 (Left -> Top -> Right -> Down)
//	 *mode1 (Down -> Left -> Top -> Right)
//	 *mode2 (Right -> Down -> Left -> Top)
//	 *mode3 (Top -> Right -> Down -> Left)
//	 *mode4 (Top -> Bottom -> Right -> Left)
//	 *mode5 (Right -> Left -> Top -> Bottom)
//	 */
//	private int recursiveCalculateAPath(Node currentNode) {
//		//Creates a pathLength Variable, initialized to 0. Initializes the currentNode and changes Visited Status.
//		int ret;
//		initNodes(currentNode);
//		currentNode.isVisited = true;
//		Node leftNode = currentNode.leftNode;
//		Node rightNode = currentNode.rightNode;
//		Node topNode = currentNode.topNode;
//		Node bottomNode = currentNode.bottomNode;
//		/**
//		 * If the node is the goal go back through the path and sets the path to the path then return the path length.
//		 */
//
//
//		if(currentNode.isGoal){
//			return returnPath(currentNode);
//		}
////		String fileName;
//
//		/**
//		 *
//		 *
//		 * Method works the same for every mode, order is just changed.
//		 * Checks if the nextNode is a wall or has been visited. If they are, skip the node.
//		 * Otherwise, change nextNode's previous Node to the currentNode.
//		 * Then return this method with the nextNode as a parameter.
//		 * Then check a different nextNode.
//		 * If nothing is ever found, return -1.
//		 *
//		 *
//		 *
//		 * The mode changes the order in which nextNode chosen.
//				* Ex. Mode0 nextNode starts with leftNode then goes to topNode, then goes to rightNode, then to bottomNode.
//		 */
//		switch (mode){
//			// Checks mode 0 DFS (Left -> Top -> Right -> Down)
//			case 0:{
//
//				if(!skipNode(leftNode)){
//					leftNode.previousInPath = currentNode;
//					 ret = recursiveCalculateAPath(leftNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(topNode)){
//					topNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(topNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(rightNode)){
//					rightNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(rightNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(bottomNode)){
//					bottomNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(bottomNode);
//					if (ret != -1)
//						return ret;
//				}
////				if(printGenerate){
////					fileName = "Assignment 8/currentMazeGen/GraphFromRow" + Integer.toString(currentNode.row) + "_Col" + Integer.toString(currentNode.col) + ".txt";
////					printGraph(fileName);
////				}
//			}
//			//Checks mode 1 DFS (Down -> Left -> Top -> Right)
//			case 1:{
//				if(!skipNode(bottomNode)){
//					bottomNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(bottomNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(leftNode)){
//					leftNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(leftNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(topNode)){
//					topNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(topNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(rightNode)){
//					rightNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(rightNode);
//					if (ret != -1)
//						return ret;
//				}
////				if(printGenerate){
////					fileName = "Assignment 8/currentMazeGen/GraphFromRow" + Integer.toString(currentNode.row) + "_Col" + Integer.toString(currentNode.col) + ".txt";
////					printGraph(fileName);
////				}
//			}
//			//Checks mode 2 DFS (Right -> Down -> Left -> Top)
//			case 2:{
//				if(!skipNode(rightNode)){
//					rightNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(rightNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(bottomNode)){
//					bottomNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(bottomNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(leftNode)){
//					leftNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(leftNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(topNode)){
//					topNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(topNode);
//					if (ret != -1)
//						return ret;
//				}
////				if(printGenerate){
////					fileName = "Assignment 8/currentMazeGen/GraphFromRow" + Integer.toString(currentNode.row) + "_Col" + Integer.toString(currentNode.col) + ".txt";
////					printGraph(fileName);
////				}
//
//			}
//			//Checks mode 3 DFS (Top -> Right -> Down -> Left)
//			case 3:{
//				if(!skipNode(topNode)){
//					topNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(topNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(rightNode)){
//					rightNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(rightNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(bottomNode)){
//					bottomNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(bottomNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(leftNode)){
//					leftNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(leftNode);
//					if (ret != -1)
//						return ret;
//				}
////				if(printGenerate){
////					fileName = "Assignment 8/currentMazeGen/GraphFromRow" + Integer.toString(currentNode.row) + "_Col" + Integer.toString(currentNode.col) + ".txt";
////					printGraph(fileName);
////				}
//
//
//			}
//			//Checks mode 4 DFS (Top -> Bottom -> Right -> Left)
//			case 4:{
//				if(!skipNode(topNode)){
//					topNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(topNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(bottomNode)){
//					bottomNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(bottomNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(rightNode)){
//					rightNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(rightNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(leftNode)){
//					leftNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(leftNode);
//					if (ret != -1)
//						return ret;
//				}
////				if(printGenerate){
////					fileName = "Assignment 8/currentMazeGen/GraphFromRow" + Integer.toString(currentNode.row) + "_Col" + Integer.toString(currentNode.col) + ".txt";
////					printGraph(fileName);
////				}
//
//			}
//			//Checks mode 5 DFS (Right -> Left -> Top -> Bottom)
//			case 5:{
//				if(!skipNode(rightNode)){
//					rightNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(rightNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(leftNode)){
//					leftNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(leftNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(topNode)){
//					topNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(topNode);
//					if (ret != -1)
//						return ret;
//				}
//				if(!skipNode(bottomNode)){
//					bottomNode.previousInPath = currentNode;
//					ret = recursiveCalculateAPath(bottomNode);
//					if (ret != -1)
//						return ret;
//				}
//
////				if(printGenerate){
////					fileName = "Assignment 8/currentMazeGen/GraphFromRow" + Integer.toString(currentNode.row) + "_Col" + Integer.toString(currentNode.col) + ".txt";
////					printGraph(fileName);
////				}
//
//			}
//		}
//
//		return -1;
//	}
//
//
//	/**
//	 * @author Daniel Kopta, Sebastian Barney, Amelia Neilson.
//	 * 	A node class to assist in the implementation of the graph.
//	 * 	You will need to add additional functionality to this class.
//	 */
//	private static class Node
//	{
//		// The node's position in the maze
//		private int row, col;
//
//		// The type of the node
//		private boolean isStart;
//		private boolean isGoal;
//		private boolean isOnPath;
//		private boolean isWall;
//		private boolean isVisited;
//
//		//Surrounding Nodes
//		private Node topNode;
//		private Node bottomNode;
//		private Node rightNode;
//		private Node leftNode;
//
//		//Data for NodePaths
//		private Node previousInPath;
//
//
//		/**
//		 * Node Constructor
//		 *
//		 * Initializes any Node at a row and column to not be Start, Goal, On Path, or Visited.
//		 *
// 		 * @param r - row of Node.
//		 * @param c - column of Node.
//		 */
//		public Node(int r, int c)
//		{
//			isStart = false;
//			isGoal = false;
//			isOnPath = false;
//			isVisited = false;
//
//
//			row = r;
//			col = c;
//
//
//			previousInPath = null;
//		}
//
//		/**
//		 * @return - String representation of Node.
//		 */
//		@Override
//		public String toString()
//		{
//			if(isWall)
//				return "X";
//			if(isStart)
//				return "S";
//			if(isGoal)
//				return "G";
//			if(isOnPath)
//				return ".";
//			if(isVisited)
//				return "V";
//			return " ";
//		}
//	}
//
//	/**
//	 * Private setter method for DFS mode.
//	 * @param n - Which mode you would like to use.
//	 */
//	public void setMode(int n){
//		if(n > 5 || n < 0){throw new IllegalArgumentException();}
//		this.mode = n;
//	}
//
//	/**
//	 * Private getter method for DFS mode.
//	 * @return - current mode of DFS.
//	 */
//	public int getMode(){
//		return this.mode;
//	}
//
//
//
//
//
//
//
//}
