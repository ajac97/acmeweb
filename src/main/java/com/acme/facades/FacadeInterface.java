package com.acme.facades;

/**
 * This is an interface that is used as a contract for a facade class that returns system information.
 */

public interface FacadeInterface {

    /**
     *
     * @return available processors
     */
    public int getAvailProcessors();

    /**
     *
     * @return available memory
     */
    public long getFreeJVMMemory();

    /**
     * @return total memory
     */
    public long getTotalJVMMemory();

    /**
     * @return JRE version
     */
    public String getJREVersion();


    /**
     * @return location of the temp files
     */
    public String getTempLocation();



}
