package beetle.npdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import beetle.netpackage.IMessage;

public class Register implements IMessage {

	
	public String Name;
	
	public String EMail;
	
	public String City;
	
	public String Country;
	
	public Date RegTime;
	
	
	@Override
	public void Load(DataInputStream stream) throws Exception {
		// TODO Auto-generated method stub
		Name = stream.readUTF();
		EMail = stream.readUTF();
		City = stream.readUTF();
		Country = stream.readUTF();
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		RegTime = sdf.parse(stream.readUTF());
	   
		
	}

	@Override
	public void Save(DataOutputStream stream) throws Exception {
		// TODO Auto-generated method stub
		stream.writeUTF(Name);
		stream.writeUTF(EMail);
		stream.writeUTF(City);
		stream.writeUTF(Country);
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		stream.writeUTF(sdf.format(RegTime));
	}

}
