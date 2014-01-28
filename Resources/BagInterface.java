/**
 *  An interface that describes the operations of a bag of objects.
 *  @author Frank M. Carrano
 *  @author Naomi Robert
 */
public interface BagInterface<T> {
    /**
     * Gets the current number of entries in this bag.
     *
     * @return the integer number of entries currently in the bag
     */
    public int getCurrentSize();

    /**
     * Sees whether this bag is empty.
     *
     * @return true if the bag is empty, or false if not 
     */
    public boolean isEmpty();

    /**
     * Adds a new entry to this bag.
     * If the new entry is null it should not be added.
     *
     * @param newEntry  the object to be added as a new entry
     * @return true if the addition is successful, or false if not 
     */
    public boolean add(T newEntry);

    /**
     * Removes one unspecified entry from this bag, if possible.
     * Entry must be randomly chosen. (NOTE: the book's code
     * in the ArrayBag implementation did not chose randomly. 
     * This method must choose the entry randomly.)
     *
     * @return the removed entry if the removal was successful, or null otherwise
     */
    public T remove();

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry  the entry to be removed
     * @return true if the removal was successful, or false otherwise
     */
    public boolean remove(T anEntry);

    /**
     * Removes all entries from this bag.
     */
    public void clear();

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry  the entry to be counted
     * @return the number of times anEntry appears in the bag 
     */
    public int getFrequencyOf(T anEntry);

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry  the entry to locate
     * @return true if this bag contains anEntry, or false otherwise 
     */
    public boolean contains(T anEntry);

    /**
     * Creates an array of all entries that are in this bag.
     * It does not destroy or alter the bag in any way.
     * If the bag is actually empty, this will still create an
     * array, but it will have length 0.
     *
     * @return a newly allocated array of all the entries in the bag 
     */
    public T[] toArray();
}
