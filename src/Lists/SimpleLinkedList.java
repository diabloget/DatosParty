package Lists;

public class SimpleLinkedList<T> extends ListParent{
    private int lastPosition = 0;
    public NodeSimple<T> first = null;
    public NodeSimple<T> last = null;

    /**
     * @param index
     * @return valor de la casilla en el juego
     */
    @Override
    public T get(int index){
        int counter = 0;
        NodeSimple<T> pointer = first;
        if(index > lastPosition){
            return null;
        }
        while (counter < index){
            pointer = pointer.getNext ();
            counter++;
        }
        return pointer.getValue ();
    }
    /**
     * @param data
     * Agrega data en un nodo final en la lista
     */
    public void addLast(T data){
        lastPosition++;
        if(first == null){
            first = new NodeSimple<T> (data);
            last = first;
        }else{
            NodeSimple<T> addingElement = new NodeSimple<> (data);
            last.setNext (addingElement);
            last = addingElement;
        }
    }

    /**
     * @param data
     * Agrega data en un nodo inicial en la lista
     */
    public void addFirst(T data){
        lastPosition++;
        if(first == null){
            first = new NodeSimple<T> (data);
            last = first;
        }else{
            NodeSimple<T> addingElement = new NodeSimple<> (data);
            addingElement.setNext (first);
            first = addingElement;
        }
    }




    @Override
    public String toString() {
        if(this.first==null){
            return "Empty";
        }else{
            StringBuilder returning = new StringBuilder ();
            NodeSimple<T> pointer = first;
            while(pointer!=null){
                returning.append (pointer.toString ());
                returning.append (" ");
                pointer = pointer.getNext ();
            }
            return returning.toString ();
        }
    }
}
