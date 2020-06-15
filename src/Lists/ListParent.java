package Lists;

public class ListParent<T> {
    private int lastPosition;
    public NodeSimple<T> reference;
    public NodeDouble<T> referenceDouble;

    public T get(int index){
        return reference.getValue ();
    }


    public int size(){
        return this.lastPosition+1;
    }
}
