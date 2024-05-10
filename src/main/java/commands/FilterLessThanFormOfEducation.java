package commands;

import model.FormOfEducation;
import model.StudyGroup;

import java.util.Set;
import java.util.stream.Collectors;

public class FilterLessThanFormOfEducation {
    private Set<StudyGroup> studyGroups;

    public FilterLessThanFormOfEducation(Set<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid command syntax. Usage: filter_less_than_form_of_education formOfEducation");
            return;
        }

        try {
            FormOfEducation formOfEducation = FormOfEducation.valueOf(args[1]);
            filterLessThanFormOfEducation(formOfEducation);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid form of education.");
        }
    }

    private void filterLessThanFormOfEducation(FormOfEducation formOfEducation) {
        Set<StudyGroup> filteredGroups = studyGroups.stream()
                .filter(group -> group.getFormOfEducation().compareTo(formOfEducation) < 0)
                .collect(Collectors.toSet());

        if (filteredGroups.isEmpty()) {
            System.out.println("No study groups found with a form of education less than " + formOfEducation);
        } else {
            System.out.println("Study groups with a form of education less than " + formOfEducation + ":");
            for (StudyGroup group : filteredGroups) {
                System.out.println(formatStudyGroup(group));
            }
        }
    }
    private String formatStudyGroup(StudyGroup group) {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(group.getId()).append("\n");
        sb.append("Name: ").append(group.getName()).append("\n");
        sb.append("Coordinates: ").append(group.getCoordinates()).append("\n");
        sb.append("Creation Date: ").append(group.getCreationDate()).append("\n");
        sb.append("Students Count: ").append(group.getStudentsCount()).append("\n");
        sb.append("Average Mark: ").append(group.getAverageMark()).append("\n");
        sb.append("Form of Education: ").append(group.getFormOfEducation()).append("\n");
        sb.append("Semester: ").append(group.getSemesterEnum()).append("\n");
        sb.append("Group Admin: ").append(group.getGroupAdmin()).append("\n");
        sb.append("Location: ").append(group.getGroupAdmin().getLocation()).append("\n");
        return sb.toString();
    }
}
