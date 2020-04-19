package com.app.animals3D.helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    private Animal animal;

    @Before
    public void setUp() {
        System.out.println("Start unit test animal");
        animal = new Animal("TestName", 1, "TestResource", 2);

    }

    @After
    public void tearDown() {
        System.out.println("End unit test animal");
    }

    @Test
    public void testGetName() {
        assertEquals("TestName", animal.getName());
    }

    @Test
    public void testGetIdDrawable() {
        assertEquals(1, animal.getIdDrawable());
    }

    @Test
    public void testGetSource3D() {
        assertEquals("TestResource", animal.getSource3D());
    }

    @Test
    public void testGetIdSound() {
        assertEquals(2, animal.getIdSound());
    }

    @Test
    public void testHashCode() {
        assertEquals(animal.getName().hashCode() + animal.getIdDrawable() + animal.getSource3D().hashCode() + animal.getIdSound(), animal.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("TestName", animal.toString());
    }
}