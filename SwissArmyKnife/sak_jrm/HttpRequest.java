/**
* The HttpRequest.java file controls the HttpRequest command for the Swiss Army Knife program.
* The -HttpRequest command downloads and displays a URL on the console (only usable with plaintext files..
* @author  Jocelyn Murray
* @version 1.0
* @since   2019-10-31
*/

import java.util.ArrayList;

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpRequest{
    //CTURL or Current URL stores the contents of the URL as an ArrayList containing strings.
    protected ArrayList<String> CTURL;
    //RQURL or Request URL stores the URL that the user requests.
    private String RQURL;

    //Default Constrtuctor
    HttpRequest(){
        RQURL = "";
        CTURL = new ArrayList<String>();
    }

    //Parses through the Request URL and creates a connection, later used in HttpRequestIndex.java.
    public boolean readRQURL(String URLNLL) {
        
        RQURL = URLNLL;
        boolean retvalA = false;
        
        //Reads the URL's page and adds lines to the ArrayList to outprint.
        try{
            URL aURL = new URL(RQURL);
            URLConnection aConnection = aURL.openConnection();
            BufferedReader a = new BufferedReader(new InputStreamReader(aConnection.getInputStream()));
            String ILine;
            while((ILine = a.readLine()) != null ) {
                CTURL.add(ILine);
                retvalA = true;
            }
            a.close();
        }

        //If the URL is invalid, an exception will be thrown saying that the HttpRequest is invalid.
        catch (Exception e) {
            retvalA = false;
            System.out.println("Exeption: HTTP Request");
            System.out.println("URL:" + RQURL);
        }

        return retvalA;
        }

    //Establishes the toString function for HttpRequest, outprinting the countents of the Requested URL page.
    public String toString() {
        String retvalB = "URL: " + RQURL;
        for (String e : CTURL) {
            retvalB = retvalB + e + "\n";
        }
        return retvalB;
    }


    //Test run for main
    public static void main(String[] args) {
        HttpRequest request = new HttpRequest();
        if (request.readRQURL("https://thunderbird-data-jrmv2.azurewebsites.net/strange.json")) {
            System.out.println(request);
        }    
    }
}