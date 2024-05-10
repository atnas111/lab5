package commands;

import model.StudyGroup;
import readwrite.Writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.util.Set;

public class Save {
    private Set<StudyGroup> studyGroups;
    private String filename;

    public Save(Set<StudyGroup> studyGroups, String filename) {
        this.studyGroups = studyGroups;
        this.filename = filename;
    }

    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid command syntax. Usage: save");
            return;
        }
        Writer writer = new Writer();
        writer.writeCSV1(studyGroups, filename);
//        try (FileOutputStream fileOut = new FileOutputStream(filename);
//             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
//            objectOut.writeObject(studyGroups);
//            System.out.println("Study groups saved to file: " + filename);
//        } catch (IOException e) {
//            System.out.println("Error saving study groups to file: " + e.getMessage());
//        }
    }
}
