
package buildingproject;


import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.xmp.options.AliasOptions;
import java.io.File;
import java.io.FileOutputStream;

public class PDFInvoiceGenerate {
    public static void pdfCreate() {
        FileEdit.allDirs();
        String path = System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"Invoices"+File.separator;
        String outputFolderPath = path.concat((Lists.pointerOfProduct == 1) ? "SalesInvoices" : "PurchasesInvoices");
        String outputFileName = "Invoice_"+DateTimeTotalType.date+"_"+DateTimeTotalType.time.replace(":", "-") + ".pdf";

        
        File outputFolder = new File(outputFolderPath);
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }

        String fullOutputPath = outputFolderPath + File.separator + outputFileName;

        Document document = new Document();

        try {
            
            
            PdfWriter.getInstance(document, new FileOutputStream(fullOutputPath));
            document.open();
           
            Paragraph header = new Paragraph("INVOICE\n\n\n",new Font(Font.FontFamily.HELVETICA,18,Font.BOLD));
            header.setAlignment(Element.ALIGN_CENTER);
            Paragraph d = new Paragraph("Date : "+DateTimeTotalType.date);
            Paragraph t = new Paragraph("Time : "+DateTimeTotalType.time+"\n\n");
            
             Font f0 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            PdfPTable table = new PdfPTable(3);
            table.addCell(new Phrase("Designation",f0));
            table.addCell(new Phrase("Prix unitaire",f0));
            table.addCell(new Phrase("Qte",f0));

            switch(Lists.pointerOfProduct){
                case 1 -> {
                    for(Product p : Lists.list1){
                        table.addCell(p.getCode()+"");
                        table.addCell(p.getPrix_unitaire()+"");
                        table.addCell(p.getQte()+"");
                    }
                }
                    
                case 2 -> {
                    for(Product p: Lists.list2){
                        table.addCell(p.getDisignation());
                        table.addCell(p.getPrix_unitaire()+"");
                        table.addCell(p.getQte()+"");
                    }
                    System.out.println("table created successfully");
                }
                
                default -> {
                    for(Product p : Lists.list1){
                        table.addCell(p.getDisignation());
                        table.addCell(p.getPrix_unitaire()+"");
                        table.addCell(p.getQte()+"");
                    }
                }
            }
            
            Paragraph totalP = new Paragraph("\nTotal : "+DateTimeTotalType.total+"", new Font(Font.FontFamily.COURIER,14,Font.BOLD));
            totalP.setAlignment(Element.ALIGN_LEFT);
            
            Paragraph payP = new Paragraph("\nPayment : "+DateTimeTotalType.pay+"", new Font(Font.FontFamily.COURIER,14,Font.BOLD));
            payP.setAlignment(Element.ALIGN_LEFT);
            
            Paragraph dueP = new Paragraph("\nDues: "+DateTimeTotalType.due+"", new Font(Font.FontFamily.COURIER,14,Font.BOLD));
            dueP.setAlignment(Element.ALIGN_LEFT);
 
            Paragraph pr = new Paragraph("\n********You're Welcome********", new Font(Font.FontFamily.COURIER,14,Font.BOLD));
            pr.setAlignment(Element.ALIGN_CENTER);
            
            document.add(header);
            document.add(d);
            document.add(t);
            document.add(table);
            document.add(totalP);
            document.add(payP);
            document.add(dueP);
            document.add(pr);
        } catch (Exception e) {
            System.out.println("Error creating PDF: " + e.getMessage());
        } finally {
            document.close();
        }
        PrinterPDF.printPDF(fullOutputPath);
    }
}

