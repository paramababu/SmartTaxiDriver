package in.taxi.smartdriver.net.invokers;

import org.json.JSONObject;

import java.util.HashMap;

import in.taxi.smartdriver.model.ProfileBean;
import in.taxi.smartdriver.net.ServiceNames;
import in.taxi.smartdriver.net.WebConnector;
import in.taxi.smartdriver.net.parsers.ProfileParser;
import in.taxi.smartdriver.net.utils.WSConstants;

/**
 * Created by Jemsheer K D on 20 April, 2017.
 * Package in.techware.lataxidriver.net.invokers
 * Project LaTaxiDriver
 */

public class ProfileInvoker extends BaseInvoker {

    public ProfileInvoker() {
        super();
    }

    public ProfileInvoker(HashMap<String, String> urlParams,
                          JSONObject postData) {
        super(urlParams, postData);
    }

    public ProfileBean invokeProfileWS() {

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.PROFILE), WSConstants.PROTOCOL_HTTP, urlParams, null);

        //webConnector= new WebConnector(new StringBuilder(ServiceNames.MODELS), WSConstants.PROTOCOL_HTTP, null);
//    String wsResponseString=webConnector.connectToPOST_service();
        String wsResponseString = webConnector.connectToGET_service();
        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        ProfileBean profileBean = null;
        if (wsResponseString.equals("")) {
            /*registerBean=new RegisterBean();
            registerBean.setWebError(true);*/
            return profileBean = null;
        } else {
            profileBean = new ProfileBean();
            ProfileParser profileParser = new ProfileParser();
            profileBean = profileParser.parseProfileResponse(wsResponseString);
            return profileBean;
        }
    }
}
