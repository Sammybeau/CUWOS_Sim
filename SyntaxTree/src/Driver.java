public class Driver 
{
	public static void main(String[] args)
	{
		Parser p = new Parser("a   =   5 ;     apple =     (a *   7) - 3;");
		p.parse();
		VarDefStatement vds = p.getTheSyntaxTree();
		System.out.println(vds);
		VarDefStatement vds2 = p.getSecondSyntaxTree();	
		System.out.println(vds2);
	}
}