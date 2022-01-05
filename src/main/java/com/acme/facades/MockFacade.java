package com.acme.facades;

public class MockFacade implements FacadeInterface{
    @Override
    public int getAvailProcessors() {
        return 5;
    }

    @Override
    public long getFreeJVMMemory() {
        return 6;
    }

    @Override
    public long getTotalJVMMemory() {
        return 7;
    }

    @Override
    public String getJREVersion() {
        return "17";
    }

    @Override
    public String getTempLocation() {
        return "C:\\Users\\Akiva Jacobson\\AppData\\Local\\Temp";
    }
}
