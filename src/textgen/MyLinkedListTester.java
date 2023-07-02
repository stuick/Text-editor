/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		assertEquals("Remove: check if the head is pointing to the node", list1.get(0),list1.head.next.data);
		assertEquals("Remove: check if the head is pointing to the node", list1.head.next.prev,list1.head);
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		int a = 10;
		boolean tryEmpty = emptyList.add(a);
		boolean tryList1 = list1.add(a);
		try{
			boolean b = list1.add(null);
			fail("Null should not pass the test");
		}catch (NullPointerException e) {
		}
		
		assertEquals("AddEnd: Adding to an Empty List", true,tryEmpty);
		assertEquals("AddEnd: Adding to a non empty List", true,tryList1);
		assertEquals("AddEnd: Head point to the Added Element of the empty List", emptyList.head.next.data,(Integer)10);
		assertEquals("AddEnd: Tail point to the Added Element of the non empty List", list1.tail.prev.data,(Integer)10);
		assertEquals("AddEnd: Size of list increase by 1", (Integer)list1.size,(Integer)4);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		int a = list1.remove(0);
		
		assertEquals("Size: check size is correct ", 2, list1.size());
		assertEquals("Size: check size is correct ", 2, shortList.size());
		assertEquals("Size: check size is correct ", 0, emptyList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		int a = 10;
		emptyList.add(0,a);
		list1.add(1,a);
		list1.add(3,22);
		
		try {
			list1.add(6,100);
			fail("Check Index");
		}catch (IndexOutOfBoundsException e) {
		}
		try{
			list1.add(0,null);
			fail("Null should not pass the test");
		}catch (NullPointerException e) {
		}
		
		try {
			emptyList.add(5,12);
			fail("index greater than size of list");
		}catch (IndexOutOfBoundsException e) {
		}
		
		assertEquals("Add: Adding to an Empty List", (Integer)10,emptyList.get(0));
		assertEquals("Add: Adding to a non empty List", (Integer)a,list1.get(1));
		assertEquals("Add: Head point to the Added Element of the empty List", emptyList.head.next.data,(Integer)10);
		assertEquals("Add: Tail point to the Added Element of the non empty List", list1.tail.prev.data,(Integer)42);
		assertEquals("Add: Size of list increase by 1", (Integer)list1.size,(Integer)5);
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
	    int a = 1;
	    int b = 11;
	    int c = 111;
	    
	    try {
	    	int x = emptyList.set(0, a);
	    	fail("Can't edit empty list");
	    }catch (IndexOutOfBoundsException e) {
	    }
	    
	    try {
	    	int x = list1.set(3, a);
	    	fail("index invalid ");
	    }catch (IndexOutOfBoundsException e) {
	    }
	    
	    try {
	    	int x = list1.set(2, null);
	    	fail("Can't add null");
	    }catch(NullPointerException e) {	    	
	    }
	    
	    int x = list1.set(0, a);
	    int y = list1.set(1, b);
	    int z = list1.set(2, c);
	    
	    assertEquals("Set: Editing First element", (Integer)1,list1.get(0));
		assertEquals("Set: Editing First element", (Integer)111,list1.get(list1.size()-1));
		assertEquals("Set: Checking size", (Integer)3,(Integer)list1.size());
		
		System.out.println(list1);
	}
	
	
	// TODO: Optionally add more test methods.
	
}
