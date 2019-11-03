/**
* The HttpRequestIndex.java file controls the help command for the Swiss Army Knife program.
* The -HttpRequestIndex command is meant to download and display a URL on the console (usable with JSON files contains URLS)
* @author  Jocelyn Murray
* @version 1.0
* @since   2019-10-31
*/

public class HttpRequestIndex extends HttpRequest {
   
   //Constructor call to the Super Class (HTTPRequest)
   HttpRequestIndex() {
       super();
   }
  
   //Request to read the Requested URL (RRQURL), doesn't overwrite the Super's RQURL
   public Boolean readRRQURL(String i) {
       Boolean retvalC = super.readRQURL(i);

       // The following block of code acts as a makeshift JSON interpreter used to cut out extra whitespace in order to put it into a readable format. 
       for (String l : CTURL) {
           l = l.trim();
           l = l.replace("{ \"", "");

           if (l.substring(l.length() - 1).contentEquals(",")) {
               l = l.replace("\" },", "");
           }
           else {
               l = l.replace("\" }", "");
           }

           l = l.replace("\" },", "");

           //lTks signifies Line Tokens
           String lTks[] = l.split("\", \""); 
          
           if (lTks.length > 1) {
               for (String lTk : lTks) {
                   String pTks[] = lTk.split("\":\"");
                  
                   // This initiates the search for the https:// URL, and subsequently carries out the command.
                   if (pTks[1].toLowerCase().startsWith("https://")) {
                       HttpRequest eHTTPRQ = new HttpRequest();
                       if (eHTTPRQ.readRQURL(pTks[1])) {
                           System.out.println(eHTTPRQ.toString());
                       }
                       else {
                           System.out.println("This URL cannot be accessed: " + pTks[1]);
                       }
                   }
               }
           }
       }
      
       return retvalC;
   }
}

