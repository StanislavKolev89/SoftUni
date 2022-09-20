package com.example.springdataxml.util.impl;

import com.example.springdataxml.util.ParserXml;
import org.springframework.stereotype.Component;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class ParserXmlImpl implements ParserXml {

    private  JAXBContext jaxbContext;
    @Override
    @SuppressWarnings("unchecked")
    public <T> T extractFromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException {
        jaxbContext= JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new FileReader(filePath));
    }

    @Override
    public <T> void writeToFile(String filePath, T entity) throws JAXBException {
        jaxbContext =JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        marshaller.marshal(entity,new File(filePath));

    }
}
