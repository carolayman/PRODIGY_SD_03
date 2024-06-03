import java.util.*;
import java.io.*;
public class contact {
    private String path;
    private String name ;
    private String phone_number ;
    private String email ;

    public boolean addContact(int userid, String name, String phone, String email)
    {
        this.path  = userid+"\\"+name+".txt" ;
        String data =  name + "\n" + phone + "\n" + email ;
        File file = new File(this.path) ;
        if (file.exists()) {
            System.out.println("Contact is already exists");
            return false; }
        PrintWriter pr = null;
        try {
            pr = new PrintWriter(new FileWriter(this.path,false),true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pr.println(data);
        pr.close();
        return true;
    }

    public void viewContacts (int UserId){
        File dir = new File("D:\\Intellj\\TASK 3\\"+UserId);
        String[] files = dir.list();
        File file1 = null ;
        for (String file : files) {
            file1 = new File("D:\\Intellj\\TASK 3\\"+UserId+"\\"+file);
            try {
                Scanner fr = new Scanner (file1);
                while(fr.hasNextLine())
                    System.out.println(fr.nextLine());
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean editPhone(int UserId ,String name ,String New){
        File file = new File("D:\\Intellj\\TASK 3\\"+UserId+"\\"+name+".txt");
        String[] arr ;
        try {
            Scanner fr = new Scanner (file);
            StringBuilder lines = new StringBuilder();
            while(fr.hasNextLine())
                lines.append(fr.nextLine()).append("\n");
            arr = (lines.toString().split("\n"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        arr[1] = New ;
        String data =  arr[0] + "\n" + arr[1] + "\n" + arr[2] ;

        if (!file.exists()) {
            System.out.println("Contact is not exists");
            return false; }

        PrintWriter pr = null;
        try {
            pr = new PrintWriter(new FileWriter(file,false),true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pr.println(data);
        pr.close();
        return true;
    }

    public static boolean deleteContact(int userId,String name){
        try {
            File file = new File( "D:\\Intellj\\TASK 3\\"+userId+"\\"+name+".txt");
            if (file.exists()) {
                if (file.delete()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SecurityException e) {
            return false;
        }
    }


}
