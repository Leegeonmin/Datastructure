import java.util.Scanner;

/**
 * Lab 001 
 * @version 1.0
 * @author 20171660 Geonmin Lee 
 */

class LabTest {
	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
		while (true){
			System.err.print("echo >>> ");
			String dat = in.next();
			if(dat.equals("quit"))
				break;
			System.out.println(dat + " !!");
		}
	}
}
