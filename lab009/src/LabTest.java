// Lab 009	: 
// Name :
// Student ID :

import java.util.*;

class LabTest {
    static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);

        HeapSort hsort = new HeapSort(256);	// Heasort

        while(true) {
            try {
                System.err.print("HeapSort > ");

                String cmd = in.next();
                if(cmd.equals("quit"))
                    break;
                if(cmd.equals("i")) {
                    int [] intarr = new int[1024];
                    int i = 1;
                    int item;
                    while(true) {
                        item = in.nextInt();
                        if(item == -1)
                            break;
                        intarr[i++] = item;
                    }
                    hsort.Init(intarr, i - 1);
                    System.out.println(hsort);
                    hsort.Heapify();
                    System.out.println(hsort);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
//		System.err.println("");
    }
}




