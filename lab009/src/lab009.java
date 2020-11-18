// Lab 009	: Heapsort
// Name : Leegeonmin
// Student ID : 20171660

import java.util.*;


class HeapSort {
    int[] heapArr; // array
    int hSize;  // number of elements in heapArr

    HeapSort(int capacity) {
        heapArr = new int[capacity + 1];
        hSize = 0;
    }


    public String toString() {
        String str = new String();
        // Show all the element in heapArr
        str = "Heap : - ";

        // print all the nodes in heapArr
        for(int i = 1; i <= hSize; i++)
            str +=  heapArr[i] + "  ";
        return str;
    }

    void  Init(int []es, int n) {
        // fill the heapArr array by the input
        // we need to create heap structure when we call hSort()
        hSize = n;
        for(int i = 1; i <= n; i++)
            heapArr[i] = es[i];
    }

    void  Adjust(int root, int n) {
        // adjust binary tree with root "root" to satisfy heap property.
        // The left and right subtrees of "root" already satisfy the heap
        // property. No node index is > n.

        //	NEED TO IMPLEMENT
        int e = heapArr[root];
        int tmp = 0;
        int chg = 0;
        while((root * 2) <= n){
            if((root * 2) + 1 <= n){
                chg = heapArr[root*2] > heapArr[root*2 + 1] ? root*2 + 1 : root*2;
            }else{
                chg = root*2;
            }

            if(e > heapArr[chg]){
                e = heapArr[root];
                heapArr[root] = heapArr[chg];
                heapArr[chg] = e;
                root = chg;
            }else{
                break;
            }

        }

    }

    void  Heapify() {
        // reorder heapArr[1:n] into a heap
        //	NEED TO IMPLEMENT
        int startNum = hSize / 2;
        for(int i = startNum; i > 0; i--){
            Adjust(i, hSize);
        }
    }
}


