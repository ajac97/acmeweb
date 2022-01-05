package com.acme;

public class AvailableMemoryDecorator extends BaseServerStatus {
    private BaseServerStatus toDecorate;

    public AvailableMemoryDecorator(BaseServerStatus toDecorate){
        this.toDecorate = toDecorate;

    }
    @Override
    public String getStatusDesc() {
        return toDecorate.getStatusDesc() + ", and there are " + facade.getFreeJVMMemory() + " bytes of JVM memory free";
    }
}
