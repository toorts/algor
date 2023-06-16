package hw_3;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(1);
        linkedList.addFirst(33);
        linkedList.addFirst(132);
        linkedList.addFirst(20);
        linkedList.printList();

        linkedList.reverse();

        linkedList.printList();
    }
}
