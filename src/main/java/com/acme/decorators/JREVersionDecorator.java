package com.acme.decorators;

/**
 * This class is a decorator for the BaseServerStatus class. Hence it extends BaseServerStatus. It decorates status
 * desctiprion to return the available JRE of the system.
 */


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
