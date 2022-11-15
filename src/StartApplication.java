

import java.io.*;

public class StartApplication {
    private static final String TASKLIST = "tasklist /v";

    private static final String KILL = "taskkill /IM ";

    /* public boolean isProcessRunning(String serviceName) {

         try {
             Process pro = Runtime.getRuntime().exec(TASKLIST);
             BufferedReader reader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
             String line;
             while ((line = reader.readLine()) != null) {
                 //System.out.println(line);
                 if (line.startsWith(serviceName)) {
                     return true;
                 }
             }

         } catch (IOException e) {
             e.printStackTrace();
         }

         return false;
     }
 */
    public static void startApp(String serviceName)
    {
        try {
            Runtime.getRuntime().exec("cmd /c start "+serviceName+".exe");
            System.out.println(serviceName+" started successfully!");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            //StopApplication desktop = new StopApplication();

            // To kill a command prompt
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter name of application : ");
            String appName = reader.readLine();
            //boolean isRunning = desktop.isProcessRunning(processName);
            startApp(appName);
            //.out.println("is " + processName + " running : " + isRunning);
        } catch (IOException e)
        {
            System.out.println(e);
        }

    }

}
