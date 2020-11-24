package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ClassWithNameTest {

    private ClassWithName obj = new ClassWithName() {
        @Override
        public String enterName(String question, String regex) throws IOException {
            return super.enterName(question, regex);
        }

        @Override
        public String enterName() throws IOException {
            return super.enterName();
        }

        @Override
        public void setName(String name) {
            super.setName(name);
        }

        @Override
        public String getName() {
            return super.getName();
        }
    };

    @Test
    void enterNameTest() throws IOException {
        String name = "My string";
        String expected = "My@@ string\n" +
                        "My string.\n" +
                        "My string\n" +
                        "My string\n" +
                        "n\n" +
                        "My string\n" +
                        "y\n";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        assertEquals(name, obj.enterName());
        System.setIn(sysInBackup);
    }

    @Test
    void enterNameWithParametersTest() throws IOException {
        String name = "My string";
        String expected = "My@@ string\n" +
                "My string.\n" +
                "My string\n" +
                "My string\n" +
                "n\n" +
                "My string\n" +
                "y\n";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        assertEquals(name, obj.enterName("what", "[a-zA-Z_0-9\\s]+"));
        System.setIn(sysInBackup);
    }

    @Test
    void setNameTest() {
        String expected = "Bruh";
        obj.setName(expected);
        assertEquals(expected, obj.getName());
    }

    @Test
    void getNameTest() {
        String expected = "Bruh";
        obj.setName(expected);
        assertEquals(expected, obj.getName());
    }
}