import java.util.Arrays;

public class Parser {
    String[] arguments ;
    String cmd ;
    String[] commands = {"cd","ls","cp","cat","more","mkdir","rmdir","mv","rm","date","help","pwd","clear","args","help"} ;

    public  Parser(String input)
    {
        //parse(input) ;
       // getCmd();
        //getArguements();
    }

    public boolean parse(String input) {
        boolean quoteExist=false ;
        int numberOfquotes = 0 ;
        for(int p =0 ; p<input.length() ; p++)
        {
            if(input.toCharArray()[p] == '"')
            {
                numberOfquotes++ ;
            }

        }

        for(int h = 0 ;h <input.length() ; h++)
        {
             if(input.toCharArray()[h] == '"')
            {
                quoteExist =true ;
                break;
            }
        }
         if (quoteExist == true) {
              arguments = new String[numberOfquotes/2+1];
             cmd = input.split(" ")[0]; //return the command
            int argumentCounter = 0;
            int counter = 0 ;
             for (int i = 0; i < input.length(); i++){
                if (input.toCharArray()[i] == '"') {
                    counter++ ;

                    int firstQuoteIndex = i;
                    if(counter%2 != 0 )
                    {
                        //System.out.println("i = " + i );
                    for (int x = i + 1; x < input.length(); x++) {
                        if (input.toCharArray()[x] == '"') {
                            arguments[argumentCounter] = input.substring(i + 1, x);
                            //System.out.println("argument counter = " + argumentCounter);

                           // System.out.println("arg = " + arguments[argumentCounter]);
                             argumentCounter++;
                            //System.out.println(argumentCounter+"\n"+
                            //        arguments.length+"\n");
                            break;
                        }
                    }
                    }
                }
            }
        }
         else {
             arguments = new String[input.split(" ").length];
             cmd = input.split(" ")[0]; //return the command
            for (int i = 1; i < input.split(" ").length; i++) {
                arguments[i - 1] = input.split(" ")[i]; //append the arguments to the arguments array

            }
        }
            boolean contains = Arrays.stream(commands).anyMatch(cmd::equals);
            if (contains) {

                if (cmd.compareTo("cp") == 0 || cmd.compareTo("mv") == 0 ) {
                    boolean argumentsNumber = (arguments.length-1 == 2) ? true : false;
                    return argumentsNumber;
                }
                if (cmd.compareTo("pwd") == 0) {
                    boolean argumentsNumber = (arguments.length-1 == 0) ? true : false;
                    return argumentsNumber;

                }
                if (cmd.compareTo("ls") == 0 || cmd.compareTo("cd") == 0) {
                    boolean argumentsNumber = (arguments.length-1 == 0 || arguments.length-1 == 1) ? true : false;
                    return argumentsNumber;

                }
                if (cmd.compareTo("args") == 0 ||  cmd.compareTo("more") == 0 || cmd.compareTo("mkdir") == 0 || cmd.compareTo("rmdir") == 0 || cmd.compareTo("rm") == 0) {
                    boolean argumentsNumber = (arguments.length-1 == 1) ? true : false;
                    return argumentsNumber;

                }
                if(cmd.compareTo("cat") == 0 )
                {
                    //boolean argumentsNumber = true ;
                    boolean argumentsNumber = (arguments.length-1 == 1 || arguments.length-1 == 2|| arguments.length-1 == 3) ? true : false;
                    return argumentsNumber;
                }
                if(cmd.compareTo("help") == 0 )
                {
                    boolean argumentsNumber = (arguments.length-1 == 0) ? true : false;
                    return argumentsNumber;
                }
            }
            //System.out.println("bash: " + cmd + ": command not found");
            return false;


    }
    public String getCmd()
    {
         return cmd ;
    }



    public String[] getArguements()
      {

          return arguments ;


      }




}
