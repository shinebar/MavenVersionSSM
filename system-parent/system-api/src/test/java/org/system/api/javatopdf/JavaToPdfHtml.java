package org.system.api.javatopdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class JavaToPdfHtml {
	private static final String DEST = "target/HelloWorld_CN_HTML.pdf";
    private static final String HTML = System.getProperty("user.dir")+"/template.html";
    private static final String FONT = "simhei.ttf";
  
  
    public static void main(String[] args) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        // step 3
        document.open();
        // step 4
        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
        fontImp.register(FONT);
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(HTML), null, Charset.forName("UTF-8"), fontImp);
        // step 5
        document.close();
    }	

}
