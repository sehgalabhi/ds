package com.dpatterns.command;

/**
 * Created by asehgal on 7/11/2017.
 */
public class RemoteControl {

    private Command[] remoteCommands;

    public void setSlots(Command[] remoteCommands) {
        remoteCommands = remoteCommands;
    }

    public void buttonPressed(int i){
        remoteCommands[i].execute();
    }
}
