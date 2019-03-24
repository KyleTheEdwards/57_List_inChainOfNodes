/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes_recursion{
  private Node headReference;

  /**
    Construct an empty list
   */
  public List_inChainOfNodes_recursion(){
    headReference = new Node(null, null);
  }

  /**
    @return the number of elements in this list
   */
  public int size() {
    return getSize(headReference.getReferenceToNextNode());
  }

  public int getSize(Node currentNode) {
    if(currentNode == null){
      return 0;
    } else {
      return 1 + getSize(currentNode.getReferenceToNextNode());
    }
  }


   /**
     @return a string representation of this list,
     format:
         # elements [element0,element1,element2,] 
    */
  public String toString() {
    return "[" + toStringRec(headReference.getReferenceToNextNode());
  }

  public String toStringRec(Node currentNode) {
    if(currentNode == null){
      return "]";
    } else {
      return currentNode.toString() + ", " + toStringRec(currentNode.getReferenceToNextNode());
    }
  }


  /**
    Append @value to the head of this list.

    @return true, in keeping with conventions yet to be discussed
   */
  public boolean addAsHead( Object val) {
  Node toAddNode = new Node(val, headReference.getReferenceToNextNode());
  headReference.setReferenceToNextNode(toAddNode);
  return true;
  }
}