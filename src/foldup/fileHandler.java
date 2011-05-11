package foldup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
     
     /**
      * 
      * @param String action, String file
      * @throws IOException
      * @return void
      */
     public static void logAction(String action, String fileName) throws IOException {
         File f = new File(fileName);
         FileOutputStream stream = new FileOutputStream(f);
         
         stream.write(action.getBytes());
         stream.write("\n".getBytes());
         stream.flush();
         stream.close();
     }

     /**
      *
      * @param String fileName
      * @return String[] status
      */
     public static String[] logView(String fileName) {
         String[] status = new String[0];
         int i = 0;
         try {
            Scanner input = new Scanner(new File(fileName));
            while(input.hasNext()) {
                i++;
            }
            status = new String[i];
            i = 0;
            while(input.hasNext()) {
                status[i] = input.nextLine();
                i++;
            }
         }
         catch(FileNotFoundException e) {
            status[0] = "File read error.";
         }
         return status;
     }
     
     private static String fileCheck(String path) {
         
         
         return path;
     }

}
