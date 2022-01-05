package com.acme.decorators;

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
