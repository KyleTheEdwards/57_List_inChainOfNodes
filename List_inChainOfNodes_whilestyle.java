/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes_whilestyle{
  private Node headReference;

    /**
      Construct an empty list
     */
  public List_inChainOfNodes_whilestyle(){
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
      retString += currentReference.getCargoReference().toString() + ", ";
      currentReference = currentReference.getReferenceToNextNode();
    }
    return retString + "]";
  }


    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
  public boolean addAsHead( Object val) {
    return add(val, 0);
  }

  private Node getNode(int element){
    if (element < 0) return headReference;
    Node currentNode = headReference.getReferenceToNextNode();
    for(int x = 0; x < element; x++){
      currentNode = currentNode.getReferenceToNextNode();
    }

    return currentNode;
  }

  public Object get(int element){
    return getNode(element).getCargoReference();
  }

  public Object set(Object val, int position){
    Node currentNode = getNode(position);
    Object toReturn = currentNode.getCargoReference();
    Node newNode = new Node(val, currentNode.getReferenceToNextNode());
    getNode(position-1).setReferenceToNextNode(newNode);
    return toReturn;
  }

  public boolean add(Object val, int position){
    Node prevNode = getNode(position-1);
    Node newNode = new Node(val, prevNode.getReferenceToNextNode());
    prevNode.setReferenceToNextNode(newNode);
    return true;
  }

  public void remove(int position){
    Node prevNode = getNode(position-1);
    Node newNode = getNode(position+1);

    prevNode.setReferenceToNextNode(newNode);
  }
}
