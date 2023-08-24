package Seminar1;

import java.util.*;

public class Seminar1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int numRandom = rnd.nextInt(100);
        System.out.println("Random number: " + numRandom);
        podbor(numRandom);
        randomGuess(numRandom);
        smartRandomGuessList(numRandom);
        binarySearch(numRandom);
    }

    public static void podbor(int a) {
        for (int i = 0; i < 101; i++) {
            if (i == a) {
                System.out.println("Число отгадано и это" + " " + i);
                break;
            }
        }
    }

    public static void randomGuess(int a) {
        long start = System.nanoTime();
        int k = 0;
        Random rnd1 = new Random();
        int num = rnd1.nextInt(100);
        while (a != num) {
            num = rnd1.nextInt(100);
            k += 1;
        }
        long fin = System.nanoTime();
        System.out.printf("Число подобрано  и это" + " " + num + ", на это ушло %d операций", k);
        System.out.println("Execution time: " + (fin - start) + "nanoseconds" + "\n");
    }

    public static void smartRandomGuessList(int x) {
        long start = System.nanoTime();
        int k = 0;
        List<Integer> sp = new ArrayList<>();
        for (int i = 0; i <= x; i++) {
            sp.add(i);
        }
        int a = 0;
        Random rnd2 = new Random();
        while (x != a) {
            int index = rnd2.nextInt(sp.size());
            a = sp.remove(index);
            k++;
        }
        long fin = System.nanoTime();
        System.out.printf("Число подобрано  и это" + " " + a + ", на это ушло %d операций", k);
        System.out.println("Execution time: " + (fin - start) + "nanoseconds");
    }

    public static int binarySearch(int x) {
        long start = System.nanoTime();
        int k = 1;
        int left = 0;
        int right = 100;
        int current = Math.round((right + left) / 2);
        while (current != x) {
            if (current < x) {
                left = current + 1;
            } else {
                right = current - 1;
            }
            current = Math.round((right + left) / 2);
            k++;
        }
        long end = System.nanoTime();
        System.out.printf("Число подобрано  и это" + " " + current + ", на это ушло %d операций", k);
        System.out.println("Time taken: " + (end - start) + "ns");
        return k;
    }

 /*  1. Необходимо написать алгоритм поиска всех доступных комбинаций
    (посчитать количество) для количества кубиков K с количеством граней N.
    2. У вас есть 2 варианта на выбор – количество кубиков может быть строго
    ограничено (4 кубика, например), либо их количество будет
    динамическим. Выбор за вами.
    3. Если вы реализуете простой вариант, обращает внимание, что данное
    решение имеет сложность O(n4), но если количество кубиков сделать
    переменной, то она трансформируется в O(nk), что будет представлять
    собой экспоненциальную сложность. Для второго решения очевидно, что
    его сложность O(nk) с самого начала.
*/

    public static List<List<Integer>> findCombinations(int K, int N) {
        List<List<Integer>> combinations = new ArrayList<>();
        findCombinationsHelper(new ArrayList<>(), K, N, combinations);
        return combinations;
    }

    public static void findCombinationsHelper(List<Integer> currentCombination, int remainingCubes, int N, List<List<Integer>> combinations) {
        if (remainingCubes == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }
        for (int i = 1; i <= N; i++) {
            currentCombination.add(i);
            findCombinationsHelper(currentCombination, remainingCubes - 1, N, combinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
    public static void cubeStaticCombination (){
    int K = 4; // количество кубиков
    int N = 6; // количество граней

    List<List<Integer>> combinations = findCombinations(K, N);

        System.out.println("Количество комбинаций: " + combinations.size());
        System.out.println("Комбинации: ");
        for (List<Integer> combination : combinations) {
        System.out.println(combination);
    }
}

/*1.Пишем алгоритм поиска нужного числа последовательности Фибоначчи, но в этот раз
    откажемся от рекурсии и воспользуемся обычным алгоритмом, что даст нам
    линейную сложность, т.к. вычисление каждого из чисел последовательности будет
    происходить ровно 1 раз.
*/

    public void fibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println("Число Фибоначчи под номером " + n + " равно " + c);
}
}


