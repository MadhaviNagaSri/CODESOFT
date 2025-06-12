import java.util.Scanner;

public class MarksCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask the user for number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        int totalMarks = 0;

        // Loop to take marks for each subject
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = sc.nextInt();

            // Validating input (0 to 100)
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                i--; // repeat this subject
                continue;
            }

            totalMarks += marks;
        }

        // Calculate average percentage
        double average = (double) totalMarks / numSubjects;

        // Determine grade
        String grade;
        //use this approch or another
        /*String result = (average >= 90) ? "A+" : 
                (average >= 80) ? "A" : 
                (average >= 70) ? "B" : 
                (average >= 60) ? "C" : 
                "Fail";*/

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // Display results
        System.out.println("--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        //"%.2f" → Format the floating point number to 2 decimal places.
        //%% → Prints a % sign literally (because % has special meaning in printf)
        //\n -> we already know it will add new line
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);
    }
}