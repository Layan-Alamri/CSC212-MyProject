
package csc212_project;

// BSTNode class represents a node in a BST.
public class BSTNode <K extends Comparable<K>,T> {   
      
    public K key;    
    public T data;  
    public BSTNode<K,T> left, right;  
   
        public BSTNode() {  
            left = right = null;  
        }  
        /** Creates a new instance of BSTNode */
         public BSTNode(K key, T data) {  
            this.key = key  ;    
            this.data = data;  
            left = right = null;  
        }  
  
        public BSTNode(K k, T val, BSTNode<K,T> l, BSTNode<K,T> r){  
            key = k  ;    
            data = val;  
            left = l;  
            right = r;  
        }  
              
        @Override  
        public String toString() {  
            return " ["+ "key=" + key + ", data=" + data + "] ";  
        }  
  
}//End class BSTNode.

