package Sem_4;

public class Main {
  public static void main(String[] args) {
    // String str1 = "A";
    // String str2 = "B";
    // String str3 = "C";

    // System.out.println(str1.hashCode()); // от одного и того же значения мы получаем один и тот же хеш-код -- 65
    // System.out.println(str1.hashCode()); // от одного и того же значения мы получаем один и тот же хеш-код -- 65

    // System.out.println();
    // str1 = str1 + str1;
    // System.out.println(str1.hashCode()); 

    // System.out.println();
    // String str4 = "A";
    // System.out.println(str4.hashCode()); // хеш-код вяжется к значению, не к ключу!!! от одного и того же значения мы получаем один и тот же хеш-код -- 65

    // System.out.println();
    // System.out.println(str2.hashCode());
    // System.out.println(str3.hashCode());

    // System.out.println();
    // System.out.println(str3.hashCode());
    // // с использованием нашей функции -  чтобы не выходить за пределы массива
    // System.out.println(Math.abs(str3.hashCode() % 4));

    // System.out.println();

    // HashTable<String, Integer> table = new HashTable();
    // table.add("A", 5);
    // table.print();

    // System.out.println();

    // table.add("B", 15);
    // table.add("C", 2);
    // table.add("D", 2);
    // table.add("F", 3);
    // table.add("E", 9);
    // table.print();

    // System.out.println();

    // table.remove("E");
    // table.print();



    BinTree<Integer> bin_tree = new BinTree<>();
    bin_tree.add(2);
    bin_tree.add(7);
    bin_tree.add(1);
    bin_tree.add(10);
    bin_tree.add(-1);
    bin_tree.add(-10);
    bin_tree.add(8);
    bin_tree.add(16);
    bin_tree.print();
  }
}
