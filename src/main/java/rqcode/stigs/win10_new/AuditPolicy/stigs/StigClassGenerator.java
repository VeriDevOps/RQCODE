import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StigClassGenerator {
    public static void main(String[] args) {
        String fileName = "src/main/java/rqcode/stigs/win10_new/AuditPolicy/stigs/stig_input.txt";
        String outputDirectory = "rqcode/stigs/win10_new/AuditPolicy/stigs/outputs";
        List<StigInfo> stigInfoList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s"); // Split by spaces
                if (parts.length == 3) {
                    String stig = parts[0];
                    String checkValue = parts[1];
                    String guid = parts[2];
                    stigInfoList.add(new StigInfo(stig, checkValue, guid));
                } else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate StigTemplate classes based on stigInfoList
        for (StigInfo stigInfo : stigInfoList) {
            String className = "V_" + stigInfo.getStig();
            String filePath = outputDirectory + "/" + className + ".java";

            try (FileWriter writer = new FileWriter(new File(filePath))) {
                writer.write("public class " + className + " extends StigTemplate {\n");
                writer.write("\tpublic " + className + "() {\n");
                writer.write("\t\tsuper(\"" + stigInfo.getGuid() + "\", \"" + stigInfo.getCheckValue() + "\");\n");
                writer.write("\t}\n");
                writer.write("}\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class StigInfo {
        private String stig;
        private String checkValue;
        private String guid;

        public StigInfo(String stig, String checkValue, String guid) {
            this.stig = stig;
            this.checkValue = checkValue;
            this.guid = guid;
        }

        public String getStig() {
            return stig;
        }

        public String getCheckValue() {
            return checkValue;
        }

        public String getGuid() {
            return guid;
        }
    }
}
