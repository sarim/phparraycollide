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

class PostThread implements Runnable {
	private String data;
	private String URL;
	private int id;
	public PostThread(String data,String URL,int id){
		this.data = data;
		this.URL = URL;
		this.id = id;
	}
	public void run() {
		try {
			
		    // Send data
		    URL url = new URL(this.URL);
		    URLConnection conn = url.openConnection();
		    conn.setDoOutput(true);
		    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		    wr.write(this.data);
		    wr.flush();
		    //upload finished, now banging started on remote server
		    	System.out.println("upload end from " + this.id + " no thread");
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
int tcount = Integer.parseInt(arg[2]);
for (int i=0;i < tcount;i++)
(new Thread(new PostThread(data, arg[1],i))).start();
        
             
    }
}

