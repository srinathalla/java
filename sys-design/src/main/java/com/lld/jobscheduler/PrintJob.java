package com.lld.jobscheduler;

public class PrintJob implements Job {

    String name;
    PrintJob(String name)
    {
        this.name = name;
    }
    @Override
    public void execute() {
        System.out.println("Hello " + name);
    }
}
