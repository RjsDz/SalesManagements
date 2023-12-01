
package buildingproject;

import java.io.File;


public class FileEdit {
    
    public static void mkdirInvoices(){
        try {
            File f = new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"Invoices");
            if(!f.exists())
                f.mkdir();
        } catch (Exception e) {
        }
    }
    
    public static void mkdirSalesInvoices(){
        try {
            File f = new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"Invoices"+File.separator+"SalesInvoices");
            
            if(!f.exists())
                f.mkdir();
        } catch (Exception e) {
            System.out.println(e +"");
        }
    }
    
    public static void mkdirPurchasesInvoices(){
        try {
            File f = new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"Invoices"+File.separator+"PurchasesInvoices");
            
            if(!f.exists())
                f.mkdir();
        } catch (Exception e) {
            System.out.println(e +"");
        }
    }
    
    public static void allDirs(){
        FileEdit.mkdirInvoices();
        FileEdit.mkdirPurchasesInvoices();
        FileEdit.mkdirSalesInvoices();
    }
    
    
    public static boolean isExistsFile(String path){
        String p = System.getProperty("user.home")+File.separator+"Desktop"+path;
        File f = new File(path);
        if(f.exists()){
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }
}
