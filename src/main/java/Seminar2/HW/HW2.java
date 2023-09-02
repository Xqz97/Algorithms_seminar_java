package Seminar2.HW;

public class HW2 {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;


        sort(arr);

        System.out.println("Отсортированный массив");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }

    }
    // Реализация сортировки кучей.
    public static void sort(int arr[]) {
        int n = arr.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Извлечение элементов из кучи в убывающем порядке
        for (int i = n - 1; i >= 0; i--) {
            // Перемещение текущего корня в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызов max heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // Левый потомок узла i
        int r = 2 * i + 2; // Правый потомок узла i

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно применяем процедуру heapify для поддерева, затронутого нарушением
            heapify(arr, n, largest);
        }
    }
}
