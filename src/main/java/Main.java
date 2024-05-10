import java.io.File;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

import commands.ComManager;
import model.StudyGroup;
import model.Semester;
import model.Person;
import model.Coordinates;
import model.FormOfEducation;
import model.Location;
import readwrite.Reader;
import readwrite.Writer;

public class Main {
    public static void main(String[] args) {

//      if (args.length > 0) {
//            System.out.println("Использование: java Main <имя файла.csv>");
//           if (!args[0].endsWith(".csv")) {
//               System.out.println("Файл не является CSV файлом");
//                return;
//            }
//      }

       String fileName = "std.csv";
            System.out.println("Имя файла: " + fileName);
//            StudyGroup[] groups = {
//                    new StudyGroup(1L, "Group A", new Coordinates(1, 2f), LocalDateTime.now(), 30, 85.5, FormOfEducation.FULL_TIME_EDUCATION, Semester.FIRST, new Person("Alice", LocalDateTime.now(), 60, new Location(1.0, 2, 3L, "Location A"))),
//                    new StudyGroup(2L, "Group B", new Coordinates(3, 4f), LocalDateTime.now(), 25, 90.0, FormOfEducation.DISTANCE_EDUCATION, Semester.FOURTH, new Person("Bob", LocalDateTime.now(), 70, new Location(4.0, 5, 6L, "Location B"))),
//                    new StudyGroup(3L, "Group C", new Coordinates(5, 6f), LocalDateTime.now(), 20, 92.5, FormOfEducation.EVENING_CLASSES, Semester.SIXTH, new Person("Charlie", LocalDateTime.now(), 65, new Location(7.0, 8, 9L, "Location C")))
//            };
//            Writer writer = new Writer();
//            writer.writeCSV(groups, fileName);
            Scanner scanner = new Scanner(System.in);
            Reader reader = new Reader();
            ComManager commandManager = new ComManager(reader.readFromCSV(fileName), fileName);
        while (true) {
            System.out.print("Enter command: ");

            try {
                String command = scanner.nextLine();

                if (command.equalsIgnoreCase("exit")) {
                    break;
                }

                if (command.trim().isEmpty()) {
                    continue;
                }

                // Выполняем команду
                commandManager.executeCommand(command);

            } catch (NoSuchElementException e) {
                // Обрабатываем ошибку NoSuchElementException,
                // которая возникает при использовании Ctrl+D (или Ctrl+Z в Windows)
                System.out.println("Выход из программы.");
                break; // Выходим из цикла
            }
        }

        scanner.close();
    }

}

