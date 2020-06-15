package Lists;

public class DoubleLinkedList<T> extends ListParent{
    public NodeDouble<T> first = null;
    public NodeDouble<T> last = null;
    private int lastPostion = 0;




    /**
     * @param index
     * @return valor de la casilla en el juego
     */

    @Override
    public T get(int index){
        int counter = 0;
        NodeDouble<T> pointer = first;
        if(index > lastPostion){
            return null;
        }
        while (counter < index){
            pointer = pointer.getNext ();
            counter++;
        }
        return pointer.getValue ();
    }

    /**
     * @return Tamano de la lista
     */
    public int size(){
        return this.lastPostion+1;
    }

    /**
     * @param data
     * Agrega data en un nodo inicial en la lista
     */
    public void addFirst(T data){
        lastPostion++;
        if(first==null){
            first = new NodeDouble<T>(data);
            last=first;
            first.setPrevious(null);
            first.setNext(null);
        }else{
            NodeDouble<T> addingElement = new NodeDouble<>(data);
            first.setPrevious(addingElement);
            addingElement.setNext(first);
            first = addingElement;
        }
    }

    /**
     * @param data
     * Agrega data en un nodo final en la lista
     */
    public void addLast(T data){
        lastPostion++;
        if(first==null){
            last = new NodeDouble<T>(data);
            first = last;
        }else{
            NodeDouble<T> addingElement = new NodeDouble<T>(data);
            last.setNext(addingElement);
            addingElement.setPrevious(last);
            last = addingElement;
        }
    }

    @Override
    public String toString() {
        if(this.first==null){
            return "Empty";
        }else{
            StringBuilder returning = new StringBuilder ();
            NodeDouble<T> pointer = first;
            while(pointer!=null){
                returning.append (pointer.toString ());
                returning.append (" ");
                pointer = pointer.getNext ();
            }
            return returning.toString ();
        }
    }
}

