package com.bill.BillGenerator.book;

import com.bill.BillGenerator.enricher.RandomNumberEnricher;
import com.bill.BillGenerator.pojo.Book;
import com.bill.BillGenerator.utils.CommonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.itextpdf.html2pdf.HtmlConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static com.bill.BillGenerator.book.BookConstants.*;

public class BookBillApp {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException, XPathExpressionException {
        InputStream inputStream = TypeReference.class.getResourceAsStream("/book/book.html");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputStream);
        XPath xpath = XPathFactory.newInstance().newXPath();
        updateInvoiceNumber(xpath, doc);
        assignValues(xpath, doc, "billDate", BILL_DATE);
        updateBilledBy(xpath, doc);
        updateBilledTo(xpath, doc);
        Integer totalSum = 0;
        for (Book book : books) {
            updateBook(xpath, doc, book);
            totalSum += book.getTotal();
        }
        double finalPrice = Math.round(totalSum / 1.12 * 100.0) / 100.0;
        double finalTax = Math.round(finalPrice * 0.12 * 100.0) / 100.0;
        assignValues(xpath, doc, "finalTotal", "₹" + totalSum);
        assignValues(xpath, doc, "finalGst", "₹" + finalTax);
        assignValues(xpath, doc, "finalPrice", "₹" + finalPrice);
        assignValues(xpath, doc, "totalInWords", CommonUtils.numberToWords(totalSum) + " Rupees Only");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/main/resources/book/output/output.html"));
        transformer.transform(source, result);
        HtmlConverter.convertToPdf(new File("src/main/resources/book/output/output.html"), new File("src/main/resources/book/output/output.pdf"));
    }

    private static void updateBook(XPath xpath, Document document, Book book) throws XPathExpressionException {
        Node node = (Node) xpath.evaluate("//*[@id='" + book.getId() + "']", document, XPathConstants.NODE);
        Integer totalPrice = book.getTotal();
        double price = Math.round(totalPrice / 1.12 * 100.0) / 100.0;
        double cgst = Math.round(price * 0.12 * 100.0) / 100.0;
        NodeList list = node.getChildNodes();
        list.item(3).setTextContent(book.getName());
        list.item(9).setTextContent("₹" + price);
        list.item(11).setTextContent("₹" + cgst);
        list.item(13).setTextContent("₹" + totalPrice);

    }

    private static void updateBilledBy(XPath xpath, Document document) throws XPathExpressionException {
        Node node = (Node) xpath.evaluate("//*[@id='billedBy']", document, XPathConstants.NODE);
        node.getChildNodes().item(0).setTextContent(SELLER_NAME);
        node.getChildNodes().item(2).setTextContent(SELLER_ADDRESS);
        node.getChildNodes().item(5).setTextContent(SELLER_EMAIL);
    }

    private static void updateBilledTo(XPath xpath, Document document) throws XPathExpressionException {
        Node node = (Node) xpath.evaluate("//*[@id='billedTo']", document, XPathConstants.NODE);
        node.getChildNodes().item(0).setTextContent(BUYER_NAME);
        node.getChildNodes().item(2).setTextContent(BUYER_ADDRESS);
        node.getChildNodes().item(5).setTextContent(BUYER_EMAIL);
    }

    private static void assignValues(XPath xpath, Document document, String nodeId, String value) throws XPathExpressionException {
        Node node = (Node) xpath.evaluate("//*[@id='" + nodeId + "']", document, XPathConstants.NODE);
        node.getChildNodes().item(0).setTextContent(value);
    }

    private static void updateInvoiceNumber(XPath xpath, Document document) throws XPathExpressionException {
        Node node = (Node) xpath.evaluate("//*[@id='invoiceNo']", document, XPathConstants.NODE);
        node.getChildNodes().item(0).setTextContent(new RandomNumberEnricher().process());
    }
}
