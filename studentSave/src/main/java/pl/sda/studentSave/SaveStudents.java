package pl.sda.studentSave;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.studentModel.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SaveStudents {

    private static void saveStudents() {

        ObjectMapper mapper = new ObjectMapper();

        Student student1 = new Student("Bob", "Walizka", 111);
        Student student2 = new Student("Adam", "Alizka", 211);
        Student student3 = new Student("Arek", "Lizka", 311);
        Student student4 = new Student("Cyps", "Izka", 411);
        Student student5 = new Student("Zyps", "Zka", 511);

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4, student5);

        String studentListString = null;
        try {
            studentListString = mapper.writeValueAsString(studentList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            if (studentListString != null) {
                Files.write(Paths.get("studentList.json"), studentListString.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        saveStudents();
    }

}
