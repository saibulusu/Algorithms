package navigation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ShortestPath {
	
	public static void main(String[] args) throws FileNotFoundException {
		String path = "/Users/saibulusu/myworkspace/workspace/Other/src/";
		Scanner in = new Scanner(new File(path + "shortestpathtest.dat"));

		int numberOfTests = in.nextInt();

		for (int i = 0; i < numberOfTests; i++) {
			int size = in.nextInt();
			in.nextLine();
			char[][] grid = new char[size][size];
			
			for (int r = 0; r < size; r++) {
				grid[r] = in.nextLine().toCharArray();
			}
			
			// find the source and destination nodes
			int sRow = 0;
			int sCol = 0;
			int dRow = 0;
			int dCol = 0;
			
			boolean[][] checked = new boolean[size][size];
			boolean[][] avoid = new boolean[size][size];
			
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					if (grid[r][c] == 'S') {
						sRow = r;
						sCol = c;
						grid[r][c] = '.';
					} else if (grid[r][c] == 'X') {
						dRow = r;
						dCol = c;
						grid[r][c] = '.';
					}
					
					// do not avoid or have these nodes checked
					avoid[r][c] = false;
					checked[r][c] = false;
				}
			}
			
			int[][] distance = new int[size][size];
			
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					// each cell in distance holds the length of the shortest path to the destination
					distance[r][c] = distance(grid, r, c, dRow, dCol);
				}
			}

			// analyze the source and destination at the same time
			analyze(grid, checked, avoid, distance, sRow, sCol, dRow, dCol);
			
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					// mark everything that has been crossed with a 'C'
					if (checked[r][c]) {
						grid[r][c] = 'C';
					}
					
					// fix the source and destination nodes
					if (r == sRow && c == sCol) {
						grid[r][c] = 'S';
					}
					
					if (r == dRow && c == dCol) {
						grid[r][c] = 'X';
					}
					
					System.out.print(grid[r][c]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		in.close();
	}
	
	// analyze a given position
	static void analyze(char[][] grid, boolean[][] checked, boolean[][] avoid, int[][] distance, 
			int sRow, int sCol, int dRow, int dCol) {
		if (sRow == dRow && sCol == dCol) {
			// check if the source and destination are equal
			checked[sRow][sCol] = true;
		} else {
			// set the checked value to false
			checked[sRow][sCol] = false;
			// check everything around the current value
			// if something adjacent is valid, then set checked on the current value to true
			// don't avoid the current value in this situation
			if (sRow - 1 >= 0 && grid[sRow - 1][sCol] == '.' && !checked[sRow - 1][sCol]
					&& !avoid[sRow - 1][sCol] && 
					distance[sRow - 1][sCol] + 1 == distance[sRow][sCol]) {
				checked[sRow][sCol] = true;
				avoid[sRow][sCol] = false;
				analyze(grid, checked, avoid, distance, sRow - 1, sCol, dRow, dCol);
			} else if (sRow + 1 < checked.length && grid[sRow + 1][sCol] == '.' && 
					!checked[sRow + 1][sCol]
					&& !avoid[sRow + 1][sCol] && 
					distance[sRow + 1][sCol] + 1 == distance[sRow][sCol]) {
				checked[sRow][sCol] = true;
				avoid[sRow][sCol] = false;
				analyze(grid, checked, avoid, distance, sRow + 1, sCol, dRow, dCol);
			} else if (sCol - 1 >= 0 && grid[sRow][sCol - 1] == '.' && !checked[sRow][sCol - 1]
					&& !avoid[sRow][sCol - 1] && 
					distance[sRow][sCol - 1] + 1 == distance[sRow][sCol]) {
				checked[sRow][sCol] = true;
				avoid[sRow][sCol] = false;
				analyze(grid, checked, avoid, distance, sRow, sCol - 1, dRow, dCol);
			} else if (sCol + 1 < checked.length && grid[sRow][sCol + 1] == '.' && 
					!checked[sRow][sCol + 1]
					&& !avoid[sRow][sCol + 1] && 
					distance[sRow][sCol + 1] + 1 == distance[sRow][sCol]) {
				checked[sRow][sCol] = true;
				avoid[sRow][sCol] = false;
				analyze(grid, checked, avoid, distance, sRow, sCol + 1, dRow, dCol);
			} else {
				// if no adjacent value is valid, then avoid the current value and don't check it
				avoid[sRow][sCol] = false;
				checked[sRow][sCol] = true;
				distance[sRow][sCol] = -1;
				if (sRow - 1 >= 0 && distance[sRow - 1][sCol] - 1 == distance[sRow][sCol]
						&& checked[sRow - 1][sCol]) {
					analyze(grid, checked, avoid, distance, sRow - 1, sCol, dRow, dCol);
				} else if (sRow + 1 < checked.length && 
						distance[sRow + 1][sCol] - 1 == distance[sRow][sCol]
						&& checked[sRow + 1][sCol]) {
					analyze(grid, checked, avoid, distance, sRow + 1, sCol, dRow, dCol);
				} else if (sCol - 1 >= 0 && distance[sRow][sCol - 1] - 1 == distance[sRow][sCol]
						&& checked[sRow][sCol - 1]) {
					analyze(grid, checked, avoid, distance, sRow, sCol - 1, dRow, dCol);
				} else if (sCol + 1 < checked.length && 
						distance[sRow][sCol + 1] - 1 == distance[sRow][sCol]
								&& checked[sRow][sCol + 1]) {
					analyze(grid, checked, avoid, distance, sRow, sCol + 1, dRow, dCol);
				}
			}
		}
	}
	
	// find the length of the shortest path between the source and the destination
	static int distance(char[][] field, int sRow, int sCol, int dRow, int dCol) {
		// create a copy array which can be altered
		char[][] copy = new char[field.length][field[0].length];

		// store the distances for each node to the source
		int[][] distance = new int[field.length][field[0].length];
		//the source is 0 distance away from itself
		distance[sRow][sCol] = 0;

		int row = 0;
		int col = 0;
		
		while (row < field.length) {
			while (col < field[row].length) {
				copy[row][col] = field[row][col];
				col++;
			}
			row++;
			col = 0;
		}
		
		//crossed will hold everything that has to be checked
		ArrayList<Integer[]> crossed = new ArrayList<Integer[]>();
		//first check the source
		Integer[] first = { sRow, sCol };
		crossed.add(first);

		//while there are still more values to check
		while (crossed.size() > 0) {
			//temp holds everything that has yet to be checked
			ArrayList<Integer[]> temp = new ArrayList<Integer[]>();

			int i = 0;
			
			while (i < crossed.size()) {
				int r = crossed.get(i)[0];
				int c = crossed.get(i)[1];

				//if the current value is the source
				if (r == dRow && c == dCol) {
					return distance[r][c];
				}
				
				//add the four nodes around the current node, if they are valid
				//the distance of the adjacent nodes is one more than the 
				//distance of the current node
				if (r - 1 >= 0 && copy[r - 1][c] == '.') {
					Integer[] add = { r - 1, c };
					temp.add(add);
					distance[r - 1][c] = 1 + distance[r][c];
				}

				if (r + 1 < field.length && copy[r + 1][c] == '.') {
					Integer[] add = { r + 1, c };
					temp.add(add);
					distance[r + 1][c] = 1 + distance[r][c];
				}

				if (c - 1 >= 0 && copy[r][c - 1] == '.') {
					Integer[] add = { r, c - 1 };
					temp.add(add);
					distance[r][c - 1] = 1 + distance[r][c];
				}

				if (c + 1 < field[0].length && copy[r][c + 1] == '.') {
					Integer[] add = { r, c + 1 };
					temp.add(add);
					distance[r][c + 1] = 1 + distance[r][c];
				}
				
				//everything that has already been crossed will be marked with 'K'
				copy[r][c] = 'K';
				
				i++;
			}
			
			//everything that has yet to be crossed is now added to temp
			crossed = temp;
		}

		return -1;
	}

}