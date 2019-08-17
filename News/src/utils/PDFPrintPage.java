package utils;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PDFRenderer;


class PDFPrintPage implements Printable {
        private PDFFile file;
        PDFPrintPage(PDFFile file) {
            this.file = file;
        }
 
        public int print(Graphics g, PageFormat format, int index)
        throws PrinterException {
            int pagenum = index + 1;
            
            // don't bother if the page number is out of range.
            if ((pagenum >= 1) && (pagenum <= file.getNumPages())) {
                // fit the PDFPage into the printing area
                Graphics2D g2 = (Graphics2D)g;
                PDFPage page = file.getPage(pagenum);
                double pwidth = format.getImageableWidth();
                double pheight = format.getImageableHeight();
 
                Rectangle imgbounds;
                format.getPaper().setSize(pwidth, pwidth);

                imgbounds = new Rectangle((int)(format.getImageableX()),5, (int)pwidth,(int)pheight-20 );
                // render the page
               
                PDFRenderer pgs = new PDFRenderer(page, g2, imgbounds, null, null);
                try {
                    page.waitForFinish();
                    pgs.run();
                } catch (InterruptedException ie) {}
 
                return PAGE_EXISTS;
            } else {
                return NO_SUCH_PAGE;
            }
        }
        
    }
