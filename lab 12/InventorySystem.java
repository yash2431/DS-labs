import java.util.Scanner;

class ListNode {
    String code; // To store category or product code
    int inStock; // To store stock value
    ListNode next; // To store the next node

    ListNode(String code, int inStock) {
        this.code = code;
        this.inStock = inStock;
        this.next = null;
    }
}

public class InventorySystem {
    private ListNode mainCategoryHead; // Head node for main categories
    private ListNode subCategoryHead; // Head node for sub-categories
    private ListNode productHead; // Head node for products

    // Function to add an item with the given code and stock value
    public void addItem(String code, int n) {
        String ab = code.substring(0, 2);
        String cd = code.substring(2, 4);
        String ef = code.substring(4, 6);

        // Add/update in main category list
        ListNode mainCategoryNode = findOrCreate(mainCategoryHead, ab, true);
        // Add/update in sub-category list
        ListNode subCategoryNode = findOrCreate(mainCategoryNode.next, cd, true);
        // Add/update in product list
        findOrCreate(subCategoryNode.next, ef, false).inStock += n;

        // Clean up zero stock nodes
        cleanupZeroStock(productHead);
        cleanupZeroStock(subCategoryHead);
        cleanupZeroStock(mainCategoryHead);
    }

    // Function to find or create a node with the given code
    private ListNode findOrCreate(ListNode head, String code, boolean isCategory) {
        if (head == null) {
            return new ListNode(code, 0);
        }

        ListNode current = head;
        do {
            if (current.code.equals(code)) {
                return current;
            }
            current = current.next;
        } while (current != head);

        // Create new node if not found
        ListNode newNode = new ListNode(code, 0);
        if (head == null) {
            head = newNode;
            head.next = head; // Circular link
        } else {
            ListNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }

        return newNode;
    }

    // Function to remove zero stock nodes
    private void cleanupZeroStock(ListNode head) {
        if (head == null) return;

        ListNode current = head;
        ListNode prev = null;

        do {
            if (current.inStock <= 0) {
                if (prev == null) {
                    // Removing head
                    ListNode temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = current.next;
                }
                current = prev != null ? prev.next : head;
            } else {
                prev = current;
                current = current.next;
            }
        } while (current != head);
    }

    // Function to merge two main categories
    public void mergeCategories(int n, int m) {
        ListNode first = getNodeAt(mainCategoryHead, n);
        ListNode second = getNodeAt(mainCategoryHead, m);

        if (first == null || second == null) return;

        String code1 = first.code;
        String code2 = second.code;

        // Check if merge is allowed
        if (code1.charAt(0) != code2.charAt(0)) return;

        String newCode = code1.charAt(1) < code2.charAt(1) ? code1.charAt(1) + "" + code2.charAt(1) : code2.charAt(1) + "" + code1.charAt(1);
        ListNode newCategory = findOrCreate(mainCategoryHead, newCode, true);

        // Merge sub-categories and products
        mergeSubCategoriesAndProducts(first.next, second.next, newCategory);

        // Remove second category
        removeNode(mainCategoryHead, second.code);
    }

    // Function to merge sub-categories and products
    private void mergeSubCategoriesAndProducts(ListNode first, ListNode second, ListNode mergedCategory) {
        ListNode firstSub = first;
        ListNode secondSub = second;

        while (firstSub != null) {
            findOrCreate(mergedCategory.next, firstSub.code, true).inStock += firstSub.inStock;
            firstSub = firstSub.next;
        }

        while (secondSub != null) {
            findOrCreate(mergedCategory.next, secondSub.code, true).inStock += secondSub.inStock;
            secondSub = secondSub.next;
        }
    }

    // Function to get the node at a specific position
    private ListNode getNodeAt(ListNode head, int pos) {
        if (head == null || pos < 1) return null;
        ListNode current = head;
        for (int i = 1; i < pos; i++) {
            current = current.next;
            if (current == head) return null;
        }
        return current;
    }

    // Function to remove a node with the given code
    private void removeNode(ListNode head, String code) {
        if (head == null) return;

        ListNode current = head;
        ListNode prev = null;
        do {
            if (current.code.equals(code)) {
                if (prev == null) {
                    ListNode temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Function to print stock of specific categories or products
    public void printStock(String code) {
        ListNode node = findNode(mainCategoryHead, code);
        if (node != null) {
            System.out.println(node.inStock);
        }
        node = findNode(subCategoryHead, code);
        if (node != null) {
            System.out.println(node.inStock);
        }
        node = findNode(productHead, code);
        if (node != null) {
            System.out.println(node.inStock);
        }
    }

    // Function to print all products
    public void printAllProducts() {
        ListNode current = productHead;
        if (current == null) return;
        do {
            System.out.println(current.code + " " + current.inStock);
            current = current.next;
        } while (current != productHead);
    }

    // Function to find a node with the given code
    private ListNode findNode(ListNode head, String code) {
        if (head == null) return null;
        ListNode current = head;
        do {
            if (current.code.equals(code)) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventorySystem inventory = new InventorySystem();

        int N = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < N; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String command = parts[0];

            switch (command) {
                case "I":
                    String code = parts[1];
                    int stock = Integer.parseInt(parts[2]);
                    inventory.addItem(code, stock);
                    break;
                case "M":
                    int n = Integer.parseInt(parts[1]);
                    int m = Integer.parseInt(parts[2]);
                    inventory.mergeCategories(n, m);
                    break;
                case "S":
                    String query = parts[1];
                    inventory.printStock(query);
                    break;
                case "P":
                    inventory.printAllProducts();
                    break;
            }
        }

        scanner.close();
    }
}
