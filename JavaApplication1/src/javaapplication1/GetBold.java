/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import static GUI.main.textarea;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author local
 */
public class GetBold {
    
    public static void gettingbold()
    {
          
        int start = textarea.getSelectionStart();
        int end = textarea.getSelectionEnd();      
        String text = textarea.getSelectedText();
 
            try{
                HTMLEditorKit editorKit = new HTMLEditorKit();
                HTMLDocument document = (HTMLDocument) textarea.getDocument();
                document.remove(start, (end - start));
                editorKit.insertHTML(document, start,  ("<b>" + text +  "</b>"), 0, 0, HTML.Tag.B);
  
             }
            catch (Exception ex)
           {
                ex.printStackTrace();
           }
 
        textarea.requestFocus();
        textarea.select(start, end);
    }
}
