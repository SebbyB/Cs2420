package assign08;

import org.junit.jupiter.api.Test;

class GraphTester {

	@Test
	void test() throws Exception {

//		Runtime rt = Runtime.getRuntime();
//		Process pr = rt.exec("");


		String Maze = "Assignment 8/pacman/bigMaze_multigoal.txt";
		String out = "Solution.txt";

//		assign08.Graph2 mazeGraph = new assign08.Graph2(Maze);
//		mazeGraph.setPrintMaze(false);
//		mazeGraph.setPrintGenerate(false);
//		int pathLen = mazeGraph.CalculateShortestPath();
//		System.out.println(pathLen);

//		for(int mode = 0; mode <= 5; mode++){
//
//			mazeGraph = new Graph(Maze);
//			mazeGraph.setMode(mode);
//			out = "rand" + "DFSMode" + Integer.toString(mazeGraph.getMode());
//			String outFilePath = "Assignment 8/pacman/pathFind/" + out + ".txt";
//			System.out.println(out + "  Pathlength:" + Integer.toString(mazeGraph.CalculateAPath()));
//			mazeGraph.printGraph(outFilePath);
//
//		}

		out = "randshortest";

		String outFilePath = "Assignment 8/pacman/pathFind/" + out + ".txt";
//		mazeGraph.setPrintGenerate(false);
//		System.out.println(out + "  Pathlength:" + Integer.toString(mazeGraph.CalculateShortestPath()));
//		mazeGraph.printGraph(outFilePath);

//		mazeGraph = new Graph(Maze);
//		mazeGraph.printGraph(outFilePath);

//		mazeGraph.setMode(2);
//		int pathLen = mazeGraph.CalculateAPath();
//		System.out.println(pathLen);
//
//
//		assign08.PathFinder.solveMaze(Maze,out , false);
//		assertEquals(3,pathLen);


	}

}
