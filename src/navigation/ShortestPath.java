package navigation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ShortestPath {

	/**
	 * Gather the information from input files to see what the grid looks like
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String path = "/Users/saibulusu/myworkspace/workspace/Other/src/";
		Scanner in = new Scanner(new File(path + "shortestpathtest.dat"));

		int numberOfTests = in.nextInt();

		for (int i = 0; i < numberOfTests; i++) {
			// generate the grid
			int size = in.nextInt();
			in.nextLine();
			char[][] grid = new char[size][size];
			
			for (int r = 0; r < size; r++) {
				grid[r] = in.nextLine().toCharArray();
			}
			
			// determine the source and destination locations
			int sRow = 0;
			int sCol = 0;
			int dRow = 0;
			int dCol = 0;
			
			for (int r = 0; r < grid.length; r++) {
				for (int c = 0; c < grid[r].length; c++) {
					if (grid[r][c] == 'S') {
						sRow = r;
						sCol = c;
					} else if (grid[r][c] == 'D') {
						dRow = r;
						dCol = c;
					}
				}
			}

			// reinitialize crossed to have all false for this new grid
			crossed = new boolean[grid.length][grid[0].length];
			// analyze the board given the locations of the source and destination
			System.out.println(analyze(grid, sRow, sCol, dRow, dCol));
		}
		
		in.close();
	}
	
	// crossed will make sure that no position is crossed twice
	static boolean[][] crossed;
	
	/**
	 * Analyze a given position and determine the best path from the current location to the destination
	 * @param grid holds all of the positions and values at those positions
	 * @param sRow the row coordinate of the source
	 * @param sCol the column coordinate of the source
	 * @param dRow the row coordinate of the destination
	 * @param dCol the column coordinate of the destination
	 * @return
	 */
	static String analyze(char[][] grid, int sRow, int sCol, int dRow, int dCol) {
		// make sure that this position will not be crossed in future iterations
		crossed[sRow][sCol] = true;
		
		// base cases where this location is at or one away from the destination
		if (sRow == dRow && sCol == dCol) {
			return "";
		} else if (sRow == dRow && sCol - 1 == dCol) {
			return "L";
		} else if (sRow == dRow && sCol + 1 == dCol) {
			return "R";
		} else if (sRow - 1 == dRow && sCol == dCol) {
			return "U";
		} else if (sRow + 1 == dRow && sCol == dCol) {
			return "D";
		}

		// will compare the four neighbors' best paths
		String up = "";
		String down = "";
		String left = "";
		String right = "";
		
		/*
		 *  construct the four strings representing the best paths of the neighbors,
		 *  but in some cases ignore them, because:
		 *  out of bounds
		 *  not reachable location
		 *  already crossed
		 */
		if (sRow == 0 || grid[sRow - 1][sCol] == 'X' || crossed[sRow - 1][sCol]) {
			up = "ignore";
		} else {
			up = analyze(grid, sRow - 1, sCol, dRow, dCol);
		}
		
		if (sRow == grid.length - 1 || grid[sRow + 1][sCol] == 'X' || crossed[sRow + 1][sCol]) {
			down = "ignore";
		} else {
			down = analyze(grid, sRow + 1, sCol, dRow, dCol);
		}
		
		if (sCol == 0 || grid[sRow][sCol - 1] == 'X' || crossed[sRow][sCol - 1]) {
			left = "ignore";
		} else {
			left = analyze(grid, sRow, sCol - 1, dRow, dCol);
		}
		
		if (sCol == grid[0].length - 1 || grid[sRow][sCol + 1] == 'X' || crossed[sRow][sCol + 1]) {
			right = "ignore";
		} else {
			right = analyze(grid, sRow, sCol + 1, dRow, dCol);
		}
		
		// list will make it easy to compare the four generated strings to see which is the best path
		ArrayList<String> list = new ArrayList<String>();
		if (!up.equals("ignore")) {
			list.add(up);
		}
		
		if (!down.equals("ignore")) {
			list.add(down);
		}
		
		if (!left.equals("ignore")) {
			list.add(left);
		}
		
		if (!right.equals("ignore")) {
			list.add(right);
		}
		
		// sort the list, the zeroth index is the best one
		Collections.sort(list, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});

		// the best string in this list is the one to consider
		String best = "";
		
		if (list.size() == 0) {
			return "error";
		}

		if (list.get(0).equals(up)) {
			best += "U";
		} else if (list.get(0).equals(down)) {
			best += "D";
		} else if (list.get(0).equals(left)) {
			best += "L";
		} else if (list.get(0).equals(right)) {
			best += "R";
		}
		
		return best + list.get(0);
	}
}
