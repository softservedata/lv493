/*
 * Task 88г) Приписать по единице в начало и в конец записи числа n.
 */
package com.gmail.okstrishch;

import java.util.Scanner;

/**
 * Class about solution task 88г.
 */
  final class Exercise88 {
    /**
     * Default constructor.
     */
    private Exercise88() {
    }
/*
 * Scanner work with console.
 * This solution added 1 first and end to enter integer number.
 */
    public static void main(final String[] args) {
    System.out.println(addNumberTo(scanConsole()));
    }
    static int scanConsole() {
        Scanner enter = new Scanner(System.in);
        System.out.println("Entere number, please: ");
        int num =  enter.nextInt();
        enter.close();
        return num;
    }
    public static int addNumberTo(int num) {
        String text = String.valueOf(num);
        String textAddNum = "1" + text + "1";
        num = Integer.parseInt(textAddNum);
        return num;
    }

}
