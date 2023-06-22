package MobilePlan.entities;

import MobilePlan.provided.Customer;

public class PrePaidCard extends MobilePhoneContract{
    private float preloadedAmount;
    public PrePaidCard(Customer customer,
                       java.lang.String imei,
                       java.lang.String carrier,
                       float preloadedAmount){
        super(customer,imei,carrier);
        this.preloadedAmount = preloadedAmount;
    }
    public PrePaidCard(Customer customer,
                        java.lang.String imei,
                        java.lang.String carrier){
        super(customer,imei,carrier);
        this.preloadedAmount = 0;
    }
    @Override
    public int unitsLeft() {
        return 0;
    }

    @Override
    public float additionalFee() {
        return 0;
    }
}
