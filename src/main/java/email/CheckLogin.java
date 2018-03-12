package email;

import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

public class CheckLogin extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		// TODO Auto-generated method stub
		
		String Data=message.getProperty("http.query.params",PropertyScope.OUTBOUND);
		
		
		String data=message.getPayload().toString();
		if (data.length()==2){
			System.out.println("Invalid user name and password........................................");
		}
		else{
			message.setProperty("uname", message.getProperty("uname",PropertyScope.INVOCATION),PropertyScope.SESSION);
		}
		//Map<String,String> data=(Map<String,String>) message.getPayload();
		
		return message;
	}
	

}
