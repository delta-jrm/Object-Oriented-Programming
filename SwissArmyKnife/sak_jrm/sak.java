/**
* the SAK project is an assignment to create a command line application that can be utilized as a "sandbox" environment to work on new features before you add them to more sophisticated applications. 
* The SAK can downloads and display URLs on the console.
* @author  Jocelyn Murray
* @version 1.0
* @since   2019-10-31
*/


public class sak {

   public static void main(String[] args) {

       //Firstline intro to running the program
       System.out.println("Now Running... SWISS ARMY KNIFE!!!");
      

      //Checks what to do in the case that the user types -Help, in a case insensitive way.
       if ((args.length < 1) || (args[0].equalsIgnoreCase("-Help"))) {
           
           //Checks if there are no arguments input, throws invalid error and displays -Help to provide user help.
           if (args.length < 1) {
               System.out.println("Invalid: Please refer to the -Help information which will be printed below:");
           }
           help.provideHelp();
           System.exit(0);
       }

       //Checks what to do in the case that the user types -HttpRequest or -HttpRequestIndex and there is not a valid URL, in a case insensitive way.
       else if (((args[0].equalsIgnoreCase("-HttpRequest")) || (args[0].equalsIgnoreCase("-HttpRequestIndex"))) && (args.length != 2)) {
           System.out.println("Invalid: -HttpRequest and -HttpRequestIndex need a valid URL. Please use the -Help for more info");
           System.exit(0);
       }

       //Checks to see if the input arguments are valid.
       else if ((args.length > 2) || (args.length < 2)) {
           System.out.println("Invalid: Not a valid function. Please use the -Help argument for more info");
           System.exit(0);
       }

       String URLa = args[1];
      
      //Checks what to do in the case that the user types -HttpRequest or -HttpRequestIndex with a valid index in a case insensitive way.
       if (args[0].equalsIgnoreCase("-HttpRequest")) {
           HttpRequest request = new HttpRequest();
           
           
           //Creates new HttpRequest and runs the command to read the URL and print the response
           System.out.println("-Running HttpRequest...");
          
           if (request.readRQURL(URLa)) {
               System.out.println(request);
           }

           //In the case that the URL cannot be accessed, an error will be thrown.
           else {
               System.out.format("Invalid: Can't access URL: ", URLa);
           }  
       }

       //Creates new HttpRequestIndex and runs the command to read the URL and print the response
       else if (args[0].equalsIgnoreCase("-HttpRequestIndex")) {
           HttpRequestIndex requestIndex = new HttpRequestIndex();
          
           System.out.println("-Running HttpRequestIndex...");

           if (requestIndex.readRQURL(URLa)) {
                System.out.println(requestIndex);
           }

           //In the case that the URL cannot be accessed, an error will be thrown.
           else {
               System.out.format("Can't access URL: ", URLa);
           }
       }
   }
}