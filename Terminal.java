import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

public class Terminal {
     Parser obj ;
     boolean flag ;

    public Terminal(String input)
    {
        obj = new Parser(input) ;
        flag = obj.parse(input) ;

    }
//ls command ------------------------------------------------
    public void ls() {


        File f = null;
        String[] paths;
        //  System.out.println(flag);
        //   System.out.println(obj.arguments.length);
        //System.out.printf(obj.arguments[0]);
        if (flag == true) {
            try {


                if (obj.arguments.length - 1 == 0) {
                    f = new File(System.getProperty("user.dir"));
                    paths = f.list();
                    for (String path : paths) {
                        System.out.println(path);
                    }
                } else {
                    try {
                        f = new File(obj.arguments[0]);
                        paths = f.list();
                        for (String path : paths) {
                            System.out.println(path);
                        }
                    } catch (Exception e) {
                        System.out.println("ls: cannot access " + obj.arguments[0] + ": No such file or directory");
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid current Directory use cd to solve it ");
            }

        }
        else
        {
            System.out.println("Invalid Path");
        }
    }

//---------------------------------cd command --------------------------
    public void cd()
    {
        if(obj.arguments.length-1 == 0)
        {
            System.setProperty("user.dir", "/root");


        }
        else
        {
            System.setProperty("user.dir", obj.arguments[0]);

        }




    }
    public void pwd()
    {
       // System.out.println(obj.arguments.length);
        System.out.println("Current Directory: "+System.getProperty("user.dir"));

     }
     public  void rm()
     {

         if(flag)
         {
             File file = new File(obj.arguments[0]);
             if(file.delete())
             {
                 System.out.println("File deleted successfully");
             }
             else
             {
                 System.out.println("Failed to delete the file");
             }
         }
         else
         {
             System.out.println("rm: missing operand\n");
         }
     }
     public void mv( ) throws IOException {
        // System.out.println(obj.arguments[0]);
         //System.out.println(obj.arguments[1]);
         //System.out.println(obj.arguments.length);
         //System.out.println(flag);
         if(flag)
         {
             try {


                 if (new File(obj.arguments[0]).isDirectory()) {
                     Files.move(new File(obj.arguments[0]).toPath(), new File(obj.arguments[1]).toPath(), StandardCopyOption.REPLACE_EXISTING);
                 }
                 else {

                     //         System.out.println(obj.arguments[0]);
                     //       System.out.println(obj.arguments[1]);
                     //     System.out.println(obj.arguments.length);
                     Path temp = Files.move(Paths.get(obj.arguments[0]), Paths.get(obj.arguments[1]));
                     if (temp != null) {
                         System.out.println("File renamed and moved successfully");
                     } else {
                         System.out.println("Failed to move the file");
                     }
                 }
             }
             catch (Exception e)
             {
                 System.out.println("Invaild path");
             }

         }
     }
     public void rmdir(File file)throws IOException
     {
         /*
         System.out.println(flag);
         System.out.println(obj.arguments.length);
         System.out.println(obj.arguments[0]);
         */

          if(flag)
         {

             if (file.isDirectory()) {
                 File[] entries = file.listFiles();
                 if (entries != null) {
                     for (File entry : entries) {
                         rmdir(entry);
                     }
                 }
             }
             if (!file.delete())
             {
                 throw new IOException("Failed to delete " + file);
             }
         }
     }
     public void date ()
     {
         if(flag)
         {
             Date date = new Date();
             System.out.println(date.toString());
         }

     }
     public void help() {
         if (flag) {


             System.out.println("args : List all command arguments\n" +
                     "date : Current date/time\n" +
                     "exit : Stop all\n" +
                     "rmdir : Delete Directory\n" +
                     "cp : copy file to specific Destination\n" +
                     "ls : list all files\n" +
                     "pwd : Print current Working Directory\n" +
                     "mv : move or rename file or directory\n" +
                     "rm : remove files\n" +
                     "cat : print the file content\n" +
                     "cd : change Directory\n" +
                     "clear : clears your screen if this is possible\n");
         }
     }
     public void cat() throws IOException {
         if(flag)
         {
             BufferedReader in = new BufferedReader(new FileReader(obj.arguments[0]));
             String line= "asd";

             while((line = in.readLine()) != null)
             {
                 System.out.println(line);
             }
             in.close();
         }
     }
     public void args()
     {
        if(flag)
        {
            switch (obj.arguments[0]) {
                case "ls":
                    System.out.printf("arg1 destination path ,or the default is the home directory\n");
                    break ;
                case "cp":
                    System.out.printf("arg1:source path , arg2:destination path \n");
                    break ;
                case "rmdir":
                    System.out.printf("arg1:source path\n");
                    break ;
                case "mv":
                    System.out.printf("arg1:source path ,arg2:destination path\n");
                    break ;
                case "rm":
                    System.out.printf("arg1: source path\n");
                    break ;
                case "mkdir":
                    System.out.printf("arg1:source path of the new directory\n");
                    break ;
                case "cat":
                    System.out.printf("arg1 : path source path to print it's content\n");
                    break ;
                case "cd":
                    System.out.printf("arg1 : Destination path\n");
                    break ;
                default:
                    System.out.println("Invalid Command");
            }
           }
     }
     public void mkdir()
     {
         if(flag)
         {
              File file = new File(obj.arguments[0]);
             if (!file.exists()) {
                 if (file.mkdir()) {
                     System.out.println("Directory is created!");
                 } else {
                     System.out.println("Failed to create directory!");
                 }
             }
             else if (file.exists())
             {
                 System.out.println("Already Exists " );
             }


         }
     }

     public  void clear()
     {
         System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

     }
     public void cp() throws IOException {
          try {
             if (flag) {
                 File source = new File(obj.arguments[0]);
                 File dest = new File(obj.arguments[1]);
                 //System.out.println(obj.arguments[0]);
                 //System.out.println(obj.arguments[1]);
                 Files.copy(source.toPath(), dest.toPath());
             }
             else
             {
                 System.out.println("cp: missing file operand");
             }
         } catch (IOException e) {
              System.out.println("cp: cannot stat "+obj.arguments[0] +  ": No such file or directory");
         }
     }
     public void more() throws IOException {
        try {

            if (flag) {
                BufferedReader in = new BufferedReader(new FileReader(obj.arguments[0]));
                Scanner myScannerObj = new Scanner(System.in);
                String breaker;
                int counter = 1;
                String line;

                while ((line = in.readLine()) != null) {

                    if (counter % 6 != 0) {
                        System.out.println(line);

                    }

                    else
                    {
                        breaker = myScannerObj.nextLine();
                    }
                    counter++ ;

                }
                in.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("more cannot stat "+obj.arguments[0]+" :  (No such file or directory)");
        }
     }
     public void cat2() throws IOException {
         try {
             if (flag) {
                 BufferedWriter writer;
                 BufferedReader in = new BufferedReader(new FileReader(obj.arguments[0]));
                 if (obj.arguments[1] == ">") {
                     writer = new BufferedWriter(new FileWriter(obj.arguments[2]));

                 } else {
                     writer = new BufferedWriter(new FileWriter(obj.arguments[1]));
                 }

                 String line;
                 while ((line = in.readLine()) != null) {

                     writer.write(line);
                     writer.write("\n");
                 }
                 in.close();
                 writer.close();
             }
         } catch (IOException e) {
            // e.printStackTrace();
             System.out.println("Fix the arguments");
         }
     }
    public void cat3() throws IOException {
        try {
            if (flag) {
                BufferedWriter writer;
                BufferedReader in = new BufferedReader(new FileReader(obj.arguments[0]));

                if (obj.arguments[1] == ">>" ) {
                    writer = new BufferedWriter(new FileWriter(obj.arguments[2], true));
                    //System.out.println(obj.arguments[2]);

                } else {
                    writer = new BufferedWriter(new FileWriter(obj.arguments[1], true));
                    //System.out.println(obj.arguments[1]);
                }

                String line;
                while ((line = in.readLine()) != null) {
                    writer.append("\n");
                   // System.out.println(line);
                    writer.append(line);

                }
                in.close();
                writer.close();
            }
        } catch (IOException e) {
           // e.printStackTrace();
            System.out.println("Fix the arguments");
        }
    }

}












