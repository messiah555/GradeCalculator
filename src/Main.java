import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> averages = new ArrayList<>();
        ArrayList<String> grades = new ArrayList<>();

        String choice = "yes";
        boolean firstStudent = true;

        while(choice.equalsIgnoreCase("yes")) {

            if(!firstStudent) {
                sc.nextLine(); // only clear buffer from 2nd student onwards
            }
            firstStudent = false;

            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks in subject 1: ");
            int marks1 = sc.nextInt();

            System.out.print("Enter marks in subject 2: ");
            int marks2 = sc.nextInt();

            System.out.print("Enter marks in subject 3: ");
            int marks3 = sc.nextInt();

            double average = (marks1 + marks2 + marks3) / 3.0;

            String grade;
            if(average >= 90) grade = "A";
            else if(average >= 75) grade = "B";
            else if(average >= 60) grade = "C";
            else if(average >= 45) grade = "D";
            else grade = "F";

            names.add(name);
            averages.add(average);
            grades.add(grade);

            System.out.print("\nAdd another student? (yes/no): ");
            choice = sc.next();
        }

        System.out.println("\n===== ALL STUDENTS =====");
        for(int i = 0; i < names.size(); i++) {
            System.out.println("Name: " + names.get(i) +
                    " | Average: " + averages.get(i) +
                    " | Grade: " + grades.get(i));
        }
        // Find topper
        int topperIndex = 0;
        for(int i = 1; i < averages.size(); i++){
            if(averages.get(i) > averages.get(topperIndex)){
                topperIndex = i;
            }
        }

        System.out.println("\n===== TOPPER =====");
        System.out.println("Name: " + names.get(topperIndex) +
                " | Average: " + averages.get(topperIndex) +
                " | Grade: " + grades.get(topperIndex));

        // Class Statistics
        double total = 0;
        double highest = averages.get(0);
        double lowest = averages.get(0);

        for(int i = 0; i < averages.size(); i++){
            total += averages.get(i);
            if(averages.get(i) > highest) highest = averages.get(i);
            if(averages.get(i) < lowest) lowest = averages.get(i);
        }

        double classAverage = total / averages.size();

        System.out.println("\n===== CLASS STATISTICS =====");
        System.out.println("Total Students: " + names.size());
        System.out.println("Class Average: " + classAverage);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
    }
}