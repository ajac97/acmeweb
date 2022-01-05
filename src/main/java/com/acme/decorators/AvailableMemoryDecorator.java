package com.acme.decorators;

/**
 * This class is a decorator for the BaseServerStatus class. Hence it extends BaseServerStatus. It decorates status
 * desctiprion to return the available memory of the system.
 */

public class AvailableMemoryDecorator extends BaseServerStatus {
    private BaseServerStatus toDecorate;

    public AvailableMemoryDecorator(BaseServerStatus toDecorate){
        this.toDecorate = toDecorate;

    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String getStatusDesc() {
        return toDecorate.getStatusDesc() + ", and there are " + facade.getFreeJVMMemory() + " bytes of JVM memory free";
    }
}
