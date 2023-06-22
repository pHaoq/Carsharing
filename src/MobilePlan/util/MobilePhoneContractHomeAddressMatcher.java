package MobilePlan.util;

import MobilePlan.entities.MobilePhoneContract;
import MobilePlan.provided.Matcher;

public class MobilePhoneContractHomeAddressMatcher implements Matcher<MobilePhoneContract>{
    private java.lang.String pattern;
    public MobilePhoneContractHomeAddressMatcher(java.lang.String pattern){
        this.pattern = pattern;
    }
    /*
     * nicht fertig
     */
    public boolean matches(MobilePhoneContract t){

        return true;
    }
}
