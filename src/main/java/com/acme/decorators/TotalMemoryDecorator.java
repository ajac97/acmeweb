package com.acme.decorators;

/**
 * This class is a decorator for the BaseServerStatus class. Hence it extends BaseServerStatus. It decorates status
 * desctiprion to return the total memory of the system.
 */


public class TotalMemoryDecorator extends BaseServerStatus {

    private BaseServerStatus objToDecorate;

    public TotalMemoryDecorator(BaseServerStatus objToDecorate){
        this.objToDecorate = objToDecorate;
    }
    @Override
    public String getStatusDesc() {
        return objToDecorate.getStatusDesc() + ", and there is a total of " + facade.getTotalJVMMemory() + " bytes of JVM memory";
    }

}
