package cz.vojtechkrakora.wso2.training;

import org.apache.axiom.om.*;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axiom.soap.SOAPProcessingException;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.builder.Builder;
import org.apache.axis2.context.MessageContext;
import org.wso2.carbon.relay.StreamingOnRequestDataSource;

import javax.activation.DataHandler;
import java.io.InputStream;

public class CoolMessageBuilder implements Builder {
    public OMElement processDocument(InputStream inputStream, String contentType, MessageContext messageContext) throws AxisFault {
        try {
            messageContext.setProperty(Constants.Configuration.CONTENT_TYPE, contentType);
            SOAPFactory factory;

            if (messageContext.isSOAP11()) {
                factory = OMAbstractFactory.getSOAP11Factory();
            } else {
                factory = OMAbstractFactory.getSOAP12Factory();
            }
            SOAPEnvelope env = factory.getDefaultEnvelope();

            if (inputStream != null) {
                StreamingOnRequestDataSource ds = new StreamingOnRequestDataSource(inputStream);
                DataHandler dataHandler = new DataHandler(ds);
                messageContext.addAttachment(dataHandler.getName(), dataHandler);

                OMNamespace nam = factory.createOMNamespace("http://namespace", "nam");
                OMElement omEle = factory.createOMElement("DownloadResponse", nam);
                OMElement omReturn = factory.createOMElement("return", nam);

                OMText textData = factory.createOMText(dataHandler, true);
                omReturn.addChild(textData);
                omEle.addChild(omReturn);
                env.getBody().addChild(omEle);
            }
            return env;
        } catch (
                SOAPProcessingException e) {
            throw AxisFault.makeFault(e);
        } catch (
                OMException e) {
            throw AxisFault.makeFault(e);
        }
    }
}
