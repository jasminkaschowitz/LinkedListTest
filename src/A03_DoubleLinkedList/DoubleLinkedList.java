package A03_DoubleLinkedList;

public class DoubleLinkedList<T>
{
    private Node<T> first;
    private Node<T> last;
    private Node<T> curr;


    /**
     * Einfügen einer neuen <T>
     * @param a <T>
     */
    public void add(T a) {
    Node<T> newNode = new Node<>(a);
    if (first == null) {
        first = last = newNode;
        first.setPrevious(null);
        last.setNext(null);

    }
    else {
        last.setNext(newNode);
        newNode.setPrevious(last);
        last = newNode;
        last.setNext(null);
    }
    }

    /**
     * Internen Zeiger für next() zurücksetzen
     */
    public void reset() {
        curr = first;
    }

    /**
     * analog zur Funktion reset()
     */
    public void resetToLast() {
        curr = last;
    }

    /**
     * Liefert erste Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getFirst() {
    	if(first == null) {
            return null;
        }
        else {
            return first;
        }

    }
    
    /**
     * Liefert letzte Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getLast() {
        if(first == null) {
            return null;
        }
        else {
            return last;
        }

    }
    
    /**
     * Gibt aktuelle <T> zurück und setzt internen Zeiger weiter.
     * Falls current nicht gesetzt, wird null retourniert.
     * @return <T>|null
     */
    public T next() {
        if (curr == null) {
            return null;
        }

        T tmp = curr.getData();
        curr = curr.getNext();

    	return tmp;
    }

    /**
     * analog zur Funktion next()
     * @return <T>|null
     */
    public T previous() {

        if (curr == null) {
            return null;
        }

        T tmp = curr.getData();
        curr = curr.getPrevious();

        return tmp;
    }
    
    /**
     * Current-Pointer auf nächste <T> setzen (aber nicht auslesen).
     * Ignoriert still, dass current nicht gesetzt ist.
     */
    public void moveNext() {
        if (curr == null) {
            return;
        }
        curr = curr.getNext();

    }
    
    /**
     * Analog zur Funktion moveNext()
     */
    public void movePrevious() {
        if (curr == null) {
            return;
        }
        curr = curr.getPrevious();
    }
   
    /**
     * Retourniert aktuelle (current) <T>, ohne Zeiger zu ändern
     * @return <T>
     * @throws CurrentNotSetException
     */
    public T getCurrent() throws CurrentNotSetException {
    if (curr == null) {
        throw new CurrentNotSetException();
    }
    else {
        return curr.getData();
    }
    }

    /**
     * Gibt <T> an bestimmter Position zurück
     * @param pos Position, Nummerierung startet mit 1
     * @return <T>|null
     */
    public T get(int pos) {
        Node<T> curr;
        if(first == null) {
            return null;
        }
        else{
            curr = first;
            for (int i = 1; i < pos; i++) {
                curr = curr.getNext();

            }
        }
        return curr.getData();

    }

    /**
     * Entfernen des Elements an der angegebenen Position.
     * Falls das entfernte Element das aktuelle Element ist, wird current auf null gesetzt.
     * @param pos
     */
    public void remove(int pos) {
        if(first == null) {
            return;
        }
        Node<T> helper = first;
            for (int i = 1; i < pos; i++) {
                helper = helper.getNext(); }
                if (helper == first) {
                    first = helper.getNext();
                    first.setPrevious(null);
                }
                else if (helper == last) {
                    last = last.getPrevious();
                    last.setNext(null);
                }

                else {
                    helper.getPrevious().setNext(helper.getNext());
                    helper.getNext().setPrevious(helper.getPrevious());
                }
                if (helper == curr) {
                    curr = null;
                }


            }



    
    /**
     * Entfernt das aktuelle Element.
     * Als neues aktuelles Element wird der Nachfolger gesetzt oder
     * (falls kein Nachfolger) das vorhergehende Element 
     * @throws CurrentNotSetException
     */
    public void removeCurrent() throws CurrentNotSetException {
        if (curr == null) {
            throw new CurrentNotSetException();}


            if (curr == first) {
                first = curr.getNext();
                if (first == null) {
                    throw new CurrentNotSetException();
                }
                first.setPrevious(null);
                curr = first;
            } else if (curr == last) {
                last = curr.getPrevious();
                last.setNext(null);
                curr = last;
            } else {
                curr.getPrevious().setNext(curr.getNext());
                curr.getNext().setPrevious(curr.getPrevious());
                curr = curr.getNext();
            }
        }



    
    /**
     * Die Methode fügt die übergebene <T> nach der aktuellen (current) ein
     * und setzt dann die neu eingefügte <T> als aktuelle (current) <T>.
     * @throws CurrentNotSetException 
     */
    public void insertAfterCurrentAndMove(T a) throws CurrentNotSetException {
        Node<T> newNode = new Node<>(a);
        if (curr == null) {
            throw new CurrentNotSetException();
        }
        newNode.setNext(curr.getNext());
        curr.setNext(newNode);
            newNode.setPrevious(curr);

            curr = newNode;

        }
    }

