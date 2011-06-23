
public class HammingSimulator {
	public static void main(String[] args) {
		Matrix Generator, Checker, Receiver, Data1, Data2, Received, CheckResult, Decoded;
		
		Generator = new Matrix("g.txt");
		Checker = new Matrix("h.txt");
		Receiver = new Matrix("r.txt");
		Data1 = new Matrix("p1.txt");
		Data2 = new Matrix("p2.txt");
		
		Received = Matrix.multiply(Generator, Data1);
		Received.modulate();
		Received.set(2, 0, 0);
		
		CheckResult = Matrix.multiply(Checker, Received);
		CheckResult.modulate();
		//CheckResult.printMatrix();
		if(CheckResult.toInt() == 0) {
			System.out.println("Matrix fehlerfrei empfangen");
		}
		else {
			System.out.println("Fehler in der Übertragung.");
		}
		
		Decoded = Matrix.multiply(Receiver, Received);
		Decoded.printMatrix();
	}
}
