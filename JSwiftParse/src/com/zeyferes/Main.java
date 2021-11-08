package com.zeyferes;

import com.zeyferes.Blocks.*;
import com.zeyferes.Parser.ApplicationHeaderBlockParser;
import com.zeyferes.Parser.BasicHeaderBlockParser;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
//        Block basic = new BasicHeaderBlock('F', 01, "TCMBTR2AOXXX", 4321, 123456);
//        System.out.println(basic);
//
//        String textBlock = "{1:F014321TCMBTR2AOXXX}";
//        char a = textBlock.charAt(0);
//        char b = textBlock.charAt(textBlock.length() - 1);
//        System.out.println(a);
//        System.out.println(b);
//
//        Pattern pattern;
//        pattern = Pattern.compile("\\{\\w{1,3}:[FAL]\\d{2}[A-Z0-9]{12}\\d{4}\\d{6}\\}");

////        {w{1,4}:[FAL]d{2}[A-Z0-9]{12}d{4}d{6}}
//        System.out.println(str.matches(String.valueOf(pattern)));
//        int colonIndex = str.indexOf(':');
//        System.out.println(str.charAt(4));

//        String str = "{1:A21TCMBTR2A0XXX4321123486}";
//        BasicHeaderBlock basic = BasicHeaderBlockParser.parse(str);
//        System.out.println(basic);
//        System.out.println(basic.getLtAddress());
//        System.out.println(basic.getServiceId());
//        System.out.println(basic.getSequenceNumber());
//        System.out.println(basic.getSessionNumber());
//        System.out.println("BIC of Inst.: " + basic.getLtAddress().substring(0,8));
//
//        System.out.println("************************");

//        ApplicationHeaderBlock appHeader = new InputApplicationHeaderBlock.Builder()
//                .deliveryMonitoring(3)
//                .priority('U')
//                .destinationLtAddress("BANKFRPPAXXX")
//                .build("103");
//
//        ApplicationHeaderBlock appHeader = new OutputApplicationHeaderBlock(
//                "202", 'N', "1345", "160418SOGEFRPPAXXX0089725497",
//                "160418", "1345"
//        );


        String text = "{2:O2021345160418SOGEFRPPAXXX00897254971604181345N}";

//        System.out.println(text.indexOf(':'));
//        System.out.println(text.substring(4,7));
//        System.out.println("Input Time: " + text.substring(7,11));
//        System.out.println("MIR:" + text.substring(13,39));
        ApplicationHeaderBlock appHeader = ApplicationHeaderBlockParser.parse(text);
        System.out.println(appHeader);
        System.out.println(appHeader.getPriority());
    }

}
