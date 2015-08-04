import java.util.*;

public class MyHashMap<K extends Object, V> implements Map61B<K, V> {
    //How full linkHolder is supposed to be
    private float loadFactor;
    //The capacity
    private int size;
    //The actual load
    private int entries;
    //Holds the linked lists according to hashCode
    private List<Entry> linkHolder;
    //The number of rehashes... just for kicks
    private int rehashes = 1;

    //General bucket calculations: Math.abs(key.hashCode()) % size
    //When size*loadFactor <= entries, double size, update, and rehash 
    // MUST UPDATE PUT AND REMOVE

    /**Constructors*/
    public MyHashMap() {
        //Defaults
        entries = 0;
        size = 10;
        loadFactor = (float) .75;
        linkHolder = new ArrayList<Entry>();
        fillWithNull(linkHolder, size);
    }
    public MyHashMap(int initialSize) {
        //Default loadFactor but variable size
        entries = 0;
        size = initialSize;
        loadFactor = (float) .75;
        linkHolder = new ArrayList<Entry>(size);
        fillWithNull(linkHolder, size);
    }
    public MyHashMap(int initialSize, float loadFactor) {
        //Variable loadFactor and variable size
        entries = 0;
        size = initialSize;
        this.loadFactor = loadFactor;
        linkHolder = new ArrayList<Entry>(size);
        fillWithNull(linkHolder, size);
    }

    boolean reHash() {
        //Rehashing not needed if loadFactor not exceeded
        if (size*loadFactor >= entries && entries != size)
            return false;   

        System.out.println("Rehashing... Attempt: " + rehashes);
        rehashes += 1;              

        size *= 2;
        entries = 0;
        List<Entry> oldLinks = linkHolder;
        linkHolder = new ArrayList<Entry>(size);
        fillWithNull(linkHolder, size);

        //First for loop iterates through each "bucket" in oldlinks, an arraylist representing my hashMap
        for (Entry bucket : oldLinks) {
            //Second for loop deep copies everything from oldLinks and places them in their new buckets
            for (Entry pointer = bucket; pointer != null; pointer = pointer.next) {
                this.put(pointer.getKey(), pointer.getVal());
            }
        }

        return true;
    }

    private void fillWithNull(List<Entry> lst, int size) {
        for (int i = 0; i < size; i += 1) {
            lst.add(null);
        }
    }
    
    /** Removes all of the mappings from this map. */
    public void clear() {
        size = 10;
        entries = 0;
        linkHolder = new ArrayList<Entry>();
        fillWithNull(linkHolder, size);
    }

    /* Returns true if this map contains a mapping for the specified key. 
     * Should run on average constant time when called on a HashMap. 
     */
    public boolean containsKey(K key) {
        if (key == null) return false;

        int whichBucket = Math.abs(key.hashCode()) % size;
        Entry thisBucket = linkHolder.get(whichBucket);
        
        return thisBucket != null && thisBucket.get(key) != null;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. Should run on average constant time
     * when called on a HashMap. 
     */
    public V get(K key) {
        if (key == null) return null;
        //Compute the correct bucket
        int whichBucket = Math.abs(key.hashCode()) % size;
        //Get the bucket
        Entry thisBucket = linkHolder.get(whichBucket);
        //Get the entry FROM the bucket, if it exists
        if (thisBucket == null) return null;
        Entry thisEntry = thisBucket.get(key);
        //Return the entry's value, if it exists
        if (thisEntry != null) return thisEntry.getVal();
        //Return null if the key did not exist
        return null;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return entries;
    }

    /* Associates the specified value with the specified key in this map. 
     * Should run on average constant time when called on a HashMap. */
    public void put(K key, V value) {
        if (!this.containsKey(key)) {
            //Compute which bucket it should be put into
            int whichBucket = Math.abs(key.hashCode()) % size;
            //Make a new Entry
            Entry newEntry;
        
            newEntry = new Entry(key, value, linkHolder.get(whichBucket));
            //Update the bucket
            linkHolder.add(whichBucket, newEntry);

            entries += 1;

            reHash();
        } else {
            //Compute the correct bucket
            int whichBucket = Math.abs(key.hashCode()) % size;
            //Get the bucket
            Entry thisBucket = linkHolder.get(whichBucket);
            //Get the entry FROM the bucket, if it exists
            Entry thisEntry = thisBucket.get(key);
            thisEntry.updateVal(value);
        }

    }

    /* Removes the mapping for the specified key from this map if present. 
     * Should run on average constant time when called on a HashMap. */
    public V remove(K key) {
        //Compute which bucket it should be put into
        int whichBucket = Math.abs(key.hashCode()) % size;
        //Get the bucket 
        Entry thisBucket = linkHolder.get(whichBucket);

        if (thisBucket == null) return null;
        
        //Iterate along the linked list until you find and remove 
        Entry pointer = thisBucket.next;
        Entry slowPointer = thisBucket;

        if (slowPointer.getKey().equals(key)) {
            linkHolder.set(whichBucket, pointer);
            entries -= 1;

            return slowPointer.getVal();
        }

        while (pointer != null) {
            K nextKey = pointer.getKey();
            
            if (nextKey.equals(key)) {
                slowPointer.next = slowPointer.next.next;
                entries -= 1;
                return pointer.getVal();    
            }

            slowPointer = slowPointer.next;
            pointer = pointer.next;     
        }
        //If you haven't returned by now, the key was not found
        return null;
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Should run on average constant time when called on 
     * a HashMap. */
    public V remove(K key, V value) {
        //Compute which bucket it should be put into
        int whichBucket = Math.abs(key.hashCode()) % size;
        //Get the bucket 
        Entry thisBucket = linkHolder.get(whichBucket);

        if (thisBucket == null) return null;
        
        //Iterate along the linked list until you find and remove 
        Entry pointer = thisBucket.next;
        Entry slowPointer = thisBucket;

        if (slowPointer.getKey().equals(key) && slowPointer.getVal().equals(value)) {
            linkHolder.set(whichBucket, pointer);
            entries -= 1;
            return slowPointer.getVal();
        }

        while (pointer != null) {
            K nextKey = pointer.getKey();
            
            if (nextKey.equals(key) && pointer.getVal().equals(value)) {
                slowPointer.next = slowPointer.next.next;
                entries -= 1;
                return pointer.getVal();    
            }

            slowPointer = slowPointer.next;
            pointer = pointer.next;     
        }
        //If you haven't returned by now, the key was not found
        return null;
    }

    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet() {
        HashSet<K> keys = new HashSet<K>();

        for (Entry bucket : linkHolder) {
            for (Entry pointer = bucket; pointer != null; pointer = pointer.next) {
                keys.add(pointer.getKey());
            }
        }
        return keys;
    }

    private class Entry {
        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  NEXT as the next node in the linked list. */
        public Entry(K key, V val, Entry next) {
            _key = key;
            _val = val;
            this.next = next;
            _hashCode = key.hashCode();
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  is equal to KEY, or null if no such Entry exists. */
        public Entry get(K key) {
            if (key != null && key.equals(_key)) return this;
            if (next == null) return null;
            return next.get(key);
        }

        public K getKey() {
            return this._key;
        }

        public V getVal() {
            return this._val;
        }

        public Entry getNext() {
            return this.next;
        }

        public int getHash() {
            return this._hashCode;
        }

        public void updateVal(V value) {
            this._val = value;
        }

        /** Stores the key of the key-value pair of this node in the list. */
        private K _key;
        /** Stores the value of the key-value pair of this node in the list. */
        private V _val;
        /** Stores the next Entry in the linked list. */
        Entry next;
        /** Stores the hashcode*/
        private int _hashCode;  
    }   
}
    