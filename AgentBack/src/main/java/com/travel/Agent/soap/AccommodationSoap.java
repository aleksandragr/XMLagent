package com.travel.Agent.soap;

import java.net.URL;

import javax.xml.soap.*;

import com.travel.Agent.dto.AccommodationDTO;


public class AccommodationSoap {

	
	private String soapEndpointUrl = "http://localhost:8085/accommodationws";
    private String soapAction = "http://www.travel.com/accommodation/setAccommodationStatusRequest";
    private static AccommodationDTO accommodationDTO;
    
    private static String env;
    
    public void accommodationSoap(String env,AccommodationDTO a) {
    	this.accommodationDTO = a;
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

        if(env.equals("addAccommodation")) {
        	soapEnvelopeAddAcc(soapMessage);
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
    
    
    private static void soapEnvelopeAddAcc(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "gs";
        String myNamespaceURI = "http://www.travel.com/accommodation";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        
       
        
            /*
            Constructed SOAP Request Message:
            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="http://www.webserviceX.NET">
                <SOAP-ENV:Header/>
                <SOAP-ENV:Body>
                    <myNamespace:GetInfoByCity>
                        <myNamespace:USCity>New York</myNamespace:USCity>
                    </myNamespace:GetInfoByCity>
                </SOAP-ENV:Body>
            </SOAP-ENV:Envelope>
            */

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("addAccommodationRequest", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("name", myNamespace);
        soapBodyElem1.addTextNode(accommodationDTO.getName());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("country", myNamespace);
        soapBodyElem2.addTextNode(accommodationDTO.getCountry());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("city", myNamespace);
        soapBodyElem3.addTextNode(accommodationDTO.getCity());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("address", myNamespace);
        soapBodyElem4.addTextNode(accommodationDTO.getAddress());
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("rating", myNamespace);
        soapBodyElem5.addTextNode(Integer.toString(accommodationDTO.getRating()));
        SOAPElement soapBodyElem14 = soapBodyElem.addChildElement("description", myNamespace);
        soapBodyElem14.addTextNode(accommodationDTO.getDescription());
        SOAPElement soapBodyElem15 = soapBodyElem.addChildElement("type", myNamespace);
        soapBodyElem15.addTextNode(accommodationDTO.getType());
        
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("wifi", myNamespace);
        if(accommodationDTO.isWiFi()) {
        	soapBodyElem6.addTextNode("true");
        }
        else {
        	soapBodyElem6.addTextNode("false");
        }
        
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("tv", myNamespace);
        if(accommodationDTO.isTv()) {
        	soapBodyElem7.addTextNode("true");
        }
        else {
        	soapBodyElem7.addTextNode("false");
        }
        
        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("parking", myNamespace);
        if(accommodationDTO.isParking()) {
        	soapBodyElem8.addTextNode("true");
        }
        else {
        	soapBodyElem8.addTextNode("false");
        }
        
        SOAPElement soapBodyElem9 = soapBodyElem.addChildElement("kitchen", myNamespace);
        if(accommodationDTO.isKitchen()) {
        	soapBodyElem9.addTextNode("true");
        }
        else {
        	soapBodyElem9.addTextNode("false");
        }
        
        SOAPElement soapBodyElem10 = soapBodyElem.addChildElement("breakfast", myNamespace);
        if(accommodationDTO.isBreakfast()) {
        	soapBodyElem10.addTextNode("true");
        }
        else {
        	soapBodyElem10.addTextNode("false");
        }
        
        SOAPElement soapBodyElem11 = soapBodyElem.addChildElement("halfBoard", myNamespace);
        if(accommodationDTO.isHalfBoard()) {
        	soapBodyElem11.addTextNode("true");
        }
        else {
        	soapBodyElem11.addTextNode("false");
        }
        
        SOAPElement soapBodyElem12 = soapBodyElem.addChildElement("fullBoard", myNamespace);
        if(accommodationDTO.isFullBoard()) {
        	soapBodyElem12.addTextNode("true");
        }
        else {
        	soapBodyElem12.addTextNode("false");
        }
        
        SOAPElement soapBodyElem13 = soapBodyElem.addChildElement("bathroom", myNamespace);
        if(accommodationDTO.isBathroom()) {
        	soapBodyElem13.addTextNode("true");
        }
        else {
        	soapBodyElem13.addTextNode("false");
        }
        
        
    }
	
}
