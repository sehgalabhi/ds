package com.dpatterns.command;

/**
 * Created by asehgal on 7/11/2017.
 */
public class RemoteControlSimulator {

    public static void main(String[] args) {
        new RemoteControlSimulator().test();
    }

    private void test() {
        RemoteControl remoteControl = new RemoteControl();

        Command remoteCommands[] = new Command[2];

        remoteCommands[0] = new LightOnCommand();
        remoteCommands[1] = new FanOffCommand();

        remoteControl.setSlots(remoteCommands);
    }
}
