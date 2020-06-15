package Lists;

public class CircularSimpleLinkedList<T> extends ListParent {
    public NodeSimple<T> last = null;
    private int lastPosition = 0;
    /**
     * @return Tamano de la lista
     */
    public int size(){
        return this.lastPosition+1;
    }


    /**
     * @param index indice para obtener valor
     * @return valor de la casilla en el juego
     */
    @Override
    public T get(int index){
        NodeSimple<T> pointer = last.getNext ();
        int counter = 0;
        if(index > lastPosition){
            return null;
        }
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
    public void addLast(T data) {
        lastPosition++;
        if ( this.last==null ) {
            this.last = new NodeSimple<T>(data);
            last.setNext(last);
        } else {
            NodeSimple<T> addingElement = new NodeSimple<>(data);
            addingElement.setNext(last.getNext());
            last.setNext(addingElement);
            last = addingElement;
        }

    }

    /**
     * @param data
     * Agrega data en un nodo inicial en la lista
     */
    public void addFirst(T data) {
        lastPosition++;
        if ( last==null ) {
            this.last = new NodeSimple<T>(data);
            last.setNext(last);
        } else {
            NodeSimple<T> addingElement = new NodeSimple<>(data);
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
            NodeSimple<T> pointer = last;
            NodeSimple<T> tail = last;
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

