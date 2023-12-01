
package buildingproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;


public class PrinterPDF {
       

    public static void printPDF(String filePath) {
        try {
            
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

            
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();

            
            HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            pras.add(new Copies(1));

          
            DocPrintJob job = printService.createPrintJob();

           
            FileInputStream fis = new FileInputStream(filePath);
            Doc doc = new SimpleDoc(fis, flavor, null);

            
            job.print(doc, pras);

            
            fis.close();
        } catch (PrintException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

