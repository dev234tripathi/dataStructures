/**
We can use Insertion Sort to sort the elements efficiently. Following is the C code for standard Insertion Sort.
*/
static void insertionSort(int A[], int size)  
{  
int i, key, j;  
for (i = 1; i < size; i++)  
{  
    key = A[i];  
    j = i-1;  
  
    /* Move elements of A[0..i-1], that are greater than key, to one  
        position ahead of their current position.  
        This loop will run at most k times */
    while (j >= 0 && A[j] > key)  
    {  
        A[j+1] = A[j];  
        j = j-1;  
    }  
    A[j+1] = key;  
}  
}  

/**
The inner loop will run at most k times. To move every element to its correct place, at most k elements need to be moved. So overall complexity will be O(nk)
*/

/**
We can sort such arrays more efficiently with the help of Heap data structure. Following is the detailed process that uses Heap.
1) Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time (See this GFact)
2) One by one remove min element from heap, put it in result array, and add a new element to heap from remaining elements.

Removing an element and adding a new element to min heap will take Logk time. So overall complexity will be O(k) + O((n-k)*logK)
*/

// A java program to sort a nearly sorted array 
import java.util.Iterator; 
import java.util.PriorityQueue; 

class GFG 
{ 
	private static void kSort(int[] arr, int n, int k) 
	{ 

		// min heap 
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); 

		// add first k + 1 items to the min heap 
		for(int i = 0; i < k + 1; i++) 
		{ 
			priorityQueue.add(arr[i]); 
		} 

		int index = 0; 
		for(int i = k + 1; i < n; i++) 
		{ 
			arr[index++] = priorityQueue.peek(); 
			priorityQueue.poll(); 
			priorityQueue.add(arr[i]); 
		} 

		Iterator<Integer> itr = priorityQueue.iterator(); 

		while(itr.hasNext()) 
		{ 
			arr[index++] = priorityQueue.peek(); 
			priorityQueue.poll(); 
		} 

	} 

	// A utility function to print the array 
	private static void printArray(int[] arr, int n) 
	{ 
		for(int i = 0; i < n; i++) 
			System.out.print(arr[i] + " "); 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		int k = 3; 
		int arr[] = { 2, 6, 3, 12, 56, 8 }; 
		int n = arr.length; 
		kSort(arr, n, k); 
		System.out.println("Following is sorted array"); 
		printArray(arr, n); 
	} 
}  
