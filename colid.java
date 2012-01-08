import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;




/**
 *
 * @author sarim
 */
public class colid {
   static String fileToString(String filename) throws IOException
{
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    StringBuilder builder = new StringBuilder();
    String line;    

    // For every line in the file, append it to the string builder
    while((line = reader.readLine()) != null)
    {
        builder.append(line);
    }

    return builder.toString();
}
    public static void main(String arg[]) throws Exception{
       
//the output from generatedate stored in txt file
        
String data = fileToString(arg[0]);

try {

    // Send data
    URL url = new URL(arg[1]);
    URLConnection conn = url.openConnection();
    conn.setDoOutput(true);
    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    wr.write(data);
    wr.flush();
    //upload finished, now banging started on remote server
System.out.println("upload end");
    // lets wait from the response
    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line;
    while ((line = rd.readLine()) != null) {
        System.out.println(line);
    }
    wr.close();
    rd.close();
} catch (Exception e) {
}        
        
             
    }
}
