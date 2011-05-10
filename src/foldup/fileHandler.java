package foldup;
import java.io.File;
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
     
     private static String fileCheck(String path) {
         return path;
     }

}
