public class HammingSimulator {
	public static void main(String[] args) {
		MatrixReader reader;
		int[][] g, h, r, p1, p2;
		
		reader = new MatrixReader();
		
		reader.readFile("g.txt");
		g = reader.getMatrix();
		reader.printMatrix();
		
		reader.readFile("h.txt");
		h = reader.getMatrix();
		reader.printMatrix();
		
		reader.readFile("r.txt");
		r = reader.getMatrix();
		reader.printMatrix();
		
		reader.readFile("p1.txt");
		p1 = reader.getMatrix();
		reader.printMatrix();
		
		reader.readFile("p2.txt");
		p2 = reader.getMatrix();
		reader.printMatrix();
	}
}
