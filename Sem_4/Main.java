package Sem_4;

public class Main {
  public static void main(String[] args) {
    String str1 = "A";
    String str2 = "B";
    String str3 = "C";

    System.out.println(str1.hashCode()); // от одного и того же значения мы получаем один и тот же хеш-код -- 65
    System.out.println(str1.hashCode()); // от одного и того же значения мы получаем один и тот же хеш-код -- 65
    System.out.println(str1.hashCode()); // от одного и того же значения мы получаем один и тот же хеш-код -- 65
    System.out.println(str1.hashCode()); // от одного и того же значения мы получаем один и тот же хеш-код -- 65
    System.out.println();
    System.out.println(str2.hashCode());
    System.out.println(str3.hashCode());
  }
}
