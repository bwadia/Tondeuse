/*
 * Copyright (c) 2019. Brahim WADIA.
 */

package fr.mowitnow.tondeuse.service;

import fr.mowitnow.tondeuse.bean.Pelouse;
import fr.mowitnow.tondeuse.bean.Tondeuse;
import fr.mowitnow.tondeuse.exception.PelouseException;
import fr.mowitnow.tondeuse.exception.TondeuseException;

import static org.junit.jupiter.api.Assertions.*;

class RobotServiceTest {

    RobotService rSce = new RobotService();

    @org.junit.jupiter.api.Test
    void iniatPelouseException() {
        try {
            rSce.initiatePelouse("");
        } catch (PelouseException e) {
            assertTrue(true);
        }
    }

    @org.junit.jupiter.api.Test
    void iniatPelouseValid() {
        String st = "5 5";
        try {
            Pelouse p1 = new Pelouse(5,5);
            Pelouse p2 = rSce.initiatePelouse(st);
            assertTrue(p1.equals(p2));
        } catch (PelouseException e) {

        }
    }

    @org.junit.jupiter.api.Test
    void initiateTondeuseException() {
        try {
            rSce.initiateTondeuse("");
        } catch (TondeuseException e) {
            assertTrue(true);
        }
    }

    @org.junit.jupiter.api.Test
    void commandTondeuseValide() throws TondeuseException {
        Tondeuse t1 = new Tondeuse(new int[] {1,1},"N");
        Tondeuse t2 = rSce.initiateTondeuse("1 1 N");
        assertTrue(t1.equals(t2));
    }
}