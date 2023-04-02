package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FactionTest {

    private RangeCharacter Boromir = new RangeCharacter(12);
    private MyCharacter Merry = new MyCharacter(2);
    private MyCharacter Pippin = new MyCharacter(2);
    Faction archers = new Faction("archers");
    Faction strikers = new Faction("strikers");
    

    public FactionTest() {
        strikers.addCharacter(Merry);
        strikers.addCharacter(Pippin);
    }

    @Test
    void add_character_faction() {
        archers.addCharacter(Boromir);
        assertEquals("archers", Boromir.getFaction().getName());
    }

    @Test
    void character_dont_attack_allies() {
        Merry.attackCharacter(Pippin);
        assertEquals(1000, Pippin.getActualHealth());
    }

    @Test
    void character_attack() {
        Boromir.attackCharacter(Merry);
        assertEquals(800, Merry.getActualHealth());
    }

    @Test
    void enemys_cant_heal(){
        Boromir.attackCharacter(Merry);
        Boromir.attackCharacter(Merry);
        Boromir.healCharacter(Merry);
        assertEquals(600, Merry.getActualHealth());
    }

    @Test
    void allies_can_heal(){
        Boromir.attackCharacter(Merry);
        Boromir.attackCharacter(Merry);
        Pippin.healCharacter(Merry);
        assertEquals(650, Merry.getActualHealth());
    }

}
