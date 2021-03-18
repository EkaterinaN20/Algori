package Lesson8;

import java.util.Map;
import java.util.Objects;

public class HashTableChain<K, V> implements HashTable<K, V> {


    static class Item<K, V> implements Entry<K,V> {

            private final K key;
            private int hash;
            private V value;
            private Item<K, V> next;

        public void setNext(K key, V value) {
            this.next = new Item(key, value);
        }

        public Item<K, V> getNext() {
            return next;
        }



        public Item(K key, V value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }

            public void resetNext(Item item) {
            this.next = item;
            }

            @Override
            public String toString() {
                return "Item{" +
                        "key=" + key +
                        ", value=" + value +
                        '}';
            }

            public final int hashCode() {
                return Objects.hashCode(key) ^ Objects.hashCode(value);
            }

            @Override
            public final K getKey() {
                return key;
            }

            @Override
            public V getValue() {
                return value;
            }

            @Override
            public V setValue(V newValue) {
                V oldValue = value;
                value = newValue;
                return oldValue;
            }

            public final boolean equals(Object o) {
                if (o == this)
                    return true;
                if (o instanceof Map.Entry) {
                    Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                    if (Objects.equals(key, e.getKey()) &&
                            Objects.equals(value, e.getValue()))
                        return true;
                }
                return false;
            }
        }

    private final HashTableChain.Item<K, V>[] data;
    private int size;

    public HashTableChain(int maxSize) {
        this.data = new HashTableChain.Item[maxSize * 2];
    }

    @SuppressWarnings("unchecked")

        private int hashFunc(K key) {
            return key.hashCode() % data.length;
        }

        @Override
        public boolean put(K key, V value) {
            int index = hashFunc(key);
            if (data[index] == null) {
                size++;
                data[index] = new Item<>(key, value);
                return true;
            } else {
                Item next = data[index];
                while (next.getNext() != null) {
                    next = next.getNext();
                }
                next.setNext(key, value);
                size++;
                return true;
            }
        }

        @Override
        public V get(K key) {
            int index = indexOf(key);
          //  System.out.println(index);
            if (index != -1) {
                    if (key.equals(data[index].getKey())) {
                        return data[index].getValue();}
                    else {
                        Item item;
                        if (data[index].getNext()!= null) {
                            item = data[index];
                            //System.out.println(next);
                            while (item.next != null) {
                                item = item.getNext();
                                if (key.equals(item.getKey())) {
                                  //  System.out.println(item + "!!!");
                                    return (V) item.getValue();
                                }
                            }
                        }
                    }
                }
            return null;
        }

        private int indexOf(K key) {
            int index = hashFunc(key);
           // System.out.println(index);
            if (data[index] == null) {
                return -1;
            }
            Item<K, V> item = data[index];
                if (item.getKey().equals(key))
                {
                  //  System.out.println(index + "!");
                    return index;}
                    Item next;
                        if (data[index]!= null) {
                           // System.out.println(data[index]);
                            if (data[index].getNext() != null) {
                                next = data[index].getNext();
                               // System.out.println(next);
                                while (next!= null) {
                                    if (next.getKey().equals(key)) {
                                    // System.out.println(index+ "!!");
                                        return index;
                                    }
                                    next = next.getNext();
                                }
                            }
                        }
            //System.out.println(index);
            return -1;
        }

        @Override
        public V remove(K key) {
            int index = hashFunc(key);
            if (data[index] != null) {
            if (data[index].getKey().equals(key)) {
                Item item = data[index];
                Item removed = item;
               data[index] = data[index].getNext();
               size--;
               return (V) removed.getValue();
            }
                Item item = data[index];
                Item previous = null;
                while (item.next != null) {
                  //  System.out.println(key);
                    if (item.getKey().equals(key)) {
                      //  System.out.println(key);
                        Item removed = item;
                        previous.resetNext(item.getNext());
                        size--;
                        return (V) removed.getValue();
                    }
                    previous = item;
                    item = item.getNext();

                }
            }
            System.out.println("No element with this key: " + key);
            return null;
        }


        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public void display() {
            System.out.println("----------");
            for (int i = 0; i < data.length; i++) {
                if (data[i] != null) {
                System.out.printf("%d = [%s]", i, data[i]);
                Item next;
                if (data[i].getNext()!= null) {
                    next = data[i].getNext();
                    while (next != null) {
                        System.out.printf(" [%s]", next);
                        next = next.getNext();
                    }
                }
                System.out.println();
                    System.out.println("----------");
            }
        }
        }
    }
