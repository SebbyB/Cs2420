package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> implements Map<K, V> {





    private ArrayList<LinkedList<MapEntry<K, V>>> table;

    private int capacity = 100;

    private int size;


    double lambda = .75;


    public HashTable(){
        table = new ArrayList<LinkedList<MapEntry<K, V>>>();
        for(int i = 0; i < capacity; i++)
            table.add(new LinkedList<MapEntry<K, V>>());

        size = 0;
    }




    /**
     * Removes all mappings from this map.
     * <p>
     * O(table length)
     */
    @Override
    public void clear() {
        for(LinkedList<MapEntry<K,V>> list : this.table){
        list.clear();}
    }


    public int hashKey(K key){
        return key.hashCode() % this.capacity;
    }


    /**
     * Determines whether this map contains the specified key.
     * <p>
     * O(1)
     *
     * @param key
     * @return true if this map contains the key, false otherwise
     */
    @Override
    public boolean containsKey(K key) {

        LinkedList<MapEntry<K,V>> list = table.get(hashKey(key));

        for(MapEntry<K,V> entry : list){
        if(entry.getKey() == key){
            return true;}}
        return false;
    }

    /**
     * Determines whether this map contains the specified value.
     * <p>
     * O(table length)
     *
     * @param value
     * @return true if this map contains one or more keys to the specified value,
     * false otherwise
     */
    @Override
    public boolean containsValue(V value) {

        for (LinkedList<MapEntry<K,V>> list : this.table){
            for(MapEntry<K,V> entry : list){
                if(entry.getValue() == value)
                    return true;
            }
        }
        return false;
    }



    public boolean containsKeyValuePair(MapEntry<K,V> entry){


        V value = entry.getValue();
        K key = entry.getKey();
        if(this.containsKey(key) && containsValue(value))
            return true;
        else return false;
    }
    /**
     * Returns a List view of the mappings contained in this map, where the ordering of
     * mapping in the list is insignificant.
     * <p>
     * O(table length)
     *
     * @return a List object containing all mapping (i.e., entries) in this map
     */
    @Override
    public List<MapEntry<K, V>> entries() {

        ArrayList<MapEntry<K,V>> retList = new ArrayList<>();

        for (LinkedList<MapEntry<K,V>> list : this.table){
            retList.addAll(list);
        }

        return retList;
    }


    boolean isPrime(int num){

        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;

    }

    int doublePrime(int num){

        int dub = num*2;

        while(!isPrime(dub)){
            dub++;
        }
        return dub;
    }


    private void reSizeReHash(){

        List<MapEntry<K,V>> list = this.entries();
        int oldCap = this.capacity;
        int newCap;
        newCap = doublePrime(this.capacity);
        clear();
        int listsAdded = newCap - oldCap;

        for(int i = 0; i < listsAdded; i++){
            table.add(new LinkedList<MapEntry<K,V>>());
            this.capacity++;
        }
        size = 0;
        for(MapEntry<K,V> entry : list){
            this.put(entry.getKey(), entry.getValue());
        }


    }
    /**
     * Gets the value to which the specified key is mapped.
     * <p>
     * O(1)
     *
     * @param key
     * @return the value to which the specified key is mapped, or null if this map
     * contains no mapping for the key
     */
    @Override
    public V get(K key) {

        if(containsKey(key)){
            LinkedList<MapEntry<K,V>> list = this.table.get(hashKey(key));

            if(list.size() > 1){

                for(MapEntry<K,V> entry : list){
                    if(entry.getKey() == key)
                        return entry.getValue();
                }

            }
            else return list.getFirst().getValue();
        }
        return null;
    }

    /**
     * Determines whether this map contains any mappings.
     * <p>
     * O(1)
     *
     * @return true if this map contains no mappings, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(this.size == 0) return true;
        else return false;
    }


    /**
     * Associates the specified value with the specified key in this map.
     * (I.e., if the key already exists in this map, resets the value;
     * otherwise adds the specified key-value pair.)
     * <p>
     * O(1)
     *
     * @param key
     * @param value
     * @return the previous value associated with key, or null if there was no
     * mapping for key
     */
    @Override
    public V put(K key, V value) {
        int hashKey = hashKey(key);
        MapEntry<K,V> entry = new MapEntry<>(key,value);

        if((double)(size)/capacity >= lambda){
            reSizeReHash();
        }


            LinkedList<MapEntry<K,V>> list = this.table.get(hashKey);

            for(MapEntry<K,V> kvPair : list){
                if(kvPair.equals(entry)){
                    return null;
                }
            }
        list.add(entry);
        size++;
            return value;


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
        if((containsKey(key))){
            LinkedList<MapEntry<K,V>> list = this.table.get(hashKey);
            V value;
            size--;
            if(list.size() > 1) {
                for (MapEntry<K, V> entry : list) {
                    if (entry.getKey() == key) {
                        value = entry.getValue();
                        list.remove(entry);
                        return value;
                    }
                }
            }
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

    public double currLambda(){

        return (double)(this.size) / this.capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }
    public void setCapacity(int n){
        this.capacity = n;
    }
}
