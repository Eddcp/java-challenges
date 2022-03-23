package exercises.codesignalcontainer;

/**
 * A container of integers that should support
 * addition, removal, and search for the median integer
 */
public interface Container {

    /**
     * Adds the specified value to the container
     *
     * @param value
     */
    void add(int value);

    /**
     * Attempts to delete one item of the specified value from the container
     *
     * @param value
     * @return true, if the value has been deleted, or
     * false, otherwise.
     */
    boolean delete(int value);

    /**
     * Finds the container's median integer value, which is
     * the middle integer when the all integers are sorted in order. If the sorted
     * array has an even length, the leftmost integer between the two middle
     * integers should be considered as the median.
     *
     * @return the median if the array is not empty, or
     * @throws a runtime exception, otherwise.
     */
    int getMedian();
}