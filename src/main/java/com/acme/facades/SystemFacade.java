package com.acme.facades;

/**
 * This is an implementation of the FacadeInterface that returns real system results. It is used by the webserver to
 * access system info.
 */

public class SystemFacade implements FacadeInterface{
    private Runtime rt = Runtime.getRuntime();

    /**
     *
     * @return available processors
     */
    @Override
    public int getAvailProcessors() {
        return rt.availableProcessors();
    }

    /**
     *
     * @return available memory
     */
    @Override
    public long getFreeJVMMemory() {
        return rt.freeMemory();
    }

    /**
     * @return total memory
     */
    @Override
    public long getTotalJVMMemory() {
        return rt.totalMemory();
    }

    /**
     * @return JRE version
     */
    @Override
    public String getJREVersion() {
        return System.getProperty("java.runtime.version");
    }

    /**
     * @return location of the temp files
     */
    @Override
    public String getTempLocation() {
        return System.getProperty("TEMP");
    }
}
