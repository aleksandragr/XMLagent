package com.travel.Agent.soap;

import java.net.URL;

import javax.xml.soap.*;

import com.travel.Agent.dto.AccommodationDTO;
import com.travel.Agent.dto.PricePlanDTO;


public class PricePlanSoap {

	
	private String soapEndpointUrl = "http://localhost:8085/accommodationws";
    private String soapAction = "http://www.travel.com/accommodation/setAccommodationStatusRequest";
    private static PricePlanDTO priceplanDTO;
    
    private static String env;
    
    public void pricePlanSoap(String env,PricePlanDTO p) {
    	this.priceplanDTO = p;
    	this.env = env;
    	
    	callSoapWebService(soapEndpointUrl, soapAction);
    }


    private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
           
            
            
            // Send SOAP Message to SOAP Server
            URL endpoint = new URL(soapEndpointUrl);
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction),endpoint);
            
            
            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            soapConnection.close();
        } catch (Exception e) {
            //System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
           // e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        if(env.equals("addPricePlan")) {
        	soapEnvelopeAddPriceP(soapMessage);
        }
        
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
       // headers.addHeader("SOAPAction", soapAction);
        headers.setHeader("Content-Type", "text/xml");

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }
    
    
    private static void soapEnvelopeAddPriceP(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "gs";
        String myNamespaceURI = "http://www.travel.com/accommodation";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("addPricePlanRequest", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("roomtype", myNamespace);
        soapBodyElem1.addTextNode(Integer.toString(priceplanDTO.getRoomType()));
        
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("januaryprice", myNamespace);
        soapBodyElem2.addTextNode(Integer.toString(priceplanDTO.getJanuary()));
        
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("februaryprice", myNamespace);
        soapBodyElem3.addTextNode(Integer.toString(priceplanDTO.getFebruary()));
        
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("marchprice", myNamespace);
        soapBodyElem4.addTextNode(Integer.toString(priceplanDTO.getMarch()));
        
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("aprilprice", myNamespace);
        soapBodyElem5.addTextNode(Integer.toString(priceplanDTO.getApril()));
        
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("mayprice", myNamespace);
        soapBodyElem6.addTextNode(Integer.toString(priceplanDTO.getMay()));
        
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("juneprice", myNamespace);
        soapBodyElem7.addTextNode(Integer.toString(priceplanDTO.getJune()));
        
        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("julyprice", myNamespace);
        soapBodyElem8.addTextNode(Integer.toString(priceplanDTO.getJuly()));
        
        SOAPElement soapBodyElem9 = soapBodyElem.addChildElement("augustprice", myNamespace);
        soapBodyElem9.addTextNode(Integer.toString(priceplanDTO.getAugust()));
        
        SOAPElement soapBodyElem10 = soapBodyElem.addChildElement("septemberprice", myNamespace);
        soapBodyElem10.addTextNode(Integer.toString(priceplanDTO.getSeptember()));
        
        SOAPElement soapBodyElem11 = soapBodyElem.addChildElement("octoberprice", myNamespace);
        soapBodyElem11.addTextNode(Integer.toString(priceplanDTO.getOctober()));
        
        SOAPElement soapBodyElem12 = soapBodyElem.addChildElement("novemberprice", myNamespace);
        soapBodyElem12.addTextNode(Integer.toString(priceplanDTO.getNovember()));
        
        SOAPElement soapBodyElem13 = soapBodyElem.addChildElement("decemberprice", myNamespace);
        soapBodyElem13.addTextNode(Integer.toString(priceplanDTO.getDecember()));
       
        SOAPElement soapBodyElem14 = soapBodyElem.addChildElement("id", myNamespace);
        soapBodyElem14.addTextNode(Integer.toString(priceplanDTO.getIdAccommodation()));
        
    }


}
