package com.zeyferes.Blocks;

public class InputApplicationHeaderBlock extends ApplicationHeaderBlock{
    private int deliveryMonitoring; // 1:Non-delivery, 2:Delivery Notf., 3:Non delivery & Delivery Notf.
    private int obsolescencePeriod; // 3 digits number with leading zero
    private String destinationLtAddress; // 12 character Logical Terminal Address

    public InputApplicationHeaderBlock(Builder builder, String messageType){
        super('I', messageType, builder.priority);
        this.deliveryMonitoring = builder.deliveryMonitoring;
        this.destinationLtAddress = builder.destinationLtAddress;
        if (builder.priority == 'N') {
            this.obsolescencePeriod = 20;
        }
        if (builder.priority =='U') {
            this.obsolescencePeriod = 3;
        }
    }

    public static class Builder{
        private int deliveryMonitoring;
        private char priority;
        private String destinationLtAddress;

        public Builder() {}

        public Builder deliveryMonitoring(int deliveryMonitoring) throws Exception {
            if (this.priority == 'U' && deliveryMonitoring == 2) {
                throw new IllegalArgumentException("Delivery Monitoring cannot be 2 for Urgent priorities");
            }
            if (this.priority == 'N' && (deliveryMonitoring == 1 || deliveryMonitoring == 3)) {
                throw new IllegalArgumentException("Delivery Monitoring should be 2 or blank");
            }
            this.deliveryMonitoring = deliveryMonitoring;
            return this;
        }

        public Builder priority(char priority){
            this.priority = priority;
            if (priority == 'U' && deliveryMonitoring == 2) {
                throw new IllegalArgumentException("priority=U && deliveryMonitoring=2");
            }
            if (priority == 'N' && (deliveryMonitoring == 1 ||deliveryMonitoring == 3)) {
                throw new IllegalArgumentException("priority=" + priority + " && deliveryMonitoring=" + deliveryMonitoring );
            }
            return this;
        }

        public Builder destinationLtAddress(String ltAddress) {
            this.destinationLtAddress = ltAddress;
            return this;
        }


        public InputApplicationHeaderBlock build(String messageType) {
            return new InputApplicationHeaderBlock(this, messageType);
        }
    }

    public int getDeliveryMonitoring() {
        return deliveryMonitoring;
    }

    public int getObsolescencePeriod() {
        return obsolescencePeriod;
    }

    public String getDestinationLtAddress() {
        return destinationLtAddress;
    }

    @Override
    public String toString() {
        return getStartOfBlockIndicator() + getBlockIdentifier() +
               getSepChar() + getInputOutputIdentifier() + getMessageType() +
                getDestinationLtAddress() + getPriority() + getDeliveryMonitoring() +
                String.format("%03d", getObsolescencePeriod()) + getEndOfBlockIndicator();

    }
}
