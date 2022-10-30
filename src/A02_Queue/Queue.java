package A02_Queue;

public class Queue<T>
{
    private Node<T> first;
    
    private Node<T> last;
    private int counter = 0;
    /**
     * Das vorderste (=erste) Element aus der Queue entfernen und zur�ckliefern.
     * Existiert kein Element, wird eine Exception ausgel�st.
     * @throws QueueEmptyException 
     */
    public T dequeue() throws QueueEmptyException {
        if (first == null) {
            throw new QueueEmptyException();
        }
        T data = first.getData();
        first = first.getNext();
        counter = getCount() - 1;
    	return data;
    }
    
    
    
    /**
     * �bergebenen Integer am Ende der Queue anh�ngen.
     * @param i Zahl
     */
    public void enqueue(T i) {
    Node<T> newNode = new Node<>(i);
    if (first == null) {
        first = last = newNode;
    }
    else {
        last.setNext(newNode);
        last = newNode;
    }

    counter = getCount() + 1;


    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return counter;
    }
}
