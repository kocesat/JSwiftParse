package com.zeyferes.Parser;

import com.zeyferes.Blocks.ApplicationHeaderBlock;
import com.zeyferes.Blocks.OutputApplicationHeaderBlock;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ApplicationHeaderBlockParser {

    public static ApplicationHeaderBlock parse(String textOfBlock) throws Exception{
        ApplicationHeaderBlock appHeader = null;
        
        int colonIndex = textOfBlock.indexOf(':');
        if (!textOfBlock.substring(1,colonIndex).equals("2") ) {
            throw new Exception("Invalid Block Identifier");
        }

        if (textOfBlock.charAt(colonIndex + 1)=='O') {
            appHeader = parseOutputApplicationHeader(textOfBlock);
        } else if (textOfBlock.charAt(colonIndex + 1)=='I'){
            appHeader = parseInputApplicationHeader(textOfBlock);
        } else {
            throw new Exception("Invalid Input Output Mode in Block 2");
        }

        return appHeader;
    }

    public static ApplicationHeaderBlock parseOutputApplicationHeader(String textOfBlock) {
        Pattern pattern = Pattern.compile("\\{\\w{1,3}:O\\d{3}\\d{5}\\d{5}[A-Z]{4}[A-Z]{2}[0-9A-Z]{2}[0-9A-Z][0-9A-Z]{3}[0-9]{4}[0-9]{6}\\d{10}(S|U|N)?\\}");
        if (!textOfBlock.matches(String.valueOf(pattern))){
            throw new PatternSyntaxException("Pattern doesn't match", String.valueOf(pattern), -1);
        }

        int colonIndex = textOfBlock.indexOf(':');
        String messageType = textOfBlock.substring(colonIndex + 2, colonIndex + 5);
        String inputTime = textOfBlock.substring(colonIndex + 5, colonIndex + 9);
        String MIR = textOfBlock.substring(colonIndex + 9, colonIndex + 37);
        String outputDate = textOfBlock.substring(colonIndex + 37, colonIndex + 43);
        String outputTime = textOfBlock.substring(colonIndex + 43, colonIndex + 47);
        if (textOfBlock.matches("(S|U|N)\\}")) {
            char priority = textOfBlock.charAt(textOfBlock.indexOf("(S|U|N)\\}"));
            return new OutputApplicationHeaderBlock(messageType, priority, inputTime, MIR, outputDate, outputTime);
        } else {
            return new OutputApplicationHeaderBlock(messageType, inputTime, MIR, outputDate, outputTime);
        }

    }

    public static ApplicationHeaderBlock parseInputApplicationHeader(String textOfBlock) {
        // TODO: Write a parser function parseInputApplicationHeader
        return null;
    }
}
