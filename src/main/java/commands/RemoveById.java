package commands;

import model.StudyGroup;

import java.util.Iterator;
import java.util.Set;

public class RemoveById {
    private Set<StudyGroup> studyGroups;

    public RemoveById(Set<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid command syntax. Usage: remove_by_id id");
            return;
        }

        long id;
        try {
            id = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
            return;
        }

        Iterator<StudyGroup> iterator = studyGroups.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            StudyGroup group = iterator.next();
            if (group.getId() == id) {
                iterator.remove();
                removed = true;
                System.out.println("Study group with ID " + id + " removed successfully.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Study group with ID " + id + " not found.");
        }
    }
}
