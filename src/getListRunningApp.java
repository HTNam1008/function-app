import java.io.*;
import java.util.*;

public class getListRunningApp {

    static boolean check(List<String> s, String st)
    {
        for (int i=0; i<s.size(); i++)
        {
            if (st.equals(s.get(i)))
            {
                return false;
            }
        }
        return true;
    }
    public static List listRunningApp() {
        //List<String> processes = new ArrayList<String>();
        List<String> appRunning =new ArrayList<String>();
        try {
            String line;
            Process p = Runtime.getRuntime().exec("tasklist /v /fo csv");
            BufferedReader input = new BufferedReader
                    (new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                //System.out.println(line+'\n');
                //System.out.println(line+'\n');
                String[] parse = line.split(",");
                String appName=parse[parse.length-1];
                String pid=parse[1];
                pid=pid.substring(1,pid.length()-1);
                //System.out.println(line+'\n');
                appName=appName.substring(1,appName.length()-1);
                if (!appName.equals("N/A") && check(appRunning,appName)) {
                    // keep only the process name
                    appRunning.add(appName);
                    System.out.println(appName+"    "+pid);
                }

            }
            input.close();
        }
        catch (Exception err) {
            err.printStackTrace();
        }
        return appRunning;
    }


    public static void main(String[] args){
        List<String> apps = listRunningApp();
            /*String result = "";
            Iterator<String> it = apps.iterator();
            int i = 0;
            while (it.hasNext()) {
                System.out.println(it.next());
                result += it.next() +"\n";
                i++;
                if (i==10) {
                    result += "\n";
                    i = 0;
                }
            }
            System.out.println("Running apps :\n  " + result+"\n Total No of Apps: "+ apps.size());*/
        //msgBox("Running processes :\n  " + result+"\n Total No of Processes: "+ processes.size());

    }

       /* public static void msgBox(String msg) {
            javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)
                            null, msg, "WindowsUtils",
                    javax.swing.JOptionPane.DEFAULT_OPTION);
        }*/
}