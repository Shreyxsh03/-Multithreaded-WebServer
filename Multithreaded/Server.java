package Multithreaded;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {
   public Server() {
   }

   public Consumer<Socket> getConsumer() {
      return (var0) -> {
         try {
            PrintWriter var1 = new PrintWriter(var0.getOutputStream());
            var1.println("Hello from the Server");
            var1.close();
            var0.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }

      };
   }

   public static void main(String[] var0) {
      short var1 = 8010;
      Server var2 = new Server();

      try {
         ServerSocket var3 = new ServerSocket(var1);
         var3.setSoTimeout(20000);
         System.out.println("Server started to listen on port");

         while(true) {
            Socket var4 = var3.accept();
            Thread var5 = new Thread(() -> {
               var2.getConsumer().accept(var4);
            });
            var5.start();
         }
      } catch (IOException var6) {
         var6.printStackTrace();
      }
   }
}
