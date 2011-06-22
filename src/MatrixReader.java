import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrixReader {
	int[][] matrix;
	int lines, columns;
	public MatrixReader() {
		
	}
	
	public MatrixReader(String file) {
		readFile(file);
	}
	
	public int[][] getMatrix() {
		return matrix;
	}
	
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
	
	public void printMatrix() {
		System.out.print("[");
		for(int i = 0; i < lines; i++) {
			System.out.print("[");
			for(int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("]");
			if(i < lines-1) {
				System.out.println();
			}
		}
		System.out.println("]");
	}
}
