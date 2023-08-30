package Seminar2;

import java.util.Random;

public class Seminar2 {
    public static void main(String[] args) {

        int[] array = new int[]{4,6,8,9,11,23,32,2,1,0};
//        int[] array = new int[10];
//        int[] array1 = new int[10];
//        int[] array2 = new int[10];
//        Random randomMy = new Random();
//        for (int i = 0; i < array.length; i++) {
//            array[i] = randomMy.nextInt();
//            array1[i] = randomMy.nextInt();
//            array2[i] = randomMy.nextInt();
//        }



//        for (int num : array) {
//            System.out.println(num);
//        }

        long executionTime = calculateExecutionTime(() -> insertionSort(array));
        System.out.println("Время выполнения insertSort: " + executionTime + " наносекунд");
        long executionTime1 = calculateExecutionTime(() -> bubbleSort(array));
        System.out.println("Время выполнения babbleSort: " + executionTime1 + " наносекунд");
        long executionTime2 = calculateExecutionTime(() -> quickSort(array, 0, 9));
        System.out.println("Время выполнения quickSort: " + executionTime2 + " наносекунд");


        System.out.println(binarySearch(array, 8, 0, 9));
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

//    Функция высшего порядка, считающая затраченное время.
    public static long calculateExecutionTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        return executionTime;
    }


    // https://habr.com/ru/articles/204600/
/*    Задание 1 (тайминг 10 минут)
            1. Необходимо написать один из простых алгоритмов сортировки,
    имеющий сложность O(n2).
            2. Можно выбрать из пузырьковой сортировки, сортировки вставками и
    сортировки выбором.
            3. Следует обратить внимание на сложность данных алгоритмов и
    указать признаки квадратичной сложности для каждого из них.*/
// пузырьковая сортировка

        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // меняем местами arr[j] и arr[j + 1]
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

    // Сортировка вставкой.
    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            // Сдвигаем все элементы больше key на одну позицию вправо
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }

    // еще один вариант.
/*    void Sort(int* arr,int n){
        for(int i=1;i<n;i++){
            for(int j=i; j>0 && arr[j-1]>arr[j];j--){
                int tmp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=tmp;
            }
        }
*/
  /*  Задание 2 (тайминг 20 минут)
            1.Написать алгоритм быстрого поиска (quicksort).
*/

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

//    Задание 4 (тайминг 15 минут)
//            1.После успешной сортировки массива на нем можно использовать бинарный
//    поиск. Необходимо реализовать алгоритм бинарного поиска по
//    элементам.
//2.Стоит акцентировать внимание, что т.к. алгоритм использует подход
//«разделяй и властвуй», его удобно писать с помощью рекурсии.
//            3.Так что стоит акцентировать внимание на алгоритмическую сложность
//    данного алгоритма, что его выполнение многократно быстрее простого
//    перебора на больших массивах

    public static int binarySearch (int[] array, int value, int min, int max){
        int midpoint;

        if (max < min){
            return -1;
        }else {
            midpoint = (max - min) / 2 + min;
        }
        if (array[midpoint] < value){
            return binarySearch(array, value, midpoint + 1, max);
        } else {
            if (array[midpoint] > value){
                return binarySearch(array, value, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }
}
