import java.util.*;
import java.lang.reflect.*;

/**
 * Generic version of the MinHeap class.
 * @param <T> the type of the value being added
 */

class MinHeap <T extends Comparable> {
    private T[] heapArray;
    private int heapSize;	// number of heap elements

    /**
     * Create an empty MinHeap of size capacity
     */
    MinHeap(Class<T> elemType, int capacity) {
        heapArray = (T []) Array.newInstance(elemType, capacity);
        heapSize = 0;
    }


    /**
     * Insert item into the MinHeap
     */
    void Insert (T item) {
        if(heapSize== 0){
            heapArray[1] = item;
            heapSize++;
        }else{
            heapSize++;
            T tmp;
            int comItem = heapSize;
            if(heapArray[heapSize/2].compareTo(item)>0){
                while(heapArray[comItem/2].compareTo(item) > 0) {
                    tmp = heapArray[comItem / 2];
                    heapArray[comItem / 2] = item;
                    heapArray[comItem] = tmp;
                    comItem /= 2;
                    if(comItem/2 < 1){
                        break;
                    }
                }
            }else{
                heapArray[heapSize] = item;
            }
        }




    }

    void PostOrder (final int idx) {
        if(idx > heapSize){
            System.out.println("\nEnter correct Index, current HeapSize is " + heapSize);
        }
        if(heapSize >= idx*2+1){
            PostOrder(idx*2);
            PostOrder(idx*2 + 1);
            System.out.print(heapArray[idx] + " ");
        }else if(heapSize < idx*2){
            System.out.print(heapArray[idx] + " ");
        }else{
            PostOrder(idx*2);
            System.out.print(heapArray[idx] + " ");
        }





    }


    public String toString() {
        String a = new String();
        a = "Min Heap : - ";
        for(int i = 1; i <= heapSize; i++) {
            a += heapArray[i] + "  ";
        }
        return a;
    }
};




