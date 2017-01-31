/** 
* @author Alejandro Parana
* Various sorting algorithms from Weiss' book
*/
public class Sorting {
    /** ********** INSERTION SORT*********
     * Simple insertion sort. Fig. 7.2 
     * @param a an array of Comparable items.
     */
    public static<AnyType extends Comparable<?super AnyType>>
    void insertionSort(AnyType [] a) {
        int j;
        for(int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            for(j = p; j > 0 &&
             tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }
    /** *********** SHELL SORT #1**********
     * Shellsort, using Shell's increments. Fig. 7.4
     * @param a an array of Comparable items.
     */
    public static<AnyType extends Comparable<?super AnyType>>
    void shellsort1(AnyType[] a) {
        int j;
        for(int gap = a.length / 2; gap > 0; gap /= 2)
            for(int i = gap; i < a.length; i++) {
                AnyType tmp = a[i];
                for(j = i; j >= gap &&
                 tmp.compareTo(a[j-gap]) < 0; j -= gap)
                    a[j] = a[j-gap];
                a[j] = tmp;
            }
    }
    /** *********** SHELL SORT #2**********
    * Shellsort, using Knuths's increments. 
    * @param a an array of Comparable items.
    */
    public static<AnyType extends Comparable<?super AnyType>> 
    void shellsort2(AnyType[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3)
            h = 3 * h + 1;
        while(h >= 1){
            for(int i = h; i < N; i++)
                for(int j = i; j >= h 
                	&& a[j].compareTo(a[j-h]) < 0; j-=h){
                    AnyType temp = a[j-h];
                    a[j-h] = a[j];
                    a[j] = temp;
                }
            h /= 3;
        }
    }
    /** *********** QUICK SORT************
     * Quicksort median-of-three.  Fig. 7.13
     * @param a an array of Comparable items.
     */
    public static<AnyType extends Comparable<?super AnyType>>
    void quicksort(AnyType[] a) {
        quicksort(a, 0, a.length - 1);
    }
    private static final int CUTOFF = 3;
    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static <AnyType> void 
    swapReferences(AnyType[] a, int index1, int index2){
        AnyType tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private static<AnyType extends Comparable<?super AnyType>>
    AnyType median3(AnyType[] a, int left, int right){
        int center = (left + right) / 2;
        if(a[center].compareTo(a[left]) < 0 )
            swapReferences(a, left, center);
        if(a[right].compareTo(a[left]) < 0 )
            swapReferences(a, left, right);
        if(a[right].compareTo(a[center]) < 0 )
            swapReferences( a, center, right );
            // Place pivot at position right - 1
        swapReferences(a, center, right-1);
        return a[right-1];
    }
    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static<AnyType extends Comparable<?super AnyType>>
    void quicksort(AnyType[] a, int left, int right){
        if(left + CUTOFF <= right){
            AnyType pivot = median3(a, left, right);
                // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; ){
                while(a[++i].compareTo(pivot) < 0) { }
                while(a[--j].compareTo(pivot) > 0) { }
                if(i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }
            swapReferences(a, i, right - 1);// Restore pivot

            quicksort(a, left, i - 1); // Sort small element
            quicksort(a, i + 1, right); // Sort large element
        }
        else  // Do an insertion sort on the subarray
            insertionSort(a, left, right);
    }
    /**
     * Internal insertion sort routine for subarrays
     * that is used by quicksort.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static<AnyType extends Comparable<?super AnyType>>
    void insertionSort(AnyType[] a, int left, int right) {
        for(int p = left + 1; p <= right; p++) {
            AnyType tmp = a[p];
            int j;
            for(j = p; j > left &&
             tmp.compareTo(a[j-1]) < 0; j--)
                a[j] = a[j-1];
            a[j] = tmp;
        }
    }
}
