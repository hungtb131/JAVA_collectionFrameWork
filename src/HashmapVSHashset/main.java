package HashmapVSHashset;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, new Student("Hung", 27, "Nam Dinh"));
        studentMap.put(2, new Student("Minh", 20, "Bac Ninh"));
        studentMap.put(3, new Student("Vinh", 25, "Ha Nam"));

        for (Map.Entry<Integer, Student> studentEntry : studentMap.entrySet()) {
            System.out.println(studentEntry.toString());
        }

        System.out.println("......Set");
        Set<Student> students = new HashSet<>();
        students.add(new Student("Hung", 27, "Nam Dinh"));
        students.add(new Student("Minh", 20, "Bac Ninh"));
        students.add(new Student("Vinh", 25, "Ha Nam"));

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}