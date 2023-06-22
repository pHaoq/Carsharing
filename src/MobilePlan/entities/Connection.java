package MobilePlan.entities;

import MobilePlan.provided.ConnectionType;
import MobilePlan.provided.DateTime;

import java.util.Date;

/**
 * 
 * A connection, aka a call between two contracts. A "phone call".<br>
 * 
 */
public class Connection {
    private final MobilePhoneContract callee;
    private final MobilePhoneContract caller;
    private final DateTime dateTime;
    private final ConnectionType type;
    private final int units;

    public Connection(MobilePhoneContract caller,
                       MobilePhoneContract callee,
                       ConnectionType type,
                       DateTime dt,
                       int units){
        if (caller == null || callee == null || type == null || dt ==null || units < 0)
            throw new IllegalArgumentException("Illegal Arguments");
        this.caller = caller;
        this.callee = callee;
        this.type = type;
        this.dateTime = dt;
        this.units = units;
    }
    public int getUnits(){
        return units;
    }
    public MobilePhoneContract getCaller(){
        return caller;
    }

    /**
     *  Creates a string representation of this connection.<br>
     */
    @Override
    public String toString() {
        return "\nConnection [caller=" + caller.getImei() + ", callee=" + callee.getImei() + ", type=" + type
                + ", units=" + units + ", DateTime=" + dateTime + "]";
    }

}
