package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RadioTest {

    private Radio radio;

    @BeforeEach
    public void reset() {
        radio = new Radio();
    }
    @Test
    public void shouldGetCurrentStation() {
        radio.setCurrentStation(0);
        radio.setCurrentStation(-1);
        radio.setCurrentStation(11);
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldPressNextStation() {
        radio.setCurrentStation(0);
        radio.nextStation();
        Assertions.assertEquals(1, radio.getCurrentStation());

        radio.setCurrentStation(10);
        radio.nextStation();
        Assertions.assertEquals(0, radio.getCurrentStation());

        radio.setCurrentStation(11);
        radio.nextStation();
        Assertions.assertEquals(1, radio.getCurrentStation());

    }


    @Test
    void shouldPrevStation() {
        radio.setCurrentStation(4);
        radio.previousStation();
        Assertions.assertEquals(3, radio.getCurrentStation());
    }

    @Test
    void shouldBelowMinStation() {
        radio.setCurrentStation(0);
        radio.previousStation();
        Assertions.assertEquals(10, radio.getCurrentStation());
    }

    @Test
    public void shouldGetToMaxStation() {
        Assertions.assertEquals(10, radio.getMaxStation());
    }

    @Test
    public void shouldSetMaxStation() {
        radio.setMaxStation(0);
        radio.setMaxStation(11);
        Assertions.assertEquals(11, radio.getMaxStation());
    }

    @Test
    public void shouldGetToMinStation() {
        Assertions.assertEquals(0, radio.getMinStation());
    }

    @Test
    public void shouldSetMinStation() {
        radio.setMinStation(0);
        radio.setMinStation(11);
        Assertions.assertEquals(11, radio.getMinStation());
    }

    @Test
    public void shouldCreateStationsWithLimits() {
        Radio radio = new Radio(1);
        Assertions.assertEquals(0, radio.getMaxStation());

        Radio radio1 = new Radio(50);
        Assertions.assertEquals(49, radio1.getMaxStation());

        Radio radio2 = new Radio(11);
        Assertions.assertEquals(10, radio2.getMaxStation());
    }

    @Test
    public void shouldChangeVolume() {
        radio.setCurrentVolume(77);
        Assertions.assertEquals(77, radio.getCurrentVolume());
    }

    @Test
    public void shouldGetMaxVolume() {
        Assertions.assertEquals(100, radio.getMaxVolume());
    }

    @Test
    public void shouldSetMaxVolume() {
        radio.setMaxVolume(101);
        radio.setMinVolume(0);
        Assertions.assertEquals(101, radio.getMaxVolume());

    }

    @Test
    public void shouldGetMinVolume() {
        Assertions.assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void shouldSetMinVolume() {
        radio.setMinVolume(1);
        radio.setMaxVolume(100);
        Assertions.assertEquals(1, radio.getMinVolume());

    }

    @Test
    public void checkingIncorrectVolume() {
        radio.setCurrentVolume(-1);
        radio.setCurrentVolume(101);
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() {
        radio.setCurrentVolume(77);
        radio.increaseVolume();
        Assertions.assertEquals(78, radio.getCurrentVolume());
    }

    @Test
    public void shouldOverMaxVolume1() {
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        radio.setCurrentVolume(6);
        radio.decreaseVolume();
        Assertions.assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void shouldBelowMinVolume() {
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }
}