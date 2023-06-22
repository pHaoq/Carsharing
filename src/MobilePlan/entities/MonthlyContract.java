package MobilePlan.entities;

import MobilePlan.provided.Customer;

public class MonthlyContract extends MobilePhoneContract{
    private int includedUnits;
    public MonthlyContract(Customer customer,
                           java.lang.String imei,
                           java.lang.String carrier,
                           int includedUnits){
        super(customer,imei,carrier);
        if (includedUnits < 0){
            this.includedUnits = 0;
        }else this.includedUnits = includedUnits;
    }
    public void setIncludedUnits(int includedUnits){
        if (includedUnits > 0)
            this.includedUnits = includedUnits;
    }

    @Override
    public int unitsLeft() {

        return includedUnits - this.getUsedUnits();
    }

    @Override
    public float additionalFee() {
        if (unitsLeft() > 0)
            return 0;
        return unitsLeft()*0.2f*-1;
    }
}
