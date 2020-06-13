package Lists;

public class CircularDoubleLinkedList<T extends Comparable<T>> {
    public Lists.NodeDouble<T> last = null;


    /**
     * @param data
     * Agrega data en un nodo final en la lista
     */
    public void addLast(T data){
        if(last == null){
            last = new Lists.NodeDouble<T>(data);
            last.setPrevious(last);
            last.setNext(last);
        }else{
            Lists.NodeDouble<T> addingElement = new Lists.NodeDouble<T>(data);
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
        if(last==null){
            last = new Lists.NodeDouble<T>(data);
            last.setPrevious(last);
            last.setNext(last);
        }else{
            Lists.NodeDouble<T> addingElement = new Lists.NodeDouble<T>(data);
            addingElement.setPrevious(last);
            addingElement.setNext(last.getNext());
            last.setNext(addingElement);
        }
    }


    /**
     * @param value
     * Elimina el nodo al encontrar el mismo valor de datos
     */
    public void deleting(T value){
        Lists.NodeDouble<T> pointerHead = last;
        Lists.NodeDouble<T> pointerTail = last;
        while (pointerTail.getNext()!= last) {
            if ( pointerHead.getValue ().compareTo (value)==0) {
                System.out.println ("true");
                if ( pointerHead==last ) {
                    pointerHead.getPrevious ().setNext (last.getNext ());
                    pointerHead.getNext ().setPrevious (last.getPrevious ());
                    last = pointerHead.getPrevious ();
                    return;
                } else {
                    pointerTail.setNext (pointerHead.getNext ());
                    pointerHead.getNext ().setPrevious (pointerTail);
                    return;
                }
            } else {
                pointerTail = pointerHead;
                pointerHead = pointerHead.getNext ();
            }
        }
    }


    /**
     * @param e
     * @return indice de la posicion donde se encuentra el objeto.
     */
    public int find(T e) {
        Lists.NodeDouble<T> pointerHead = this.last;
        Lists.NodeDouble<T> pointerTail = this.last;
        int index = 0;
        while (pointerTail.getNext()!=last) {
            if ( pointerHead.getValue().compareTo(e)==0 ) {
                return index;
            }
            index++;
            pointerTail = pointerHead;
            pointerHead = pointerHead.getNext();
        }
        return -1;
    }

    @Override
    public String toString() {
        if(this.last==null){
            return "Empty";
        }else{
            StringBuilder returning = new StringBuilder ();
            Lists.NodeDouble<T> pointer = last;
            Lists.NodeDouble<T> tail = last;
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

