package com.travel.Agent.soap;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlID;
import javax.xml.soap.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import com.concretepage.gs_ws.GetDistinctServicesResponse;
import com.concretepage.gs_ws.GetDistinctTypesResponse;
import com.travel.Agent.model.AdditionalServices;




public class TypeAccommodationSoap {

	
	private String soapEndpointUrl = "http://localhost:8085/accommodationws";
    private String soapAction = "http://www.travel.com/accommodation/setAccommodationStatusRequest";

    private static GetDistinctTypesResponse distinctType;
    private static String env;
    
    public GetDistinctTypesResponse typeAccommodationSoap(String env) {
    	
    	this.env = env;
    	
    	callSoapWebService(soapEndpointUrl, soapAction);
    	
    	return distinctType;
    }


    private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
           
            
            
            // Send SOAP Message to SOAP Server
            URL endpoint = new URL(soapEndpointUrl);
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction),endpoint);
            
            
            
           
            JAXBContext jaxbContext = JAXBContext.newInstance(GetDistinctTypesResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            GetDistinctTypesResponse additionalServices = (GetDistinctTypesResponse) jaxbUnmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
            distinctType=additionalServices;
            
            
            /*
            //Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();
			*/
            soapConnection.close();
        } catch (Exception e) {
            //System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
           // e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        if(env.equals("getTypes")) {
        	soapEnvelopeGetType(soapMessage);
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
    
    
    private static void soapEnvelopeGetType(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "gs";
        String myNamespaceURI = "http://www.travel.com/accommodation";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        
        
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("getDistinctTypesRequest", myNamespace);
        
        
    }
}
    