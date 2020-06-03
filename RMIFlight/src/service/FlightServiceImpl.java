package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import client.FlightService;
import entity.FlightEntity;


public class FlightServiceImpl extends UnicastRemoteObject implements FlightService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5858839379542040747L;
	
	public FlightServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getFlight(String leavecity, PrintFlightService printService) throws XPathExpressionException, ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		// TODO Auto-generated method stub
		Document doc;
		XPath xpath;
		
		// 创建Document对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(new FileInputStream(new File("info_Provider1.xml")));	//中航
 
        // 创建XPath对象
        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();
        
		System.out.println("Get flights of air china ");
        try {
            Thread.currentThread();
            Thread.sleep(3000); //睡眠3秒用于模拟执行所需时间
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<FlightEntity> flights = new ArrayList<FlightEntity>();
        NodeList nodeList = (NodeList) xpath
    			.evaluate("//flights/flight[leaveairport[contains(text(),'" + leavecity + "')]]",
    					doc, XPathConstants.NODESET);
        
        System.out.println(nodeList.getLength());
        for(int i = 0; i < nodeList.getLength(); i++) {
        	String s[] = nodeList.item(i).getTextContent().split("\n");
        	flights.add(new FlightEntity(s[0], s[1], s[2], s[3], s[4], s[5], s[6]));
        }
        // 南航
        doc = db.parse(new FileInputStream(new File("info_Provider2.xml")));
        nodeList = (NodeList) xpath
    			.evaluate("//flights/flight[leaveairport[contains(text(),'" + leavecity + "')]]",
    					doc, XPathConstants.NODESET);
        System.out.println(nodeList.getLength());
        for(int i = 0; i < nodeList.getLength(); i++) {
        	String s[] = nodeList.item(i).getTextContent().split("\n");
        	flights.add(new FlightEntity(s[0], s[1], s[2], s[3], s[4], s[5], s[6]));
        }      
        //厦航
        doc = db.parse(new FileInputStream(new File("info_Provider3.xml")));
        nodeList = (NodeList) xpath
    			.evaluate("//flights/flight[leaveairport[contains(text(),'" + leavecity + "')]]",
    					doc, XPathConstants.NODESET);
        System.out.println(nodeList.getLength());
        for(int i = 0; i < nodeList.getLength(); i++) {
        	String s[] = nodeList.item(i).getTextContent().split("\n");
        	flights.add(new FlightEntity(s[0], s[1], s[2], s[3], s[4], s[5], s[6]));
        }
        
        printService.printFlight(flights); //执行客户端的回调函数
	}
}
