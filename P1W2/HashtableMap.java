
// --== CS400 Project One File Header ==--
// Name: Anurag Sai Tallapragada
// CSL Username: tallapragada
// Email: atallapragad@wisc.edu
// Lecture #: 002 @2:30pm
// Notes to Grader: <any optional extra notes to your grader>
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 *
 * @param <KeyType>   key in the key value pair
 * @param <ValueType> value in the key value pair this class generates a hash table map
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

  // instantiated a generic array with KeyType and ValueType as parameters
  protected LinkedList<HTentry<KeyType, ValueType>>[] elements;

  @SuppressWarnings("unchecked")

  // constructor 1 which makes a hash table of fixed capacity
  public HashtableMap(int capacity) {
    elements = (LinkedList<HTentry<KeyType, ValueType>>[]) new LinkedList[capacity];
    for (int i = 0; i < elements.length; i++) {
      elements[i] = new LinkedList<HTentry<KeyType, ValueType>>();
    }
  }

  @SuppressWarnings("unchecked")
  // default constructor which makes an array of size 15
  public HashtableMap() {
    elements = (LinkedList<HTentry<KeyType, ValueType>>[]) new LinkedList[15];
    for (int i = 0; i < elements.length; i++) {
      elements[i] = new LinkedList<HTentry<KeyType, ValueType>>();
    }
  } // with default capacity = 15

  @SuppressWarnings("unchecked")
  @Override

  /**
   * Inserts a new (key, value) pair into the map if the map does not contain a value mapped to key
   * yet.
   * 
   * @param key   the key of the (key, value) pair to store
   * @param value the value that the key will map to
   * @return true if the (key, value) pair was inserted into the map, false if a mapping for key
   *         already exists and the new (key, value) pair could not be inserted
   */
  public boolean put(KeyType key, ValueType value) {
    // TODO Auto-generated method stub
    // checking to see if key and value exist/not null.
    if (key == null || value == null || containsKey(key)) {
      return false;
    }
    // made a new hashtable entry
    HTentry<KeyType, ValueType> newHash = new HTentry<KeyType, ValueType>(key, value);
    // implemented hash code function moddding hash code with the length of the
    // array
    int hashCode = Math.abs(key.hashCode() % elements.length);
    elements[hashCode].add(newHash);

    // made a load factor variable to ensure load factor does not cross 0.7 or 70%
    float loadFactor = (float) size() / elements.length;

    // checking to see if load factor is 70% or over
    if (Float.compare(loadFactor, (float) 0.7) == 0 || Float.compare(loadFactor, (float) 0.7) > 0) {
      LinkedList<HTentry<KeyType, ValueType>>[] newElements =
          (LinkedList<HTentry<KeyType, ValueType>>[]) new LinkedList[2 * elements.length];

      // copying all the elements from the previous array and doubling the size of the array in
      // order to reduce load factor.
      for (int i = 0; i < newElements.length; i++) {
        newElements[i] = new LinkedList<HTentry<KeyType, ValueType>>();
      }

      // 1st for loop is iterating through the array
      // 2nd for loop is iterating through the linked lists in the array
      for (int i = 0; i < elements.length; i++) {
        for (int j = 0; j < elements[i].size(); j++) {
          // implemented new hash code function as the length of the array has doubled
          int newHashCode =
              Math.abs(elements[i].get(j).getKey1().hashCode() % (2 * elements.length));
          newElements[newHashCode].add(elements[i].get(j));
        }
      }
      elements = newElements;
    }

    return true;
  }

  @Override
  /**
   * Returns the value mapped to a key if the map contains such a mapping.
   * 
   * @param key the key for which to look up the value
   * @return the value mapped to the key
   * @throws NoSuchElementException if the map does not contain a mapping for the key
   */
  public ValueType get(KeyType key) throws NoSuchElementException {
    // TODO Auto-generated method stub
    // checking if key is in the array or not
    if (containsKey(key) == false) {
      throw new NoSuchElementException();
    }

    // 1st for loop is iterating through the array
    // 2nd for loop is iterating through the linked lists in the array
    else {
      for (int i = 0; i < elements.length; i++) {
        for (int j = 0; j < elements[i].size(); j++) {
          // if we find the key, we return the keys corresponding value
          if (elements[i].get(j).getKey1().equals(key)) {
            return elements[i].get(j).getValueType1();
          }

        }
      }
    }
    return null;

  }

  @Override
  /**
   * Removes a key and its value from the map.
   * 
   * @param key the key for the (key, value) pair to remove
   * @return the value for the (key, value) pair that was removed, or null if the map did not
   *         contain a mapping for key
   */
  public ValueType remove(KeyType key) {
    // TODO Auto-generated method stub
    // 1st for loop is iterating through the array
    // 2nd for loop is iterating through the linked lists in the array
    for (int i = 0; i < elements.length; i++) {
      for (int j = 0; j < elements[i].size(); j++) {
        // if we find a key in the array with the same key, we remove that key value pair
        if (elements[i].get(j).getKey1().equals(key)) {
          elements[i].remove(j);
        }

      }
    }

    return null;
  }

  @Override
  /**
   * Checks if a key is stored in the map.
   * 
   * @param key the key to check for
   * @return true if the key is stored (mapped to a value) by the map and false otherwise
   */
  public boolean containsKey(KeyType key) {
    // TODO Auto-generated method stub
    // 1st for loop is iterating through the array
    // 2nd for loop is iterating through the linked lists in the array
    for (int i = 0; i < elements.length; i++) {
      for (int j = 0; j < elements[i].size(); j++) {
        // if we find a key in the array with the same key , it means the array contains that key.
        if (elements[i].get(j).getKey1().equals(key)) {
          return true;
        }

      }
    }

    return false;
  }

  @Override
  /**
   * Returns the number of (key, value) pairs stored in the map.
   * 
   * @return the number of (key, value) pairs stored in the map
   */
  public int size() {
    // TODO Auto-generated method stub
    // count variable to keep track of all key value pairs
    int count = 0;
    for (int i = 0; i < elements.length; i++) {
      for (int j = 0; j < elements[i].size(); j++) {
        // incrementing count for every key value pair found
        count++;

      }
    }
    return count;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    for (int i = 0; i < elements.length; i++) {
      // clears all elements in the array.
      elements[i].clear();;
    }

  }

}
