package ch.baloise.corellia.api.doc;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class OpenApi2DocGenerator {

    public static void main(String[] args) {
        System.out.println("pwd: " + System.getProperty("user.dir"));
        String npm = System.getProperty("os.name").toLowerCase().contains("win") ? "npm.cmd" : "npm";
        try {
            Process npmProcess = new ProcessBuilder(npm, "run", "convert").redirectErrorStream(true).start();
            BufferedReader br = new BufferedReader(new InputStreamReader(npmProcess.getInputStream()));

            // Store and print output of process
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
                System.out.println(line);
            }

            npmProcess.waitFor();
            System.out.println("Finished converting: " + npmProcess.exitValue());
            if (npmProcess.exitValue() != 0) {
                System.out.println("An error occrred. See stdout");
                System.exit(npmProcess.exitValue());
            }
            System.out.println("Read conversion output");
            boolean jsonStarted = false;
            // Remove lines until first {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lines.size(); i++) {
                if (!jsonStarted && !lines.get(i).contains("{")) {
                    continue;
                } else if (lines.get(i).startsWith("}")) {
                    // hack to really only get the json content. since pretty print was used, this is surely the last closing brace.
                    sb.append(lines.get(i)).append("\n");
                    break;
                } else {
                    jsonStarted = true;
                    sb.append(lines.get(i)).append("\n");
                }
            }
            Writer w = new OutputStreamWriter(new FileOutputStream("docs/swagger.json"), StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            System.out.println("Done.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
