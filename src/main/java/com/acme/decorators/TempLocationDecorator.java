package com.acme.decorators;

/**
 * This class is a decorator for the BaseServerStatus class. Hence it extends BaseServerStatus. It decorates status
 * desctiprion to return the location of temp of the system.
 */

public class TempLocationDecorator extends BaseServerStatus {

    private BaseServerStatus objToDecorate;

    public TempLocationDecorator(BaseServerStatus objToDecorate){
        this.objToDecorate = objToDecorate;
    }
    @Override
    public String getStatusDesc() {
        return objToDecorate.getStatusDesc() + ", and the server's temp file location is " + facade.getTempLocation();
    }

}
