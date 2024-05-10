package readwrite;

import model.StudyGroup;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Writer {
    public void writeCSV(StudyGroup[] groups, String filename) {
        Set<StudyGroup> groupSet = new LinkedHashSet<>(Arrays.asList(groups));

        try (PrintWriter csvWriter = new PrintWriter(filename)) {
            csvWriter.append("ID,Name,Coordinate X,Coordinate Y,Creation Date,Students Count,Average Mark,Form Of Education,Semester,Group Admin Name,Birthday,Weight,Location X,Location Y,Location Z,Location Name\n");

            for (StudyGroup group : groupSet) {
                csvWriter.append(String.join(",",
                        String.valueOf(group.getId()),
                        group.getName(),
                        String.valueOf(group.getCoordinates().getX()),
                        String.valueOf(group.getCoordinates().getY()),
                        group.getCreationDate().toString(),
                        String.valueOf(group.getStudentsCount()),
                        String.valueOf(group.getAverageMark()),
                        group.getFormOfEducation().toString(),
                        group.getSemesterEnum().toString(),
                        group.getGroupAdmin().getName(),
                        group.getGroupAdmin().getBirthday().toString(),
                        String.valueOf(group.getGroupAdmin().getWeight()),
                        String.valueOf(group.getGroupAdmin().getLocation().getX()),
                        String.valueOf(group.getGroupAdmin().getLocation().getY()),
                        String.valueOf(group.getGroupAdmin().getLocation().getZ()),
                        group.getGroupAdmin().getLocation().getName()
                ));
                csvWriter.append("\n");
            }

            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }}
        public void writeCSV1 (Set < StudyGroup > groups, String filename){


            try (PrintWriter csvWriter = new PrintWriter(filename)) {
                csvWriter.append("ID,Name,Coordinate X,Coordinate Y,Creation Date,Students Count,Average Mark,Form Of Education,Semester,Group Admin Name,Birthday,Weight,Location X,Location Y,Location Z,Location Name\n");

                for (StudyGroup group : groups) {
                    csvWriter.append(String.join(",",
                            String.valueOf(group.getId()),
                            group.getName(),
                            String.valueOf(group.getCoordinates().getX()),
                            String.valueOf(group.getCoordinates().getY()),
                            group.getCreationDate().toString(),
                            String.valueOf(group.getStudentsCount()),
                            String.valueOf(group.getAverageMark()),
                            group.getFormOfEducation().toString(),
                            group.getSemesterEnum().toString(),
                            group.getGroupAdmin().getName(),
                            group.getGroupAdmin().getBirthday().toString(),
                            String.valueOf(group.getGroupAdmin().getWeight()),
                            String.valueOf(group.getGroupAdmin().getLocation().getX()),
                            String.valueOf(group.getGroupAdmin().getLocation().getY()),
                            String.valueOf(group.getGroupAdmin().getLocation().getZ()),
                            group.getGroupAdmin().getLocation().getName()
                    ));
                    csvWriter.append("\n");
                }

                csvWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
