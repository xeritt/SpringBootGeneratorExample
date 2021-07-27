package org.generator;

import java.io.*;
import java.util.HashMap;

abstract public class Base {
    public void generate(String PROJECT_HOME, String cfg_file, String tmp_file, String dest_file) {
        String cfg_path = PROJECT_HOME + "generator/cfg/" + cfg_file + ".cfg";//controller;
        String code_path = PROJECT_HOME + "generator/code/" + tmp_file + ".java";//Controller";
        HashMap<String, String> mappings = new HashMap<String, String>();
        mappings = FileHelper.loadConfig(cfg_path, mappings);

        String package_path = mappings.get("PACKAGE").replace('.', '/');
        String dest_path = PROJECT_HOME + "src/main/java/" +package_path+"/"+cfg_file+"/";
        String file = mappings.get("MODEL")+ dest_file +".java";
        File fout = new File(dest_path);
        fout.mkdirs();

        System.out.println("Dest PATH="+dest_path);
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(code_path)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dest_path+file)))
        ) {
            FileHelper.replaceAll(mappings, reader, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
