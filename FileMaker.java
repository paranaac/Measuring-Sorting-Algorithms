/** 
* @author Alejandro Parana
* Helper methods for creating and reading files
*/
import java.util.*;
import java.io.*;
public class FileMaker {
	private int[] a;
    Random rand = new Random();
	/** 
	*  Make a file of random values
	*  @param size is the size of the input
	*/
	public void makeRandom(int size) throws IOException{
		a = new int[size];
		String file = size + ".txt";
		FileWriter fw = new FileWriter (file);
   		BufferedWriter bw = new BufferedWriter (fw);
        PrintWriter outFile = new PrintWriter (bw);
		for (int i = 0; i < a.length; i++)  {
			a[i] = rand.nextInt();
			outFile.println(a[i]);
		}
		outFile.close();
	}
	/** 
	*  Make an almost sorted file 
	*  (5% of elements are shifted)
	*  @param n is the size of the input
	*/
	public void makeAlmostSorted(int n) throws IOException{
			String file = n + "Almost.txt";
			a = new int[n];
			FileWriter fw = new FileWriter (file);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter outFile = new PrintWriter (bw);
			for(int i = 0; i < n; i++) {
				a[i] = rand.nextInt();
			}
			Arrays.sort(a); // Make 5% unsorted
			for(int i = 0; i < (n*.05); i++) {
				int index = rand.nextInt(n-1);
					swap(a, index, index+1);
			}
   			for (int i = 0; i < a.length; i++)
				outFile.println(a[i]);
			outFile.close();
	}
	private static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	/** 
	*   Read the random file created and copy into array
	*	@param size is the name of the file
    */
	public void readRandom(int size) 
	throws FileNotFoundException {
		a = new int[size];
		FileReader file = new FileReader(size + "Random.txt");
	    int i = 0;
	    try {
		        Scanner input = new Scanner(file);
		        while(input.hasNext()) {
		            a[i] = input.nextInt();
		            i++;
		        }
		        input.close();
	   	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	}
    /** 
    *   Read the almost sorted file created and copy into array
	*	@param size is the name of the file
    */
	public void readAlmostSorted(int size) 
	throws FileNotFoundException {
		a = new int[size];
		FileReader file = new FileReader(size+"Almost.txt");
	    int i = 0;
	    try{
		        Scanner input = new Scanner(file);
		        while(input.hasNext()) {
		            a[i] = input.nextInt();
		            i++;
		        }
		        input.close();
	   	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	/** Copies int[] values into Integer[] array, returns it
	*/
	public Integer[] getA() {
		Integer[] array = new Integer[a.length];
		int i = 0;
		for (int value : a) {
		    array[i++] = Integer.valueOf(value);
		}
		return array;
	}
}

	



