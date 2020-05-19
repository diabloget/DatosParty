package Lists;

public class CircularDoubleLinkedList<T extends Comparable<T>> {
    public NodeDouble<T> last = null;

    public void addLast(T data){
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

    public void addFirst(T data){
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

    public void deleting(T value){
        NodeDouble<T> pointerHead = last;
        NodeDouble<T> pointerTail = last;
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

    public int find(T e) {
        NodeDouble<T> pointerHead = this.last;
        NodeDouble<T> pointerTail = this.last;
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

