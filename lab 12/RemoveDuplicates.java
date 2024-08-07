class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicates {
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

    // Function to remove duplicates from a sorted linked list
    public void removeDuplicates() {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                // Skip the next node
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        RemoveDuplicates list = new RemoveDuplicates();

        // Initialize the linked list with given data
        int[] input = {1, 1, 6, 13, 13, 13, 27, 27};
        for (int num : input) {
            list.append(num);
        }

        System.out.println("Original list:");
        list.printList();

        // Remove duplicates
        list.removeDuplicates();

        System.out.println("List after removing duplicates:");
        list.printList();
    }
}
