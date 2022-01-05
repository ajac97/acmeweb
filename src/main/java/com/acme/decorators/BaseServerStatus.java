package com.acme.decorators;

import com.acme.facades.FacadeInterface;

import java.util.List;

/**
 * This is a class that represents the basic server status object that is intended to be decorated by decorators that
 * extend this class.
 */

public abstract class BaseServerStatus {
    protected static long id;
    protected static String contentHeader;
    protected static String statusDesc = "Unknown";
    protected static List<String> details;
    protected static FacadeInterface facade;



    /**
     * Get the content header that was specified by the request
     *
     * @return some string
     */
    public String getContentHeader() {
        return contentHeader;
    }

    /**
     * Get an english-like description of the server's status
     *
     * @return A string describing status
     */

    public abstract String getStatusDesc();

    /**
     * Returns the auto incremented ID for each refresh of the web page.
     * @return
     */
    public long getId() {
        return id;
    }


    /**
     * This sets the implementation of the facade class that is to be used when running the server.
     * @param facadeInterface
     */

    public static void setFacade(FacadeInterface facadeInterface) {
        facade = facadeInterface;
    }


}
