package com.zeyferes.Blocks;

public class ApplicationHeaderBlock extends Block{
    private char inputOutputIdentifier; // I:Input Mode (Sender), O:Output Mode (Receiver)
    private String messageType; // 3 characters of message type eg. 103
    private char priority; // S:System, U:Urgent, N:Normal

    public ApplicationHeaderBlock(char inputOutputIdentifier, String messageType) {
        super("2");
        this.inputOutputIdentifier = inputOutputIdentifier;
        this.messageType = messageType;
    }

    public ApplicationHeaderBlock(char inputOutputIdentifier, String messageType, char priority) {
        super("2");
        this.inputOutputIdentifier = inputOutputIdentifier;
        this.messageType = messageType;
        this.priority = priority;
    }

    public char getInputOutputIdentifier() {
        return inputOutputIdentifier;
    }

    public String getMessageType() {
        return messageType;
    }

    public char getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "ApplicationHeaderBlock{" +
                "inputOutputIdentifier=" + inputOutputIdentifier +
                ", messageType='" + messageType + '\'' +
                ", priority=" + priority +
                '}';
    }
}

