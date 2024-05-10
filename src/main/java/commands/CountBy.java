package commands;

import model.StudyGroup;

import java.util.Set;

public class CountBy {
    private Set<StudyGroup> studyGroups;

    public CountBy(Set<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid command syntax. Usage: count_by_group_admin groupAdmin");
            return;
        }

        String groupAdminName = args[1];
        long count = countByGroupAdmin(groupAdminName);
        System.out.println("Number of study groups with group admin \"" + groupAdminName + "\": " + count);
    }

    private long countByGroupAdmin(String groupAdminName) {
        return studyGroups.stream()
                .filter(group -> group.getGroupAdmin().getName().equalsIgnoreCase(groupAdminName))
                .count();
    }
}
