import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Matrix {
	int[][] matrix;
	int lines, columns;
	
	public Matrix() {
		
	}
	
	public Matrix(String file) {
		readFile(file);
	}
	
	public Matrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	/**
	 * @return The matrix you are currently working with as an integer array
	 */
	public int[][] getMatrix() {
		return matrix;
	}
	
	/**
	 * Reads a file and turns it into a matrix
	 * @param file the file to read
	 */
	public void readFile(String file) {
		String line = "";
		String column[];
		
		Scanner scanner;
		lines = 0;
		columns = 0;
		try {
			scanner = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			System.err.println("Unable to read file: "+file);
			e.printStackTrace();
			return;
		}
		
		while(scanner.hasNextLine()) {
			lines++;
			line = scanner.nextLine();
		}
		
		column = line.split(" ");
		columns = column.length;
		
		try {
			scanner = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			System.err.println("Unable to read file: "+file);
			e.printStackTrace();
			return;
		}
		
		
		matrix = new int[lines][columns];
		
		for(int i = 0; i < lines; i++) {
			line = scanner.nextLine();
			column = line.split(" ");
			
			for(int j = 0; j < columns; j++) {
				matrix[i][j] = Integer.parseInt(column[j]);
			}
		}
	}
	
	/**
	 * set a value in the matrix
	 * @param line
	 * @param column
	 * @param value
	 */
	
	public void set(int line, int column, int value) {
		matrix[line][column] = value;
	}
	
	public int get(int line, int column) {
		return matrix[line][column];
	}
	
	public void printMatrix() {
		printMatrix(matrix);
	}
	
	public void printMatrixLine() {
		printMatrixLine(matrix);
	}
	
	public static void printMatrix(int[][] m) {
		System.out.print("[");
		for(int i = 0; i < m.length; i++) {
			System.out.print("[");
			for(int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.print("]");
			if(i < m.length-1) {
				System.out.println();
			}
		}
		System.out.println("]");
	}
	
	public static void printMatrixLine(int[][] m) {
		System.out.print("(");
		for(int i = 0; i < m[0].length; i++) {
			for(int j = 0; j < m.length; j++) {
				System.out.print(m[j][i]);
				if(j < m.length-1) {
					System.out.print(" ");
				}
			}
		}
		System.out.println(")");
	}
	
	public static int[][] multiply(int[][] m, int[][] n) {
		try {
			if(m[0].length != n.length) {
				System.err.println("Matrix length not matching.");
				System.err.println("Number of lines of first matrix has to be number of columns of second matrix.");
				return null;
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		
		int[][] o = new int[m.length][n[0].length];
		for(int i = 0; i < o.length; i++) {
			for(int j = 0; j < o[0].length; j++) {
				o[i][j] = 0;
				for(int k = 0; k < n.length; k++) {
					o[i][j] += m[i][k]*n[k][j];
				}
			}
		}
		return o;
	}
	
	public static Matrix multiply(Matrix M, Matrix N) {
		return new Matrix(multiply(M.getMatrix(), N.getMatrix()));
	}
	
	public void modulate() {
		modulate(2);
	}
	
	public void modulate(int by) {
		matrix = modulate(matrix, by);
	}
	
	public static int[][] modulate(int[][] m, int by) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				m[i][j] = m[i][j] % by;
			}
		}
		return m;
	}
	
	public int toInt() {
		int sum = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				sum += matrix[i][j];
			}
		}
		return sum;
	}
}
