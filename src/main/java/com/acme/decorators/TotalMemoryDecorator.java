package com.acme.decorators;

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
