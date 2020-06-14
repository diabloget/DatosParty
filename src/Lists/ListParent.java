package Lists;

public class ListParent<T> {
    public NodeSimple<T> reference;
    public NodeDouble<T> referenceDouble;

    public T get(int index){
        return reference.getValue ();
    }
}
