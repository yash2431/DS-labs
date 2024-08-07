class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListSwap {
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

    // Function to swap every two consecutive nodes
    public void swapConsecutiveNodes() {
        // Dummy node to handle edge cases and simplify swaps
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move to the next pair
            prev = first;
        }

        // Update head to be the new first node after swapping
        head = dummy.next;
    }

    public static void main(String[] args) {
        LinkedListSwap list = new LinkedListSwap();
        
        // Initialize the linked list with given data
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int num : input) {
            list.append(num);
        }

        System.out.println("Original list:");
        list.printList();

        // Swap consecutive nodes
        list.swapConsecutiveNodes();

        System.out.println("List after swapping consecutive nodes:");
        list.printList();
    }
}
