package com.zeyferes.Parser;

import com.zeyferes.Blocks.BasicHeaderBlock;

import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class BasicHeaderBlockParser {

    /**
     * Returns a BasicHeaderBlock created after parsing text of the block
     * @param textOfBlock
     * @return
     * @throws Exception
     */
    public static BasicHeaderBlock parse(String textOfBlock) throws Exception {

        Pattern pattern = Pattern.compile("\\{\\w{1,3}:[FAL](01|21)[A-Z0-9]{12}\\d{4}\\d{6}\\}");
        if (!textOfBlock.matches(String.valueOf(pattern))) {
            throw new PatternSyntaxException("Pattern doesn't match to basic header block",
                                        String.valueOf(pattern), -1);
        }

        int colonIndex = textOfBlock.indexOf(':');
        if (!textOfBlock.substring(1,colonIndex).equals("1") ) {
            throw new Exception("Invalid Block Identifier");
        }

        // {1:A01TCMBTR2A0XXX4321123456}
        char appId = textOfBlock.charAt(3);
        int serviceId = Integer.parseInt(textOfBlock.substring(4,6));
        String ltAddress = textOfBlock.substring(6,18);
        int sessionNumber = Integer.parseInt(textOfBlock.substring(18,22));
        int sequenceNumber = Integer.parseInt(textOfBlock.substring(22,28));

        return new BasicHeaderBlock(appId, serviceId, ltAddress, sessionNumber, sequenceNumber);
    }
}
