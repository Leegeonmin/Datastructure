import java.util.*;

// Name : Leegeonmin
// Student ID : 20171660


class Chain <T> {





    class ChainNode <U> {
        private U data;	// storage for data
        private ChainNode<U> link;	// link to the next node

        // constructors come here
        ChainNode() {
            this.link = null;
            // the link field is null
        }
        ChainNode(U data) {
            // set the data field only
            this.data = data;
        }
        ChainNode(U data, ChainNode<U> link) {
            // set the data field and link field
            this.data = data;
            this.link = link;
        }
    };

    private ChainNode<T> first; // reference to the fist node

    Chain() {

        first = null;
    }

    boolean IsEmpty() {return first == null;}

    /**
     * Show all the elements in the Chain in sequence
     */
    public String toString() {
        ChainNode<T> p = first;
        String str = new String();
        str = String.format("List (%d) : ", Size());

        // show all the nodes
        while (p != null) {
            str += p.data + " ";
            p = p.link;
        }
        return str;
    }

    /**
     * insert theElement in theIndex
     */

    boolean Insert(int theIndex, T theElement) {
        if(first == null){
            if(theIndex != 0) {
                return false;
            }
            ChainNode<T> desiredNode = new ChainNode<T>(theElement, first);
            first = desiredNode;

        }
        else{
            if(theIndex == 0) {
                ChainNode<T> desiredNode = new ChainNode<T>(theElement, first);
                first = desiredNode;
            }else {

                ChainNode<T> beforeNode = first;
                for(int i = 1; i < theIndex; i++){

                    if(beforeNode.link == null){
                        return false;
                    }
                    beforeNode = beforeNode.link;

                }
                ChainNode<T> desiredNode = new ChainNode<T>(theElement, beforeNode.link);
                beforeNode.link = desiredNode;
            }

        }
        return true;
    }

    /**
     * delete an element from the first
     */
    T DeleteFront() {
        if(first == null){
            T data = null;
            return data;
        }
        T data = first.data;
        first = first.link;

        return data;
    }

    /**
     * return the number of elements in Chain
     */
    final int  Size() {
        ChainNode<T> p = first;
        int cnt = 0;
        if(p == null){
            return cnt;
        }

        while(p.link != null){
            p = p.link;
            cnt++;
        }
        if((p.link == null) & (p.data != null)){
            cnt++;
        }

        return cnt;
    }

}


