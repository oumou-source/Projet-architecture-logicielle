
package serviceweb;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "NewsSoapServiceService", targetNamespace = "http://serviceWeb/", wsdlLocation = "http://localhost:8088/NewsSoapService?wsdl")
public class NewsSoapServiceService
    extends Service
{

    private final static URL NEWSSOAPSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException NEWSSOAPSERVICESERVICE_EXCEPTION;
    private final static QName NEWSSOAPSERVICESERVICE_QNAME = new QName("http://serviceWeb/", "NewsSoapServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8088/NewsSoapService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NEWSSOAPSERVICESERVICE_WSDL_LOCATION = url;
        NEWSSOAPSERVICESERVICE_EXCEPTION = e;
    }

    public NewsSoapServiceService() {
        super(__getWsdlLocation(), NEWSSOAPSERVICESERVICE_QNAME);
    }

    public NewsSoapServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), NEWSSOAPSERVICESERVICE_QNAME, features);
    }

    public NewsSoapServiceService(URL wsdlLocation) {
        super(wsdlLocation, NEWSSOAPSERVICESERVICE_QNAME);
    }

    public NewsSoapServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NEWSSOAPSERVICESERVICE_QNAME, features);
    }

    public NewsSoapServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NewsSoapServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns NewsSoapService
     */
    @WebEndpoint(name = "NewsSoapServicePort")
    public NewsSoapService getNewsSoapServicePort() {
        return super.getPort(new QName("http://serviceWeb/", "NewsSoapServicePort"), NewsSoapService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NewsSoapService
     */
    @WebEndpoint(name = "NewsSoapServicePort")
    public NewsSoapService getNewsSoapServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://serviceWeb/", "NewsSoapServicePort"), NewsSoapService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NEWSSOAPSERVICESERVICE_EXCEPTION!= null) {
            throw NEWSSOAPSERVICESERVICE_EXCEPTION;
        }
        return NEWSSOAPSERVICESERVICE_WSDL_LOCATION;
    }

}
