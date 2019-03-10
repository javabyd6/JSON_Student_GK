package pl.sda.studentRead;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.studentModel.Student;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadStudents {

    public static void readStudentList(){

        ObjectMapper mapper = new ObjectMapper();

        try {
            Student[] studentsArray = mapper.readValue(new File("studentList.json"), Student[].class);
            System.out.println("students array = " + Arrays.toString(studentsArray));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void readStudentListNamed(String initial) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            Student[] students = mapper.readValue(new File("studentList.json"), Student[].class);
            List <Student> studentList = Arrays.asList(students);
            studentList.stream()
                    .filter(x -> x.getLastName().startsWith(initial.toUpperCase()))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        readStudentList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj inicjal nazwiska szukanego studenta: ");
        String initial = scanner.next();
        readStudentListNamed(initial);
    }
}
