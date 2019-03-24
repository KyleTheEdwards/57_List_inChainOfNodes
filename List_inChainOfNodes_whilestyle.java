/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes_whilestyle{
  private Node headReference;

    /**
      Construct an empty list
     */
  public List_inChainOfNodes(){
    headReference = new Node("Head of list", null);
  }

    /**
      @return the number of elements in this list
     */
  public int size() {
    int size = 0;
    Node currentReference = headReference.getReferenceToNextNode();
    while(currentReference instanceof Node){
      size++;
      currentReference = currentReference.getReferenceToNextNode();
    }

    return size;
  }

    
     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,] 
      */
  public String toString() {
    String retString = "[";
    Node currentReference = headReference.getReferenceToNextNode();
    while(currentReference instanceof Node){
      retString += currentReference.toString() + ", ";
      currentReference = currentReference.getReferenceToNextNode();
    }
    return retString + "]";
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