package Seminar3;

public class Seminar3 {

//    1.Реализуем простой односвязный список.
//    2.Пишем только структуру, никаких методов не требуется.

    public class SinglyLinkedList {
        private Node head;

        public SinglyLinkedList() {
            this.head = null;
        }

        private static class Node {
            private int value;
            private Node next;

            public Node(int value) {
                this.value = value;
                this.next = null;
            }
        }

        //    1.Реализуем метод добавления новых элементов в начало списка и удаление
//    первого элемента связного списка.
//            2.Односвязный список всегда имеет ссылку на первый элемент
//    последовательности, потому именно с реализации методов для первого
//    элемента последовательности стоит начать.
        public void addFirst(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        public void remove(int value) {
            if (head == null) {
                return;
            }

            if (head.value == value) {
                head = head.next;
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.value == value) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }

        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }

        //    1.Реализуем метод поиска элемента в односвязном списке для проверки наличия
//    элемента внутри списка.
//2.Для корректной работы со связным список необходимо понимать, как именно
//    можно обходить все значения внутри связного списка.
//3.Для нашего примера проще всего будет написать метод поиска значения в
//    связном списке и возвращения из метода информации о наличии искомого
//    внутри списка.
        public boolean search(int value) {
            Node current = head;
            while (current != null) {
                if (current.value == value) {
                    return true; // Значение найдено в списке
                }
                current = current.next;
            }
            return false; // Значение не найдено в списке
        }

//    1.Реализуем метод добавления новых элементов в конец списка и удаление
//    последнего элемента связного списка.
//            2.Теперь, когда мы понимаем, как можно искать значения внутри связного списка,
//    мы можем сделать методы добавления и удаления элементов в конец нашего
//    односвязного списка.


        public void removeLast() {
            if (head == null) {
                return; // Список пуст, ничего не удаляем
            } else if (head.next == null) {
                head = null; // В списке только один элемент, удаляем его
            } else {
                Node current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null; // Удаляем ссылку на последний элемент списка
            }
        }

        public void addLast(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        //    1.Добавляем метод сортировки для связного списка.
//            2.Можно использовать любой алгоритм, что мы использовали на предыдущем
//    семинаре, но с точки зрения работы связного списка лучше ориентироваться на
//    пузырьковую сортировку, т.к. она взаимодействует с соседними элементами, а
//    не только по индексам, как делают все остальные сортировки.

        public void bubbleSort() {
            if (head == null || head.next == null) {
                return; // Список пуст или содержит только один элемент, уже отсортирован
            }

            boolean swapped;
            do {
                swapped = false;
                Node previous = null;
                Node current = head;
                Node next = current.next;

                while (next != null) {
                    if (current.value > next.value) {
                        if (previous == null) {
                            // Перестановка первого и второго узла
                            head = next;
                        } else {
                            // Перестановка текущего и следующего узла
                            previous.next = next;
                        }
                        current.next = next.next;
                        next.next = current;
                        // Обновление указателей
                        previous = next;
                        next = current.next;
                        swapped = true;
                    } else {
                        // Перемещение указателей вперед
                        previous = current;
                        current = next;
                        next = next.next;
                    }
                }
            } while (swapped);
        }
    }
}
