package com.acme.decorators;
/**
 * This class is a decorator for the BaseServerStatus class. Hence it extends BaseServerStatus. It decorates status
 * desctiprion to return the available processors of the system.
 */

public class AvailableProcessorsDecorator extends BaseServerStatus {
    private BaseServerStatus objToDecorate;

    public AvailableProcessorsDecorator(BaseServerStatus objToDecorate){
        this.objToDecorate = objToDecorate;
    }
    @Override
    public String getStatusDesc() {
        return objToDecorate.getStatusDesc() + ", and there are " + facade.getAvailProcessors() + " processors available";
    }
}
