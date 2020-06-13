package Lists;

public class NodeSimple<T extends Comparable<T>> {
    private T value;
    private NodeSimple<T> next;

    public NodeSimple(T value) {
        this.value = value;
        this.next = null;
    }


    public T getValue(){
        return this.value;
    }

    public void setData(T value){
        this.value=value;
    }

    public void setNext(NodeSimple<T> next){
        this.next=next;
    }

    public NodeSimple<T> getNext(){
        return this.next;
    }

    @Override
    public String toString() {
        return value.toString ();
    }
}