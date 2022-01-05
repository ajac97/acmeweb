package com.acme;

public class AvailableProcessorsDecorator extends BaseServerStatus {
    private BaseServerStatus objToDecorate;

    public AvailableProcessorsDecorator(BaseServerStatus objToDecorate){
        this.objToDecorate = objToDecorate;
    }
    @Override
    public String getStatusDesc() {
        return objToDecorate.getStatusDesc() + ", and there are " + facade.getAvailProcessors() + "  processors available";
    }
}
