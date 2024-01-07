
// --== CS400 Project One File Header ==--
// Name: Anurag Sai Tallapragada
// CSL Username: tallapragada
// Email: atallapragad@wisc.edu
// Lecture #: 002 @2:30pm
// Notes to Grader: <any optional extra notes to your grader>
import java.util.NoSuchElementException;

/**
 * 
 * this class tests the methods in the HashtableMap file
 *
 */
public class HashtableMapTests {
  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();

  }

  // tester for put()method
  public static boolean test1() { /* test code here */
    // creating a hash table map of size 10
    HashtableMap<Integer, Integer> testhash = new HashtableMap<Integer, Integer>(10);
    // key value is 3
    Integer k = 3;
    // value in key-value pair is 6
    Integer v = 6;
    // putting key value pair into hash table map
    testhash.put(k, v);
    int hash = Math.abs(k.hashCode()) % 10;
    // if the key is not contained in the array, the put method did not work
    if (testhash.containsKey(k) == false) {
      System.out.println("put() method: error");
      return false;
    }

    // iterating through the array using hashcode of the key value pair
    for (int i = 0; i < testhash.elements[hash].size(); i++) {
      // if the key found is the same as the given key, the put() method works
      if (testhash.elements[hash].get(i).getKey1().equals(k)) {
        System.out.println("put(): true");
        return true;
        // else it does not work
      } else {
        System.out.println("put(): error");
        return false;
      }
    }
    return false;

  }

  // tester for get() method.
  public static boolean test2() { /* test code here */
    // creating a hash table map of size 10
    HashtableMap<Integer, Integer> testhash = new HashtableMap<Integer, Integer>(10);
    // key value is 3
    Integer k = 3;
    // value in key-value pair is 6
    Integer v = 6;
    // putting key value pair into hash table map
    testhash.put(k, v);
    // if the key is not contained in the array, the put method did not work
    int hash = Math.abs(k.hashCode()) % 10;
    if (testhash.containsKey(k) == false) {
      System.out.println("put() method: error");
      return false;
    }
    // if the value we get from the key is the same as the corresponding key, get() method works
    if (testhash.get(k) == v) {
      System.out.println("get(): true");
      return true;
    }


    return false;
  }

  // tester for remove() method
  public static boolean test3() { /* test code here */
    // creating a hash table map of size 10
    HashtableMap<Integer, Integer> testhash = new HashtableMap<Integer, Integer>(10);
    // key value is 3
    Integer k = 3;
    // value in key-value pair is 6
    Integer v = 6;
    // putting key value pair into hash table map
    testhash.put(k, v);
    // if the key is not contained in the array, the put method did not work
    int hash = Math.abs(k.hashCode()) % 10;
    if (testhash.containsKey(k) == false) {
      System.out.println("put() method: error");
      return false;
    }
    // remove key value pair
    testhash.remove(k);
    // if the key is not in the array, it means the remove method worked
    if (testhash.containsKey(k) == false) {
      System.out.println("remove(): true");
      return true;
    }

    return false;
  }

  // tester for containsKey() method
  public static boolean test4() { /* test code here */
    // creating a hash table map of size 10
    HashtableMap<Integer, Integer> testhash = new HashtableMap<Integer, Integer>(10);
    // key value is 3
    Integer k = 3;
    // value in key-value pair is 6
    Integer v = 6;
    // putting key value pair into hash table map
    testhash.put(k, v);
    // if the key is not contained in the array, the put method did not work
    int hash = Math.abs(k.hashCode()) % 10;
    if (testhash.containsKey(k) == false) {
      System.out.println("put() method: error");
      return false;
    }

    // if the key is not contained in the array, the get method works
    if (testhash.containsKey(k) == true) {
      System.out.println("containsKey(): true");
      return true;
    }

    return false;
  }

  // tester for size method
  public static boolean test5() { /* test code here */
    // creating a hash table map of size 10
    HashtableMap<Integer, Integer> testhash = new HashtableMap<Integer, Integer>(10);
    // key value is 3
    Integer k = 3;
    // value in key-value pair is 6
    Integer v = 6;
    // key value is 2
    Integer k1 = 2;
    // value in key-value pair is 7
    Integer v1 = 7;

    testhash.put(k, v);
    // putting key value pair into hash table map

    int hash = Math.abs(k.hashCode()) % 10;
    // if the key is not contained in the array, the put method did not work

    if (testhash.containsKey(k) == false) {
      System.out.println("put() method: error");
      return false;
    }

    testhash.put(k1, v1);
    // putting key value pair into hash table map

    int hash1 = Math.abs(k1.hashCode()) % 10;

    // if the key is not contained in the array, the put method did not work
    if (testhash.containsKey(k1) == false) {
      System.out.println("put() method: error");
      return false;
    }
    // if the size is 2, the size method works
    if (testhash.size() == 2) {
      System.out.println("size(): true");
      return true;
    }

    return false;
  }
}
