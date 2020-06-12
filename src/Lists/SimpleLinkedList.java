package Lists;

public class SimpleLinkedList<T extends Comparable<T>> {
    public NodeSimple<T> first = null;
    public NodeSimple<T> last = null;

    /**
     * @param data
     * Agrega data en un nodo final en la lista
     */
    public void addLast(T data){
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
        if(first == null){
            first = new NodeSimple<T> (data);
            last = first;
        }else{
            NodeSimple<T> addingElement = new NodeSimple<> (data);
            addingElement.setNext (first);
            first = addingElement;
        }
    }

    /**
     * @param data
     * Elimina el nodo al encontrar el mismo valor de datos
     */
    public void deleting(T data){
        NodeSimple<T> pointerHead = first;
        NodeSimple<T> pointerTail = first;
        while (pointerHead!=null){
            if(pointerHead.getValue().compareTo (data)==0){
                if(pointerHead==first){
                    first = pointerHead.getNext ();
                    return;
                }else{
                    if(pointerHead==last){
                        last = pointerTail;
                    }
                    pointerTail.setNext (pointerHead.getNext ());
                }
            }
            pointerTail = pointerHead;
            pointerHead = pointerHead.getNext ();
        }
    }

    /**
     * @param e
     * @return indice de la posicion donde se encuentra el objeto.
     */
    public int find(T e) {
        NodeSimple<T> temp = this.first;
        int index = 0;
        while (temp!=null) {
            if ( temp.getValue().compareTo(e)==0 ) {
                return index;
            }
            index++;
            temp = temp.getNext();
        }
        return -1;
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
