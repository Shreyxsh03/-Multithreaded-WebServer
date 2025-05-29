mport java.io.IOException;
import java.net.UnknownHostException;

public class Client {
   public Client() {
   }

   public Runnable getRunnable() throws UnknownHostException, IOException {
      return new Client$1(this);
   }

   public static void main(String[] var0) {
      Client var1 = new Client();

      for(int var2 = 0; var2 < 100; ++var2) {
         try {
            Thread var3 = new Thread(var1.getRunnable());
            var3.start();
         } catch (Exception var4) {
            return;
         }
      }

   }
}
