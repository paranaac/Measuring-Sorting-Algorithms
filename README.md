# Measuring-Sorting-Algorithms

Timing various sorting algorithms and analyzing the runtimes.

#Date: 3/25/2015

#Insertion Sort

Compared to the other sorting algorithms, insertion sort is less efficient on large inputs. It iterates through an input list consuming an element during each repetition. Each iteration removes a sorted element and places it in it’s exact location in the sorted list. From our analysis, insertion sort works well on an almost-sorted list. Since 5% of the elements in the almost-sorted array we created were just shifted right once, it could sort them in one pass and at N = 106 it took 16 milliseconds. It would have a O(n) in a best case, when the input is already or almost sorted. The worst case is for large inputs in reverse order and for random inputs, both O(n2). In our runs, the random at N = 106 took approximately 30 mins.

##Shell Sort

Works great with almost sorted inputs because it is based on insertion sort; it compares elements far apart, steadily reducing the gap between elements being sorted. it then performs insertion sort on adjacent elements.

•	Donald Shell’s original sequence repeatedly divides by 2 to determine how far apart elements to be sorted are. At N=106 it takes 1044 milliseconds on average to sort a random list, four times slower than quicksort. Shell’s sequence has a time complexity of O(n2). This would not be a good implementation for a large list of random values, but it would be good to use on a large list of almost-sorted values or when the list is not very large. 

•	Knuths’s increments (1, 4, 13, 40..) has a slightly better performance and a time complexity of O(N3/2). At N = 106 it took 765 milliseconds to sort a random list. This too would be a simple implementation for a list of small values, or almost sorted integers. It works quite well for smaller random and almost-sorted files because it doesn’t exceed 100 milliseconds up to N = 105.

#Quicksort

Mathematically, quicksort has an average running time of O(NlogN). It works best for random numbers, large inputs, and inputs where less than relation is defined. The worst case for quicksort is O(n2), the rare event when the pivot is the largest or smallest element in the array. Quicksort uses divide-and-conquer to sort the array, it splits the array into two subarrays and recursively sorts them. In our test runs, it performed faster than all the other algorithms for a random list, but slower compared to others for the almost-sorted list on small inputs. This would be the ideal algorithm to use for very large inputs of random data that can be performed in main memory.
