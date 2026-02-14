

package cgpacalculater;

import java.util.Scanner;

public class GPACalculator2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Academic CGPA Calculator ===");

        // 1. የቆየውን ውጤት በቀላሉ መቀበል
        System.out.print("Enter your Previous CGPA : ");
        double prevGPA = input.nextDouble();

        System.out.print("Enter your Previous Total Credit Hours : ");
        double prevTotalCredits = input.nextDouble();

        // የቆየውን ነጥብ እራሱ ኮዱ እንዲያሰላው እናደርጋለን
        double prevTotalPoints = prevGPA * prevTotalCredits;

        // 2. የአሁኑን ሴሚስተር ውጤት መቀበል
        System.out.println("\n--- Current Semester Data ---");
        System.out.print("How many courses did you take this semester? ");
        int numCourses = input.nextInt();

        double currentSemesterPoints = 0;
        double currentSemesterCredits = 0;

        for (int i = 1; i <= numCourses; i++) {
            System.out.print("\nCourse " + i + " Name: ");
            String courseName = input.next();
            
            System.out.print("Grade for " + courseName + " (A, B+, etc.): ");
            String grade = input.next().toUpperCase();
            
            double gradeValue = 0;
            switch (grade) {
                case "A+": case "A": gradeValue = 4.0; break;
                case "A-": gradeValue = 3.75; break;
                case "B+": gradeValue = 3.5; break;
                case "B":  gradeValue = 3.0; break;
                case "B-": gradeValue = 2.75; break;
                case "C+": gradeValue = 2.5; break;
                case "C":  gradeValue = 2.0; break;
                case "C-": gradeValue = 1.5; break;
                case "D":  gradeValue = 1.0; break;
                case "F":  gradeValue = 0.0; break;
                default:
                    System.out.println("Invalid Grade! Skipping...");
                    continue;
            }

            System.out.print("Credit Hours for " + courseName + ": ");
            double credit = input.nextDouble();

            currentSemesterPoints += (gradeValue * credit);
            currentSemesterCredits += credit;
        }

        // 3. አጠቃላይ ስሌት
        double totalPoints = prevTotalPoints + currentSemesterPoints;
        double totalCredits = prevTotalCredits + currentSemesterCredits;

        System.out.println("\n==============================");
        System.out.println("       ACADEMIC REPORT        ");
        System.out.println("==============================");

        if (currentSemesterCredits > 0) {
            double currentGPA = currentSemesterPoints / currentSemesterCredits;
            System.out.printf("Current Semester GPA: %.2f\n", currentGPA);
        }

        if (totalCredits > 0) {
            double cgpa = totalPoints / totalCredits;
            System.out.printf("OVERALL CGPA: %.2f\n", cgpa);

            // ደረጃን ለመግለጽ
            if (cgpa >= 3.5) System.out.println("Status: Excellent!");
            else if (cgpa >= 3.0) System.out.println("Status: Very Good");
            else if (cgpa >= 2.0) System.out.println("Status: Satisfactory");
            else System.out.println("Status: Academic Warning");
        }
        System.out.println("==============================");
        input.close();
    }
}