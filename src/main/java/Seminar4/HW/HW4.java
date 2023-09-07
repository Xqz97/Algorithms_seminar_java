package Seminar4.HW;

public class HW4 {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        // Добавляем элементы в дерево
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);

        // Выводим дерево на экран
        System.out.println("Левостороннее красно-черное дерево:");
        printTree(tree.root);
    }

    // Метод для печати дерева (обход в порядке инфикса)
    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    static class Node {
        int data; // Значение узла
        Node left, right; // Левый и правый потомки
        int color; // Цвет узла (0 - черный, 1 - красный)

        // Конструктор узла
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Определяем класс для самого дерева
    static class RedBlackTree {
        private Node root; // Корень дерева

        // Метод для добавления элемента в дерево
        public void insert(int data) {
            root = insertHelper(root, data); // Вызов вспомогательного рекурсивного метода для вставки элемента
            root.color = 0; // Корень всегда черный
        }

        // Вспомогательный рекурсивный метод для вставки элемента
        private Node insertHelper(Node root, int data) {
            // Если дерево пустое, создаем новый узел и возвращаем его
            if (root == null) {
                return new Node(data);
            }

            // Вставляем элемент в дерево по правилам бинарного поиска
            if (data < root.data) {
                root.left = insertHelper(root.left, data);
            } else if (data > root.data) {
                root.right = insertHelper(root.right, data);
            } else {
                // Если элемент уже существует, ничего не делаем
                return root;
            }

            // Балансируем дерево после вставки элемента
            if (isRed(root.right) && !isRed(root.left)) {
                root = rotateLeft(root);
            }
            if (isRed(root.left) && isRed(root.left.left)) {
                root = rotateRight(root);
            }
            if (isRed(root.left) && isRed(root.right)) {
                flipColors(root);
            }

            return root;
        }

        // Метод для проверки цвета узла
        private boolean isRed(Node node) {
            if (node == null) {
                return false; // Пустые узлы считаются черными
            }
            return node.color == 1;
        }

        // Метод для выполнения левого поворота вокруг узла
        private Node rotateLeft(Node root) {
            Node newNode = root.right;
            root.right = newNode.left;
            newNode.left = root;
            newNode.color = root.color;
            root.color = 1;
            return newNode;
        }

        // Метод для выполнения правого поворота вокруг узла
        private Node rotateRight(Node root) {
            Node newNode = root.left;
            root.left = newNode.right;
            newNode.right = root;
            newNode.color = root.color;
            root.color = 1;
            return newNode;
        }

        // Метод для изменения цветов узлов
        private void flipColors(Node root) {
            root.color = 1;
            root.left.color = 0;
            root.right.color = 0;
        }
    }
}