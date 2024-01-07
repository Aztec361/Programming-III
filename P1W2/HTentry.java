// --== CS400 Project One File Header ==--
// Name: Anurag Sai Tallapragada
// CSL Username: tallapragada
// Email: atallapragad@wisc.edu
// Lecture #: 002 @2:30pm
// Notes to Grader: <any optional extra notes to your grader>
/**
 * 
 * @author anura
 *
 * @param <KeyType>key in key value pair
 * @param <ValueType>  value in key value pair This class generates getters and setters to help us
 *                     find keys and values in a key value pair easily.
 */
public class HTentry<KeyType, ValueType> {
  // instance variable for keys
  private KeyType key1;
  // instance variable for values
  private ValueType ValueType1;

  // getter method for keys
  public KeyType getKey1() {
    return key1;

  }// setter method for keys

  public void setKey1(KeyType key1) {
    this.key1 = key1;
  }

  // getter method for values
  public ValueType getValueType1() {
    return ValueType1;
  }

  // setter method for values
  public void setValueType1(ValueType valueType1) {
    ValueType1 = valueType1;
  }

  // constructor with key1 and valueType1 as parameters
  public HTentry(KeyType key1, ValueType valueType1) {
    this.key1 = key1;
    this.ValueType1 = valueType1;
    // ValueType1 = valueType1;
  }


}
