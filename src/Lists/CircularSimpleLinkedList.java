package Lists;

public class CircularSimpleLinkedList<T extends Comparable<T>> {
    public NodeSimple<T> last = null;

    public void addLast(T data) {
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

    public void addFirst(T data) {
        if ( last==null ) {
            this.last = new NodeSimple<T>(data);
            last.setNext(last);
        } else {
            NodeSimple<T> addingElement = new NodeSimple<>(data);
            addingElement.setNext(last.getNext());
            last.setNext(addingElement);
        }
    }

    public void deleting(T data) {
        NodeSimple<T> pointerHead = this.last.getNext ();
        NodeSimple<T> pointerTail = this.last.getNext ();

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

    public int find(T e) {
        NodeSimple<T> pointerHead = this.last;
        NodeSimple<T> pointerTail = this.last;
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
