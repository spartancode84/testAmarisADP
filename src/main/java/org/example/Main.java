package org.example;

import com.github.javafaker.Faker;
import org.example.entity.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @project ${PROJECT_NAME}
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date ${DATE}
 **/
public class Main {

    private static Faker faker = new Faker();

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            studentList.add(new Student(UUID.randomUUID(), faker.name().name(), faker.number().randomDigitNotZero(), (i < 3 ? "Lima" : "Callao")));
        }
        System.out.println("groupStudentByLocation = " + groupStudentByLocation(studentList));
        System.out.println("groupStudentByRolNumber = " + groupStudentByRolNumber(studentList));
        sorted(studentList, "ASC").forEach(student -> System.out.println("student.getName() = " + student.getRolNumber()));
        System.out.println("filterByRolNumber = " + filterByRolNumber(studentList, 2));
        sorted(studentList, "DES").forEach(student -> System.out.println("student.getName() = " + student.getRolNumber()));
        System.out.println("testStreamWithNumber(Arrays.asList( 4,5,7,3,2,6)) = " + testStreamWithNumber(Arrays.asList( 4,5,7,3,2,6)));
    }

    //Grouping By Location
    private static Map<String, List<Student>> groupStudentByLocation(List<Student> studentList) {
        return studentList.stream().collect(
                Collectors.groupingBy(Student::getLocation));
    }

    //Grouping By Location
    private static Map<Integer, List<Student>> groupStudentByRolNumber(List<Student> studentList) {
        return studentList.stream().collect(
                Collectors.groupingBy(Student::getRolNumber));
    }

    //Filter By Some Atributes
    private static List<Student> filterByRolNumber(List<Student> studentList, int number) {
        return studentList.stream()
                .filter(student -> student.getRolNumber() > number && student.getLocation().equalsIgnoreCase("Callao"))
                .collect(Collectors.toList());
    }

    private static List<Student> sorted(List<Student> studentList, String type) {
        return (type.equalsIgnoreCase("ASC") ? studentList.stream().sorted(Comparator.comparingInt(Student::getRolNumber)).collect(Collectors.toList()) : studentList.stream().sorted(Comparator.comparingInt(Student::getRolNumber).reversed()).collect(Collectors.toList()));
    }
    
    private static int testStreamWithNumber(List<Integer> nums){
        return nums.stream()
                .filter(integer -> integer%2==0)
                .map(integer -> integer*2)
                .reduce(0, (integer, integer2) -> integer + integer2 );
    }
}