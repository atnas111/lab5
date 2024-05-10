package commands;

import model.StudyGroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class ComManager {
    private Set<StudyGroup> studyGroups;
    private String filename;

    public ComManager(Set<StudyGroup> studyGroups, String filename) {
        this.studyGroups = studyGroups;
        this.filename = filename;
    }

    public void executeCommand(String command) {
        String[] parts = command.split("\\s+", 3);
        String commandName = parts[0];

        switch (commandName) {
            case "add":
                new Add(studyGroups).execute();
                break;
            case "update":
                new UpdateId(studyGroups).execute(parts);
                break;
            case "remove_by_id":
                new RemoveById(studyGroups).execute(parts);
                break;
            case "clear":
                new Clear(studyGroups).execute(parts);
                break;
            case "save":
                new Save(studyGroups, filename).execute(parts);
                break;
            case "add_if_max":
                new AddIfMax(studyGroups).execute();
                break;
            case "add_if_min":
                new AddIfMin(studyGroups).execute();
                break;
            case "remove_lower":
                new RemoveLower(studyGroups).execute(parts);
                break;
            case "max_by_creation_date":
                new MaxByCreationDate(studyGroups).execute(parts);
                break;
            case "count_by_group_admin":
                new CountBy(studyGroups).execute(parts);
                break;
            case "filter_less_than_form_of_education":
                new FilterLessThanFormOfEducation(studyGroups).execute(parts);
                break;
            case "help":
                new Help().execute(parts);
                break;
            case "info":
                new Info(studyGroups).execute(parts);
                break;
            case "show":
                new Show(studyGroups).execute(parts);
                break;
            case "execute_script":
                executeScript(parts[1]);
                break;
            default:
                System.out.println("Unknown command.");
        }
    }
    public void executeScript(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                executeCommand(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading the script file: " + e.getMessage());
    }

}}
