package com.zeyferes.Blocks;

public abstract class Block {
    final char startOfBlockIndicator = '{';
    private String blockIdentifier;
    final char sepChar = ':';
    final char endOfBlockIndicator = '}';

    public Block(String blockIdentifier) {
        this.blockIdentifier = blockIdentifier;
    }

    public char getStartOfBlockIndicator() {
        return startOfBlockIndicator;
    }

    public String getBlockIdentifier() {
        return blockIdentifier;
    }

    public char getSepChar() {
        return sepChar;
    }

    public char getEndOfBlockIndicator() {
        return endOfBlockIndicator;
    }

}
