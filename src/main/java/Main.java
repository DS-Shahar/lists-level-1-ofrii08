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



/6/
    public static LinkedList<Integer> six(LinkedList<Integer> list, int num) {
        if (list.isEmpty()) {
            return list;
        }

        if (list.getFirst() == num) {
            list.removeFirst(); 
        } else {
            list.remove(Integer.valueOf(num));
        }

        return list; 
    }
    
    /7/
    public static LinkedList<Integer> seven(LinkedList<Integer> list, int x) {
        if (list.isEmpty() || x < 1 || x > list.size()) {
            return list; 
        }
        int index = x - 1;
        list.remove(index);
        return list;
    }
    
    /8/
    public static boolean eight(LinkedList<Integer> L1, LinkedList<Integer> L2) {
        if (L1.isEmpty()) {
            return true;
        }
        int firstValue = L1.getFirst();
        if (L2.contains(firstValue)) {
            L1.removeFirst(); 
            return eight(L1, L2);   
        } else {
            return false;
        }
    }

    /9/
    public static void nine(LinkedList<Integer> L1, LinkedList<Integer> L2) {
        for (int value : L1) {
            if (L2.contains(value)) {
                System.out.println(value);
            }
        }
    }
    
    /10/
    public static LinkedList<Integer> ten(LinkedList<Integer> L1, LinkedList<Integer> L2) {
        LinkedList<Integer> commonList = new LinkedList<>();  

                for (int value : L1) {
            if (L2.contains(value)) {
                commonList.add(value);  
                L2.removeFirstOccurrence(value);              }
        }

        return commonList;  
        }
    
    /11/
    public static LinkedList<Integer> eleven(LinkedList<Integer> L1, LinkedList<Integer> L2) {
        for (int i = 0; i < L1.size(); i++) {
            if (L2.contains(L1.get(i))) {
                L1.remove(i); 
                i--;             }
        }
        return L1; 
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
        /6/
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Before removal: " + list);
        
        list = six(list, 2);

        System.out.println("After removal: " + list);
        /7/
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        System.out.println("Before removal: " + list1);
        list1 = seven(list1, 1);
        System.out.println("After removal: " + list1);
        
        /8/
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();
        
        L1.add(1);
        L1.add(2);
        L1.add(3);
        
        L2.add(1);
        L2.add(2);
        L2.add(3);
        L2.add(4);
        
        boolean result = eight(L1, L2);
        System.out.println("Does every element of L1 exist in L2? " + result);
        
        /9/
        LinkedList<Integer> L11 = new LinkedList<>();
        LinkedList<Integer> L21 = new LinkedList<>();

        L11.add(1);
        L11.add(2);
        L11.add(3);
        L11.add(4);

        L21.add(2);
        L21.add(3);
        L21.add(5);
        L21.add(2); 

        System.out.println("Common elements between L1 and L2 are:");
         nine(L11, L21);
         
         /10/
         LinkedList<Integer> L111 = new LinkedList<>();
         LinkedList<Integer> L211 = new LinkedList<>();

         L111.add(1);
         L111.add(2);
         L111.add(3);
         L111.add(2);  
         L211.add(2);
         L211.add(3);
         L211.add(2);  
         L211.add(4);

         LinkedList<Integer> commonList = ten(L111, L211);

         System.out.println("Common elements between L1 and L2 are: " + commonList);
         
         /11/

         L1.add(1);
         L1.add(2);
         L1.add(3);
         L1.add(4);
         L1.add(5);

         L2.add(2);
         L2.add(4);

         LinkedList<Integer> result1 = eleven(L1, L2);

         System.out.println("L1 after removal: " + result1);
    }
}
    }
}



}
