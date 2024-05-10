package commands;

import model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;

public class AddIfMax {
    private Set<StudyGroup> studyGroups;

    public AddIfMax(Set<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public void execute() {


        StudyGroup newStudyGroup = inputCollection();
        if (newStudyGroup == null) {
            System.out.println("Failed to parse the input element of StudyGroup.");
            return;
        }

        StudyGroup maxStudyGroup = studyGroups.stream()
                .max(Comparator.comparingDouble(StudyGroup::getAverageMark))
                .orElse(null);

        if (maxStudyGroup == null || newStudyGroup.getAverageMark() > maxStudyGroup.getAverageMark()) {
            studyGroups.add(newStudyGroup);
            System.out.println("New study group added because it exceeds the values of the largest study group.");
        } else {
            System.out.println("The provided study group does not exceed the values of the largest study group.");
        }
    }

    public StudyGroup inputCollection() {
        Scanner scanner = new Scanner(System.in);
        String groupName = null;
        Double x = null;
        Float y = null;
        LocalDateTime time = null;
        Integer studentsCount = null;
        Double averageMark = null;
        FormOfEducation formOfEducation = null;
        Semester semester = null;
        String nameAdmin = null;
        LocalDateTime adminBirthday = null;
        int adminWeight = 0;
        Double locationX = null;
        Double locationY = null;
        Long locationZ = null;
        String locationName = null;

        int numberOfElements = studyGroups.size();
        Long id = (long)(numberOfElements+1);
        do{
            try {
                System.out.print("Enter name of group: ");
                groupName = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter coordinates (x): ");
                x = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid coordinate format: " + e.getMessage());
            }
        } while (true);

        do{


            try {
                System.out.print("Enter coordinates (y): ");
                y = Float.parseFloat(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid coordinate format: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter Date (YYYY-MM-DDTHH:MM:SS): ");
                time = LocalDateTime.parse(scanner.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date/time format: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter количество студентов: ");
                studentsCount = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid students count format: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter average mark: ");
                averageMark = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid average mark format: " + e.getMessage());
            }
        } while (true);
        do {
            try {
                System.out.print("Enter form of education (DISTANCE_EDUCATION,\n" +
                        "    FULL_TIME_EDUCATION,\n" +
                        "    EVENING_CLASSES): ");
                formOfEducation = FormOfEducation.valueOf(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid form of education: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter semester: FIRST,\n" +
                        "    FOURTH,\n" +
                        "    SIXTH,\n" +
                        "    EIGHTH");
                semester = Semester.valueOf(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid semester: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter name admin: ");
                nameAdmin = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter admin birthday (YYYY-MM-DDTHH:MM:SS): ");
                adminBirthday = LocalDateTime.parse(scanner.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid admin birthday format: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter admin weight: ");
                adminWeight = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid admin weight format: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter admin location (x): ");
                locationX = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid admin location format: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter admin location (y): ");
                locationY = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid admin location format: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter admin location (z): ");
                locationZ = Long.parseLong(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid admin location format: " + e.getMessage());
            }
        } while (true);
        do{
            try {
                System.out.print("Enter admin location name: ");
                locationName = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        } while (true);

        // Create and return the StudyGroup object
        return new StudyGroup(id, groupName, new Coordinates(x, y), time,
                studentsCount, averageMark, formOfEducation, semester,
                new Person(nameAdmin, adminBirthday, adminWeight, new Location(locationX, locationY, locationZ, locationName)));
    }


}
