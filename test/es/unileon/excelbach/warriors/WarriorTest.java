package es.unileon.excelbach.warriors;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WarriorTest {

        private Warrior warrior;

        @Before
        public void setUp() throws Exception {
            this.warrior = new Warrior("WarriorName", 10);
        }

        @Test
        public void testWarrior() {
            assertEquals("WarriorName\n" + 
                            "**********\n", this.warrior.toString());
        }

        @Test(expected = WarriorsGameException.class)
        public void testWarriorNotEnoughtHealth() throws WarriorsGameException {
            new Warrior("WarriorName", 1);
        }

        @Test(expected = WarriorsGameException.class)
        public void testWarriorTooMuchHealth() throws WarriorsGameException {
            new Warrior("WarriorName", 21);
        }

        @Test(expected = WarriorsGameException.class)
        public void testWarriorShortName() throws WarriorsGameException {
            new Warrior("Name", 10);
        }

        @Test
        public void testReceiveAttack() {
            this.warrior.receiveAttack(5);

            assertEquals("WarriorName\n" + 
                            "*****\n", this.warrior.toString());
        }

        @Test
        public void testReceiveAttackAffectShield() {
            this.warrior.addShield(6);
            this.warrior.receiveAttack(5);

            assertEquals("WarriorName\n" + 
                            "**********\n" + 
                            "+", this.warrior.toString());
        }

        @Test
        public void testReceiveAttackAffectShieldAndHealth() {
            this.warrior.addShield(6);
            this.warrior.receiveAttack(7);

            assertEquals("WarriorName\n" + 
                            "*********\n", this.warrior.toString());
        }

        @Test
        public void testReceiveAttackAndDie() {
            this.warrior.receiveAttack(10);

            assertEquals("WarriorName\n" + 
                            "\n", this.warrior.toString());
        }

        @Test
        public void testReceiveAttackAndDiePowerfull() {
            this.warrior.receiveAttack(15);

            assertEquals("WarriorName\n" + 
                            "\n", this.warrior.toString());
        }

        @Test
        public void testAddShield() {
            this.warrior.addShield(5);;

            assertEquals("WarriorName\n" + 
                            "**********\n" + 
                            "+++++", this.warrior.toString());
        }

        @Test
        public void testGetName() {
            assertEquals("WarriorName", this.warrior.getName());
        }

        @Test
        public void testIsDefeated() {
            assertEquals(false, this.warrior.isDefeated());
            this.warrior.receiveAttack(10);
            assertEquals(true, this.warrior.isDefeated());
        }
    }