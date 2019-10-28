/*
 * Copyright (c) 2019. Brahim WADIA.
 */

package fr.mowitnow.tondeuse.service;

import fr.mowitnow.tondeuse.bean.Pelouse;
import fr.mowitnow.tondeuse.bean.Tondeuse;
import fr.mowitnow.tondeuse.exception.PelouseException;
import fr.mowitnow.tondeuse.exception.TondeuseException;

public class RobotService {

    public static Pelouse initiatePelouse(String firstLigne) throws PelouseException {
        Pelouse pelouse = new Pelouse();
        try {
            if (firstLigne.length() == 3) {
                int maxX = Integer.parseInt(firstLigne.substring(0, 1)), maxY = Integer.parseInt(firstLigne.substring(2, 3));
                pelouse.setPelouseY(maxY);
                pelouse.setPelousX(maxX);
            } else {
                throw new PelouseException("PelouseException: Problem in ligne 1 of comand file", new Throwable());
            }
        } catch (Exception e) {
            throw new PelouseException("PelouseException: Problem in ligne 1 of comand file", e);
        }
        return pelouse;
    }

    public static Tondeuse initiateTondeuse(String ligne) throws TondeuseException {
        Tondeuse tondeuse = new Tondeuse();
        if(ligne.length() == 5){
            tondeuse.setCoordonnes(new int[] {Integer.parseInt(ligne.substring(0,1)), Integer.parseInt(ligne.substring(2,3))});
            tondeuse.setOrientation(ligne.substring(4,5));
        } else {
            throw new TondeuseException("TondeuseException: Can't Initiate Tondeuse with command " + ligne, new Throwable());
        }
        return tondeuse;
    }

    public static Tondeuse CommandTondeuse(Pelouse pelouse, Tondeuse tondeuse, String cmdLine) {
        char[] listCmd = cmdLine.toCharArray();
        int x, y = 0;
        for(char cmd : listCmd) {
            switch(tondeuse.getOrientation().charAt(0)) {
                case 'N':
                    switch (cmd) {
                        case 'A':
                            x = tondeuse.getCoordonnes()[0];
                            y = tondeuse.getCoordonnes()[1] + 1;
                            if (y >= 0 && y <= pelouse.getPelouseY())
                                tondeuse.setCoordonnes(new int[] {x,y});
                            break;
                        case 'D':
                            tondeuse.setOrientation("E");
                            break;
                        case 'G':
                            tondeuse.setOrientation("W");
                            break;
                    }
                    break;
                case 'E':
                    switch (cmd) {
                        case 'A':
                            x = tondeuse.getCoordonnes()[0] + 1;
                            y = tondeuse.getCoordonnes()[1] ;
                            if (x >= 0 && x <= pelouse.getPelousX())
                                tondeuse.setCoordonnes(new int[] {x,y});
                            break;
                        case 'D':
                            tondeuse.setOrientation("S");
                            break;
                        case 'G':
                            tondeuse.setOrientation("N");
                            break;
                    }
                    break;
                case 'S':
                    switch (cmd) {
                        case 'A':
                            x = tondeuse.getCoordonnes()[0];
                            y = tondeuse.getCoordonnes()[1] - 1;
                            if (y >= 0 && y <= pelouse.getPelouseY())
                                tondeuse.setCoordonnes(new int[] {x,y});
                            break;
                        case 'D':
                            tondeuse.setOrientation("W");
                            break;
                        case 'G':
                            tondeuse.setOrientation("E");
                            break;
                    }
                    break;
                case 'W':
                    switch (cmd) {
                        case 'A':
                            x = tondeuse.getCoordonnes()[0]-1;
                            y = tondeuse.getCoordonnes()[1] ;
                            if (x >= 0 && x <= pelouse.getPelousX())
                                tondeuse.setCoordonnes(new int[] {x,y});
                            break;
                        case 'D':
                            tondeuse.setOrientation("N");
                            break;
                        case 'G':
                            tondeuse.setOrientation("S");
                            break;
                    }
                    break;
            }
        }
        System.out.println("TADA : "+tondeuse.getCoordonnes()[0]+" "+tondeuse.getCoordonnes()[1] + " "+tondeuse.getOrientation());
        return tondeuse;
    }

}
