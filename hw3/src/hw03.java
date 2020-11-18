// HW 203, QuickSort
// Name : Leegeonmin
// Student ID : 20171660

import java.util.*;


class QuickSort {
    int[] arr; // array
    int arrSize;  // number of elements in arr

    QuickSort() {
        arr = new int[1024];
        arrSize = 0;
    }


    void Show(int s, int e) {
        // Show all the element in the arr
        if(s > e)
            return ;
        String str = new String();
        str = "arr : ";

        // print all the nodes in the arr
        for(int i = 0; i < arrSize; i++) {
            if(i == s)
                str += "[";
            else
                str += " ";
            str += arr[i];
            if(i == e)
                str += "]";
            else
                str += " ";
        }
        System.out.println( str);
    }

    void  Init(int[] es, int n) {
        // fill the arr array by the input
        arrSize = n;
        for(int i = 0; i < n; i++)
            arr[i] = es[i];
    }


    void  Sort() {
        // sort arr[0:arrSize-1] into nonincreasing order
        // This is an invoking method to the Partition() and QSort()
        QSort(0, arrSize - 1);	// quick sort from 0 to n-1
    }



    void  QSort(int s, int e) {
        // sort arr[s:e] into nonincreasing order
        System.out.println("Sort in [" + s + "," + e + "]");
        Show(s, e);

        if(s >= e)
            return;


        //	"NEED TO IMPLEMENT"
        int pivot;
        int[] pivarr = {arr[s], arr[(s+e)/2], arr[e]};
        Arrays.sort(pivarr);
        pivot = pivarr[1];

        if(pivot == arr[(s+e)/2]){
            arr[(s+e)/2] = arr[s];
            arr[s] = pivot;

         }else if(pivot == arr[e]){
            arr[e] = arr[s];
            arr[s] = pivot;
         }

        int apos = s + 1, bpos = e;
        int tmp;

        while(true){
                if ((pivot >= arr[apos]) && (pivot <= arr[bpos])) {
                    if(apos < bpos) {
                        tmp = arr[apos];
                        arr[apos] = arr[bpos];
                        arr[bpos] = tmp;
                        apos++;
                        bpos--;
                    }else if(apos == bpos){
                        if(pivot > arr[apos]){
                            bpos--;
                            tmp = arr[bpos];
                            arr[bpos] = pivot;
                            arr[s] = tmp;
                            break;
                        }else if(pivot < arr[apos]){
                            tmp = arr[bpos];
                            arr[bpos] = pivot;
                            arr[s] = tmp;
                            break;
                        }else{
                            apos++;
                            break;
                        }

                    }else if(apos > bpos){
                        tmp = arr[bpos];
                        arr[bpos] = pivot;
                        arr[s] = tmp;
                        break;
                    }
                } else if (pivot >= arr[apos]) {
                    bpos--;
                } else if (pivot <= arr[bpos]) {
                    apos++;
                } else {
                    bpos--;
                    apos++;
                }
        }
        QSort(s, bpos - 1);
        QSort(apos , e);
    }

}


