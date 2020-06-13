package Lists;

public class CircularSimpleLinkedList<T extends Comparable<T>> {
    public Lists.NodeSimple<T> last = null;

    /**
     * @param data
     * Agrega data en un nodo final en la lista
     */
    public void addLast(T data) {
        if ( this.last==null ) {
            this.last = new Lists.NodeSimple<T>(data);
            last.setNext(last);
        } else {
            Lists.NodeSimple<T> addingElement = new Lists.NodeSimple<T>(data);
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
        if ( last==null ) {
            this.last = new Lists.NodeSimple<T>(data);
            last.setNext(last);
        } else {
            Lists.NodeSimple<T> addingElement = new Lists.NodeSimple<T>(data);
            addingElement.setNext(last.getNext());
            last.setNext(addingElement);
        }
    }

    /**
     * @param data
     * Elimina el nodo al encontrar el mismo valor de datos
     */
    public void deleting(T data) {
        Lists.NodeSimple<T> pointerHead = this.last.getNext ();
        Lists.NodeSimple<T> pointerTail = this.last.getNext ();

        while (pointerTail!= last) {
            if ( pointerHead.getValue().compareTo (data)==0 ) {
                System.out.println ("true");
                if ( pointerHead==last ) {
                    last = pointerTail;
                }
                pointerTail.setNext(pointerHead.getNext());
                return;
            } else {
                pointerTail = pointerHead;
                pointerHead = pointerHead.getNext();
            }

        }

    }

    /**
     * @param e
     * @return indice de la posicion donde se encuentra el objeto.
     */
    public int find(T e) {
        Lists.NodeSimple<T> pointerHead = this.last;
        Lists.NodeSimple<T> pointerTail = this.last;
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
            Lists.NodeSimple<T> pointer = last;
            Lists.NodeSimple<T> tail = last;
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

