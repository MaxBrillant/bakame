package CloudOperations;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Arrays;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class Mongo {
    public static void main (String [] args)
    {
    	JFrame j = new JFrame();
    	j.setVisible(true);
    	j.setSize(new Dimension(400, 300));
		JPanel p = new JPanel();
		p.setBackground(Color.green);
    	p.setPreferredSize(new Dimension(400, 300));
		j.add(p);
		JLabel jl = new JLabel("Hello World");
		p.add(jl);
		PrintFrameToPDF(p, new File("C:/Users/User/Desktop/test.pdf"));
		System.out.println("Done");
		}
 
    public static void PrintFrameToPDF(Component c, File file) {
        try {
            com.itextpdf.text.Document d = new com.itextpdf.text.Document();
            PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream(file));
            d.open();

            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate template = cb.createTemplate(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            Graphics2D g2d = template.createGraphics(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            g2d.translate(48.0, 48.0);
            c.paintAll(g2d);
            g2d.dispose();
            
            cb.addTemplate(template, 0, 0);
            d.close();
        } catch (Exception e) {
            //
        }
    }
}
