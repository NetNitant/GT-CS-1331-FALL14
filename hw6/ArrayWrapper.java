import java.util.NoSuchElementException;

/**
 * A wrapper for an array that's more like a collection.
 *
 * @author Nitant Dandekar
 * @version 1
 */
public class ArrayWrapper<T> implements SimpleCollection<T> {
    private static final int DEFAULT_SIZE = 5;
    private T[] array;
    private int size;
    private int capacity;

    /**
     * Creates a new ArrayWrapper.
     */
    public ArrayWrapper() {
        array = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
        capacity = 5;
    }

    /**
     * Adds an element into the collection.
     * If the new element would exceed the size of the backing array,
     * instead resize the array, doubling it in size and copy over the
     * old elements.
     *
     * @param elem The element being added.
     */
    public void add(T elem) {
        if (size >= capacity) {
            T[] newArray = (T[]) new Object[capacity * 2];

            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
            capacity *= 2;
        }

        array[size] = elem;
        size++;
    }

    /**
     * Adds all elements in elems to the collection.
     * Hint: can this be implemented in terms of add(T elem)?
     *
     * @param elems Array of elements to be added.
     */
    public void addAll(T[] elems) {
        for (int i = 0; i < elems.length; i++) {
            add(elems[i]);
        }
    }

    /**
     * Remove elem from the collection. Removing an element
     * should shift all the elements behind it forward, ensuring
     * that the backing array is contiguous. For example:
     *
     * Collection = ["hi", "hello", "wsup", "hey", null]
     * Collection after remove("hello") = ["hi", "wsup", "hey", null, null]
     *
     * @param elem Element to be removed.
     * @return true if the element was removed,
     *         false if it was not in the collection.
     */
    public boolean remove(T elem) {
        boolean removed = false;

        for (int i = 0; i < size; i++) {
            if (!removed) {
                if (elem.equals(array[i])) {
                    array[i] = null;
                    removed = true;
                }
            } else {
                array[i - 1] = array[i];
            }
        }

        if (removed) {
            size--;
        }

        return removed;
    }

    /**
     * Removes each element in elems from the collection.
     * Hint: can this be implemented in terms of remove(T elem)?
     *
     * @param elems Array of elements to be removed.
     * @return true if any elements were removed,
     *         false if no elements were removed.
     */
    public boolean removeAll(T[] elems) {
        boolean removedElements = false;

        for (int i = 0; i < elems.length; i++) {
            boolean currentlyRemoving = true;

            while (currentlyRemoving) {
                currentlyRemoving = remove(elems[i]);

                if (currentlyRemoving) {
                    removedElements = true;
                }
            }
        }

        return removedElements;
    }

    /**
     * Checks to see if the collection contains a given element.
     *
     * @param elem The element we are checking for.
     * @return true if the collection contains elem, false otherwise.
     */
    public boolean contains(T elem) {
        for (int i = 0; i < size; i++) {
            if (elem.equals(array[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * Gets an element from the collection, using its 0-based index.
     * If the index is within our backing array but more than our last
     * element, rather than returning null, this should throw
     * a java.util.NoSuchElementException.
     *
     * @param index The index of the element we want.
     * @return The element at the specified index.
     */
    public T get(int index) {
        if (index >= size) {
            throw new NoSuchElementException("element " + index + " does not "
                + "exist within the array");
        }

        return array[index];
    }

    /**
     * Returns the current number of elements in the collection.
     *
     * @return The size of the collection.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the current capacity of the collection - namely, the
     * size of its backing array.
     *
     * @return The total capacity of the collection.
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Clears the collection, resetting size and starting from a fresh
     * backing array of size 5.
     */
    public void clear() {
        array = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
        capacity = 5;
    }

    /**
     * Tests if the collection is empty, i.e. it contains no elements.
     *
     * @return true if the collection has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * While having toString be defined in the interface doesn't force you
     * to override the method in the implementing class, the format we
     * expect the toString() is as follows:
     *
     * [element1, element2, element3, ..., elementN]
     *
     * The end of the list should not contain any nulls, even if the
     * backing array is larger than the number of elements.
     *
     * @return [element1, element2, element3, ..., elementN]

     */
    public String toString() {
        String arrayString = "[";

        for (int i = 0; i < size; i++) {
            if (i > 0) {
                arrayString += ", ";
            }

            arrayString += array[i];
        }

        arrayString += "]";

        return arrayString;
    }
}
