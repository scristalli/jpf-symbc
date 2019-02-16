package chains;

//import gov.nasa.jpf.symbc.Debug;
import java.lang.reflect.Method;
import java.util.PriorityQueue;
import java.lang.reflect.Field;
import java.util.Comparator;

public class Chain {
	
    public void driver(Object[] queue, int size, Comparator<Object> comparator, int modCount, A a) throws Exception {

	if(a != null) {
	PriorityQueue<Object> priorityQueue = new PriorityQueue<Object>();
	
	Field f_queue = priorityQueue.getClass().getDeclaredField("queue");
	f_queue.setAccessible(true);
	f_queue.set(priorityQueue, queue);

	Field f_size = priorityQueue.getClass().getDeclaredField("size");
	f_size.setAccessible(true);
	f_size.set(priorityQueue, size);

	Field f_comparator = priorityQueue.getClass().getDeclaredField("comparator");
	f_comparator.setAccessible(true);
	f_comparator.set(priorityQueue, comparator);

	Field f_modCount = priorityQueue.getClass().getDeclaredField("modCount");
	f_modCount.setAccessible(true);
	f_modCount.set(priorityQueue, modCount);

	Method method = priorityQueue.getClass().getDeclaredMethod("heapify");
	method.setAccessible(true);
	method.invoke(priorityQueue);
	}
    }

    // The test driver
    public static void main(String[] args) throws Exception {

	System.setProperty("java.library.path", "/home/sc/progetti/jpf/jpf-symbc/lib");
        System.out.println("BEGIN\n");

	Object[] queue = null;
	int size = 0;
	Comparator<Object> comparator = null;
	int modCount = 0;

        Chain mc = new Chain();
        mc.driver(queue, size, comparator, modCount, null);

	//Debug.printPC("MyClass1.myMethod Path Condition: ");
        System.out.println("\nEND");
    }
	
}

