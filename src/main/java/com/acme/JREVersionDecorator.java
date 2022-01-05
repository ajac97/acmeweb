package com.acme;

public class JREVersionDecorator extends BaseServerStatus {
    private BaseServerStatus objToDecorate;

    public JREVersionDecorator(BaseServerStatus objToDecorate){
        this.objToDecorate = objToDecorate;
    }
    @Override
    public String getStatusDesc() {
        return objToDecorate.getStatusDesc() + ", and the JRE version is " + facade.getJREVersion();
    }


}
