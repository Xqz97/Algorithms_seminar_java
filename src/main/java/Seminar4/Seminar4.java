package Seminar4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Seminar4 {

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("key1", 10);
        hashMap.put("key2", 20);
        hashMap.put("key3", 30);

        System.out.println(hashMap.get("key2")); // Выводит 20

        hashMap.remove("key2");

        System.out.println(hashMap.get("key2")); // Выводит null, так как "key2" был удален
    }


    //_______________________________________________________________________________________________________________
    // Создаем класс для пары ключ значение, и мы к нему сразу можем обращаться.
    // Также используем дженерики, для того, чтобы обезопасить код со стороны типов класса.
    class KeyValuePair<K, V> {
        private K key; // Ключ
        private V value; // Значение

        public KeyValuePair(K key, V value) {
            this.key = key; // Инициализация ключа
            this.value = value; // Инициализация значения
        }

        public K getKey() {
            return key; // Возвращает ключ
        }

        public V getValue() {
            return value; // Возвращает значение
        }
    }

    // Класс для узла списка
    class Node<K, V> {
        private K key; // Ключ
        private V value; // Значение
        private Node<K, V> next; // Ссылка на следующий узел

        public Node(K key, V value) {
            this.key = key; // Инициализация ключа
            this.value = value; // Инициализация значения
            this.next = null; // Инициализация ссылки на следующий узел
        }

        public K getKey() {
            return key; // Возвращает ключ
        }

        public V getValue() {
            return value; // Возвращает значение
        }

        public Node<K, V> getNext() {
            return next; // Возвращает ссылку на следующий узел
        }

        public void setNext(Node<K, V> next) {
            this.next = next; // Устанавливает ссылку на следующий узел
        }
    }

    class LinkedList<K, V> {
        private Node<K, V> head; // Головной узел списка

        public LinkedList() {
            head = null; // Инициализация пустого списка
        }

        public void insert(K key, V value) {
            Node<K, V> newNode = new Node<>(key, value); // Создание нового узла

            if (head == null) {
                head = newNode; // Если список пуст, новый узел становится головным
            } else {
                Node<K, V> current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode); // Добавление нового узла в конец списка
            }
        }

        public V search(K key) {
            Node<K, V> current = head;
            while (current != null) {
                if (current.getKey().equals(key)) {
                    return current.getValue(); // Поиск значения по ключу
                }
                current = current.getNext();
            }
            return null; // Если ключ не найден, возвращается null
        }

        public void delete(K key) {
            if (head != null && head.getKey().equals(key)) {
                head = head.getNext(); // Если ключ находится в головном узле, головной узел изменяется на следующий узел
                return;
            }

            Node<K, V> prev = null;
            Node<K, V> current = head;
            while (current != null) {
                if (current.getKey().equals(key)) {
                    prev.setNext(current.getNext()); // Удаление узла, если ключ найден
                    return;
                }
                prev = current;
                current = current.getNext();
            }
        }
    }
    // ______________________________________________________________________________________________________________
    // **Создание хэш-таблицы и функций для работы с ней**
    class HashTable<K, V> {
        private ArrayList<Map<K, V>> buckets;
        private int numBuckets;

        public HashTable(int numBuckets) {
            this.numBuckets = numBuckets;

            buckets = new ArrayList<>(numBuckets);
            for (int i = 0; i < numBuckets; i++) {
                buckets.add(new HashMap<>());
            }
        }

        private int getHash(K key) {
            int hashCode = key.hashCode();
            int index = hashCode % numBuckets;
            return (index >= 0) ? index : index + numBuckets;
        }

        public void put(K key, V value) {
            int bucketIndex = getHash(key);
            Map<K, V> bucket = buckets.get(bucketIndex);
            bucket.put(key, value); // Использование метода put() HashMap для добавления пары ключ-значение
        }

        public V get(K key) {
            int bucketIndex = getHash(key);
            Map<K, V> bucket = buckets.get(bucketIndex);
            return bucket.get(key); // Использование метода get() HashMap для получения значения по ключу
        }

        public void remove(K key) {
            int bucketIndex = getHash(key);
            Map<K, V> bucket = buckets.get(bucketIndex);
            bucket.remove(key); // Использование метода remove() HashMap для удаления пары ключ-значение
        }
    }

}


