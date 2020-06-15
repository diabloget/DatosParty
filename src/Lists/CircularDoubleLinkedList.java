package Lists;

public class CircularDoubleLinkedList<T> extends ListParent{
    public NodeDouble<T> last = null;
    private int lastPosition = 0;

    /**
     * @return Tamano de la lista
     */
    @Override
    public int size(){
        return this.lastPosition+1;
    }

    /**
     * @param index
     * @return valor de la casilla en el juego
     */

    @Override
    public T get(int index){
        NodeDouble<T> pointer = last.getNext ();
        if(index > lastPosition){
            return null;
        }
        int counter = 0;
        while(counter < index){
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
        if(last == null){
            last = new NodeDouble<>(data);
            last.setPrevious(last);
            last.setNext(last);
        }else{
            NodeDouble<T> addingElement = new NodeDouble<>(data);
            addingElement.setPrevious(last);
            addingElement.setNext(last.getNext());
            last.setNext(addingElement);
            last = addingElement;
        }
    }

    /**
     * @param data
     * Agrega data en un nodo inicial en la lista
     */
    public void addFirst(T data){
        lastPosition++;
        if(last==null){
            last = new NodeDouble<>(data);
            last.setPrevious(last);
            last.setNext(last);
        }else{
            NodeDouble<T> addingElement = new NodeDouble<>(data);
            addingElement.setPrevious(last);
            addingElement.setNext(last.getNext());
            last.setNext(addingElement);
        }
    }



    @Override
    public String toString() {
        if(this.last==null){
            return "Empty";
        }else{
            StringBuilder returning = new StringBuilder ();
            NodeDouble<T> pointer = last;
            NodeDouble<T> tail = last;
            while(tail.getNext ()!=last){
                returning.append (pointer.toString ());
                returning.append (" ");
                tail = pointer;
                pointer = pointer.getNext ();
            }
            return returning.toString ();
        }

    }

}

