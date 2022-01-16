/* JAVA-1 lesson2
@version 13.01.2022
@author Gurjeva AD
* */

package lesson2;

class Lesson2 {
    public static void main(String[] args) {
        System.out.println(isBetween10And20(10, 0));
        isPositive(-1);
        System.out.println(isNegative(9));
        printString(5, "JAVA");

        // to check different cases
        System.out.println(isWisYear(2000));
        System.out.println(isWisYear(1));
        System.out.println(isWisYear(2100));
        System.out.println(isWisYear(500));
        System.out.println(isWisYear(440));
    }

    /*
    Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false.
    */
    static boolean isBetween10And20(int a, int b) {
        int s = a + b;
        return s >= 10 && s <= 20;
    }

    /* Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    * положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом. */
    static void isPositive(int a){
        System.out.println(a >= 0 ? "положительное":"отрицательное");
    }

    /* Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное. */
    static boolean isNegative(int a){
        return a < 0;
    }

    /* Написать метод, которому в качестве аргументов передается строка и число,
    метод должен отпечатать в консоль указанную строку, указанное количество раз;
    */
    static void printString(int n, String s){
        for (; n > 0; n--) System.out.println(s);
    }

    /* Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true,
     * не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го,
     * при этом каждый 400-й – високосный.*/
    static boolean isWisYear(int year){
        if (year % 400 == 0) return true;
        else if (year % 100 == 0) return false;
        else return year % 4 == 0;
    }

}
