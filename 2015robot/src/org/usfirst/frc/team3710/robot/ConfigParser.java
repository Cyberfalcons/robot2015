package org.usfirst.frc.team3710.robot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ConfigParser {

    static Config cfg = new Config();

    public ConfigParser() {
        
    }

    public static void LoadFromFile() {
        try {
            File f = new File("test.txt");
            FileReader fr = new FileReader(f);
            
            try (BufferedReader br = new BufferedReader(fr)) {
                cfg.autoOn = Boolean.parseBoolean(br.readLine().split(",")[1]);
                
                cfg.elevatorPID_P = Double.parseDouble(br.readLine().split(",")[1]);
                cfg.elevatorPID_I = Double.parseDouble(br.readLine().split(",")[1]);
                cfg.elevatorPID_D = Double.parseDouble(br.readLine().split(",")[1]);
                
                cfg.drivePID_P = Double.parseDouble(br.readLine().split(",")[1]);
                cfg.drivePID_I = Double.parseDouble(br.readLine().split(",")[1]);
                cfg.drivePID_D = Double.parseDouble(br.readLine().split(",")[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}