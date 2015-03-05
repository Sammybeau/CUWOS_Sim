public class Disc extends Object
{
	private int size;
	private Disc nextDisc;
	
	public Disc(int size)
	{
		this.size = size;
		this.nextDisc = null;		
	}

	public int getSize() 
	{
		return size;
	}
	//toString DOES NOT NEED TO BE HERE
	//it is already included in 'invisible ink'
	public String toString()
	{
		//return super.toString();
		return "" + this.size + " (" + super.toString() + ")"; //size followed by memory address
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}

	public Disc getNextDisc()
	{
		return nextDisc;
	}

	public void setNextDisc(Disc nextDisc)
	{
		this.nextDisc = nextDisc;
	}
}