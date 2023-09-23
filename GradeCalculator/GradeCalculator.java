import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int numSubjects) {
        this.name = name;
        this.marks = new int[numSubjects];
    }
}

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine();

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of Student " + (i + 1) + ": ");
            String studentName = scanner.nextLine();
            students[i] = new Student(studentName, numSubjects);

            for (int j = 0; j < numSubjects; j++) {
                boolean validInput = false;
                while (!validInput) {
                    System.out.print("Enter marks for " + students[i].name + " in Subject " + (j + 1) + ": ");
                    if (scanner.hasNextInt()) {
                        int mark = scanner.nextInt();
                        if (mark >= 0 && mark <= 100) {
                            students[i].marks[j] = mark;
                            validInput = true;
                        } else {
                            System.out.println("Invalid input. Marks should be between 0 and 100.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer for marks.");
                        scanner.nextLine();
                    }
                }
            }
            scanner.nextLine();
        }

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nResults for " + students[i].name + ":");
            int totalMarks = 0;
            for (int mark : students[i].marks) {
                totalMarks += mark;
            }

            double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;
            String grade = calculateGrade(averagePercentage);

            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);
        }

        scanner.close();
    }

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
