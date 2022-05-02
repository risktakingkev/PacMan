import java.util.Random;
import java.util.Scanner;

public class PacMan {

	// constants for various characters in the grid
	private static final char COOKIE = 'O', EMPTY = '.', VISITED = ' ', PAC_LEFT = '>', PAC_UP = 'V', PAC_RIGHT = '<',
			PAC_DOWN = '^';

	// constants for pacman direction
	private static final int LEFT = 0, RIGHT = 1, UP = 2, DOWN = 3;

	// total percentage of cookies on the grid
	private static final double TOTAL_COOKIES = 0.15;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// read rows and cols
		System.out.print("Enter rows: ");
		int rows = scanner.nextInt();
		System.out.print("Enter cols: ");
		int cols = scanner.nextInt();

		// Initialize grid and current pacman direction
		char[][] grid = intializeGrid(rows, cols);
		int pacmanDir = LEFT;
		int pacRow = 0, pacCol = 0;

		System.out.println("\nWelcome to PacMan!");

		
		// display menu at start
		displayMenu();
		System.out.println();

		int cookiesEaten = 0, moves = 0;

		// while user doesn't exit
		boolean exit = false;
		while (!exit) {
			// display grid
			displayGrid(grid);
			
			// read command
			System.out.print("\nCommand: ");
			int command = scanner.nextInt();

			System.out.println();

			switch (command) {
			case 0: // display menu
				displayMenu();
				break;

			case 1: // turn left
				pacmanDir = turnLeft(pacmanDir);
				grid[pacRow][pacCol] = getPac(pacmanDir);
				break;

			case 2: // turn right
				pacmanDir = turnRight(pacmanDir);
				grid[pacRow][pacCol] = getPac(pacmanDir);
				break;

			case 3: // move
				// get new position
				int[] newPos = move(pacmanDir, pacRow, pacCol, grid);
				if (newPos == null) // if not possible
					System.out.println("Error: Cannot move in the current direction");
				else {  // move possible
					moves++; // update move count
					
					int newRow = newPos[0], newCol = newPos[1];
					char pacChar = grid[pacRow][pacCol];
					
					// update previous position as visited
					grid[pacRow][pacCol] = VISITED;
					
					// update new location of pacman
					pacRow = newRow;
					pacCol = newCol;

					if (grid[pacRow][pacCol] == COOKIE) { // if new location is cookie
						cookiesEaten++;
						System.out.println("Yum Yum. That was good!");

					}

					// set pacman to new location
					grid[pacRow][pacCol] = pacChar;
				}
				break;

			case 4: // exit
				exit = true;
				break;

			default: // invalid choice
				System.out.println("Error: Invalid command.");
				System.out.println("Here are the valid commands:");
				displayMenu();
				break;
			}

			System.out.println();

		}

		
		// total moves and cookie eaten
		System.out.print("#Moves: " + moves + " #Cookies Eaten: " + cookiesEaten);
		if (cookiesEaten > 0) // if at least one cookie eaten
			System.out.println(" #Moves per cookie: " + (double) moves / cookiesEaten);
		else // no cookie  eaten
			System.out.println(" #Moves per cookie: n/a");

		System.out.println("\nBye Bye!");

	}

	
	// method to display menu
	public static void displayMenu() {
		System.out.println("Enter your desired command number from the following commands:");
		System.out.println("0. Display Commands");
		System.out.println("1. Turn Left");
		System.out.println("2. Turn Right");
		System.out.println("3. Move");
		System.out.println("4. Exit");
	}

	
	// initialize grid 
	public static char[][] intializeGrid(int rows, int cols) {
		char[][] grid = new char[rows][cols];

		// initialize all positions to empty
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = EMPTY;
			}
		}

		// set pacman
		grid[0][0] = PAC_LEFT;

		// fill cookies
		fillCookies(grid);

		return grid;
	}

	
	// turn left from current direction
	public static int turnLeft(int currDir) {
		if (currDir == UP)
			return LEFT;
		else if (currDir == RIGHT)
			return UP;
		else if (currDir == DOWN)
			return RIGHT;
		else // if(currDir == LEFT)
			return DOWN;
	}

	
	// turn right from current direction
	public static int turnRight(int currDir) {
		if (currDir == UP)
			return RIGHT;
		else if (currDir == RIGHT)
			return DOWN;
		else if (currDir == DOWN)
			return LEFT;
		else // if(currDir == LEFT)
			return UP;
	}

	
	// get pacman character based on current direction
	public static char getPac(int currDir) {
		if (currDir == UP)
			return PAC_UP;
		else if (currDir == RIGHT)
			return PAC_RIGHT;
		else if (currDir == DOWN)
			return PAC_DOWN;
		else // if(currDir == LEFT)
			return PAC_LEFT;
	}

	
	// fill cookies
	private static void fillCookies(char[][] grid) {
		Random random = new Random();

		int rows = grid.length;
		int cols = grid[0].length;

		// calculate total cookies and round
		int totalCookies = (int) (rows * cols * TOTAL_COOKIES);
		
		// while all cookies has not been placed
		while (totalCookies != 0) {
			// generate a random location
			int row = random.nextInt(rows);
			int col = random.nextInt(cols);
			
			// if empty, place cookie
			if (grid[row][col] == EMPTY) {
				grid[row][col] = COOKIE;
				totalCookies--;
			}
		}
	}


	// prints the grid on screen
	private static void displayGrid(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

	
	// move pacman in the curr direction
	public static int[] move(int currDir, int pacRow, int pacCol, char[][] grid) {
		// find new location
		int newRow = pacRow, newCol = pacCol;
		if (currDir == UP)
			newRow--;
		else if (currDir == DOWN)
			newRow++;
		else if (currDir == LEFT)
			newCol--;
		else
			newCol++;

		// if move is possible
		if (isPossible(newRow, newCol, grid))
			return new int[] { newRow, newCol };
		else // not possible
			return null;

	}

	
	// check if move is possible
	public static boolean isPossible(int row, int col, char[][] grid) {
		return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
	}

}