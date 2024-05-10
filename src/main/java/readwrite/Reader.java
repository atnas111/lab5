package readwrite;

import model.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashSet;


public class Reader {
    public LinkedHashSet<StudyGroup> studyGroups = new LinkedHashSet<>();

    public LinkedHashSet<StudyGroup> readFromCSV(String csvFile) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile)))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                StudyGroup studyGroup = new StudyGroup();
                // Inside the while loop
                try {
                    studyGroup.setId(Long.parseLong(data[0]));
                } catch (NumberFormatException e) {
                    // Handle the parsing error for ID
                    // For example, set a default value or log a message
                    studyGroup.setId(0L); // Or any default value you want to set
                }

                studyGroup.setName(data[1]);

                Coordinates coordinates = new Coordinates();
                try {
                    coordinates.setX(Integer.parseInt(data[2]));
                } catch (NumberFormatException e) {
                    // Handle the parsing error for X coordinate
                    coordinates.setX(0); // Or any default value you want to set
                }

                try {
                    coordinates.setY(Float.parseFloat(data[3]));
                } catch (NumberFormatException e) {
                    // Handle the parsing error for Y coordinate
                    coordinates.setY(0.0f); // Or any default value you want to set
                }
                studyGroup.setCoordinates(coordinates);

                try {
                    studyGroup.setCreationDate(java.time.LocalDateTime.parse(data[4]));
                } catch (DateTimeParseException e) {
                    // Handle the parsing error for Creation Date
                    // For example, set a default value or log a message
                    studyGroup.setCreationDate(LocalDateTime.now()); // Or any default value you want to set
                }

                try {
                    studyGroup.setStudentsCount(Integer.parseInt(data[5]));
                } catch (NumberFormatException e) {
                    // Handle the parsing error for Students Count
                    studyGroup.setStudentsCount(0); // Or any default value you want to set
                }

                try {
                    studyGroup.setAverageMark(Double.parseDouble(data[6]));
                } catch (NumberFormatException e) {
                    // Handle the parsing error for Average Mark
                    studyGroup.setAverageMark(0.0); // Or any default value you want to set
                }

                try {
                    studyGroup.setFormOfEducation(FormOfEducation.valueOf(data[7]));
                } catch (IllegalArgumentException e) {
                    // Handle the parsing error for Form Of Education
                    // For example, set a default value or log a message
                    studyGroup.setFormOfEducation(FormOfEducation.UNKNOWN); // Or any default value you want to set
                }

                try {
                    studyGroup.setSemesterEnum(Semester.valueOf(data[8]));
                } catch (IllegalArgumentException e) {
                    // Handle the parsing error for Semester Enum
                    // For example, set a default value or log a message
                    studyGroup.setSemesterEnum(Semester.UNKNOWN); // Or any default value you want to set
                }

                Person groupAdmin = new Person();
                groupAdmin.setName(data[9]);
                try {
                    groupAdmin.setBirthday(java.time.LocalDateTime.parse(data[10]));
                } catch (DateTimeParseException e) {
                    // Handle the parsing error for Birthday
                    // For example, set a default value or log a message
                    groupAdmin.setBirthday(LocalDateTime.now()); // Or any default value you want to set
                }

                try {
                    groupAdmin.setWeight(Integer.parseInt(data[11]));
                } catch (NumberFormatException e) {
                    // Handle the parsing error for Weight
                    groupAdmin.setWeight(0); // Or any default value you want to set
                }

                Location location = new Location();
                try {
                    location.setX(Double.parseDouble(data[12]));
                } catch (NumberFormatException e) {
                    // Handle the parsing error for X coordinate of Location
                    location.setX(0.0); // Or any default value you want to set
                }

                try {
                    location.setY(Integer.parseInt(data[13]));
                } catch (NumberFormatException e) {
                    // Handle the parsing error for Y coordinate of Location
                    location.setY(0); // Or any default value you want to set
                }

                try {
                    location.setZ(Long.parseLong(data[14]));
                } catch (NumberFormatException e) {
                    // Handle the parsing error for Z coordinate of Location
                    location.setZ(0L); // Or any default value you want to set
                }

                location.setName(data[15]);
                groupAdmin.setLocation(location);

                studyGroup.setGroupAdmin(groupAdmin);
                studyGroups.add(studyGroup);

            }

            return studyGroups;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
