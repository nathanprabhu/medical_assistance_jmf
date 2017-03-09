import java.io.*;
import java.util.*;
import javax.comm.*;

public class SimpleWrite
{
	static Enumeration portList;
	static CommPortIdentifier portId;
	static String messageString;
	static SerialPort serialPort;
	static OutputStream outputStream;
	static String data;

	public void writeData (String data)
	{
		this.data = data;
		portList = CommPortIdentifier.getPortIdentifiers();

		while (portList.hasMoreElements())
		{
			portId = (CommPortIdentifier) portList.nextElement();

			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
			{
					 if (portId.getName().equals("COM1"))
					{
						try
						{
							serialPort = (SerialPort)
							portId.open("SimpleWriteApp", 2000);
						} catch (PortInUseException e) {}


						try
						{
							outputStream = serialPort.getOutputStream();
						} catch (IOException e) {}

						try
						{
							serialPort.setSerialPortParams(9600,
							SerialPort.DATABITS_8,
							SerialPort.STOPBITS_1,
							SerialPort.PARITY_NONE);
						} catch (UnsupportedCommOperationException e) {}

						try
						{
							outputStream.write(data.getBytes());
						} catch (IOException e) {}

						if(serialPort!=null)
						{
							serialPort.close();
						}
					}
				}
			}
		}
}