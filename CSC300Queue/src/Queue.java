public class Queue
{
	private Person headPerson;
	private Person tailPerson;
	private int count;
	
	public Queue()
	{
		this.headPerson = null;
		this.tailPerson = null;
		this.count = 0;
	}

	public void enqueue(Person p)
	{		
		Person currPerson = p;
		if(this.headPerson == null)
		{
			this.headPerson = currPerson;
			this.tailPerson = currPerson;
		}
		else
		{
			this.tailPerson.setNextPerson(currPerson);
			currPerson.setPrevPerson(this.tailPerson);
			this.tailPerson = currPerson;			
		}
		this.count++;
	}
	
	public Person dequeue() throws Exception
	{
		if (headPerson == null)
		{
			throw new Exception("Can Not Dequeue: Empty Queue");
		}
		else if(this.count == 1)
		{
			Person currPerson = headPerson;
			this.headPerson = null;
			this.tailPerson = null;
			this.count--;
			return currPerson;
		}
		else
		{
			Person currPerson = headPerson;
			currPerson.getNextPerson().setPrevPerson(null);
			headPerson = currPerson.getNextPerson();
			currPerson.setNextPerson(null);
			this.count--;
			return currPerson;
		}
	}

}