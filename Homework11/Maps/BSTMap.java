import java.util.Set;
import java.util.TreeSet;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private BST map;
    private int size = 0;
    /** Removes all of the mappings from this map. */
    public void clear() {
        map = null;
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        BST p = map;

        while (p != null) {
            int compVal = key.compareTo(p.key);
            
            if (compVal > 0) {          
            //The new key is "bigger"
                p = p.right;
            } else if (compVal < 0) {       
            //The new key is "smaller"
                p = p.left;
            } else {                       
            //This is the key I'm trying to find
                return true;
            }
        }

        return false;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. 
     */
    public V get(K key) {
        BST p = map;
        while (p != null) {
            int compVal = key.compareTo(p.key);
            
            if (compVal > 0) {          
            //The new key is "bigger"
                p = p.right;
            } else if (compVal < 0) {       
            //The new key is "smaller"
                p = p.left;
            } else {                        
            //Updating a current key
                return p.val;
            }
        }

        return null;
    }

   /* Returns the number of key-value mappings in this map. */
    public int size() {
        return this.size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value) {
        map = addToEnd(key, value, map);
    }

    private BST addToEnd(K key, V val, BST p) {
        if (p == null) {
            size += 1;
            return new BST(key, val);
        }
        
        int compVal = key.compareTo(p.key);
        if (compVal > 0) {          //The new key is "bigger"
            p.right = addToEnd(key, val, p.right);
        } else if (compVal < 0) {       //The new key is "smaller"
            p.left = addToEnd(key, val, p.left);
        } else {                        //Updating a current key
            p.update(val);
        }
        return p;
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for HW5. */
    public V remove(K key) {
        /* REASSIGN THE BST TO BE a new BST constructed of all the elements i
         * n KeySet except this new key
         */
        System.out.println("Operation is not supported");
        return null; //FIX
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for HW5. */
    public V remove(K key, V value) {
        System.out.println("Operation is not supported");
        return null; //FIX
    }

    /* Returns a Set view of the keys contained in this map*/
    public Set<K> keySet() {
        return addToKeys(map);
    }

    public Set<K> addToKeys(BST p) {    
        if (p == null) {
            return null;
        }

        Set<K> keys = new TreeSet<K>();
        keys.add(p.key);

        Set<K> lKeys = addToKeys(p.left);
        Set<K> rKeys = addToKeys(p.right);

        if (lKeys != null) {
            keys.addAll(lKeys);
        }
        if (rKeys != null) {
            keys.addAll(rKeys);
        }

        return keys;
    }

    public void printInOrder() {
        printOut(map);
    }

    public void printOut(BST p) {
        if (p != null) {
            printOut(p.left);
            System.out.println(p.key);
            printOut(p.right);
        }
    }

    private class BST {
        BST left, right;            //The left and right subtrees
        K key;
        V val;

        public BST() {
            this.left = null;
            this.right = null;
            this.key = null;
            this.val = null;
        }

        public BST(K k, V v) {
            this.left = null;
            this.right = null;
            this.key = k;
            this.val = v;
        }

        public BST(K k, V v, BST l, BST r) {
            this.left = l;
            this.right = r;
            this.key = k;
            this.val = v; 
        }

        public void update(V newVal) {
            this.val = newVal;
        }
    } 
}
