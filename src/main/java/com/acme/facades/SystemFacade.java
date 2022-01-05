package com.acme.facades;

public class SystemFacade implements FacadeInterface{
    private Runtime rt = Runtime.getRuntime();
    @Override
    public int getAvailProcessors() {
        return rt.availableProcessors();
    }

    @Override
    public long getFreeJVMMemory() {
        return rt.freeMemory();
    }

    @Override
    public long getTotalJVMMemory() {
        return rt.totalMemory();
    }

    @Override
    public String getJREVersion() {
        return System.getProperty("java.runtime.version");
    }

    @Override
    public String getTempLocation() {
        return System.getProperty("TEMP");
    }
}
