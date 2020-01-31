package pxr180025;
import java.util.Scanner;

public class BoundedQueue<T> {
	
	private int queueSize;
	private int currSize = 0;
	private int front,rear;
	private T queue[];
	
	public BoundedQueue(int size) {
		queue = (T[]) new Object[size] ;
		this.queueSize = size;
		this.front = this.rear = this.currSize = 0;
	}
	
	public boolean offer(T entry) {
		if(isFull()) {
			return false;
		}
		queue[rear] = entry;
		if(rear == queueSize -1) {
			rear =0;
		}else {
			rear++;
		}
		currSize++;
		return true;
		
	}
	
	public T poll() {
		if(isEmpty()) {
			return null;
		}
		
		T value = queue[front];
		queue[front] = null;
		if(front == queueSize -1) {
			front =0;
		}else {
			front++;
		}
		currSize--;
		return value;
	}
	
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		return queue[front];
	}
	
	public int size() {
		return currSize;
		
	}
	
	public boolean isEmpty() {
		if( currSize == 0){
			return true;
		}
		return false;
	}
	
	private boolean isFull() {
		if( currSize == queueSize){
			return true;
		}
		return false;
	}
	
	public void clear() {
		for(int i=0; i<currSize; i++) {
			queue[i] = null;
		}
		
		currSize = 0;
		front = 0;
		rear = 0;
		
	}
	
	public void toArray(T[] a) {
		if (currSize ==0){
			System.out.println("Queue is empty.");
		}
		int arrayLength = a.length;
		
		for(int i = 0; i < currSize; i++) {
			if(arrayLength > 0) {
				if((front+i) < queueSize)
					a[i] = queue[front+i]; 
				else
					a[i] = queue[(front+i)%queueSize]; 
				arrayLength--;
				
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the queue:");
		int size = sc.nextInt();
		BoundedQueue<String> bq = new BoundedQueue(size);
		int val;
		boolean condition = true;
		whileloop:
			while(condition) {
		
				System.out.println("\n1. Offer \n2. Poll\n3. Peek\n4. Size\n5. isEmpty\n6. Clear\n7. toArray\nEnter your choice: ");
				val = sc.nextInt();
				switch(val) {
		
				case 1: 
					System.out.println("Enter a string : ");
					String str = sc.next();
					if(bq.offer(str))
						System.out.println("Element added to the queue");
					else
						System.out.println("Queue is full. Element not added!");
					break;
				case 2:
					String str2 = bq.poll();
					if (str2 != null)
						System.out.println("Element popped: " + str2);
					else
						System.out.println("Queue is empty");
					break;
					
				case 3:
					String str3 = bq.peek();
					if (str3 != null)
						System.out.println("Element at top of queue: " + str3);
					else
						System.out.println("Queue is empty");
					break;
				case 4:
					System.out.println("Size of queue : " + bq.currSize);
					break;
					
				case 5:
					if(bq.isEmpty())
						System.out.println("Queue is empty");
					else
						System.out.println("Queue is not empty");
					break;
				case 6:
					bq.clear();
					System.out.println("Queue is cleared");
					break;
				
				case 7:
					System.out.println("Enter the size of the array : ");
					int s = sc.nextInt();
					
					String arr[] = new String[s];
					bq.toArray(arr);
					System.out.println("Elements in the queue : ");
					for(String x : arr) {
						System.out.print(x + "	");
					}
					break;
				default:
					condition = false;
					System.out.println("Invalid choice. Loop terminated.");
					break whileloop;		
							
		}
		
	}
	
	
	
}
}