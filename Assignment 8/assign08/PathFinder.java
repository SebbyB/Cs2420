package assign08;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author Daniel Kopta
 * Simple class to drive the path finding logic and solve a maze.
 */
public class PathFinder {

	/**
	 * Given an input file containing a maze,
	 * finds a path to the goal then outputs the solved maze.
	 * @param inputFile - the file containing the input maze
	 * @param outputFile - the file to write the solution to closest goal shortest path
	 * @param findShortest - if true, the path found is required to be the shortest path,
	 *                       if false, the path found can be any path
	 */
	public static void solveMaze(String inputFile, String outputFile, boolean findShortest)
	{
		assign08.Graph g = null;
		try {
			g = new assign08.Graph(inputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(findShortest)
			g.CalculateShortestPath();
		else
			g.setMode(0);
			g.CalculateAPath();
		
		g.printGraph(outputFile);
	}
	


	public static void main(String[] args){

		String out;
		String mazeIn;
		String outFilePath;

		System.out.println("StartingPathFinder...");

		try {
			Scanner scanner = new Scanner(new File("C:\\Users\\sebas\\OneDrive\\Documents\\GitHub\\Cs2420\\Assignment 8\\pacman\\pathFind\\pacman.txt"));

			System.out.println("Solving maze...");

			while(scanner.hasNextLine()){
				String m = scanner.nextLine();
				mazeIn = "C:\\Users\\sebas\\OneDrive\\Documents\\GitHub\\Cs2420\\Assignment 8\\pacman\\" + m;

				out = m + "Shortest";
				outFilePath = "C:\\Users\\sebas\\OneDrive\\Documents\\GitHub\\Cs2420\\Assignment 8\\pacman\\pathFind\\" + out +".txt";

				Graph mazeGraph = new Graph(mazeIn);



//				System.out.println(out + "PathLength:" + Integer.toString(mazeGraph.CalculateShortestPath()));
				mazeGraph.printGraph(outFilePath);

				for(int mode = 0; mode <= 5; mode++){

					mazeGraph = new Graph(mazeIn);
					mazeGraph.setMode(mode);
				out =m + "DFSMode" + Integer.toString(mazeGraph.getMode());
					outFilePath = "C:\\Users\\sebas\\OneDrive\\Documents\\GitHub\\Cs2420\\Assignment 8\\pacman\\pathFind\\" + out + ".txt";


				System.out.println(out + "  Pathlength:" + Integer.toString(mazeGraph.CalculateAPath()));
					mazeGraph.printGraph(outFilePath);

				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done...");



	}
}
