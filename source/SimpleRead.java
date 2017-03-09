import java.io.*;
import java.util.*;
import javax.comm.*;
import java.sql.*;

public class SimpleRead implements Runnable, SerialPortEventListener {
    static CommPortIdentifier portId;
    static Enumeration portList;

    InputStream inputStream;
    SerialPort serialPort;
    Thread readThread;
	private Statement stmt = null;
	private Connection con = null;
	private ResultSet rs = null;
    Database db;

    //public static void main(String[] args) {
		public SimpleRead(String agggg){
			showData();
		}
		void showData(){
        portList = CommPortIdentifier.getPortIdentifiers();

        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
			
                 if (portId.getName().equals("COM1")) {
			        SimpleRead reader = new SimpleRead();
                }
            }
        }
    }

    public SimpleRead() {
        try {
            serialPort = (SerialPort) portId.open("SimpleReadApp", 2000);
			db=new Database();
			 con=db.getConnection();
					 stmt=con.createStatement();
		

        } catch (PortInUseException e) {System.out.println(e);}
		catch(Exception ex){ex.printStackTrace();}
        try {
            inputStream = serialPort.getInputStream();
        }catch (IOException e) {System.out.println(e);}
	try {
            serialPort.addEventListener(this);
	}catch(TooManyListenersException e) {System.out.println(e);}
        serialPort.notifyOnDataAvailable(true);
        try {
            serialPort.setSerialPortParams(9600,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
        } catch (UnsupportedCommOperationException e) {System.out.println(e);}
        readThread = new Thread(this);
        readThread.start();
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {System.out.println(e);}
    }

    public void serialEvent(SerialPortEvent event) {
	//	while(true){
        switch(event.getEventType()) {
        case SerialPortEvent.BI:
        case SerialPortEvent.OE:
        case SerialPortEvent.FE:
        case SerialPortEvent.PE:
        case SerialPortEvent.CD:
        case SerialPortEvent.CTS:
        case SerialPortEvent.DSR:
        case SerialPortEvent.RI:
        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            break;
        case SerialPortEvent.DATA_AVAILABLE:
            byte[] readBuffer = new byte[20];

            try {
                while (inputStream.available() > 0) {
                    int numBytes = inputStream.read(readBuffer);
                }
				
				//Thread.sleep(8000);
				 String str=new String(readBuffer);
                System.out.print("Read the value from serial port...."+str.trim());
			
				if(str.trim().startsWith("T")){
				 int t = Integer.parseInt((str.trim().substring(2)));
				 //if(t>35){
				 //   System.out.println("Temprature is ..."+str);
				  /*   con = getConncetion();
				     stmt = con.createStatement();*/
					String str1=str.trim().substring(2);
					stmt.executeUpdate("update patientinfo temp set temp='"+str.trim().substring(2)+"' ");
					System.out.println("hfgffhh1"+t);
					
				     
				     System.out.println("Device Beyond The Limit");
				     //SendSMS.sendMessageToMobile("Temprature Beyond The Limit..."+t,"9500131687");
					// con.close();
					// stmt.close();
				//}else{
					/* con = getConncetion();
				     stmt = con.createStatement();
				     stmt.executeUpdate("insert into history_table values('"+t+"',getdate())");
					  con.close();
					 stmt.close();*/
					// System.out.println("Else");
				//}
				
            }else if(str.trim().startsWith("H")){
				// int w = Integer.parseInt((str.trim()));
				// if(w>80){
				    System.out.println("Heard bit is ..."+str);
						stmt.executeUpdate("update patientinfo set heartbit='"+str.trim().substring(2)+"' ");
				  /*   con = getConncetion();
				     stmt = con.createStatement();
				   //  stmt.executeUpdate("update dataacqustion set temp="+t+" where id=1");
				     System.out.println("Device Beyond The Limit");
				     //SendSMS.sendMessageToMobile("Weight Beyond The Limit..."+t,"9500131687");
					 con.close();
					 stmt.close();*/
				//}
			}else if(str.trim().startsWith("G")){
				 int g = Integer.parseInt((str.trim().substring(2)));
				 if(g>35){
				    System.out.println("Gas is ..."+str);
				    /* con = getConncetion();
				     stmt = con.createStatement();
				   //  stmt.executeUpdate("update dataacqustion set temp="+t+" where id=1");
				     System.out.println("Device Beyond The Limit");
				     //SendSMS.sendMessageToMobile("Gas Beyond The Limit..."+t,"9500131687");
					 con.close();
					 stmt.close();*/
				}
			}else if(str.trim().startsWith("S")){
				 int s = Integer.parseInt((str.trim().substring(2)));
				 if(s==80 || s==100){
				    System.out.println("Speed is ..."+str);
					new SimpleWrite().writeData("S");
				     //con = getConncetion();
				     //stmt = con.createStatement();
				   //  stmt.executeUpdate("update dataacqustion set temp="+t+" where id=1");
				     //System.out.println("Device Beyond The Limit");
				     //SendSMS.sendMessageToMobile("Gas Beyond The Limit..."+t,"9500131687");
					 //con.close();
					 //stmt.close();
				}
			}
				
			
			} catch (Exception e) {e.printStackTrace();}
            break;
        }
		}
    


	/*public Connection getConncetion(){
	   try{
		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   con = DriverManager.getConnection("jdbc:odbc:Driver={SQL Server};Server=.;Database=building;UID=sa");

	   }catch(Exception ex){
		   ex.printStackTrace();
		   System.out.println(ex);
	   }
	   return con;
   }*/

   public static void main(String a[]){
	   try{
		   new SimpleRead("KKK");
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }
}
