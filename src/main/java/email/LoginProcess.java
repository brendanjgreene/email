package email;

import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

public class LoginProcess extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		// TODO Auto-generated method stub
		
		
		
		
		Map<String,String> data=(Map<String,String>) message.getPayload();

		
		message.setProperty("uname", data.get("user_name"),PropertyScope.INVOCATION);
		message.setProperty("pwd", data.get("password"),PropertyScope.INVOCATION);
		//message.setProperty("uname", data.get("user_name"),PropertyScope.SESSION);
		
		
		//System.out.println((String) message.getProperty("uname",PropertyScope.OUTBOUND));
			
		return message;
	}
	

}
