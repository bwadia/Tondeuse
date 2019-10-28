/*
 * Copyright (c) 2019. Brahim WADIA.
 */

package fr.mowitnow.tondeuse.bean;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Tondeuse {
    private int[] coordonnes = new int[2];
    private String orientation;

    public Tondeuse(int[] coordonnes, String orientation) {
        this.coordonnes = coordonnes;
        this.orientation = orientation;
    }
}
