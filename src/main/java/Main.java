class Main {

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Member {
    
    public static List<Integer> generateRandomNumbers(int x, int y) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(y - x + 1) + x); // מחולל מספר אקראי בטווח x, y
        }
        return numbers;
    }

    public static int countOccurrences(List<Integer> list, int x) {
        int count = 0;
        for (int num : list) {
            if (num == x) {
                count++;
            }
        }
        return count;
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void printListReverse(Node<Integer> head) {
        if (head == null) {
            return;
        }
        printListReverse(head.getNext());
        System.out.println(head.getValue());
    }
    
    public static void printEvenNumbers(Node<Integer> head) {
        if (head == null) {
            return;
        }
        if (head.getValue() != null && head.getValue() % 2 == 0) {
            System.out.println(head.getValue());
        }
        printEvenNumbers(head.getNext());
    }

    public static Node<Integer> createListFromInput() {
        Node<Integer> list = new Node<>(null);
        Node<Integer> p = list;
        System.out.println("הכנס מספרים או -1 כדי לסיים:");
        int num = scanner.nextInt();
        while (num != -1) {
            Node<Integer> newNode = new Node<>(num);
            p.setNext(newNode);
            p = newNode;
            System.out.println("הכנס מספרים או -1 כדי לסיים:");
            num = scanner.nextInt();
        }
        return list.getNext();
    }

    public static boolean containsValueRecursive(Node<Integer> head, Object target) {
        if (head == null) {
            return false;
        }
        if (head.getValue().equals(target)) {
            return true;
        }
        return containsValueRecursive(head.getNext(), target);
    }

    public static Node<Integer> createListFromArray(int[] array) {
        Node<Integer> head = new Node<>(array[0]);
        Node<Integer> p = head;
        for (int i = 1; i < array.length; i++) {
            Node<Integer> newNode = new Node<>(array[i]);
            p.setNext(newNode);
            p = newNode;
        }
        return head;
    }

    public static void printListIteratively(Node<Integer> head) {
        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }

    public static void printListReverse2(Node<Integer> head) {
        if (head == null) {
            return;
        }
        printListReverse2(head.getNext());
        System.out.println(head.getValue());
    }

    public static boolean containsValueIteratively(Node<Integer> head, int target) {
        while (head != null) {
            if (head.getValue() == target) {
                return true;
            }
            head = head.getNext();
        }
        return false;
    }
    public static void main(String[] args) {
        int x = 1; 
        int y = 100; 

        List<Integer> randomNumbers = generateRandomNumbers(x, y);
        System.out.println("המספרים האקראיים הם: " + randomNumbers);

        int numberToCount = 50;  
        int occurrences = countOccurrences(randomNumbers, numberToCount);
        System.out.println("המספר " + numberToCount + " מופיע " + occurrences + " פעמים ברשימה");
    }
}
    public static void main(String[] args) {
        int[] array = {10, 15, 20, 25, 30};
        Node<Integer> listFromArray = createListFromArray(array);
        System.out.println("רשימה שנבנתה ממערך:");
        printListIteratively(listFromArray);

        System.out.println("\nהדפסת הרשימה הפוך:");
        printListReverse(listFromArray);

        System.out.println("\nהמספרים הזוגיים ברשימה:");
        printEvenNumbers(listFromArray);

        System.out.println("\nהכנס ערכים ליצירת רשימה:");
        Node<Integer> userList = createListFromInput();
        System.out.println("הרשימה שנוצרה מהקלט שלך:");
        printListIteratively(userList);

        System.out.println("\nהכנס מספר לחיפוש ברשימה (רקורסיה):");
        int target = scanner.nextInt();
        boolean foundRecursively = containsValueRecursive(listFromArray, target);
        System.out.println("האם המספר נמצא ברשימה? " + foundRecursively);

        System.out.println("\nהכנס מספר לחיפוש ברשימה (איטרטיבי):");
        target = scanner.nextInt();
        boolean foundIteratively = containsValueIteratively(listFromArray, target);
        System.out.println("האם המספר נמצא ברשימה? " + foundIteratively);
    }
}



}
