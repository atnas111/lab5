package commands;

import model.StudyGroup;

import java.util.Set;

public class Info {
    private Set<StudyGroup> studyGroups;

    public Info(Set<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;}

    public void execute(String[] args) {
        System.out.println("Collection type: LinkedHashSet<StudyGroup>");
        System.out.println("Number of elements in the collection: " + studyGroups.size());
    }
}
