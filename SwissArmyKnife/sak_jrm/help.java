/**
* The help.java file controls the help command for the Swiss Army Knife program.
* The -Help command is meant to share information and clear up confusion about any command a user may run.
* @author  Jocelyn Murray
* @version 1.0
* @since   2019-10-31
*/

import java.util.ArrayList;

public class help{

    public static void provideHelp(){
        ArrayList <String> disphelp = new ArrayList<String>();

        //Introduces Swiss Army Knife, confirms that it is running.
        disphelp.add("Now Running... SWISS ARMY KNIFE \n");
        disphelp.add("Commands: \n");

        //Provides help with the -Help command as well as an example of it running.
        disphelp.add("-Help: Provides help for the application. \n");
        disphelp.add("EXAMPLE: java sak -Help \n");

        //Provides help with the -HttpRequest command as well as an example of it running against microsoft's website.
        disphelp.add("-HttpRequest [URL]: Downloads and displays a URL on the console (only usable with plaintext files. \n");
        disphelp.add("EXAMPLE: java sak -HttpRequest https://microsoft.com \n");

        //Provides help with the -HttpRequestIndex command as well as an example of it running against Dr. Strange's JSON file on my Azure sitete.
        disphelp.add("-HttpRequestIndex [URL]: Downloads and displays a URL on the console (usable with JSON files contains URLS) \n");
        disphelp.add("EXAMPLE: java sak -HttpRequestIndex https://thunderbird-data-jrmv2.azurewebsites.net/strange.json \n");

        //For each loop will outprint all lines in the -Help command
        for(String help: disphelp){
            System.out.println(help);
        }
    }
}