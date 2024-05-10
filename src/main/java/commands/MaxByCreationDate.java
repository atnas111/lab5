package commands;

import model.StudyGroup;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class MaxByCreationDate {
    private Set<StudyGroup> studyGroups;

    public MaxByCreationDate(Set<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid command syntax. Usage: max_by_creation_date");
            return;
        }

        Optional<StudyGroup> maxStudyGroupOptional = getMaxByCreationDate();
        if (maxStudyGroupOptional.isPresent()) {
            System.out.println("Study group with maximum creation date: " + maxStudyGroupOptional.get());
        } else {
            System.out.println("There are no study groups in the collection.");
        }
    }

    private Optional<StudyGroup> getMaxByCreationDate() {
        return studyGroups.stream()
                .max(Comparator.comparing(StudyGroup::getCreationDate));
    }
}
