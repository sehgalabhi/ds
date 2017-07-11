package com.dpatterns.command;

/**
 * Created by asehgal on 7/11/2017.
 */
public class FanOffCommand implements Command {

    private Fan fan;

    @Override
    public void execute() {
        fan.on();
    }
}
