import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
   public Server() {
   }

   public void run() throws IOException, UnknownHostException {
      short var1 = 8010;
      ServerSocket var2 = new ServerSocket(var1);
      var2.setSoTimeout(10000);

      while(true) {
         System.out.println("Server is listening on port: " + var1);
         Socket var3 = var2.accept();
         System.out.println("Connected to " + var3.getRemoteSocketAddress());
         PrintWriter var4 = new PrintWriter(var3.getOutputStream(), true);
         new BufferedReader(new InputStreamReader(var3.getInputStream()));
         var4.println("Hello World from the server");
      }
   }

   public static void main(String[] var0) {
      Server var1 = new Server();

      try {
         var1.run();
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }
}
