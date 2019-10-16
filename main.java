import java.io.File;
import java.io.IOException;
import  java.util.Scanner; //import scanner class
public class main {
    public static void main(String argus[]) throws IOException {


        //Parser p = new Parser("rmdir /Desktop/file " ) ;
         ///Terminal t = new Terminal(input);

         // new Terminal("cat /root/Desktop/file");
       // Terminal t = new Terminal("ls \"/root\"");
         // t.ls();
        //t.cd();
         //t.pwd();
        //t.cd();
      //  t.pwd();
        //t.rm();
       // t.date();
        //t.help();
       // t.rmdir(new File("/root/Desktop/Texts"));
        //t.cat();



       // String[] arr = p.getArguements() ;
         //System.out.println(System.getProperty("user.dir"));
     ///  System.out.println(arr[]);
        Scanner myScannerObj = new Scanner(System.in) ; //create scanner object

        Terminal t;
        Terminal first = new Terminal("") ;
        Terminal second = new Terminal("") ;
        String input ;

        while (true) {
            System.out.printf("root@Marwan:~# ");
            input = myScannerObj.nextLine();
            t = new Terminal(input);

            String firstInput = "", secondInput = "";

            if (input.contains(";")) {
                firstInput = input.substring(0, input.indexOf(';') - 1);
                //System.out.println(firstInput);
                secondInput = input.substring(input.indexOf(';') + 2, input.length());
                //System.out.println(secondInput);
                first = new Terminal(firstInput);
                second = new Terminal(secondInput);
             }
            //---------------------------------------------------args----------------------------------------------------

            if (input.indexOf("args") != -1) {
                t.args();
                continue;
            }
            //---------------------------------------------------ls----------------------------------------------------

            if (input.indexOf("ls") != -1 || firstInput.indexOf("ls") != -1 || secondInput.indexOf("ls") != -1) {
                if (firstInput.contains("ls")) {
                    first.ls();
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("ls")) {
                    second.ls();
                    System.out.println("-------------------------------------------------------------");

                } else {
                    t.ls();

                }
            }
            //---------------------------------------------------help----------------------------------------------------

            if (input.indexOf("help") != -1 || firstInput.indexOf("help") != -1 || secondInput.indexOf("help") != -1) {
                if (firstInput.contains("help")) {
                    first.help();
                    System.out.println("\n");

                } else if (secondInput.contains("help")) {
                    second.help();
                    System.out.println("\n");
                } else {
                    t.help();
                }
            }
            //---------------------------------------------------date----------------------------------------------------

            if (input.indexOf("date") != -1 || firstInput.indexOf("date") != -1 || secondInput.indexOf("date") != -1) {
                if (firstInput.contains("date")) {
                    first.date();
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("date")) {
                    second.date();
                    System.out.println("-------------------------------------------------------------");

                } else {
                    t.date();

                }
            }
            //---------------------------------------------------rmdir----------------------------------------------------
            if (input.indexOf("rmdir") != -1 || firstInput.indexOf("rmdir") != -1 || secondInput.indexOf("rmdir") != -1) {
                if (firstInput.contains("rmdir")) {
                    String fileName;
                    File file;
                    if (firstInput.contains("\"")) {
                        fileName = firstInput.substring(firstInput.indexOf("\"") + 1, firstInput.length() - 1);
                        file = new File(fileName);
                    } else {
                        fileName = firstInput.split(" ")[1];
                        file = new File(fileName);
                    }
                    first.rmdir(file);
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("rmdir")) {
                    if (secondInput.contains("rmdir")) {
                        String fileName;
                        File file;
                        if (secondInput.contains("\"")) {
                            fileName = secondInput.substring(secondInput.indexOf("\"") + 1, secondInput.length() - 1);
                            file = new File(fileName);
                        } else {
                            fileName = secondInput.split(" ")[1];
                            file = new File(fileName);
                        }
                        second.rmdir(file);
                        System.out.println("-------------------------------------------------------------");
                    }

                } else {
                    String fileName;
                    File file;
                    if (input.contains("\"")) {
                        fileName = input.substring(input.indexOf("\"") + 1, input.length() - 1);
                        file = new File(fileName);
                    } else {
                        fileName = input.split(" ")[1];
                        file = new File(fileName);
                    }
                    t.rmdir(file);

                }
            }

                //---------------------------------------------------mv----------------------------------------------------

            if (input.indexOf("mv") != -1 || firstInput.indexOf("mv") != -1 || secondInput.indexOf("mv") != -1) {
                if (firstInput.contains("mv")) {
                    first.mv();
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("mv")) {
                    second.mv();
                    System.out.println("-------------------------------------------------------------");

                } else {
                    t.mv();

                }
            }

                //---------------------------------------------------cd----------------------------------------------------

            if (input.indexOf("cd") != -1 || firstInput.indexOf("cd") != -1 || secondInput.indexOf("cd") != -1) {
                if (firstInput.contains("cd")) {
                    first.cd();
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("cd")) {
                    second.cd();
                    System.out.println("-------------------------------------------------------------");

                } else {
                    t.cd();

                }
            }
                //---------------------------------------------------pwd----------------------------------------------------

            if (input.indexOf("pwd") != -1 || firstInput.indexOf("pwd") != -1 || secondInput.indexOf("pwd") != -1) {
                if (firstInput.contains("pwd")) {
                    first.pwd();
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("pwd")) {
                    second.pwd();
                    System.out.println("-------------------------------------------------------------");

                } else {
                    t.pwd();

                }
            }
                //---------------------------------------------------cat----------------------------------------------------

            if (input.indexOf("cat") != -1 || firstInput.indexOf("cat") != -1 || secondInput.indexOf("cat") != -1) {
                if (firstInput.contains("cat")) {
                    first.cat();
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("cat")) {
                    second.cat();
                    System.out.println("-------------------------------------------------------------");

                } else {
                    if(input.contains(">>"))
                    {
                        t.cat3();

                        continue;
                    }
                    if(input.contains(">"))
                    {
                         t.cat2();
                    }

                    else
                    {
                        t.cat();
                    }


                }
            }
                //---------------------------------------------------mkdir----------------------------------------------------

            if (input.indexOf("mkdir") != -1 || firstInput.indexOf("mkdir") != -1 || secondInput.indexOf("mkdir") != -1) {
                if (firstInput.contains("mkdir")) {
                    first.mkdir();
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("mkdir")) {
                    second.mkdir();
                    System.out.println("-------------------------------------------------------------");

                } else {
                    t.mkdir();

                }
            }
                //---------------------------------------------------clear----------------------------------------------------

            if (input.indexOf("clear") != -1 || firstInput.indexOf("clear") != -1 || secondInput.indexOf("clear") != -1) {
                if (firstInput.contains("clear")) {
                    first.clear();
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("clear")) {
                    second.clear();
                    System.out.println("-------------------------------------------------------------");

                } else {
                    t.clear();

                }
            }
                //---------------------------------------------------cp----------------------------------------------------

            if (input.indexOf("cp") != -1 || firstInput.indexOf("cp") != -1 || secondInput.indexOf("cp") != -1) {
                if (firstInput.contains("cp")) {
                    first.cp();
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("cp")) {
                    second.cp();
                    System.out.println("-------------------------------------------------------------");

                } else {
                    t.cp();

                }
            }
                //---------------------------------------------------more----------------------------------------------------

            if (input.indexOf("more") != -1 || firstInput.indexOf("more") != -1 || secondInput.indexOf("more") != -1) {
                if (firstInput.contains("more")) {
                    first.more();
                    System.out.println("-------------------------------------------------------------");

                } else if (secondInput.contains("more")) {
                    second.more();
                    System.out.println("-------------------------------------------------------------");

                } else {
                    t.more();

                }
            }

            }
        }

        }




