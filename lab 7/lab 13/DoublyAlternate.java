class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    
    void deleteAlternateNodes() {
        if (head == null) return;

        Node current = head;
        boolean delete = false;

        while (current != null && current.next != null) {
            if (delete) {
                Node nodeToDelete = current.next;
                current.next = nodeToDelete.next;
                if (nodeToDelete.next != null) {
                    nodeToDelete.next.prev = current;
                }
                nodeToDelete = null;
            } else {
                current = current.next;
            }
            delete = !delete;
        }

        
        if (delete) {
            if (current.prev != null) {
                current.prev.next = null;
            } else {
                head = null;
            }
        }
    }
}

public class DoublyAlternate {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);

        System.out.println("Original list:");
        list.printList();

        list.deleteAlternateNodes();

        System.out.println("List after deleting alternate nodes:");
        list.printList();
    }
}
