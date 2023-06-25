package HW_3;

public class LinkedList {
  private Node head;
  private int size;

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

  public void revert(){ // сложность O(n)
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

  private Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node currentNode = head;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.nextNode;
        return currentNode;
    }

    private int getValue(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node currentNode = head;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.nextNode;
        return currentNode.value;
    }

  private void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size)
            return;
        if (index2 < 0 || index2 >= size)
            return;
        Node node1 = this.getNode(index1);
        Node node2 = this.getNode(index2);
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

  public void reverse() { // вариант преподавателя
    for (int i = 0; i < size / 2; i++) {
      swap (i, size - i - 1);
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

