

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/*
 We are preparing three files:
 * exec.txt: This is a simple template of a PowerShell script for setting values.
 * check.txt: This is a template of a PowerShell script for obtaining values.
 * tasks.properties: This file is used for mapping task numbers (e.g., V-63447) to their corresponding GUID (e.g., {0000-0000-000-0001}). Additionally, we store additional fields for the parameter and value of each task in this file.

 How it works:
 *  The task name is provided as a command-line argument when running the JAR file. For example, when running the JAR, you simply specify the task name (java -jar jarname.jar V-63447).
 *
 *  Next, we read the tasks.properties file and check if the desired task exists. If it doesn't exist, we throw an exception.
 *  The next step is to read the check.txt file, as it's a template that needs to be filled with real values. We have already obtained the real values from tasks.properties.
 *  After substituting these values, we have a command ready to be executed.
 */


public class AuditPolMain {

    public static void main(String[] args) throws IOException {
        String taskName = args[0];

        try (InputStream input = AuditPolMain.class.getClassLoader().getResourceAsStream("tasks.properties")) {

            Properties properties = new Properties();

            if (input == null) {
                throw new IllegalArgumentException("file tasks.properties is not found");
            }

            //load a properties file from class path, inside static method
            properties.load(input);

            String guid = (String) properties.get(taskName);
            String parameter = (String)properties.get(taskName + ".param");
            String value = (String)properties.get(taskName + ".value");
            if(guid == null || parameter == null || value == null)
                throw new IllegalArgumentException(String.format("Task number %s not found!", taskName));


            byte[] bytes = Files.readAllBytes(Paths.get("ExternalFiles" + File.separator + "check.txt"));
            String exec = new String(bytes);
            exec = exec.replaceAll("%task%", guid);
            exec = exec.replaceAll("%guid%", guid);
            exec = exec.replaceAll("%parameter%", parameter);
            exec = exec.replaceAll("%value%", value);
            System.out.println(exec);
            //Process execResult = Runtime.getRuntime().exec(exec);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}

