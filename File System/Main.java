import java.util.*;

class File {
    String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }
}

public class Filesystem {
    private static ArrayList<File> desktop = new ArrayList<>();
    private static ArrayList<File> document = new ArrayList<>();
    private static ArrayList<File> pictures = new ArrayList<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome");
            System.out.println("1: Create a file and add to a directory");
            System.out.println("2: Rename a file");
            System.out.println("3: Delete a file");
            System.out.println("4.print");
            System.out.println("4: Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    create(sc);
                    break;
                case 2:
                    rename(sc);
                    break;
                case 3:
                    delete(sc);
                    break;
                case 4:
                	print(sc);
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    public static void create(Scanner sc) {
        System.out.print("Enter File Name: ");
        String fileName = sc.nextLine();
        File newFile = new File(fileName);

        System.out.println("Select a directory to add the file:");
        System.out.println("1: Desktop");
        System.out.println("2: Documents");
        System.out.println("3: Pictures");
        
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();  
        switch (choice) {
            case 1:
                desktop.add(newFile);
                System.out.println("File added to Desktop.");
                break;
            case 2:
                document.add(newFile);
                System.out.println("File added to Documents.");
                break;
            case 3:
                pictures.add(newFile);
                System.out.println("File added to Pictures.");
                break;
            
            	
            default:
                System.out.println("Invalid choice. File not added.");
        }
    }

    public static void rename(Scanner sc) {
        System.out.print("Enter the current file name: ");
        String oldName = sc.nextLine();

        File file = findFile(oldName);
        if (file != null) {
            System.out.print("Enter the new file name: ");
            file.fileName = sc.nextLine();
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("File not found.");
        }
    }

    public static void delete(Scanner sc) {
        System.out.print("Enter the file name to delete: ");
        String fileName = sc.nextLine();
        
        if (removeFile(fileName)) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File not found.");
        }
    }

    private static File findFile(String fileName) {
        for (File file : desktop) {
            if (file.fileName.equals(fileName)) return file;
        }
        for (File file : document) {
            if (file.fileName.equals(fileName)) return file;
        }
        for (File file : pictures) {
            if (file.fileName.equals(fileName)) return file;
        }
        return null;
    }

    private static boolean removeFile(String fileName) {
        return desktop.removeIf(file -> file.fileName.equals(fileName)) ||
               document.removeIf(file -> file.fileName.equals(fileName)) ||
               pictures.removeIf(file -> file.fileName.equals(fileName));
    }
    private static void print(Scanner sc) {
    	System.out.println("Select a directory to print:");
        System.out.println("1: Desktop");
        System.out.println("2: Documents");
        System.out.println("3: Pictures");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();  
        switch (choice) {
            case 1:
                
                System.out.println(desktop.toString());
                break;
            case 2:
            	System.out.println(document.toString());
                break;
            case 3:
            	System.out.println(pictures.toString());
                break;
            
            	
            default:
                System.out.println("Invalid choice. File not added.");
        }
    }
}
