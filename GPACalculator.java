package cgpacalculater;
import java.util.Scanner;
public class GPACalculator {
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
 // Variables to accumulate data across all semesters for CGPA
      double grandTotalPoints = 0;
      double grandTotalCredits = 0;
  System.out.println("=== Academic CGPA Calculator ===");
  System.out.print("Enter total number of semesters: ");
    int numSemesters = input.nextInt();
 // OUTER LOOP: Iterates through each semester
for (int s = 1; s <= numSemesters; s++) {
  System.out.println("\n----------------------------");
  System.out.println("Processing Semester: " + s);
  System.out.println("----------------------------");
  System.out.print("How many courses did you take in Semester " + s + "? ");
     int numCourses = input.nextInt();
      double semesterPoints = 0;
       double semesterCredits = 0;
 // INNER LOOP: Iterates through each course in the current semester
 for (int i = 1; i <= numCourses; i++) {
   System.out.print("\nCourse " + i + " Name: ");
            String courseName = input.next(); 
 System.out.print("Grade for " + courseName + " (A, B+, etc.): ");
        String grade = input.next().toUpperCase(); 
      double gradeValue = 0;
   // Grade Mapping Logic
 switch (grade) {
    case "A+":  gradeValue = 4.0;
        break;
    case "A":  gradeValue = 4.0; 
       break;
    case "A-": gradeValue = 3.75;
       break;
    case "B+": gradeValue = 3.5;
      break;
    case "B":  gradeValue = 3.0; 
      break;
    case "B-": gradeValue = 2.75;
      break;
    case "C+": gradeValue = 2.5;
       break;
    case "C":  gradeValue = 2.0; 
      break;
    case "C-":  gradeValue = 1.5;
       break;
    case "D":  gradeValue = 1.0; 
       break;
    case "F":  gradeValue = 0.0; 
       break;
         default:
System.out.println("Invalid Grade entered. Skipping this course...");
          continue; 
                }
System.out.print("Credit Hours for " + courseName + ": ");
        double credit = input.nextDouble();
     // Calculate points for this specific course
       semesterPoints += (gradeValue * credit);
       semesterCredits += credit;
            }

       // Calculate and show the GPA for the current semester
  if (semesterCredits > 0) {
     double gpa = semesterPoints / semesterCredits;
System.out.printf("\n>>> Semester %d GPA: %.2f <<<\n", s, gpa);
       // Add this semester's data to the overall CGPA totals
       grandTotalPoints += semesterPoints;
      grandTotalCredits += semesterCredits;
            }
        }
 // FINAL CGPA CALCULATION
  System.out.println("\n==============================");
  System.out.println("       FINAL ACADEMIC REPORT   ");
    System.out.println("==============================");
 if (grandTotalCredits > 0) {
     double cgpa = grandTotalPoints / grandTotalCredits;
 System.out.printf("OVERALL CGPA: %.2f\n", cgpa);
       // Optional: Add a status message based on performance
 if (cgpa >= 3.5) System.out.println("Status: Excellent! (Great Distinction)");
     else if (cgpa >= 3.0) System.out.println("Status: Very Good");
     else if (cgpa >= 2.0) System.out.println("Status: Satisfactory");
     else System.out.println("Status: Academic Warning");
          } 
    else {
   System.out.println("Error: No valid academic data found.");
        }
   System.out.println("==============================");

        input.close();
    }
}