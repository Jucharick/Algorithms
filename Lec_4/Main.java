package Lec_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) {
    final RedBlack_tree tree = new RedBlack_tree();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      while (true) {
        try {
          int value = Integer.parseInt(reader.readLine());
          tree.add(value);
          System.out.println("Ok");
        } catch (Exception ignored){

        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
