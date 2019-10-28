/*
 * Copyright (c) 2019. Brahim WADIA.
 */

package fr.mowitnow.tondeuse.bean;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Pelouse {
    private int pelousX = 0, pelouseY = 0;

    public Pelouse(int pelousX, int pelouseY) {
        this.pelousX = pelousX;
        this.pelouseY = pelouseY;
    }
}
