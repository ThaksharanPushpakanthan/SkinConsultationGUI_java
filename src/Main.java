import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EOFException {

        boolean ans = true;
        Scanner scanner = new Scanner(System.in);
        WestminsterSkinConsultationManager west = new WestminsterSkinConsultationManager();

        //Initially load all the data from the file
        west.LoadFromFile(WestminsterSkinConsultationManager.list);
        ConsultationGUI.LoadFromFile(ConsultationGUI.patientList,ConsultationGUI.consultationList);

        System.out.println("\n Welcome to Westminster Skin Consultation Manager");

        do {
            System.out.println("|                            Menu                            |");
            System.out.println("===============================" + "===============================");
            System.out.println("| Enter A to Add a Doctor");
            System.out.println("| Enter D to Delete a Doctor");
            System.out.println("| Enter P to Print the list of Doctors");
            System.out.println("| Enter S to Save in file");
            System.out.println("| Enter O to Open Graphical User Interface");
            System.out.println("| Enter Q to Quit");
            System.out.println("=============================================================");

            System.out.println("Enter your selection:");
            String choice = scanner.next().toUpperCase();

            switch (choice) {
                case "A" -> west.AddNewDoc();
                case "D" -> west.DeleteDoc();
                case "P" -> west.PrintListOfDoc();
                case "S" -> west.SaveInFile();
                case "O" -> EventQueue.invokeLater(() -> {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                            UnsupportedLookAndFeelException e) {
                        throw new RuntimeException(e);
                    }
                    new HomePageGUI();
                });
                case "Q" -> ans = false;
            }

        } while (ans);
        System.out.println("\nThank you for your time, Bye!");
    }
}