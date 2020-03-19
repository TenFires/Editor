/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.text.html.HTMLEditorKit;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author local
 */
public class StyleSheet {
 

    public static void main(String[] args) throws IOException, URISyntaxException, TransformerException {
        
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource("stylesheet.xsl");
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new File("article1.xml"));
        transformer.transform(xml, new StreamResult(new File("output.xml")));
    
}
}
