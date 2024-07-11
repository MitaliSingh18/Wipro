import java.util.Scanner;
interface Medication {
    String getName();
    int getId();
    double getPrice();
    void use();
}
class Presmedi implements Medication {
    private String name;
    private int id;
    private double price;

    public Presmedi(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }

    public void use() {
        System.out.println("Prescription medication " + getName() + " is taken with prescription.");
    }
}

class Coutmedi implements Medication {
    private String name;
    private int id;
    private double price;
public Coutmedi(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }
public String getName() {
        return name;
    }
  public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void use() {
        System.out.println("Over the counter medication " + getName() + " is taken without prescription.");
    }
}
public class Pharma {
    private Medication[] medications;
    private int medicount;

    public Pharma(int capacity) {
        medications = new Medication[capacity];
        medicount = 0;
    }

    public void addmedi(Medication medication) {
        if (medicount < medications.length) {
            medications[medicount++] = medication;
        } else {
            System.out.println("Medication list is full!");
        }
    }
    public void dismedi() {
        for (int i = 0; i < medicount; i++) {
            Medication medication = medications[i];
            System.out.println("ID: " + medication.getId() + ", Name: " + medication.getName() + ", Price: " + medication.getPrice());
            medication.use();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pharma pms = new Pharma(10);

        while (true) {
            System.out.println("1. Add Medication");
            System.out.println("2. Display All Medications");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
        
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
        System.out.println("Enter type (1 for Prescription, 2 for Over the counter): ");
                    int type = scanner.nextInt();

                    Medication medication;
                    if (type == 1) {
                        medication = new Presmedi(name, id, price);
                    } else if (type == 2) {
                        medication = new Coutmedi(name, id, price);
                    } else {
                        System.out.println("Invalid");
                        continue;
                    }
                    pms.addmedi(medication);
                    break;

                case 2:
                    pms.dismedi();
                    break;

                case 3:
                    scanner.close();
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid");
            }
        }
    }
}


