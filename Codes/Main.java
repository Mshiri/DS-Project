package DSProject;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner sc = null;
    static JFileChooser chooser = new JFileChooser();
    public static void main(String[] args) {
        selectFolder();
        showMainMenu();
    }
    static void selectFolder()
    {
        chooser.setDragEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int choice = chooser.showOpenDialog(null);
        if (choice != JFileChooser.APPROVE_OPTION) {
            System.out.println("File not selected");
        }
    }
    static void showMainMenu()
    {
        JFrame frameMain = new JFrame();
        JButton people = new JButton("People");
        JButton accounts = new JButton("Accounts");
        JButton calls = new JButton("Calls");
        JButton cars = new JButton("Cars");
        JButton homes = new JButton("Homes");
        JButton ownerships = new JButton("Ownerships");
        JButton phones = new JButton("Phones");
        JButton relationships = new JButton("Relationships");
        JButton transactions = new JButton("Transactions");
        JPanel panel = new JPanel(new GridLayout(3 , 3));
        panel.add(people);
        panel.add(accounts);
        panel.add(calls);
        panel.add(cars);
        panel.add(homes);
        panel.add(ownerships);
        panel.add(phones);
        panel.add(relationships);
        panel.add(transactions);
        frameMain.add(panel);
        frameMain.setLocationRelativeTo(null);
        frameMain.setSize(400 , 200);
        frameMain.setVisible(true);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        people.addActionListener(actionEvent -> showPeople());
        accounts.addActionListener(actionEvent -> showAccounts());
        calls.addActionListener(actionEvent -> showCalls());
        cars.addActionListener(actionEvent -> showCars());
        homes.addActionListener(actionEvent -> showHomes());
        ownerships.addActionListener(actionEvent -> showOwn());
        phones.addActionListener(actionEvent -> showPhones());
        relationships.addActionListener(actionEvent -> showRelations());
        transactions.addActionListener(actionEvent -> showTrans());
    }
    static void showPeople()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\people.csv");
        scanner(file, 6);
    }

    private static void scanner(File file, int i2) {
        try {
            sc = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String[]> values = new ArrayList<>();
        assert sc != null;
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            line = line.substring(1 , line.length()-1);
            String[] vals = line.split("\",\"");
            values.add(vals);
        }
        String[][] strings = new String[values.size()-1][i2];
        String[] raw = values.get(0);
        for (int i=1;i<values.size();i++)
            strings[i-1] = values.get(i);
        JFrame jFrame = new JFrame();
        JTable table = new JTable(strings, raw);
        JScrollPane scrollPane = new JScrollPane(table);
        jFrame.add(scrollPane);
        jFrame.setLocationRelativeTo(null);
        jFrame.setExtendedState( jFrame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    static void showAccounts()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\accounts.csv");
        scanner(file, 4);
    }
    static void showOwn()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\ownerships.csv");
        scanner(file, 5);
    }
    static void showPhones()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\phones.csv");
        scanner(file, 3);
    }
    static void showRelations()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\relationships.csv");
        scanner(file, 4);
    }
    static void showTrans()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\transactions.csv");
        scanner(file, 5);
    }
    static void showCalls()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\calls.csv");
        scanner(file, 5);
    }
    static void showCars()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\cars.csv");
        scanner(file, 4);
    }
    static void showHomes()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\homes.csv");
        scanner(file, 5);
    }
}
