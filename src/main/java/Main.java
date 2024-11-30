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

}
