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
        }else if(env.equals("editAccommodation")) {
        	soapEnvelopeEditAcc(soapMessage);
        }
        else if(env.equals("reserveAcc")) {
        	soapEnvelopeReserveAcc(soapMessage);
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
    
    
    
    private static void soapEnvelopeReserveAcc(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "gs";
        String myNamespaceURI = "http://www.travel.com/accommodation";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        
        

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("setAccommodationOccupationDatesRequest", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id", myNamespace);
        soapBodyElem1.addTextNode(Long.toString(accommodationDTO.getIdAccommodation()));
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("datefrom", myNamespace);
        soapBodyElem2.addTextNode(accommodationDTO.getReservedFrom());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("dateto", myNamespace);
        soapBodyElem3.addTextNode(accommodationDTO.getReservedTo());
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static void soapEnvelopeAddAcc(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "gs";
        String myNamespaceURI = "http://www.travel.com/accommodation";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        System.out.println("wwwww");

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
        
        SOAPElement soapBodyElem20 = soapBodyElem.addChildElement("onebadroom", myNamespace);
        soapBodyElem20.addTextNode(Integer.toString(accommodationDTO.getOnebeds()));
        SOAPElement soapBodyElem16 = soapBodyElem.addChildElement("twobadroom", myNamespace);
        soapBodyElem16.addTextNode(Integer.toString(accommodationDTO.getTwobeds()));
        SOAPElement soapBodyElem17 = soapBodyElem.addChildElement("threebadroom", myNamespace);
        soapBodyElem17.addTextNode(Integer.toString(accommodationDTO.getTheerebeds()));
        SOAPElement soapBodyElem18 = soapBodyElem.addChildElement("fourbadroom", myNamespace);
        soapBodyElem18.addTextNode(Integer.toString(accommodationDTO.getFourbeds()));
        SOAPElement soapBodyElem19 = soapBodyElem.addChildElement("fivedbadroom", myNamespace);
        soapBodyElem19.addTextNode(Integer.toString(accommodationDTO.getFivebeds()));
        
        SOAPElement soapBodyElem22 = soapBodyElem.addChildElement("picture", myNamespace);
        soapBodyElem22.addTextNode(accommodationDTO.getPicture());
        SOAPElement soapBodyElem23 = soapBodyElem.addChildElement("category", myNamespace);
        soapBodyElem23.addTextNode(Integer.toString(accommodationDTO.getCategory()));
        
        for(int i=0;i<accommodationDTO.getAditionalServices().size();i++) {
        	SOAPElement soapBodyElem21 = soapBodyElem.addChildElement("services", myNamespace);
            soapBodyElem21.addTextNode(accommodationDTO.getAditionalServices().get(i));    	
        }
       
        SOAPElement soapBodyElem26 = soapBodyElem.addChildElement("agentid", myNamespace);
        soapBodyElem26.addTextNode(Long.toString(accommodationDTO.getIdAgent()));
        
    }
    
    private static void soapEnvelopeEditAcc(SOAPMessage soapMessage) throws SOAPException {
    	
    	SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "gs";
        String myNamespaceURI = "http://www.travel.com/accommodation";
    	
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
         
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("editAccommodationRequest", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Id", myNamespace);
        soapBodyElem1.addTextNode(Long.toString(accommodationDTO.getIdAccommodation()));
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("name", myNamespace);
        soapBodyElem2.addTextNode(accommodationDTO.getName());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("type", myNamespace);
        soapBodyElem3.addTextNode(accommodationDTO.getType());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("country", myNamespace);
        soapBodyElem4.addTextNode(accommodationDTO.getCountry());
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("city", myNamespace);
        soapBodyElem5.addTextNode(accommodationDTO.getCity());
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("address", myNamespace);
        soapBodyElem6.addTextNode(accommodationDTO.getAddress());
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("description", myNamespace);
        soapBodyElem7.addTextNode(accommodationDTO.getDescription());
        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("rating", myNamespace);
        soapBodyElem8.addTextNode(Integer.toString(accommodationDTO.getRating()));
        SOAPElement soapBodyElem17 = soapBodyElem.addChildElement("category", myNamespace);
        soapBodyElem17.addTextNode(Integer.toString(accommodationDTO.getCategory()));
        
        for(int i=0;i<accommodationDTO.getAditionalServices().size();i++) {
        	SOAPElement soapBodyElem21 = soapBodyElem.addChildElement("services", myNamespace);
            soapBodyElem21.addTextNode(accommodationDTO.getAditionalServices().get(i));  	
        }
    }	
	
}
