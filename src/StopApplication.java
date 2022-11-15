
import java.io.*;
import java.util.*;
import java.lang.*;

public class StopApplication {
    public static void stopApplication(int id) {
        //List<String> processes = new ArrayList<String>();
        //List<String> processRunning =new ArrayList<String>();
        try {

            String line;
            Process p = Runtime.getRuntime().exec("tasklist /v /nh /fi \"PID eq "+id+"\" /fo csv");
            BufferedReader input = new BufferedReader
                    (new InputStreamReader(p.getInputStream()));
            /*if ((line = input.readLine()) == null)
            {
                System.err.println("Not able to find the application's process");
                return;
            }*/
            while ((line = input.readLine()) != null) {
                //System.out.println(line+'\n');
                String[] parse = line.split(",");
                String processName=parse[0];
                processName=processName.substring(1,processName.length()-1);
                System.out.println(processName+'\n');

                try {
                    Runtime.getRuntime().exec("taskkill /IM " + processName);
                    System.out.println(processName+" killed successfully!");
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            input.close();
        }
        catch (Exception err) {
            err.printStackTrace();
        }
        //return processRunning;
    }
    public static void main(String[] args){
        List<String> apps = getListRunningApp.listRunningApp();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter id of app:");
        int id=myObj.nextInt();

        stopApplication(id);
    }


}
