package utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class TableHeaderPageNormal extends PdfPageEventHelper {
    /** The header text. */
    String header;
    /** The template with the total number of pages. */
    PdfTemplate total;
    Font fontAdresse = new Font(Font.getFamily("Times New Roman"), 8,Font.NORMAL);
    /**
     * Allows us to change the content of the header.
     * @param header The new header String
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Creates the PdfTemplate that will hold the total number of pages.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(30, 16);
    }
    
    /**
     * Adds a header to every page
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onEndPage(PdfWriter writer, Document document) {
        PdfPTable table = new PdfPTable(3);
        try {
            table.setWidths(new int[]{24, 24, 2});
            table.setTotalWidth(527);
            table.setLockedWidth(true);
            table.getDefaultCell().setFixedHeight(20);
            table.getDefaultCell().setBorder(Rectangle.BOTTOM);
            PdfPCell c71 = new PdfPCell(new Paragraph(header, fontAdresse));
            c71.setBorder(Rectangle.TOP);
            c71.setVerticalAlignment(Element.ALIGN_BOTTOM);
            table.addCell(c71);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            PdfPCell c7 = new PdfPCell(new Paragraph(String.format("Page %d de", writer.getPageNumber()), fontAdresse));
            c7.setBorder(Rectangle.TOP);
            c7.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c7.setVerticalAlignment(Element.ALIGN_BOTTOM);
            table.addCell(c7);
            PdfPCell cell = new PdfPCell(Image.getInstance(total));
            cell.setBorder(Rectangle.TOP);
            table.addCell(cell);
            table.writeSelectedRows(0, -1, 20, 40, writer.getDirectContent());
        }
        catch(DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }
    
    /**
     * Fills out the total number of pages before the document is closed.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onCloseDocument(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onCloseDocument(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
                new Phrase(String.valueOf(writer.getPageNumber() - 1),fontAdresse),
                2, 2, 0);
    }
}
