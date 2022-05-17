 package Publishing;
 import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
   import org.apache.commons.net.ntp.NTPUDPClient;
   import org.apache.commons.net.ntp.TimeInfo;

    public class Connection {

public static void main(String[] args) throws Exception {
	System.out.println(isConnectedToInternet());
}

public static boolean isConnectedToInternet() {
    try {
        final URL url = new URL("http://www.google.com");
        final URLConnection conn = url.openConnection();
        conn.connect();
        conn.getInputStream().close();
        return true;
    } catch (MalformedURLException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        return false;
    }
    
}
}