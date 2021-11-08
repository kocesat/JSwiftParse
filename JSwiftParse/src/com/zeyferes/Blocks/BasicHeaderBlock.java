package com.zeyferes.Blocks;

public class BasicHeaderBlock extends Block{
        private char appId;
        private int serviceId; // 2 digit with leading zeros
        private String ltAddress; //12 characters
        private int sessionNumber; // 4 digits with leading zeros
        private int sequenceNumber; // 6 digits (always) number

    public BasicHeaderBlock(char appId, int serviceId, String ltAddress, int sessionNumber, int sequenceNumber) {
        super("1");
        this.appId = appId;
        this.serviceId = serviceId;
        this.ltAddress = ltAddress;
        this.sessionNumber = sessionNumber;
        this.sequenceNumber = sequenceNumber;
    }

    public char getAppId() {
        return appId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getLtAddress() {
        return ltAddress;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    @Override
    public String toString() {
        return super.startOfBlockIndicator + super.getBlockIdentifier() +
                super.sepChar + appId + String.format("%02d", serviceId) + ltAddress + sessionNumber +
                sequenceNumber + super.endOfBlockIndicator;
    }
}
