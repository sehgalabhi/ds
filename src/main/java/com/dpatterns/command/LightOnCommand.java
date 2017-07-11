package com.dpatterns.command;

/**
 * Created by asehgal on 7/11/2017.
 */
public class LightOnCommand implements Command {

    private Light light;

    @Override
    public void execute() {
        light.on();
    }
}
