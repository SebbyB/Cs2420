package assign08;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
		Graph g = null;
		try {
			g = new Graph(inputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(findShortest)
			g.CalculateShortestPath();
		else
//			g.setMode(0);
			g.CalculateAPath();
		
		g.printGraph(outputFile);
	}

	public static void writeDataAtOnce(String filePath, ArrayList<String[]> data) {

		// first create file object for file placed at location
		// specified by filepath
		File file = new File(filePath);

		try {
			// create FileWriter object with file as parameter
			FileWriter outputFile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputFile, ',',
					CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER,
					CSVWriter.DEFAULT_LINE_END);
			writer.writeAll(data);
			// closing writer connection
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String[] args) throws Exception {

		String out;
		String mazeIn;
		String outFilePath;

		String nt;
		String pl;
		String method;
		int num = 50;
		int dim = 100;

		ArrayList<String[]> bigData = new ArrayList<>();
	bigData.add(new String[] {"DFS0", "DFS1","DFS2","DFS3","DFS4","DFS5", "Shortest","PathLength", "MazeSolved"});
		System.out.println("StartingPathFinder...");


		String m;

		Graph mazeGraph;


		double d = .3;
		int numGoals = 4;
		for (int i = 1; i <= num; i++) {
			String[] data = new String[9];


			String fn = "Assignment 8/pacman/randomGenerateMaze" + Integer.toString(i) + ".txt";
			MazeGen.randomMaze(fn, dim, d, numGoals);

			mazeIn = fn;
			m = "randomGenerateMaze" + Integer.toString(i);
			data[8] = m;

			System.out.println(m);
			for (int mode = 0; mode <= 5; mode++) {

				mazeGraph = new Graph(fn);
				mazeGraph.setMode(mode);
				pl = Integer.toString(mazeGraph.CalculateAPath());
				nt = Integer.toString(mazeGraph.nodesTouched());
				method = "DFSMode" + Integer.toString(mazeGraph.getMode());
				data[mode] = nt;
			}
			mazeGraph = new Graph(mazeIn);
			pl = Integer.toString(mazeGraph.CalculateShortestPath());
			nt = Integer.toString(mazeGraph.nodesTouched());
			data[6] = nt;
			data[7] = pl;
//				bigData.add(new String[]{m,"Shortest",pl,nt});

			bigData.add(data);
		}
			String[] data = new String[9];


			mazeIn = "Assignment 8/pacman/bigMaze_multigoal.txt";

			m = "bigMulti";
			data[8] = m;

			System.out.println(m);
			for(int mode = 0; mode <= 5; mode++){

				mazeGraph = new Graph(mazeIn);
				mazeGraph.setMode(mode);
				pl = Integer.toString(mazeGraph.CalculateAPath());
				nt = Integer.toString(mazeGraph.nodesTouched());
				method = "DFSMode" + Integer.toString(mazeGraph.getMode());
				data[mode] = nt;
			}
			mazeGraph = new Graph(mazeIn);
			pl = Integer.toString(mazeGraph.CalculateShortestPath());
			nt = Integer.toString(mazeGraph.nodesTouched());
			data[6] = nt;
			data[7] =pl;
			bigData.add(data);


		String fout = "Assignment 8/randomGenComparison" + Integer.toString(num) + "Mazes_Size"+Integer.toString(dim) + "_Density" + Integer.toString((int)d*10) + "_numGoals" + Integer.toString(numGoals)+ ".csv";
		writeDataAtOnce(fout,bigData);
		System.out.println("Done...");

	}




	}
