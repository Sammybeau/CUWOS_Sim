import java.util.Random;


public class Person 
{
	private String name;
	private int walletBalance;
	private static Random r = new Random();
	private Person nextPerson;
	private Person prevPerson;
	
	public Person(String name)
	{
		this.name = name;
		this.walletBalance = Person.r.nextInt(10);
		this.nextPerson = null;
		this.prevPerson = null;
	}

	public String getName() {
		return name;
	}

	public int getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(int walletBalance) {
		this.walletBalance = walletBalance;
	}

	public Person getNextPerson() {
		return nextPerson;
	}

	public void setNextPerson(Person nextPerson) {
		this.nextPerson = nextPerson;
	}
	
	public Person getPrevPerson() {
		return prevPerson;
	}

	public void setPrevPerson(Person prevPerson) {
		this.prevPerson = prevPerson;
	}

	public void display()
	{
		System.out.println("Hi, my name is: " + this.name + " and I have: $" + this.walletBalance + " on me!");
	}
	
}
