import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner; // Note: Do not change this line.
    public static int numOfStudents = 0;
    public static String[] names = new String[100];
    public static List<Double>[] studentsGrades = new List[100];

    public static void printInstructions() {
        System.out.print(
                "1. Add a new student\n" +
                        "2. Display all students\n" +
                        "3. Calculate a student's average grade\n" +
                        "4. Find the top performing student\n" +
                        "5. Exit\n" +
                        "Please enter your choice:\n");
    }


    public static int getFreeIndex(String name) {

        for (int i = 0; i < names.length; i++) {
            if (names[i].isEmpty()) return i; // free location && new name
            if (names[i].equals(name)) return i; // known name
        }

        System.out.println("Student limit reached");
        return -1;
    }

    public static Double[] getGrades() {

        System.out.println("Enter grades:");
        String gradesInput = scanner.nextLine();

        String[] gradesAsString = gradesInput.split(" ");
        Double[] grades = new Double[gradesAsString.length];

        for (int i = 0; i < gradesAsString.length; i++) {
            grades[i] = Double.parseDouble(gradesAsString[i]);

            if (!(0 <= grades[i] && grades[i] <= 100)) {
                System.out.println("Invalid grades");
                return null;
            }
        }

        return grades;
    }

    public static void fillGrades(int index, Double[] grades) {
        for (Double grade : grades) {
            studentsGrades[index].add(grade);
        }
    }

    public static void addStudent() {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();

        int index = getFreeIndex(name);
        if (index == -1) return; //student limit reached

        Double[] grades = getGrades();
        if (grades == null) return; //some grades were out of bound

        names[index] = name;
        fillGrades(index, grades);

    }


    public static void displayStudent() {
    }

    public static void studentGradesAverage() {
    }

    public static void topPerformingStudent() {
    }

    public static void manageGrades() {
        System.out.println("Welcome to the Student Grade Management System!");
        printInstructions();


        int choice = scanner.nextInt();

        while (choice > 0 && choice < 5) {

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    studentGradesAverage();
                    break;
                case 4:
                    topPerformingStudent();
                    break;
            }
        }

        printInstructions();
        choice = scanner.nextInt();

    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        scanner = new Scanner(new File(path));
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfTests; i++) {
            System.out.println("Test number " + i + " starts.");
            try {
                manageGrades();
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
            System.out.println("Test number " + i + " ended.");
            System.out.println("-----------------------------------------------");
        }
        System.out.println("All tests have ended.");
    }
}