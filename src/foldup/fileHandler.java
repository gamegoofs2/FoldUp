package foldup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;

/**
 *
 * @author evan
 */
public class fileHandler {
     static String basePath;

     /**
      *
      * @param String path
      * @return void
      */
     public static void setBasePath(String path) {
         basePath = path;
     }

     /**
      * 
      * @param String path
      * @return boolean status
      */
     public static boolean createDirectories(String path) {
         boolean status;
         try {
             path = basePath + fileCheck(path);
             status = new File(path).mkdirs();
         }
         catch(SecurityException e) {
             status = false;
         }
         return status;
     }
     public static void logAction(String action) throws IOException {
         File f = new File("log.txt");
         FileOutputStream stream = new FileOutputStream(f);
         
         stream.write(action.getBytes());
         stream.flush();
         stream.close();
     }
     
     private static String fileCheck(String path) {
         
         
         return path;
     }

}
