import java.util.*;
// Name : 이건민
// Student ID : 20171660

@SuppressWarnings("unchecked")
class BST <T extends KeyValue> {
    class TreeNode <U extends KeyValue> {
        U data;	// storage for data : in HW 3, T will be Item
        TreeNode<U> leftChild;	// link to the left Child
        TreeNode<U> rightChild;	// link to the right Child

        // constructors come here
        TreeNode() {
            leftChild = rightChild = null;
        }
        TreeNode(U d) {
            // data is given
            data = d;
            // the leftChild and rightChild field are null
            leftChild = rightChild = null;
        }
    };
    public static int C = 0;
    TreeNode <T> root;// the reference to the root node
    BST() {
        // BST constructor.
        root = null;
    }
    void Show() {
        System.out.print( "Pre  Order : ");
        PreOrder(root);
        System.out.println("");
        System.out.print("In   Order : ");
        InOrder(root);
        System.out.println("");
        System.out.print("Post Order : ");
        PostOrder(root);
        System.out.println("");
        System.out.print("Count      : ");
        System.out.print( Count(root));
        System.out.println("");
        System.out.print("Height      : ");
        System.out.println( Height(root));
        System.out.println("");
    }


    // IMPLEMENT THE FOLLOWING FUNCTIONS
    boolean  Insert(T item)  {
        TreeNode<T> ptr, parent;
        ptr = root;

        // first search the key
        if(root == null) {
            root = new TreeNode<T>(item);
            return true;
        }
        while(true){
            if(ptr.data.GetKey() == item.GetKey()){
                ptr.data = item;
                return false;
            }else if(ptr.data.GetKey() > item.GetKey()){
                parent = ptr;
                if(ptr.leftChild != null) {
                    ptr = ptr.leftChild;
                }else{
                    ptr = new TreeNode<>(item);
                    parent.leftChild = ptr;
                    break;
                }
            }else if(ptr.data.GetKey() < item.GetKey()){
                parent = ptr;
                if(ptr.rightChild != null) {
                    ptr = ptr.rightChild;
                }else{
                    ptr = new TreeNode<>(item);
                    parent.rightChild = ptr;
                    break;
                }
            }
        }


        return true;
    }

    T Get(T item)  {
        // use the key field of item and find the node
        // do not use val field of item
        TreeNode<T> ptr;
        ptr = root;

        while(true){
            if(ptr.data.GetKey() == item.GetKey()){
                return ptr.data;
            }else if(ptr.data.GetKey() > item.GetKey()){
                if(ptr.leftChild != null) {
                    ptr = ptr.leftChild;
                }else{
                    return null;
                }
            }else if(ptr.data.GetKey() < item.GetKey()){
                if(ptr.rightChild != null) {
                    ptr = ptr.rightChild;
                }else{
                    return null;
                }
            }
        }

    }

    boolean Delete(T item) {
        if (root == null){
            return false;    // non existing key
        }
        TreeNode<T> parent, cur;
        parent = root;
        cur = root;

        if(root.data.GetKey() == item.GetKey()){
            if(root.leftChild == null && root.rightChild == null) {
                root = null;
                return true;
            }
        }
        while(true){
            // Find key sucess!!
            if(cur.data.GetKey() == item.GetKey()){
                // that node has 2 child
                if(cur.rightChild != null && cur.leftChild != null){
                    TreeNode<T> chg = cur.rightChild;
                    TreeNode<T> subpar = cur;
                    if(chg.leftChild == null){
                        if(chg.rightChild != null){
                            cur.rightChild = chg.rightChild;
                        }else{
                            cur.rightChild = null;
                        }
                    }else{
                        while(true){
                            if(chg.leftChild != null){
                                subpar = chg;
                                chg = chg.leftChild;
                            }else{
                                break;
                            }
                        }
                        // 찾은 값이 rightchild를 가지고 있다면
                        if(chg.rightChild != null){
                            subpar.leftChild = chg.rightChild;
                        }else{
                            subpar.leftChild = null;
                        }
                    }
                    chg.rightChild = cur.rightChild;
                    chg.leftChild = cur.leftChild;
                    if(root.data.GetKey() == item.GetKey()){
                        root = chg;
                    }else {
                        if (parent.rightChild.data.GetKey() == item.GetKey()) {
                            parent.rightChild = chg;
                        } else if (parent.leftChild.data.GetKey() == item.GetKey()) {
                            parent.leftChild = chg;
                        }
                    }

                    return true;
                // that node has only 1child
                }else if(cur.rightChild != null || cur.leftChild != null){
                    if(cur.rightChild != null){
                        if(parent.leftChild != null){
                            if(parent.leftChild == cur){
                                parent.leftChild = cur.rightChild;
                                return true;
                            }else{
                                parent.rightChild = cur.rightChild;
                                return true;
                            }
                        }else{
                            parent.rightChild = cur.rightChild;
                            return true;
                        }
                    }else if(cur.leftChild != null){
                        if(parent.leftChild != null){
                            if(parent.leftChild == cur){
                                parent.leftChild = cur.leftChild;
                                return true;
                            }else{
                                parent.rightChild = cur.leftChild;
                                return true;
                            }
                        }else{
                            parent.rightChild = cur.leftChild;
                            return true;
                        }
                    }
                // that node has no child
                }else{
                    if(parent.leftChild != null){
                        if(parent.leftChild == cur){
                            parent.leftChild = null;
                            return true;
                        }else{
                            parent.rightChild = null;
                            return true;
                        }
                    }else{
                        parent.rightChild = null;
                        return true;
                    }
                }

            // item is smaller than node
            }else if(cur.data.GetKey() > item.GetKey()){
                if(cur.leftChild != null){
                    parent = cur;
                    cur = cur.leftChild;
                }else{
                    return false;
                }
            // item is larger than node
            }else if(cur.data.GetKey() < item.GetKey()){
                if(cur.rightChild != null){
                    parent = cur;
                    cur = cur.rightChild;
                }else{
                    return false;
                }
            }
        }

    }

    void  PreOrder(TreeNode<T> t)  {
        if(t != null) {
            System.out.print(t.data.GetKey() + "(" + t.data.GetValue() + ") ");
            if (t.leftChild != null) {
                PreOrder(t.leftChild);
            }
            if (t.rightChild != null) {
                PreOrder(t.rightChild);
            }
        }
    }

    void  InOrder(TreeNode<T> t)  {
        if(t != null) {
            if (t.leftChild != null) {
                InOrder(t.leftChild);
            }
            System.out.print(t.data.GetKey() + "(" + t.data.GetValue() + ") ");
            if (t.rightChild != null) {
                InOrder(t.rightChild);
            }
        }
    }

    void  PostOrder(TreeNode<T> t)  {
        if(t != null) {
            if (t.leftChild != null) {
                PostOrder(t.leftChild);
            }
            if (t.rightChild != null) {
                PostOrder(t.rightChild);
            }
            System.out.print(t.data.GetKey() + "(" + t.data.GetValue() + ") ");
        }
    }


    int count = 0;
    int  Count(TreeNode<T> t) {
        if(t != null) {
            if (t.rightChild != null || t.leftChild != null) {
                if (t.rightChild != null && t.leftChild != null) {
                    return 1 + Count(t.rightChild) + Count(t.leftChild);
                } else if (t.rightChild != null) {
                    return 1 + Count(t.rightChild);
                } else if (t.leftChild != null) {
                    return 1 + Count(t.leftChild);
                }
            } else {
                return 1;
            }
        }else {
            return 0;
        }
        return 0;
    }

    int  Height(TreeNode<T> t)  {
        if(t != null) {
            if (t.rightChild != null || t.leftChild != null) {
                if (t.rightChild != null && t.leftChild != null) {
                    if (Height(t.leftChild) > Height(t.rightChild)) {
                        return 1 + Height(t.leftChild);
                    } else {
                        return 1 + Height(t.rightChild);
                    }
                } else if (t.rightChild != null) {
                    return 1 + Height(t.rightChild);
                } else if (t.leftChild != null) {
                    return 1 + Height(t.leftChild);
                }
            } else {
                return 1;
            }
        }else {
            return 0;
        }
        return 0;
    }
}


