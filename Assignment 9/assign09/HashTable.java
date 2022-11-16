package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> implements Map<K, V> {


    //Backing Array for the HashTable
    private ArrayList<LinkedList<MapEntry<K, V>>> table;

    //Initial Capacity for the HashTable Backing Array.
    private int capacity = 100;


    //Number of Entries in the Hash Table.
    private int size;


    //Desired Lambda value for the Hash Table
    private double lambda = 1;


    /**
     * Constructor for a new instance of HashTable.
     *
     * Creates a Backing Array of LinkedLists Containing MapEntries.
     * Sets size to 0
     */
    public HashTable(){
        table = new ArrayList<LinkedList<MapEntry<K, V>>>();
        for(int i = 0; i < capacity; i++)
            table.add(new LinkedList<MapEntry<K, V>>());

        size = 0;
    }




    /**
     * Clears the Hash Table
     */
    @Override
    public void clear() {
        for(LinkedList<MapEntry<K,V>> list : this.table){
        list.clear();
        size = 0;
        }
    }


    /**
     * Finds the necessary index for the key to go in the backing array.
     * @param key - Key being checked.
     * @return - Index in backing Array.
     */
    private int hashKey(K key){
    	int hash = key.hashCode();
    	if(hash == Integer.MIN_VALUE) {
    		hash++;
    	}
        return Math.abs(hash) % this.capacity;
    }


    /**
     * Checks if the key is in the Hash Table.
     *
     * @param key - key being checked.
     * @return true if HashTable has the key, false otherwise
     */
    @Override
    public boolean containsKey(K key) {

        //If the HashTable is empty the HashTable does not contain the key.
        if(this.isEmpty()) return false;


        //Find the Linked List with the corresponding hashKey,
        //If the List has more than one entry loop through the linked list and return the MapEntry with the value that corresponds to the key.
        //Otherwise, return the first item in the list.
        //If there is no list, the item is not in the array, so it will return false.
        LinkedList<MapEntry<K,V>> list = table.get(hashKey(key));
        if(list.size() <= 0) {
        	return false;
        }
        if(list.size() > 1){
        for(MapEntry<K,V> entry : list){
            if(entry.getKey().equals(key)){
                return true;}
            }
        }
        else{
            if( list.getFirst().getKey().equals(key))
                return true;
        }
        return false;
    }

    /**
     * Determines if a value is in the HashTable.
     *
     * @param value - Value being checked.
     * @return true if HashTable contains one or more keys to the specified value,
     * false otherwise
     */
    @Override
    public boolean containsValue(V value) {

        //If the HashTable is Empty it does not contain the value so return false.
        if(this.isEmpty()) return false;

        //Check each list in the backing array, if the list contains a MapEntry with a value matching our parameter return true.
        for (LinkedList<MapEntry<K,V>> list : this.table){
            for(MapEntry<K,V> entry : list){
                if(entry.getValue().equals(value))
                    return true;
            }
        }
        //False otherwise.
        return false;
    }



    /**
     * Returns a List view of the HashTable , where the ordering is insignificant.
     *
     * @return a List object containing all entries of the HashTable.
     */
    @Override
    public List<MapEntry<K, V>> entries() {
        ArrayList<MapEntry<K,V>> retList = new ArrayList<>();
        for (LinkedList<MapEntry<K,V>> list : this.table){
            retList.addAll(list);
        }
        return retList;
    }


    /**
     * Checks if an integer is prime.
     * @param num - number being checked.
     * @return - True if the number is prime, false otherwise.
     */
     private boolean isPrime(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * Finds an integer that is prime and at least double the size of the integer given.
     * @param num - number being doubled and primed.
     * @return - an integer that is at least twice the size of the input and prime.
     */
    private int doublePrime(int num){

        //Find twice the input parameter.
        int dub = num*2;
        //While that isn't prime increment it. Once its prime, return.
        while(!isPrime(dub)){
            dub++;
        }
        return dub;
    }

    /**
     * ReSizes and the HashTable and ReHashes all current Entries.
     */
    private void reSizeReHash(){
        //Creates a list of all current Entries.
        List<MapEntry<K,V>> list = this.entries();

        //Finds a new capacity for the backing array.
        int newCap;
        newCap = doublePrime(this.capacity);

        //Creates a new Backing Array of the new size. Populates with LinkedLists of Map Entries. Sets pointer.
        table = new ArrayList<LinkedList<MapEntry<K,V>>>(newCap);
        for(int i = 0; i < newCap; i++){
            table.add(new LinkedList<MapEntry<K,V>>());
        }

        //Changes table capacity to new capacity. Sets Size to 0.
        this.capacity = newCap;
        size = 0;
        //Puts the old entries back into the array - It will automatically ReHash the table.
        for(MapEntry<K,V> entry : list){
            this.put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Gets the value to which the specified key is mapped.
     *
     * @param key - Key that corresponds to a value.
     * @return the value to which the specified key is mapped, or null if the HashTable
     * contains no mapping for the key
     */
    @Override
    public V get(K key) {

        //if the HashTable contains the key,
        if(containsKey(key)){
            //Get the linked list that corresponds to the key.
            LinkedList<MapEntry<K,V>> list = this.table.get(hashKey(key));

            //If the list size is greater than one, get the Value that corresponds to the key.
            if(list.size() > 1){

                for(MapEntry<K,V> entry : list){
                    if(entry.getKey().equals(key))
                        return entry.getValue();
                }

            }
            //Otherwise return the first item in the list.
            else return list.getFirst().getValue();
        }
        //If the hashTable does not contain the key, return null.
        return null;
    }

    /**
     * Checks if the HashTable has no Entries.
     *
     * @return true if HashTable has entries, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        if(this.size == 0) return true;
        else return false;
    }


    /**
     *
     * Puts entry into the HashTable. Replaces Value if the Value already exists.
     * @param key - key of entry.
     * @param value - value of entry.
     * @return the previous value associated with key, or null if there was no
     * mapping for key
     */
    @Override
    public V put(K key, V value) {
        int hashKey = hashKey(key);
        MapEntry<K,V> entry = new MapEntry<>(key,value);
        //finds linked list of associated hashkey value
            LinkedList<MapEntry<K,V>> list = this.table.get(hashKey);
            for(MapEntry<K,V> kvPair : list){
                if(kvPair.getKey().equals(key)) {
                	//if there is already a mapkey with key value, replace the value
                	//with in puted value
                	V replaceValue = kvPair.getValue();
                    kvPair.setValue(entry.getValue());
                    return replaceValue;
                }

            }
            //if there is no repeat, add mapkey to associated haskey value list
        list.add(entry);
        size++;
        //checks if table needs to be rehashed
        if((double)(size)/capacity >= lambda){
            reSizeReHash();
        }
            return null;
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     * <p>
     * O(1)
     *
     * @param key
     * @return the previous value associated with key, or null if there was no
     * mapping for key
     */
    @Override
    public V remove(K key) {
        int hashKey = hashKey(key);
        //Checks if the table even contains the key
        if((containsKey(key))){
        	//Gets the hashkey linked list associated with the key
            LinkedList<MapEntry<K,V>> list = this.table.get(hashKey);
            V value;
            size--;
            //if the linked list to be searched through is larger than one
            if(list.size() > 1) {
                for (MapEntry<K, V> entry : list) {
                	//If any elements in the associated hash key linked list equal the
                	//key, remove the entry
                    if (entry.getKey().equals(key)) {
                        value = entry.getValue();
                        list.remove(entry);
                        return value;
                    }
                }
            }
            //if the linked list is one long
            else{
                value = list.getFirst().getValue();
                list.removeFirst();
                return value;
            }
        }
        return null;
    }

    /**
     * Determines the number of mappings in this map.
     * <p>
     * O(1)
     *
     * @return the number of mappings in this map
     */
    @Override
    public int size() {
        return this.size;
    }

 //METHODS PREVIOUSLY USED FOR TESTOR
    public double currLambda(){
        return (double)(this.size) / this.capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }
    public void setCapacity(int n){
        this.capacity = n;
    }
    public void setLambda(int n){
        this.lambda = n;
    }
}