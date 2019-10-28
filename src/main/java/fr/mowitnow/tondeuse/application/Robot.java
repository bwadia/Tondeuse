/*
 * Copyright (c) 2019. Brahim WADIA.
 */

package fr.mowitnow.tondeuse.application;

import fr.mowitnow.tondeuse.bean.Pelouse;
import fr.mowitnow.tondeuse.bean.Tondeuse;
import fr.mowitnow.tondeuse.exception.PelouseException;
import fr.mowitnow.tondeuse.exception.TondeuseException;
import fr.mowitnow.tondeuse.service.RobotService;
import lombok.extern.java.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log
public class Robot {

    public static void main(String[] args) {
        RobotService rSrvice = new RobotService();
        String uriCmdFile = "D:\\Work\\Tondeuse\\tondeuse.cmd";
        File cmdFile = new File(uriCmdFile);
        Pelouse pelouse = new Pelouse();
        int lineNumber = 0;
        try {
            Stream<String> lines = Files.lines(Paths.get(uriCmdFile));
            List<String> content = lines.collect(Collectors.toList());
            for(String line : content ){
                if(content.indexOf(line) == 0 )  pelouse = rSrvice.initiatePelouse(line);
                else if (content.indexOf(line)%2 != 0){
                    Tondeuse tendeuse = rSrvice.initiateTondeuse(line);
                    if(content.size() > content.indexOf(line)+1)
                        rSrvice.CommandTondeuse(pelouse,tendeuse,content.get(content.indexOf(line)+1));
                    else System.out.println("This machine doesnt have any instructions ! "+ tendeuse);
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } catch (PelouseException e) {
            log.severe(e.getMessage());
        } catch (TondeuseException e) {
            log.severe(e.getMessage());
        }
    }
}
