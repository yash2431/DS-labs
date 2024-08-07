class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    
    void printList(Node start) {
        if (start == null) return;
        Node temp = start;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != start);
        System.out.println();
    }

    
    void splitList() {
        if (head == null) return;

        Node slow = head;
        Node fast = head;

        
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        
        if (fast.next.next == head) {
            fast = fast.next;
        }

        
        Node head2 = slow.next;

        
        slow.next = head;
        fast.next = head2;

        System.out.println("First half:");
        printList(head);

        System.out.println("Second half:");
        printList(head2);
    }
}

public class TwoHalves {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);

        System.out.println("Original circular linked list:");
        list.printList(list.head);

        list.splitList();
    }
}
