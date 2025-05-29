import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
   public Client() {
   }

   public void run() throws UnknownHostException, IOException {
      short var1 = 8010;
      InetAddress var2 = InetAddress.getByName("localhost");
      Socket var3 = new Socket(var2, var1);
      PrintWriter var4 = new PrintWriter(var3.getOutputStream());
      BufferedReader var5 = new BufferedReader(new InputStreamReader(var3.getInputStream()));
      var4.println("Hello from the client");
      String var6 = var5.readLine();
      System.out.println("Response from socket is: " + var6);
      var4.close();
      var5.close();
      var3.close();
   }

   public static void main(String[] var0) {
      try {
         Client var1 = new Client();
         var1.run();
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }
}
