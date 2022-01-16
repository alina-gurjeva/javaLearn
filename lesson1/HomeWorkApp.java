package lesson1;

class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

    }

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    static void checkSumSign() {
        int a = 0;
        int b = 1;
        int s = a + b;
        if (s >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    static void printColor() {
        int value = 888;
        if (value <= 0) System.out.println("Красный");
        else if (value <= 100) System.out.println("Желтый");
        else System.out.println("Зеленый");
    }

    static void compareNumbers() {
        int a = 0;
        int b = 1;
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}
