package com.acme.decorators;

import com.acme.facades.FacadeInterface;

import java.util.List;


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

    public long getId() {
        return id;
    }



    public static void setFacade(FacadeInterface facadeInterface) {
        facade = facadeInterface;
    }


}
