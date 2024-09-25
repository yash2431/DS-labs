import java.util.LinkedList;
import java.util.Queue;

public class Sandwiches {
    public int countStudentsUnableToEat(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }

        int sandwichIndex = 0;
        int countNotTaken = 0;  
        
        while (sandwichIndex < sandwiches.length) {
            if (queue.isEmpty()) {
                break; 
            }

            int currentStudent = queue.poll(); 

            if (currentStudent == sandwiches[sandwichIndex]) {
              
                sandwichIndex++;
                countNotTaken = 0; 
            } else {
                
                queue.offer(currentStudent);
                countNotTaken++;
            }


            if (countNotTaken == students.length) {
                break;
            }
        }

        
        return queue.size();
    }

    public static void main(String[] args) {
        Sandwiches solution = new Sandwiches();
        
     
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};
        System.out.println(solution.countStudentsUnableToEat(students1, sandwiches1));

     
        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};
        System.out.println(solution.countStudentsUnableToEat(students2, sandwiches2)); 
    }
}
