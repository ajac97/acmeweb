package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;
import com.acme.decorators.BaseServerStatus;

import java.util.List;

/**
 * A POJO that represents Server Status and can be returned as the result of a request.
 */
public class ServerStatus extends BaseServerStatus {
    /*private long id;
    private String contentHeader;
    private String statusDesc = "Unknown";
    private List<String> details;*/
    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     * This class must return a pretty, english-like representation of the server status.
     *
     * @param id            a numeric identifier/counter of which request this is
     * @param contentHeader info about the request
     */


    public ServerStatus(long id, String contentHeader, List<String> details) {
        this.id = id;
        this.contentHeader = contentHeader;
        this.details = details;

        // Obtain current status of server
        this.statusDesc = "Server is " + ServerManager.getCurrentServerStatus();

    }

    public ServerStatus() {

    }

    /**
     * get the id of this request
     *
     * @return a numeric id that increases during life of server for each request .
     */

    @Override
    public String getStatusDesc() {
        return statusDesc;
    }



    public List<String> getDetails() {
        return details;
    }



}
