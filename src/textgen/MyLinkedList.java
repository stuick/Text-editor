package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>();
		tail = new LLNode<E>();
		head.next = tail;
		tail.prev = head;
		size = 0;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Cannot Add null") ;
		}
		if(size == 0) {
			LLNode<E> newNode = new LLNode<E>(element);
			head.next = newNode;
			newNode.prev = head;
			tail.prev = newNode;
			newNode.next = tail;
			size = 1;
			return true;
		}
		if(size>0) {
			LLNode<E> newNode = new LLNode<E>(element, tail.prev);
			newNode.next = tail;
			tail.prev = newNode;
			size++;
			return true;
		}
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(size == 0 || (index>size-1) || index<0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> node = new LLNode<E>();
		node = head.next;
		for(int i=0; i<size;i++) {
			if(i == index) {
				return node.data;
			}
			node = node.next;
		}
		
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Cannot Add null value") ;
		}
		if(index<0 ) {
			throw new IndexOutOfBoundsException("Check your index");
		}
		if(size == 0) {
			if(index == 0) {
				LLNode<E> newNode = new LLNode<E>(element);
				head.next = newNode;
				newNode.prev = head;
				tail.prev = newNode;
				newNode.next = tail;
				size = 1;
				return;
			}
			throw new IndexOutOfBoundsException("Check your index");
		}
		if(index>=size) {
			throw new IndexOutOfBoundsException("Check your index");
		}
		LLNode<E> current = new LLNode<E>();
		current = head.next;
		LLNode<E> node = new LLNode<E>(element);
		for(int i=0;i<size;i++) {
			if(i==index) {
				node.next = current;
				node.prev = current.prev;
				current.prev.next = node;
				current.prev=node;
				size++;
				return;		
			}
			current = current.next;				
		}		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(size == 0 || (index>size-1) || index<0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> node = new LLNode<E>();
		node = head.next;
		for(int i=0; i<size;i++) {
			if(i == index) {
				node.prev.next = node.next;
				node.next.prev = node.prev;
				size--;
				return node.data;
			}
			node = node.next;
		}
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Cannot Add null value") ;
		}
		if(index<0 || size == 0 || index>=size) {
			throw new IndexOutOfBoundsException("Check your index");
		}
		E old = null;
		LLNode<E> current = new LLNode<E>();
		current = head.next;
		for(int i=0;i<size;i++) {
			if(i==index) {
				old = current.data;
				current.data = element;
				return old;		
			}
			current = current.next;				
		}
		return null;
	}   
	
	public String toString() {
		if(size <= 0) {
			return null;
		}else {
			String result="";
			LLNode<E> current = head.next;
			for(int i=0;i<size;i++) {
				result = result +  String.valueOf(current.data) + ", ";
				current = current.next;
			}
			return result;
		}
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode(E e, LLNode<E> prevNode) {
		this.data = e;
		prevNode.next = this;
		this.prev = prevNode;
		this.next = null;
	}
	
	public LLNode() {
		this.data = null;
		this.next = null;
		this.prev = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
