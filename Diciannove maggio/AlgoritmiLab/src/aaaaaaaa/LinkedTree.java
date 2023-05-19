package aaaaaaaa;

public class LinkedTree {


    // gli alberi binari di ricerca sono ordinati da sx a dx 

    private class Node{
        private int key;
        private Node left, right;
        public Node(int x){
        key = x;
        left = right = null;
        } // end constructor
        } // end class Node
        private Node root;

        public int min(){ //return minimum value in an non-empty
        
            //note that if root == null we get an error
            return min(root);
            }
            private int min(Node g){
            if (g.left == null) return g.key;
            return min(g.left);
            }

            public void deleteMin(){
                if (root != null)
                root = deleteMin(root);
                }
                private Node deleteMin(Node g){
                if (g.left == null) // base case: if the root node g
                // has not the left subtree,
                // then g has to be erased
                // from the given tree.
                return g.right;
                g.left = deleteMin(g.left); // the minimum is in the tree
                // rooted at the left subtree of
                
                return g;
                }
                public void insert(int x) {
                    // if the key x does not occur in the tree,
                    // then insert a node with key x,
                    // otherwise nothing has to be done
                    root = insert(root, x);
                    }

                    private Node insert(Node g, int x) {
                        // if x does not occur in the BST
                        // rooted at g
                        // insert a new node
                        if (g == null)
                        return new Node(x); // the tree is empty
                        if (x < g.key)
                        g.left = insert(g.left, x);
                        else if (x > g.key)
                        g.right = insert(g.right, x);
                        return g;
                        } // end insert(Node g, int x)

    private boolean exists(int x){
        return exists(root,x);
    }

    private boolean exists(Node T, int x){
        if (T == null) return false;
        if (x > T.key) return exists(T.right, x);
        if (x < T.key) return exists(T.left, x);
        return true;
        //se un int è più grande allora è alla destra, se è più piccolo alla sinistra

    }

    private int size(){
        return size(root);
    }

    private int size(Node g){
        if (g == null) return 0;
        return 1 + size(g.left) + size(g.right);
    }

    public int height(){
      
        if (root == null) return -1;
        return height(root);
    }
    public int height(Node g){
        int size=0, size2=0;
       if (g.left == null && g.right == null) return 0;
        size = height(g.left);
        size2 = height(g.right);
        if (size > size2) return size;
        else return size2;
       
    }

    public void preorderPrint(){
        if ( root == null){
        System.out.println("The tree is empty");
        }
        else {
        System.out.println("Preorder printing...");
        preorderPrint(root, 0);
        System.out.println("- End of the tree -");
        }
        } // end preorderPrint()

        private void preorderPrint(Node g, int level){
            for(int i=0; i<level; i++) System.out.print(" ");
            if (g == null){
            System.out.println("X");
            return;
            }
            System.out.println(g.key);
            preorderPrint(g.left, level + 1);
            preorderPrint(g.right, level + 1);
            }

            public void inorderPrint(){
                if ( root == null){
                System.out.println("The tree is empty");
                }
                else {
                System.out.println("Inorder printing ...");
                inorderPrint(root, 0);
                System.out.println("- End of the tree -");
                }
                } 

                private void inorderPrint(Node g, int level){
                    if ( g == null ){ // base case
                    for(int i=0; i<level; i++) System.out.print("\t");
                    System.out.println("X");
                    return;
                    }
                    // step
                    inorderPrint(g.left, level + 1); // traverse the left
                    
                    for(int i=0; i<level; i++) System.out.print("\t");
                    System.out.println(g.key); // visit the root
                    inorderPrint(g.right, level + 1); // traverse the right
                   
                    }

                    public void printAsString(){
                        if(root == null) {
                            System.out.println("null");
                            return;
                        } else {
                            System.out.print("(");
                            printAsString(root);
                            System.out.print(")");
                        }
                    }
            void printAsString(Node g){
                if (g == null) System.out.print(" X ,");
                else System.out.print(" " + g.key + " ,");
                if (g.left == null) System.out.print(" X ,");
                else printAsString(g.left);
                if (g.right == null) System.out.print(" X ,");
                else printAsString(g.right);
                    }

                    public void breadthPrint(){
                        if (root == null){
                        System.out.println("\nThe tree is empty");
                        return;
                        }
                        //if we are here at least a node must be visited
                        int level = 0;
                        do{
                        System.out.println("\nlevel: " + level);
                        } while ( breadthPrint(root, level++) );
                        System.out.println("no nodes at level: " + (level-1));
                        }

                        
        private boolean breadthPrint(Node g, int l){    
            if (g == null) return false;
            if (l == 0){
                System.out.print(g.key + " ");
                return true;
            }
            if(l == 1 ) {
                System.out.println(g.left + " " + g.right);
            } else {
                breadthPrint(g.left, l--);
                breadthPrint(g.left, l--);
            }
            return true;
        }
}
