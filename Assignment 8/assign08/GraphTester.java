package assign08;

import org.junit.jupiter.api.Test;

class GraphTester {

	@Test
	void test() throws Exception {

//		Runtime rt = Runtime.getRuntime();
//		Process pr = rt.exec("");


		String Maze = "Assignment 8/pacman/randomMaze.txt";
		String out = "Solution.txt";

		assign08.Graph mazeGraph = new assign08.Graph(Maze);
//		int pathLen = mazeGraph.CalculateShortestPath();
//		System.out.println(pathLen);
		int pathLen = mazeGraph.CalculateAPath();
		System.out.println(pathLen);
//
//
//		assign08.PathFinder.solveMaze(Maze,out , false);
//		assertEquals(3,pathLen);


	}

}
