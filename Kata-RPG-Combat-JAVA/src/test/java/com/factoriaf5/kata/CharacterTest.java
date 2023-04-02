package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    private RangeCharacter Boromir = new RangeCharacter(12);
    private MyCharacter Merry = new MyCharacter(2);
    private MyCharacter Pippin = new MyCharacter(2);
    Faction archers = new Faction("archers");
    Faction strikers = new Faction("strikers");

    public CharacterTest() {
        archers.addCharacter(Boromir);
        strikers.addCharacter(Merry);
        strikers.addCharacter(Pippin);
    }

    

    @Test
    public void Health_is_1000() {
        assertEquals(1000,Boromir.getInitHealth());
    }

    @Test
    public void level_is_1() {
        assertEquals(1,Merry.getInitLevel());
    }

    @Test
    public void Character_Is_Alive() {
        assertEquals(true,Merry.isAlive());
    }

    @Test
    public void  no_faction_default() {
        RangeCharacter boromirbest = new RangeCharacter(2);
        assertEquals(null,boromirbest.getFaction());
    }

    

    @Test
    public void checked_damage() {
        Merry.attackCharacter(Boromir);
        assertEquals(800, Boromir.getActualHealth());
    }

    @Test
    public void character_is_die() {
        Boromir.attackCharacter(Merry);
        Boromir.attackCharacter(Merry);
        Boromir.attackCharacter(Merry);
        Boromir.attackCharacter(Merry);
        Boromir.attackCharacter(Merry);
        assertEquals(false, Merry.isAlive() );
    }

    @Test
    public void checked_sanation() {
        Boromir.attackCharacter(Merry);
        Boromir.attackCharacter(Merry);
        Boromir.attackCharacter(Merry);
        Boromir.healCharacter(Merry);
        assertEquals(450, Merry.getActualHealth());
    } 

    @Test
    public void checked_damage_myself() {
        Merry.attackCharacter(Merry);
        assertEquals(1000, Merry.getActualHealth());
    }

      @Test
    public void checked_damage_level() {
        Boromir.setActualLevel(100);
        Pippin.setActualLevel(12);
        Pippin.attackCharacter(Boromir);
        assertEquals(900, Boromir.getActualHealth());
    }

    @Test
    public void MyCharacter_can_attack() {
        Pippin.attackCharacter(Boromir);
        
        assertEquals(800, Boromir.getActualHealth());
    }

    @Test
    public void Character_cant_attack() {
        MyCharacter miCharacter = new MyCharacter(3);
        Character youCharacter = new Character();  

        miCharacter.attackCharacter(youCharacter);
        
        assertEquals(1000, youCharacter.getActualHealth());
    }

    @Test
    public void RangeCharacter_can_attack() { 

        Boromir.attackCharacter(Merry);
        
        assertEquals(800, Merry.getActualHealth());
    }

    @Test
    public void RangeCharacter_cant_attack() {
        RangeCharacter miCharacter = new RangeCharacter(21);
        Character youCharacter = new Character();  

        miCharacter.attackCharacter(youCharacter);
        
        assertEquals(1000, youCharacter.getActualHealth());
    }
}