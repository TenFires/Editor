/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import GUI.main;
import static GUI.main.accent;
import static GUI.main.textarea;
import java.awt.Font;
import static java.awt.SystemColor.text;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author local
 */
public class DOM extends main{


public static void Domparser() {
    
        try{
        JFileChooser fileopen = new JFileChooser(); //ОТКРЫВАЕТСЯ ДИАЛОГОВОЕ ОКНО!
        int ret = fileopen.showDialog(null, "Открыть файл");                
        ret = JFileChooser.APPROVE_OPTION;
        File file = fileopen.getSelectedFile();
        
        
        
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         Document document = builder.parse(new File(file.getAbsolutePath()));
         document.getDocumentElement().normalize();
       
      
        
            NodeList nodeList = document.getElementsByTagName("informant");
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {                     
                Element element = (Element) node;
                try {
                Element date = (Element) element.getElementsByTagName("birth_year").item(0);
                String datestr = date.getTextContent();
                java.util.Date date2 = new SimpleDateFormat("dd.MM.yyyy").parse(datestr);                
                DateBirthChooser.setDate(date2);
                }
                 catch (ParseException ex) {
                     Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                
                NameField.setText((element.getElementsByTagName("fname").item(0).getTextContent()));
                //DateBirthChooser.setText((element.getElementsByTagName("birth_year").item(0).getTextContent()));
                DialectField.setText((element.getElementsByTagName("dialect").item(0).getTextContent()));
                EducationField.setText((element.getElementsByTagName("education").item(0).getTextContent()));
                //GenderSelect.set((element.getElementsByTagName("geder").item(0).getTextContent()));
                PatronymicField.setText((element.getElementsByTagName("lname").item(0).getTextContent()));
                JobField.setText((element.getElementsByTagName("occupation").item(0).getTextContent()));
                SurnameField.setText((element.getElementsByTagName("sname").item(0).getTextContent()));
                SelfIDField.setText((element.getElementsByTagName("who_i_am").item(0).getTextContent()));
                Country.setText((element.getElementsByTagName("state").item(0).getTextContent()));
                region.setText((element.getElementsByTagName("region").item(0).getTextContent()));
                district.setText((element.getElementsByTagName("locality").item(0).getTextContent()));
                jTextField7.setText((element.getElementsByTagName("district").item(0).getTextContent()));
                PlaceBirthField.setText((element.getElementsByTagName("state").item(0).getTextContent()) + ";;" + (element.getElementsByTagName("region").item(0).getTextContent()) + ";;" + (element.getElementsByTagName("locality").item(0).getTextContent()));
                
                
                }
            }
                
                NodeList nodeList1 = document.getElementsByTagName("birth_parent_location");
                for (int l = 0; l < nodeList1.getLength(); l++) {
                Node node1 = nodeList1.item(l);
                
                if (Node.ELEMENT_NODE == node1.getNodeType()) {                     
                Element element = (Element) node1;
                
                Country.setText((element.getElementsByTagName("state").item(0).getTextContent()));
                region.setText((element.getElementsByTagName("region").item(0).getTextContent()));
                district.setText((element.getElementsByTagName("locality").item(0).getTextContent()));
                ParentPlaceBirthField.setText((element.getElementsByTagName("state").item(0).getTextContent()) + ";;" + (element.getElementsByTagName("region").item(0).getTextContent()) + ";;" + (element.getElementsByTagName("locality").item(0).getTextContent()));
                
                }
                }
            
                NodeList nodeList2 = document.getElementsByTagName("location");
                for (int k = 0; k < nodeList2.getLength(); k++)
                {
                    Node node2 = nodeList2.item(k);
                    if (Node.ELEMENT_NODE == node2.getNodeType()) {                     
                Element element = (Element) node2;
                Country.setText((element.getElementsByTagName("state").item(0).getTextContent()));
                region.setText((element.getElementsByTagName("region").item(0).getTextContent()));
                district.setText((element.getElementsByTagName("locality").item(0).getTextContent()));
                jTextField7.setText((element.getElementsByTagName("district").item(0).getTextContent()));
                PlaceRecordField.setText((element.getElementsByTagName("state").item(0).getTextContent()) + ";;" + (element.getElementsByTagName("region").item(0).getTextContent()) + ";;" + (element.getElementsByTagName("locality").item(0).getTextContent()) + ";;" + (element.getElementsByTagName("district").item(0).getTextContent()));
         
                }
                }
                
               
                 NodeList nodeList3 = document.getElementsByTagName("doc");
                 for (int m = 0; m < nodeList3.getLength(); m++){
                      Node node3 = nodeList3.item(m);
                      
                      
                    if (Node.ELEMENT_NODE == node3.getNodeType()) {   
      
                    Element element = (Element) node3;
                    
                      try {
                        Element date = (Element) element.getElementsByTagName("year").item(0);
                        String datestr = date.getTextContent();
                        java.util.Date date2 = new SimpleDateFormat("dd.MM.yyyy").parse(datestr);                
                        DateRecordChooser.setDate(date2);
                          }
                      catch (ParseException ex) {
                        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                          } 
                    
                    SourceField.setText((element.getElementsByTagName("source").item(0).getTextContent()));
                    CommentField.setText((element.getElementsByTagName("remark").item(0).getTextContent()));
             
                    }
                 }
                 
            NodeList nodeList4 = document.getElementsByTagName("doc");
                 for (int n = 0; n < nodeList4.getLength(); n++)
                 {
                    Element element = (Element) nodeList4.item(n);
                    NodeList name = element.getElementsByTagName("record");
                    Element line = (Element) name.item(0);
                    NodeList list = line.getChildNodes();
                    String data;
                    
                for(int index = 0; index < list.getLength(); index++){
                    if(list.item(index) instanceof CharacterData){     
                        CharacterData child  = (CharacterData) list.item(index);
                        data = child.getData();
                        SimpleAttributeSet attribs = new SimpleAttributeSet();
                        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_LEFT);                      
                        textarea.setContentType("text/html;charset=cp1251");
                        textarea.setText(data);
    
                        
                    }

                }
                    
               }

         
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        
      
}
    
}
