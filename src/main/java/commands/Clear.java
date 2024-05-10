package commands;

import model.StudyGroup;

import java.util.Set;

public class Clear {
    private Set<StudyGroup> studyGroups;

    public Clear(Set<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid command syntax. Usage: clear");
            return;
        }

        studyGroups.clear();
        System.out.println("All study groups have been cleared.");
    }
}
