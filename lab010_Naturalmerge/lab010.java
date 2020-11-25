// Lab 010	: Natural Merge
// Name : 이건민
// Student ID : 20171660

import java.util.*;


class NaturalMerge {
    int noe;  // the number of elements
    private int[] inputArray; // input array
    int[] outputArray; // output array


    NaturalMerge() {
        // Graph constructor.
        noe = 0;
    }

    public String toString() {
        String str = new String();
        str = "Input : ";
        for(int i = 0; i < noe; i++) {
            str += inputArray[i] + " ";
        }
        str += "\nOutput : ";
        for(int i = 0; i < noe; i++) {
            str += outputArray[i] + " ";
        }
        return str;
    }

    void Init(int [] arr, int n) {
        noe = n;
        inputArray = new int[noe];
        System.arraycopy(arr, 0, inputArray, 0, n);

        outputArray = new int[noe];
    }

    void Merge() {
        int n = noe;

        // NEED TO IMPLEMENT
        int R = 0;
        for(int i = 0; i < inputArray.length; i++){
            if(inputArray[i+1] < inputArray[i]){
                R = i+1;
                break;
            }
        }

        System.out.println("noe = " + noe + ", R = " + R);
        int[] Larr = new int[R];
        int[] Rarr = new int[noe-R];
        for(int i = 0; i < R; i++){
            Larr[i] = inputArray[i];
        }
        for(int i = 0; i < noe -R; i++){
            Rarr[i] = inputArray[R+i];
        }

        int Lpos = 0, Rpos = 0;
        int count = 0;
        while(true){
            if(Larr[Lpos] > Rarr[Rpos]){
                outputArray[count] = Rarr[Rpos];
                System.out.print("R ");
                count++;
                Rpos++;
                if(Rpos == Rarr.length){
                    break;
                }
            }else{
                outputArray[count] = Larr[Lpos];
                System.out.print("L ");
                count++;
                Lpos++;
                if(Lpos == Larr.length){
                    break;
                }
            }
        }
        System.out.println();
        if(Lpos == Larr.length){
            for(int i = Rpos; i < Rarr.length; i++){
                outputArray[count++] = Rarr[i];
            }
        }else{
            for(int i = Lpos; i < Larr.length; i++){
                outputArray[count++] = Larr[i];
            }
        }


    }
}







