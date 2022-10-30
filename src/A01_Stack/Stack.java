package A01_Stack;


public class Stack<T>
{
	 private Node<T> first;
     int counter = 0;
    /**
     * Oberstes Element entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws StackEmptyException 
     */
    public T pop() throws StackEmptyException {
        if (counter <= 0) {
            throw new StackEmptyException();
        }
        T top = first.getData();
        first = first.getNext();
        counter = getCount() - 1;
    	return top;
    }
    
    /**
     * Übergebenen T auf Stack (als oberstes Element) speichern.
     * @param i data
     */
    public void push(T i) {
        Node<T> newNode = new Node<>(i);
        newNode.setNext(first);
        first = newNode;
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
