package DSProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser chooser = new JFileChooser();
        chooser.setDragEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int choice = chooser.showOpenDialog(null);
        if (choice != JFileChooser.APPROVE_OPTION) {
            System.out.println("File not selected");
        }
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
        people.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\people.csv");
                Scanner sc = null;
                try {
                    sc = new Scanner(new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<String[]> values = new ArrayList<>();
                while (sc.hasNextLine())
                {
                    String line = sc.nextLine();
                    line = line.substring(1 , line.length()-1);
                    String[] vals = line.split("\",\"");
                    values.add(vals);
                }
                String[][] strings = new String[values.size()-1][6];
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
        });
    }
}
class Node
{
    String key;
    HashMap<String, Node> connected = new HashMap<>();
    HashMap<String, Edge> edges = new HashMap<>();
    public Node(String key) {
        this.key = key;
    }
    void connect(Node to, Edge edge)
    {
        connected.put(to.key , to);
        edges.put(edge.key , edge);
    }
}
class Edge
{
    String key;
    Node from, to;
    public Edge(String key, Node from, Node to) {
        this.key = key;
        this.from = from;
        this.to = to;
    }
}
class Person extends Node
{
    String firstname , lastname;
    String kode;
    String birthplace , job , birthday;
    public Person(String firstname, String lastname, String kode, String birthday, String birthplace, String job) {
        super(kode);
        this.firstname = firstname;
        this.lastname = lastname;
        this.kode = kode;
        this.birthplace = birthplace;
        this.job = job;
        this.birthday = birthday;
    }
}
class BankAccount extends Node
{
    long kode;
    String bankName , shaba;
    String accountNumber;
    public BankAccount(long kode, String bankName, String shaba, String accountNumber) {
        super(accountNumber);
        this.kode = kode;
        this.bankName = bankName;
        this.shaba = shaba;
        this.accountNumber = accountNumber;
    }
}
class Home extends Node
{
    long kode;
    String price , address;
    String postal;
    int metraj;
    public Home(long kode, String price , String postal , int metraj , String address) {
        super(postal);
        this.kode = kode;
        this.price = price;
        this.address = address;
        this.postal = postal;
        this.metraj = metraj;
    }
}
class Car extends Node
{
    String pelak , kode;
    String Model , color;

    public Car(String pelak, String kode, String model, String color) {
        super(pelak);
        this.pelak = pelak;
        this.kode = kode;
        Model = model;
        this.color = color;
    }
}
class Mobile extends Node
{
    long kode;
    String number , operator;
    public Mobile(long kode, String number, String operator) {
        super((number.charAt(0)=='0')?number = number.substring(1):number);
        this.kode = kode;
        this.number = number;
        this.operator = operator;
    }
}
class Own extends Edge
{
    String shomare;
    String time, price;

    public Own(Node from, Node to, String shomare, String time, String price) {
        super(shomare, from, to);
        this.shomare = shomare;
        this.time = time;
        this.price = price;
    }
}
class Transaction extends Edge
{
    String time, price;
    String shomare;
    public Transaction(Node from, Node to, String shomare , String time , String price) {
        super(shomare, from, to);
        this.time = time;
        this.price = price;
        this.shomare = shomare;
    }
}
class Call extends Edge
{
    String shomare;
    String time;
    int duration;
    public Call(Node from, Node to, String shomare, String time, int duration) {
        super(shomare, from, to);
        this.shomare = shomare;
        this.time = time;
        this.duration = duration;
    }
}
class Relation extends Edge
{
    String role , time;
    public Relation(Node from, Node to, String role, String time) {
        super(from.key + to.key, from, to);
        this.role = role;
        this.time = time;
    }
}
class CityGraph
{
   HashMap<String , Node> nodes = new HashMap<>();
   HashMap<String , Edge> edges = new HashMap<>();
   HashMap<String , Person> persons = new HashMap<>();
   HashMap<String , BankAccount>  bankAccounts= new HashMap<>();
   HashMap<String , Call> calls = new HashMap<>();
   HashMap<String , Car> cars = new HashMap<>();
   HashMap<String , Home> homes = new HashMap<>();
   HashMap<String , Own> owns =new HashMap<>();
   HashMap<String , Mobile> mobiles = new HashMap<>();
   HashMap<String , Relation> relations =new HashMap<>();
   HashMap<String , Transaction> transactions =new HashMap<>();
}
