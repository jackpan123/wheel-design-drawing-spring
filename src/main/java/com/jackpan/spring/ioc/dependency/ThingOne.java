package com.jackpan.spring.ioc.dependency;

public class ThingOne {

    private ThingTwo thingTwo;
    private ThingThree thingThree;

    public ThingOne(ThingTwo thingTwo, ThingThree thingThree) {
        this.thingTwo = thingTwo;
        this.thingThree = thingThree;
    }
}
