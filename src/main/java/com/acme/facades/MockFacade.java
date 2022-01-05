package com.acme.facades;

/**
 * This is a mock facade implementation of the FacadeInterface that will be used for unit testing. It returns constant arbitrary results.
 */

public class MockFacade implements FacadeInterface{
    /**
     *
     * @return available processors
     */
    @Override
    public int getAvailProcessors() {
        return 5;
    }

    /**
     *
     * @return available memory
     */
    @Override
    public long getFreeJVMMemory() {
        return 6;
    }

    /**
     * @return total memory
     */
    @Override
    public long getTotalJVMMemory() {
        return 7;
    }


    /**
     * @return JRE version
     */
    @Override
    public String getJREVersion() {
        return "17";
    }

    /**
     * @return location of the temp files
     */
    @Override
    public String getTempLocation() {
        return "C:\\Users\\Akiva Jacobson\\AppData\\Local\\Temp";
    }
}
