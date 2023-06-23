package Lec_4;

import java.util.List;

public class RedBlack_tree {
  private Node root;
  
  private boolean addNode(Node node, int value) { // все ноды уникальные, если создаем такую же - конфликт
    if (node.value == value) {
      return false;
    } else {
      if (node.value > value) {
        if (node.leftChild != null) { 
          boolean result = addNode(node.leftChild, value); // рекурсивно в глубину
          node.leftChild = rebalance(node.leftChild); // после проверяем нужно ли нам делать ребалансировку
          return result;
        } else { // если левой ноды не существует - генерируем
          node.leftChild = new Node();
          node.leftChild.color = Color.RED; // все ноды при создании получают красный цвет
          node.leftChild.value = value;
          return true;
        }
      } else {
        if (node.rightChild != null) {
          boolean result = addNode(node.rightChild, value);
          node.rightChild = rebalance(node.rightChild);
          return result;
        } else {
          node.rightChild = new Node();
          node.rightChild.color = Color.RED; // все ноды при создании получают красный цвет
          node.rightChild.value = value;
          return true;
        }
      }
    }
  }

  private Node rebalance(Node node){
    Node result = node;
    boolean needRebalance;

    do {
      needRebalance = false;
      if (result.rightChild != null && result.rightChild.color == Color.RED && (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
        needRebalance = true;
        result = rightSwap(result);
      }
      if (result.leftChild != null && result.leftChild.color == Color.RED && result.leftChild.leftChild != null || result.leftChild.leftChild.color == Color.RED) {
        needRebalance = true;
        result = leftSwap(result);
      }
      if (result.leftChild != null && result.leftChild.color == Color.RED && result.rightChild != null || result.rightChild.color == Color.RED) {
        needRebalance = true;
        colorSwap(result);
      }
    }

    return null;
  }

  private Node leftSwap(Node node){
    Node leftChild = node.leftChild;
    Node betweenChild = leftChild.rightChild;
    leftChild.rightChild = node;
    node.leftChild = betweenChild;
    leftChild.color = node.color;
    node.color = Color.RED;
    return leftChild;
  }

  private Node rightSwap(Node node){
    Node rightChild = node.rightChild;
    Node betweenChild = rightChild.leftChild;
    rightChild.leftChild = node;
    node.rightChild = betweenChild;
    rightChild.color = node.color;
    node.color = Color.RED;
    return rightChild;
  }

  private void colorSwap(Node node){
    node.rightChild.color = Color.BLACK;
    node.leftChild.color = Color.BLACK;
    node.color = Color.RED;
  }
  
  
  private class Node {
    private int value;
    private Color color;
    private Node leftChild;
    private Node rightChild;

    @Override 
    public String toString() {
      return "Node {" + "value " + value + ", color " + color + "}";
    }
  }

  private enum Color {
    RED, BLACK
  }
}