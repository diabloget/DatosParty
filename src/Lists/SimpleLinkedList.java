package Lists;

public class SimpleLinkedList<T extends Comparable<T>> {
    NodeSimple<T> first = null;
    NodeSimple<T> last = null;

    public void addLast(T data){
        if(first == null){
            first = new NodeSimple<T> (data);
            first = last;
        }else{
            NodeSimple<T> addingElement = new NodeSimple<> (data);
            last.setNext (addingElement);
            last = addingElement;
        }
    }

    public void addFirst(T data){
        if(first == null){
            first = new NodeSimple<T> (data);
            first = last;
        }else{
            NodeSimple<T> addingElement = new NodeSimple<> (data);
            addingElement.setNext (first);
            first = addingElement;
        }
    }

    public void deleting(T data){
        NodeSimple<T> pointerHead = first;
        NodeSimple<T> pointerTail = first;
        while (pointerHead!=null){
            if(pointerHead.getValue ().equals (data)){
                if(pointerHead==first){
                    first = pointerHead.getNext ();
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
}
