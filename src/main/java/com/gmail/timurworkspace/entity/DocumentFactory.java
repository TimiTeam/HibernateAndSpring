package com.gmail.timurworkspace.entity;

import com.gmail.timurworkspace.entity.documentPassport.Passport;

import java.util.Random;

public class DocumentFactory {
    private static Long documentNumber = 0L;

    private DocumentFactory() {
    }

    public static Document createDocument(String docType){
        Document result = null;
        if (docType.toLowerCase().equals("passport")){
            String serialNumber = "ID:"+(new Random().nextInt(10000))+":"+documentNumber;
            Passport passport = new Passport();
            passport.setName(docType);
            passport.setSerialNumber(serialNumber);
            result = passport;
        }
        ++documentNumber;
        return result;
    }
}
