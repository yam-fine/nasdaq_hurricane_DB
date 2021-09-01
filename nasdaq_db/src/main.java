import java.text.ParseException;

public class main {
	public static void main(String[] args) throws ParseException {
//		System.out.println("Hello world!");
		ExcelFileRader Fr = new ExcelFileRader();
		Fr.readFile("path");
	}
}
