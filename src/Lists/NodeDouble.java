

package Lists;

public class NodeDouble<T extends Comparable<T>> {
    private T value;
    private NodeDouble<T> next;
    private NodeDouble<T> previous;

    public NodeDouble(T value) {
        this.value = value;
        this.next = null;
    }

    public NodeDouble(T value, NodeDouble<T> next){
        this.value=value;
        this.next=next;
    }

    public T getValue(){
        return this.value;
    }

    public void setData(T value){
        this.value=value;
    }

    public void setNext(NodeDouble<T> next){
        this.next=next;
    }

    public void setPrevious(NodeDouble<T> previous){
        this.previous=previous;
    }

    public NodeDouble<T> getNext(){
        return this.next;
    }

    public NodeDouble<T> getPrevious(){
        return this.previous;
    }


}
