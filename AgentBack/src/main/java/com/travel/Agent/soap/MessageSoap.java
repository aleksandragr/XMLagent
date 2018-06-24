package com.travel.Agent.soap;


import java.net.URL;

import javax.xml.soap.*;

import com.travel.Agent.dto.AccommodationDTO;
import com.travel.Agent.dto.MessageDto;


public class MessageSoap {

	
	private String soapEndpointUrl = "http://localhost:8085/agentws";
    private String soapAction = "http://www.travel.com/agent/answerAgentRequest";
    
    
    private static String env;
    private static MessageDto messagedto;
    
    public void sendMessageSoap(String env,MessageDto messageDto) {
    	
    	this.env = env;
    	this.messagedto = messageDto;
    	
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

        if(env.equals("sendMail")) {
        	soapEnvelopeSendMessage(soapMessage);
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
    
    
    
    private static void soapEnvelopeSendMessage(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "gs";
        String myNamespaceURI = "http://www.travel.com/agent";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        
        System.out.println("Content: " + messagedto.getCommentcontent());
        System.out.println("ID: " + messagedto.getUserid());
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("answerAgentRequest", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("content", myNamespace);
        soapBodyElem1.addTextNode(messagedto.getCommentcontent());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("reguserid", myNamespace);
        soapBodyElem2.addTextNode(Long.toString(messagedto.getUserid()));
        
    }
}