package commands;

import model.StudyGroup;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Set;

public class Show {
    private Set<StudyGroup> studyGroups;

    public Show(Set<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public void execute(String[] args) {
        if (studyGroups.isEmpty()) {
            System.out.println("The collection is empty.");
        } else {
            System.out.println("Elements in the collection:");
            for (StudyGroup group : studyGroups) {
                try {
                    System.out.println(formatStudyGroup(group));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private String formatStudyGroup(StudyGroup group) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(group.getId()).append("\n");
        sb.append("Name: ").append(group.getName()).append("\n");
        sb.append("Creation Date: ").append(group.getCreationDate()).append("\n");
        sb.append("Students Count: ").append(group.getStudentsCount()).append("\n");
        sb.append("Average Mark: ").append(group.getAverageMark()).append("\n");
        sb.append("Form of Education: ").append(group.getFormOfEducation()).append("\n");
        sb.append("Semester: ").append(group.getSemesterEnum()).append("\n");
        sb.append("Group Admin: ").append(group.getGroupAdmname()).append("\n");
        return sb.toString();
    }
}
