/* Java1 - lesson3
@author Gurjeva AD
@version 16.01.2022
* */

package lesson3;

import java.util.Arrays;

class Lesson3 {
    public static void main(String[] args) {
        /* Первые 4 задачи не стала переписывать через методы, поскольку неясно, требуется ли,
        чтобы эти методы МЕНЯЛИ переданный массив (согласно условию) (void) - или чтобы возвращали
        новый (int[]). С учетом комментария про "никогда не модифицируйте параметры" - возвращение
        нового массива не вполне соответствует формулировке этих задач, где явно подразумевается
        их изменение.
        *
        * */

        /*Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        int[] arr = {1, 0, 1, 0, 0, 1, 1, 1};
        for (int i=0; i<arr.length; i++) arr[i] = arr[i] == 0 ? 1:0;
        //Проверка:
        System.out.println("Check task 1");
        System.out.println(Arrays.toString(arr));

        /*Задать пустой целочисленный массив длиной 100.
        С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;*/
        int[] arr2 = new int[100];
        for (int i=1; i<101; i++) arr2[i-1] = i;
        //Проверка:
        System.out.println("Check task 2");
        System.out.println(Arrays.toString(arr2));

        /*Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        и числа меньшие 6 умножить на 2;*/
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i=0; i<arr3.length; i++) arr3[i] = arr3[i] < 6 ? arr3[i] * 2 : arr3[i];
        //Проверка:
        System.out.println("Check task 3");
        System.out.println(Arrays.toString(arr3));

        /*Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
        если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
        индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
        * */
        int n = 10;
        int[][] arr2d = new int[n][n];
        for (int i=0, k=n-1; i<n; i++, k--){
            arr2d[i][i] = 1;
            arr2d[i][k] = 1;

            }
        //Проверка:
        System.out.println("Check task 4");
        for (int i=0; i<n; i++) System.out.println(Arrays.toString(arr2d[i]));

        //Проверка:
        System.out.println("Check task 5");
        System.out.println(Arrays.toString(makeArrayWithValue(5, 1)));

        //Проверка:
        System.out.println("Check task 6");
        int[] arr6 = {1, 2, 8, 0, 0, -12, 56, 0};
        System.out.println("min: "+ findMinArray(arr6));
        System.out.println("max: "+ findMaxArray(arr6));

        //Проверка:
        System.out.println("Check task 7");
        int[] testArr1 = {2, 2, 2, 1, 2, 2, 10, 1};  // must be true
        System.out.println(isContainsEqualSum(testArr1));
        int[] testArr2 = {1, 1, 1, 2, 1};  // must be true
        System.out.println(isContainsEqualSum(testArr2));
        int[] testArr3 = {1, 2, 4}; // must be false
        System.out.println(isContainsEqualSum(testArr3));

        //Проверка:
        System.out.println("Check task 8");
        int[] arr8 = {1, 2, 3};
        System.out.println("test array:");
        System.out.println(Arrays.toString(arr8));
        System.out.println("test for range from 0 to 8 (not including 8)");
        for (int i=0; i<8; i++) System.out.println(i + ": " + Arrays.toString(arrMoveN(arr8, i)));
        System.out.println("test for range from -7 to 0 (not including 0)");
        for (int i=-7; i<0; i++) System.out.println(i + ": " + Arrays.toString(arrMoveN(arr8, i)));

        System.out.println("test array:");
        int[] arr82 = {3, 5, 6, 1};
        System.out.println(Arrays.toString(arr82));
        System.out.println(Arrays.toString(arrMoveN(arr82, -2)));

        }

        /*Написать метод, принимающий на вход два аргумента: len и initialValue,
        и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;*/
    static int[] makeArrayWithValue(int len, int initialValue){
        int[] arr = new int[len];
        for (int i=0; i<len; i++) arr[i] = initialValue;
        return arr;
    }

    /*Задать одномерный массив и найти в нем минимальный и максимальный элементы*/
    static int findMinArray(int[] arr){ // we agree that arr is not empty
        int min = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) min = min > arr[i] ? arr[i] : min; // better Math.min(min, arr[i]
        return min;

    }

    static int findMaxArray(int[] arr){ // we agree that arr is not empty
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) max = max < arr[i] ? arr[i] : max; // better Math.max(max, arr[i]
        return max;

    }

    /*Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры:
    checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
    checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1

    граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
    */

    static boolean isContainsEqualSum(int[] arr){
        for (int i=0; i<arr.length; i++){
            if (sumUntilInd(arr, i) == sumAfterInd(arr, i)) return true;
        }
        return false;

    }

    static int sumUntilInd(int[] arr, int ind){  // it should be private (but we are told to not use it)
        int s=0;
        for (int i=0; i<=ind; i ++) s+= arr[i];
        return s;

    }

    static int sumAfterInd(int[] arr, int ind){  // it should be private (but we are told to not use it)
        int s=0;
        for (int i=ind+1; i<arr.length; i++) s+= arr[i];
        return s;

    }

    /*Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива
    на n позиций.
    Элементы смещаются циклично.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    [ 1, 2, 3 ] при n = 2 (на 2 вправо) -> [ 2, 3, 1 ];
    [ 1, 2, 3 ] при n = 3 (на 3 вправо) -> [ 1, 2, 3 ];
    [ 1, 2, 3 ] при n = 6 (на 6 вправо) -> [ 1, 2, 3 ];

    [ 1, 2, 3 ] при n = -1 (на 1 влево) -> [ 2, 3, 1 ];
    [ 1, 2, 3 ] при n = -2 (на 2 влево) -> [ 3, 1, 2 ];
    [ 1, 2, 3 ] при n = -3 (на 3 влево) -> [ 1, 2, 3 ];
    [ 1, 2, 3 ] при n = -6 (на 6 влево) -> [ 2, 3, 1 ];



    [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    При каком n в какую сторону сдвиг можете выбирать сами.
     */
    static int[] arrMoveN(int[] arr, int n){
        int l = arr.length;
        if (n==l || n==0) return arr;
        if (n>l) return arrMoveN(arr, n%l);
        if (n<0) {
            if ((-1)*n>l) return arrMoveN(arr, n%l);
            return arrMoveN(arr, l+n);
        }
        int[] res = new int[l];
        for (int i=0; i<l; i++){
            if (i + n < l) res[i+n] = arr[i];
            else res[(i+n)%l] = arr[i];
        }
        return res;

    }


}
