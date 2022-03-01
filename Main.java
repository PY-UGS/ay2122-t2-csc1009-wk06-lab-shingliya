import java.util.*;

public class Main
{
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args)
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for(int i = 1; i <= 11; i += 2)
		{ ll.add(i); }
		
		System.out.println("\n================================<Q1>================================\n");
		System.out.println("LinkList: " + ll + "\n");
		System.out.print("| Choose a number to add in: ");
		myFunctions.addAndSort(ll , s.nextInt());
		System.out.println("\n" + "LinkList: " + ll);
		System.out.println("\n====================================================================\n");

		
		System.out.println("================================<Q2>================================\n");
		System.out.println("LinkList: " + ll + "\n");
		System.out.print("| Pick 2 index/positions to swap: ");
		myFunctions.swapValues(ll , s.nextInt(), s.nextInt());
		System.out.println("\n" + "LinkList: " + ll);
		System.out.println("\n====================================================================\n");
		
		s.nextLine();s.nextLine();
		System.out.println("================================<Q3>================================\n");
		System.out.println("Generating 500 random integers in a LinkList\n");

		ll.clear();
		Random random = new Random(System.currentTimeMillis());
		for(int i = 0; i < 500; i++)
		{ ll.add(random.nextInt(8999) + 1000); }

		System.out.println("Generating 1 random integer\n");
		random.setSeed(ll.getLast());
		int lucky = random.nextInt(8999) + 1000;

		System.out.println("| Calling findValue function with value of random int " + lucky + " |");
		
		System.out.println("\nValue was found at index: " + myFunctions.findValue(ll, lucky));
		System.out.println("\n====================================================================\n");

		s.nextLine();
		System.out.println("===============================<Q4-5>===============================\n");
		System.out.println("Cannot make it as HashTables does not have an order");
		System.out.println("\n====================================================================\n");
		
		s.nextLine();
		System.out.println("================================<Q6>================================\n");
		System.out.println("Generating 500 random integers in a HashTable\n");
		
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		random.setSeed(System.currentTimeMillis());
		for(int i = 0; i < 500; i++)
		{ ht.put(i, random.nextInt(8999) + 1000); }

		System.out.println("Generating 1 random integer\n");
		random.setSeed(ht.get(0));
		lucky = random.nextInt(8999) + 1000;

		System.out.println("| Calling findValue function with value of random int " + lucky + " |");
		
		System.out.println("\nValue was found at index: " + myFunctions.findValue(ht, lucky));
		System.out.println("\n====================================================================\n");
	}
}

class myFunctions
{
	public static void addAndSort(LinkedList<Integer> list, int value)
	{
		int n = list.size();
		for(int i = 0; i < n; ++i)
		{
			if(value < list.get(i))
			{
				list.add(i, value);
				return;
			}
		}
		list.add(value);
	}

	public static void swapValues (LinkedList<Integer> list, int indexOne, int indexTwo)
	{
		int a, b;
		try
		{
			a = list.get(indexOne);
			b = list.get(indexTwo);
			
			list.remove(indexOne);
			list.add(indexOne, b);
			
			list.remove(indexTwo);
			list.add(indexTwo, a);
		}
		catch (Exception e)
		{
			System.out.println("<!!! Somthing went wrong with the swap !!!>");
		}
	}
	
	public static int findValue (LinkedList<Integer> list, int searchVal)
	{
		return list.indexOf(searchVal);
	}

	public static int findValue (Hashtable<Integer, Integer> hash, int searchVal)
	{
		Enumeration<Integer> e = hash.keys();
		while(e.hasMoreElements())
		{
			int key = e.nextElement();
			if(hash.get(key) == searchVal)
				return key;
		}
		return -1;
	}
}