package org.example.creational;

import org.example.creational.builder.Phone;
import org.example.creational.builder.PhoneBuilder;
import org.example.creational.factory.Environment;
import org.example.creational.factory.EnvironmentFactory;
import org.example.creational.factory.Stages;
import org.example.creational.factory.exceptions.NoSuchStageException;
import org.example.creational.prototype.BookShop;
import org.example.creational.singleton.Logger;
import org.example.creational.singleton.LoggerEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreationalDesignsTest {

    @Test
    void builder() {
        // Makes it easier to create object instead of remembering all params or passing null values
        Phone phone = new PhoneBuilder()
                .setOs("Android")
                .setBattery(3000)
                .build();

        System.out.println(phone);
    }

    @Test
    void factory() {
        // Makes it easier to get objects based on certain conditions
        try {
            Environment environment = new EnvironmentFactory().getEnvironment(Stages.ALPHA);
            environment.printStage();
        } catch (NoSuchStageException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void prototype() {
        BookShop bookShop = new BookShop();
        bookShop.setName("Universal");
        bookShop.loadDataFromDatabase();

        // even without loading data from db, we created another object
        BookShop newBookShop = bookShop.clone();
        newBookShop.setName("A1");

        bookShop.getBooks().remove(2);

        System.out.println(bookShop);
        System.out.println(newBookShop);
    }

    @Test
    void singleton() {
        // Double-Checked Locking
        Logger.getInstance();

        // Using enum
        // Even in double-checked locking, while deSerialisation (readObject())
        LoggerEnum loggerEnum1 = LoggerEnum.INSTANCE;
        loggerEnum1.i = 5;

        loggerEnum1.show();


        LoggerEnum loggerEnum2 = LoggerEnum.INSTANCE;
        loggerEnum2.i = 6;

        loggerEnum1.show();
    }
}