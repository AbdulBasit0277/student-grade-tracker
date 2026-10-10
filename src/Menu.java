import model.Student;
import services.StudentService;
import utils.InputCheck;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while (running) {

            System.out.println();
            System.out.println("Enter the action you want to perform");
            System.out.println("Enter 1 to add student");
            System.out.println("Enter 2 to delete student");
            System.out.println("Enter 3 to view all students");
            System.out.println("Enter 4 to see summary report");
            System.out.println("Enter 0 to exit");

            int choice = InputCheck.readInt(sc, "Choose: ");
//            sc.nextLine();
            switch (choice) {
                case 1:
                    String name = InputCheck.readText(sc, "Enter the name of the student: ");
                    double score = InputCheck.readScore(sc, "Enter the score of the student: ");

                    Student student = new Student(name, score);
                    StudentService.addStudent(student);
                    System.out.println(name + " has been added successfully");
                    break;
                case 2:
                    String deleteName = InputCheck.readText(sc, "Enter the name of the student you want to remove: ");
                    if (StudentService.removeStudent(deleteName)) {
                        System.out.println(deleteName + " has been deleted successfully");
                    } else {
                        System.out.println(deleteName + " does not exist");
                    }
                    break;


                case 3:
                    System.out.println("====== All Students List ======");
                    List<Student> all = StudentService.viewAllStudents();
                    if (all.isEmpty()) {
                        System.out.println("No students yet, please enter 1 to add student.");
                    } else {
                        for (Student s : all) {
                            System.out.println("Name  :          " + s.getName());
                            System.out.println("Score :          " + s.getScore());
                            System.out.println("Grade :          " + StudentService.getGrade(s));
                            System.out.println("----------------------------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.println("==== Summary Report ====");

                    Student highScore = StudentService.calculateHighestScore();
                    Student lowScore = StudentService.calculateLowestScore();

                    if (StudentService.viewAllStudents().isEmpty()) {
                        System.out.println("No students yet.");
                    } else {
                        System.out.println("Total students : " + StudentService.viewAllStudents().size());
                        System.out.printf("Average score  : %.1f", StudentService.calculateAverageScore());
                        System.out.println();
                        System.out.println("Highest Score  : " + highScore.getName() + " (" + highScore.getScore() + ")");
                        System.out.println("Lowest Score   : " + lowScore.getName() + " (" + lowScore.getScore() + ")");
                    }
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Input, please enter a number between 0 and 4.");

            }
        }
    }
}
