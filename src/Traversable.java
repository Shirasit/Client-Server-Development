import java.util.Collection;

/**
 * This interface defines the functionality required for a traversable graph
 */
public interface Traversable<T> {
    public Node<T> getOrigin();

    public Node<T> getEnd();

    public Collection<Node<T>> getReachableNodes(Node<T> someNode);

    public Collection<Node<T>> getNeighborsNoCross(Node<T> someNode);

    public int getValueN(T someNode);

    void SetStartIndex(Index index);
}