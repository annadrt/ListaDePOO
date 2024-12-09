
import java.util.List;

class Node {
    int data;
    Node prox;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.prox = null;
        this.prev = null;
    }
}

public class ListaEncandeadaDuplamenteCircular {
    private Node head;
    private Node tail;

    public ListaEncandeadaDuplamenteCircular() {
        this.head = null;
        this.tail = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = tail;
            head.prev = tail;
            tail.next = head;
            tail.prev = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
    }
    
    public void remover(int data) {
        if (head == null) {
            return;
        }

        Node current = head;

        do { 
            if (current.data == data) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;

                    if (current == head) {
                        head = current.next;
                    }
                    if (current == head) {
                        head = current.next;
                        tail = current.prev;
                    }
                }
                return;
            }
            current = current.next;
         } while (current != head); 
    }

    public void display () {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Node current = head;
        do { 
            System.out.println(current.data + " ");
            current = current.next; 
        } while (current != head);
        System.out.println();
    }
    
    public boolean search(int data) {
        if (head == null) {
            return false;
        }

        Node current = head;
        do { 
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != head);

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        ListaEncandeadaDuplamenteCircular = new ListaEncandeadaDuplamenteCircular();

        List.add(10);
        List.add(20);
        List.add(30);
        List.display();

        List.remove(20);
        List.display();

        System.out.println("Procurar 30: " + List.search(30));
        System.out.println("Search 50: " + List.search(50));
    }
}
