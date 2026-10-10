package services;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private static List<Student> students = new ArrayList<>();

    // method to get grade
    public static String getGrade(Student student) {
        if (student.getScore() >= 70) {
            return "A";
        } else if (student.getScore() >= 60) {
            return "B";
        } else if (student.getScore() >= 50) {
            return "C";
        }  else if (student.getScore() >= 45) {
            return "D";
        }else if (student.getScore() >= 40) {
            return "E";
        }
        return "F";
    }

    // method to add student to the list
    public static void addStudent(Student s){
        students.add(s);
    }
    // method to delete student from the list
    public static boolean removeStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    // method to all view students
    public static List<Student> viewAllStudents(){
        return students;
    }
    // method to calculate average, lowest and highest
    public static double calculateAverageScore(){
        if (students.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Student s: students) {
            total += s.getScore();
        }
        return total / students.size();
    }

    public static Student calculateHighestScore(){
        if (students.isEmpty()) {
            return null;
        }
        Student highest = students.get(0);
        for (Student s: students) {
            if (s.getScore() > highest.getScore()) {
                highest = s;
            }
        }
        return highest;
    }

    public static Student calculateLowestScore(){
        if (students.isEmpty()) {
            return null;
        }
        Student lowest = students.get(0);
        for (Student s: students) {
            if (s.getScore() < lowest.getScore()) {
                lowest = s;
            }
        }
        return lowest;
    }

}
