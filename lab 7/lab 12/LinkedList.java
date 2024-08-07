class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private ListNode head;

    // Function to add a new node at the end of the list
    public void append(int data) {
        if (head == null) {
            head = new ListNode(data);
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(data);
        }
    }

    // Function to print the linked list
    public void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to swap Kth node from beginning with Kth node from end
    public void swapKthNode(int K) {
        if (head == null || K <= 0) {
            System.out.println("Invalid operation");
            return;
        }

        // Step 1: Find the length of the list
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // If K is greater than the length of the list
        if (K > length) {
            System.out.println("K is greater than the length of the list.");
            return;
        }

        // Step 2: Find the Kth node from the beginning
        ListNode firstPrev = null, first = head;
        for (int i = 1; i < K; i++) {
            firstPrev = first;
            first = first.next;
        }

        // Step 3: Find the Kth node from the end
        ListNode secondPrev = null, second = head;
        for (int i = 1; i < length - K + 1; i++) {
            secondPrev = second;
            second = second.next;
        }

        // If the nodes are the same, no need to swap
        if (first == second) {
            return;
        }

        // Step 4: Swap the nodes
        if (firstPrev != null) {
            firstPrev.next = second;
        } else {
            head = second;
        }

        if (secondPrev != null) {
            secondPrev.next = first;
        } else {
            head = first;
        }

        // Swap the next pointers of the two nodes
        ListNode tempNode = second.next;
        second.next = first.next;
        first.next = tempNode;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.append(9);
        list.append(10);

        System.out.println("Original list:");
        list.printList();

        int K = 3;
        list.swapKthNode(K);

        System.out.println("List after swapping Kth nodes:");
        list.printList();
    }
}
