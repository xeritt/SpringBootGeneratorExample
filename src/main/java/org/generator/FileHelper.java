package org.generator;
import org.springframework.core.io.ClassPathResource;
import java.io.*;
import java.util.HashMap;

public class FileHelper {
    static public HashMap<String, String> loadConfig(String name, HashMap<String, String> mappings){
        if (mappings == null){
            mappings = new HashMap<String, String>();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(name)))) {
            String line;
            System.out.println("------------ Строки для замены в шаблоне ------------");
            System.out.println("Файл для загрузки ["+name+"]");
            System.out.println("-----------------------------------------------------");
            while ((line = reader.readLine()) != null) {
                System.out.println("["+line+"]");
                String vals[] = line.split("=");
                if (vals.length<2){
                    mappings.put(vals[0], "");
                } else {
                    mappings.put(vals[0], vals[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mappings;
    }

    static public void replaceAll(HashMap<String, String> mappings, BufferedReader reader, BufferedWriter writer) throws IOException {
        System.out.println("================ Строки в шаблоне ================");
        String line = "";
        while((line = reader.readLine())!=null) {
            for (String key:mappings.keySet()) {
                line = line.replace("{"+key+"}", mappings.get(key));
            }
            writer.append(line);
            writer.newLine();
            System.out.println(line);
        }
    }

    static public BufferedReader getResource(String fileName) throws IOException {
        InputStream resource = new ClassPathResource(fileName).getInputStream();
        try ( BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource)) ) {
                return reader;
        }
    }
}
