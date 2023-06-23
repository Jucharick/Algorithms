package HW_3;

public class LinkedList {
  private Node head;

  public void add(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      return;
    }
    Node currentNode = head;
    while (currentNode.nextNode != null) // останавливаемся на последнем элементе
      currentNode = currentNode.nextNode;
    currentNode.nextNode = newNode;
  }

  public void print() {
    Node currentNode = head;
    System.out.print("[ ");
    while (currentNode != null) {
      System.out.print(currentNode.value + " ");
      currentNode = currentNode.nextNode;
    }
    System.out.println("]");
  }

  public void revert(){
    Node currentNode = head;
    Node previous = null;
    while (currentNode != null) {
      Node next = currentNode.nextNode;
      currentNode.nextNode = previous;
      previous = currentNode;
      if (next == null) {
        head = currentNode;
      }
      currentNode = next;
    }
  }


  class Node { // Node - классическое название для подобных структур
    private int value;
    private Node nextNode;
    private Node previousNode;

    Node(int _value) {
      this.value = _value;
    }
    
  }
}

