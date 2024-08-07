class Node {
    int info;
    Node next;

    Node(int data) {
        this.info = data;
        this.next = null;
    }
}

public class SortLinkedList {

    static void printList(Node first) {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node merge(Node left, Node right) {

        if (left == null) return right;
        if (right == null) return left;

        Node result;
        
        if (left.info <= right.info) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    // Function to find the middle of the linked list
    static Node findMiddle(Node first) {
        if (first == null || first.next == null) {
            return first;
        }

        Node slow = first;
        Node fast = first.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Function to perform merge sort on the linked list
    static Node mergeSort(Node first) {
        // Base case: if the list is empty or has only one element
        if (first == null || first.next == null) {
            return first;
        }

        // Find the middle of the list
        Node middle = findMiddle(first);
        Node nextOfMiddle = middle.next;

        // Split the list into two halves
        middle.next = null;

        // Recursively sort the two halves
        Node left = mergeSort(first);
        Node right = mergeSort(nextOfMiddle);

        // Merge the sorted halves
        Node sortedList = merge(left, right);

        return sortedList;
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 5 -> 3 -> 7 -> 2 -> 1
        Node first = new Node(5);
        first.next = new Node(3);
        first.next.next = new Node(7);
        first.next.next.next = new Node(2);
        first.next.next.next.next = new Node(1);

        // Print the original list
        System.out.println("Original linked list:");
        printList(first);

        // Sort the linked list
        Node sortedfirst = mergeSort(first);

        // Print the sorted list
        System.out.println("Sorted linked list:");
        printList(sortedfirst);
    }
}
