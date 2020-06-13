package Lists;

public class DoubleLinkedList<T extends Comparable<T>> {
    public Lists.NodeDouble<T> first = null;
    public Lists.NodeDouble<T> last = null;

    public void addFirst(T data){
        if(first==null){
            first = new Lists.NodeDouble<T>(data);
            last=first;
            first.setPrevious(null);
            first.setNext(null);
        }else{
            Lists.NodeDouble<T> addingElement = new Lists.NodeDouble<T>(data);
            first.setPrevious(addingElement);
            addingElement.setNext(first);
            first = addingElement;
        }
    }

    public void addLast(T data){
        if(first==null){
            last = new Lists.NodeDouble<T>(data);
            first = last;
        }else{
            Lists.NodeDouble<T> addingElement = new Lists.NodeDouble<T>(data);
            last.setNext(addingElement);
            addingElement.setPrevious(last);
            last = addingElement;
        }
    }

    public void deleting (T data){
        Lists.NodeDouble<T> pointerHead = first;
        Lists.NodeDouble<T> pointerTail = first;

        while(pointerHead!=null){
            if(pointerHead.getValue().compareTo (data)==0){
                if(pointerHead==first){
                    first.getNext().setPrevious(null);
                    first = pointerHead.getNext();
                    return;
                }else{
                    if(pointerHead==last){
                        pointerTail.setNext(null);
                        last = pointerTail;
                    }else {
                        pointerTail.setNext(pointerHead.getNext());
                        pointerHead.getNext().setPrevious(pointerTail);
                    }
                }
            }else{
                pointerTail = pointerHead;
                pointerHead = pointerHead.getNext();
            }
        }
    }

    public int find(T e) {
        Lists.NodeDouble<T> temp = this.first;
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
            Lists.NodeDouble<T> pointer = first;
            while(pointer!=null){
                returning.append (pointer.toString ());
                returning.append (" ");
                pointer = pointer.getNext ();
            }
            return returning.toString ();
        }
    }
}

