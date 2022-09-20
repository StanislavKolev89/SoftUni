package com.example.springdataxml.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface ParserXml {
    <T>  T extractFromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException;
    <T> void writeToFile(String filePath, T entity) throws JAXBException;
 }
