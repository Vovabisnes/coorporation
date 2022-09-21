import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Coorporation {
    private static ArrayList<Employee> list = new ArrayList<>();

    static Scanner sc=new Scanner(System.in);

public static void main(String[] args) throws IOException {
    dataRead("C:\\Users\\vhavryliuk\\IdeaProjects\\coorporation\\test.txt");
    menu();
}

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("CHOOSE THE NUMBER:");
            System.out.println("1.Data Input\n 2.Edit Employee\n 3.Delete Employee \n 4.Find Employee \n 5.Data Output \n 6.Exit ");
            int num = sc.nextInt();
            switch (num){
                case 1: {
                    dataInput();
                    break;
                }
                case 2: {
                    editEmployee();
                    break;
                }
                case 3: {
                    deleteEmployee();
                    break;
                }
                case 4: {
                    findEmployee();
                    break;
                }
                case 5: {
                    dataOutput();
                    break;
                }
                case 6 : exit();
                default: {
                    System.out.println("Enter correct number");
                    break;
                }
            }
        }
    }

    public static void exit() {
        File file = new File("list.txt");

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bf = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bf))
        {
            for (Employee employee: list){
                out.print(employee.toString() + "\n");
            }
            System.out.println("Successfully written data to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    private static void dataInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name Surname Age PlaceOfWork Job");
        list.add(parseLine(scanner.nextLine()));
    }

    private static void deleteEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Surname");
        String surname = scanner.nextLine();

        for (int i=0; i<list.size(); i++){
            if (list.get(i).getSurname().toLowerCase().equals(surname.toLowerCase())){
                list.remove(i);
                System.out.println("The employee was successfully deleted");
            }
        }
    }

    private static void findEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Surname");
        String surname = scanner.nextLine();

        for (int i=0; i<list.size(); i++){
            if (list.get(i).getSurname().toLowerCase().equals(surname.toLowerCase())){
                System.out.println(list.get(i).toString());
            }
        }
    }

    private static void dataOutput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("CHOOSE THE NUMBER:");
        System.out.println("1.Output by age: \n 2. Output by letter\n  3.Exit");
        int num = scanner.nextInt();

        switch (num){
            case 1: {
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Enter the age: ");
                int age = scanner2.nextInt();
                File file = new File("employeeAge.txt");

                try (FileWriter fw = new FileWriter(file);
                     BufferedWriter bf = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bf))
                {
                    for (Employee employee: list){
                        if (employee.getAge() == age){
                            out.print(employee.toString() + "\n");
                            System.out.println(employee.toString());
                        }
                    }
                    System.out.println("Successfully written data to the file");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Enter the first letter: ");
                String letter = scanner2.next();
                File file = new File("employeeSurname.txt");

                try (FileWriter fw = new FileWriter(file);
                     BufferedWriter bf = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bf))
                {
                    for (Employee employee: list){
                        if (employee.getSurname().toLowerCase().startsWith(letter.toLowerCase())){
                            out.print(employee.toString() + "\n");
                            System.out.println(employee);
                        }
                    }
                    System.out.println("Successfully written data to the file");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3: break;
            default: {
                System.out.println("Incorrect number");
                break;
            }
        }
    }

    private static void editEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Surname");
        String surname = scanner.nextLine();

        Employee employee = null;
        for (int i=0; i<list.size(); i++){
            if (list.get(i).getSurname().toLowerCase().equals(surname.toLowerCase())){
                employee = list.get(i);
                break;
            }
        }

        Scanner scanner2 = new Scanner(System.in);
            System.out.println("CHOOSE THE NUMBER:");
            System.out.println("1.Edit name\n 2.Edit surname\n 3.Edit Age \n 4.Edit PlaceofWork \n 5. Edit \n 6.Exit ");
            int num = scanner2.nextInt();
            switch (num){
                case 2: {
                    System.out.println("Enter the surname:");
                    employee.setSurname(scanner2.next());
                    break;
                }
                case 3: {
                    System.out.println("Enter the age:");
                    employee.setAge(scanner2.nextInt());
                    break;
                }
                case 4: {
                    System.out.println("Enter the place of work:");
                    employee.setWorkplace(scanner2.next());
                    break;
                }
                case 5: {
                    System.out.println("Enter new Job:");
                    employee.setJob(scanner2.next());
                    break;
                }
                case 6: break;
                default: {
                    System.out.println("Incorrect number");
                    break;
                }
        }
    }


    private static void listOutput(){
        for (Employee e: list){
            System.out.println(e.toString());
        }
    }
    private static void dataRead(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName));
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            Employee employee = parseLine(scanner.next());
            list.add(employee);
            System.out.println(employee.toString());
        }
        scanner.close();
    }

    private static Employee parseLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\\s* \\s*");
        String name = scanner.next();
        String surname = scanner.next();
        int age = scanner.nextInt();
        String workplace = scanner.next();
        String job = scanner.next();
        return new Employee(name, surname, age, workplace, job);
    }

    }

