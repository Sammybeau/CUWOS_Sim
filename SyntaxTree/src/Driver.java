public class Driver 
{
	public static void main(String[] args)
	{
		Parser p = new Parser("     a =  (a * b )- c;");
		Parser p2 = new Parser("     a = b - c;");
		Parser p4 = new Parser("     a = a * (b - c );  ");
		Parser p3 = new Parser("     a =  (w - (t+ (a * b )))- c;");

		p3.parse();
	}
}