import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "notes.txt"; 

        while (true) {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.println("4. Clear All Notes");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = scanner.nextLine();
                    addNote(filename, note);
                    break;
                case 2:
                    viewNotes(filename);
                    break;
                case 3:
                    System.out.println("Bye!");
                    return;
                   case 4:
                    clearNotes(filename);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // you can add anything you want
    private static void addNote(String filename, String note) {
        try (FileWriter fw = new FileWriter(filename, true)) { 
            fw.write(note + System.lineSeparator());
            System.out.println("Note added!");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    // you can view all the notes
    private static void viewNotes(String filename) {
        System.out.println("\n--- Your Notes ---");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean hasNotes = false;
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
                hasNotes = true;
            }
            if (!hasNotes) {
                System.out.println("(No notes found)");
            }
        } catch (FileNotFoundException e) {
            System.out.println("(No notes file yet. Add a note first.)");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }
    // You can delete all the notes created so far
    private static void clearNotes(String filename) {
    try (FileWriter fw = new FileWriter(filename)) { 
        System.out.println("All notes cleared!");
    } catch (IOException e) {
        System.out.println("Error clearing notes: " + e.getMessage());
    }
}

}
