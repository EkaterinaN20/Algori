package Lesson8;

public class HW8main {
    public static void main(String[] args) {
    HashTableChain<Product, Integer> hashTable = new HashTableChain<>(5);//5 * 2 = 10

           hashTable.put(new Product(1, "Orange"), 150);
           hashTable.put(new Product(77, "Banana"), 100);
           hashTable.put(new Product(77, "Carrot"), 228);
           hashTable.put(new Product(60, "Lemon"), 250);
           hashTable.put(new Product(52, "Milk"), 120);
           hashTable.put(new Product(21, "Potato"), 67);
            hashTable.put(new Product(21, "Onion"), 15);
           hashTable.put(new Product(77, "Apple"), 10);

        System.out.println("Size is " + hashTable.size());
        hashTable.display();

        System.out.println("Cost guava is " + hashTable.get(new Product(13, "Guava")));
        System.out.println("Cost lemon is " + hashTable.get(new Product(60, "Lemon")));
        System.out.println("Cost orange is " + hashTable.get(new Product(1, "Orange")));
        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost milk is " + hashTable.get(new Product(52, "Milk")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(77, "Carrot")));
        System.out.println("Cost apple is " + hashTable.get(new Product(77, "Apple")));

        System.out.println();
        System.out.println("------");
        hashTable.remove(new Product(13, "Guava"));
        hashTable.remove(new Product(21, "Potato"));
        hashTable.remove(new Product(77, "Banana"));

        System.out.println();
        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(77, "Carrot")));

        System.out.println();
        System.out.println("Size is " + hashTable.size());
        hashTable.display();
}
}
