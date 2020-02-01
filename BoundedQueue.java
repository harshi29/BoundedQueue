package pxr180025;
import java.util.Scanner;



public class BoundedQueue<T>
{
	
	private T[] queue;
	private int size;
	private int front, rear;
	private int currSize;
	
	@SuppressWarnings("unchecked")
	public BoundedQueue(int size)                
	{
		queue = (T[]) new Object[size];
		this.size = size;
		front = 0;
		rear = 0;
		currSize = 0;
	}
	
	// add elements to queue
	private boolean offer(T x)                 
	{
		// return false if queue full
		if (currSize==size)
			return false;
		
		queue[rear] = x;
		
		//reset rear pointer
		if(rear == size -1) {
			rear =0;
		}else {
			rear++;
		}
		currSize++;
		return true;
		
	}
	
	//pop elements from queue
	private T poll()
	{
		//return false if queue empty
		if (isEmpty())
			return null;
		T x = queue[front];
		
		//reset front pointer
		if(front == size -1) {
			front =0;
		}else {
			front++;
		}
		currSize--;
		return x;
	}
	
	
	//peek top of queue
	private T peek()                          
	{
		if (isEmpty())
			return null;
		else
			return queue[front];
	}
	
	//return queue size
	private int size()                        
	{
		return (currSize);
	}
	
	//check if queue empty
	boolean isEmpty()                       
	{
		return (currSize==0);
	}
	
	//clears the queue
	public void clear() {   
		front = 0;
		rear = 0;
		currSize = 0;
		System.out.println("Queue is cleared");
	}
	
	//copy queue elements to the array
	@SuppressWarnings("unchecked")
	public void toArray( Object[] arr) {          
		
		if (isEmpty()){
			System.out.println("Queue is empty.");
		}
		arr = (T[]) new Object[currSize];
		
		for(int i = 0; i < currSize; i++) {
			if((front+i) < size)
				arr[i] = queue[front+i]; 
			else
				arr[i] = queue[(front+i)%size]; 
			
		}
		
		//print the array elements
		System.out.println("Elements in the array: ");
		for (int k = 0; k<currSize;k++)
			System.out.print(arr[k]+"	");
		System.out.println();
	}
	
	
	public static void main(String[] args)
	{
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter queue size");
			int size = sc.nextInt();
			BoundedQueue<Integer> q1 = new BoundedQueue<>(size);
			System.out.println("1.Offer	2.Poll	3.Peek	4.Size	5.IsEmpty  6.Clear 7.ToArray");
			whileloop:
				while(sc.hasNext()) {
					int com = sc.nextInt();
					switch(com)  {
					case 1: 
						System.out.println("Enter element to enqueue");
						if (q1.offer(sc.nextInt()))
							System.out.println("Element added to the queue");
						else
							System.out.println("Queue is full. Element not added!");
						break;
					case 2:						
						if (!q1.isEmpty()) {							
							System.out.println("Element popped: " + q1.poll());
						}
						else
							System.out.println("Queue is empty");
						break;
					case 3:
						if (!q1.isEmpty()) {
							System.out.println("Peek: " + q1.peek());
						}
						else
							System.out.println("Queue is empty");
						break;						
					case 4:
						System.out.println("Queue size: " + q1.size());
						break;
					case 5:
						System.out.println("Is queue empty: " + q1.isEmpty());
						break;
					case 6:
						q1.clear();
						break;
					case 7:
						Object[] arr = null;
						q1.toArray(arr);
						break;
					default:
						System.out.println("Invalid choice. Loop terminated.");
						break whileloop;
					}
				}

		}
		
	
	}
}