package Lists;

public class CircularSimpleLinkedList<T extends Comparable<T>> {
    private NodeSimple<T> last = null;

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
        NodeSimple<T> pointerHead = this.last;
        NodeSimple<T> pointerTail = this.last;

        while (pointerTail.getNext()!= last) {
            if ( pointerHead.getValue().equals(data) ) {
                if ( pointerHead==last ) {
                    last = pointerTail;
                }
                pointerTail.setNext(pointerHead.getNext());
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


}

