/** 
* @author Alejandro Parana
* Driver for timing various sorting algorithms
*/
import java.io.IOException; 
import java.text.*;
public class SortingTimes {
	public static void main(String[]args) throws IOException {
		FileMaker m = new FileMaker(); Sorting s = new Sorting();
		DecimalFormat df = new DecimalFormat("#.##");
	   
	    final int INPUT_SIZE = 1000;   
	    //m.makeRandom(INPUT_SIZE);
	    //m.makeAlmostSorted(INPUT_SIZE);
	    //m.readRandom(INPUT_SIZE);
	    m.readAlmostSorted(INPUT_SIZE);
       
       Integer[] array = m.getA();
	   long start = System.nanoTime( );
	   //s.insertionSort(array); 
	   //s.quicksort(array);
	   //s.shellsort1(array);   /*Shell*/
	   s.shellsort2(array);   /*Knuth*/
		long end = System.nanoTime( );
		for (int i: array)
			System.out.println(i + " ");
		double time = (end-start)/1000000.0;
		System.out.println("Time: "+ df.format(time) + " ms.");
	}
}

