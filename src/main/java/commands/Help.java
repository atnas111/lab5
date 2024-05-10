package commands;

public class Help {
    public void execute(String[] args) {
        System.out.println("Available commands:");
        System.out.println("help : Print available commands and their descriptions");
        System.out.println("info : Print information about the collection (type, initialization date, number of elements, etc.)");
        System.out.println("show : Print all elements of the collection");
        System.out.println("add {element} : Add a new element to the collection");
        System.out.println("update id {element} : Update the value of a collection element with the specified ID");
        System.out.println("remove_by_id id : Remove an element from the collection by its ID");
        System.out.println("clear : Clear the collection");
        System.out.println("save : Save the collection to a file");
        System.out.println("execute_script file_name : Read and execute commands from a script file");
        System.out.println("exit : Exit the program without saving the collection to a file");
        System.out.println("add_if_min {element} : Add a new element to the collection if its value is less than the smallest element in the collection");
        System.out.println("add_if_max {element} : Add a new element to the collection if its value exceeds the value of the largest element in the collection");
        System.out.println("remove_lower {element} : Remove all elements from the collection that are less than the specified element");
        System.out.println("max_by_creation_date : Print the element with the maximum creation date");
        System.out.println("count_by_group_admin groupAdmin : Count the number of elements with the specified group admin");
        System.out.println("filter_less_than_form_of_education formOfEducation : Print elements with a form of education less than the specified value");
    }
}
