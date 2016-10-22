package cs4321.project1;

/**
 * Using Java Generics to write our own "Pair" object
 * which will be used in the file EvaluateprefixListVisitor.java
 * to store values like (+,2),(-,2),(~,1), etc into the Stack
 * 
 * @authors 
 * Shweta Shrivastava - ss3646
 * Vikas P Nelamangala - vpn6
 * Saarthak Chandra - sc2776
 */

public class Pair<K, V> {

	    private K key;
	    private V value;

	    public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	    }
	    
	    public void setValue(V value) { this.value = value; }

	    public K getKey()	{ return key; }
	    public V getValue() { return value; }
	}

