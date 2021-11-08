package com.zeyferes.Blocks;

public class OutputApplicationHeaderBlock extends ApplicationHeaderBlock{
    private String inputTime; // HHMM
    private String messageInputReference;
    private String outputDate; // YYMMDD
    private String outputTime; // HHMM

    public OutputApplicationHeaderBlock(String messageType, String inputTime, String messageInputReference, String outputDate, String outputTime) {
        super('O', messageType);
        this.inputTime = inputTime;
        this.messageInputReference = messageInputReference;
        this.outputDate = outputDate;
        this.outputTime = outputTime;
    }

    public OutputApplicationHeaderBlock(String messageType, char priority, String inputTime, String messageInputReference, String outputDate, String outputTime) {
        super('O', messageType, priority);
        this.inputTime = inputTime;
        this.messageInputReference = messageInputReference;
        this.outputDate = outputDate;
        this.outputTime = outputTime;
    }

    public String getInputTime() {
        return inputTime;
    }

    public String getMessageInputReference() {
        return messageInputReference;
    }

    public String getOutputDate() {
        return outputDate;
    }

    public String getOutputTime() {
        return outputTime;
    }

    @Override
    public String toString() {
        return getStartOfBlockIndicator() + getBlockIdentifier() +
                getSepChar() + getInputOutputIdentifier() + getMessageType() +
                getInputTime() + getMessageInputReference() + getOutputDate() +
                getOutputTime() + getPriority() + getEndOfBlockIndicator();
    }
}
