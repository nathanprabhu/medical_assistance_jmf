import javax.swing.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Patientcontect extends JFrame 
 {
    private JLabel jLabel1,jLabel2;
 	private JTextField jTextField1;
	private JLabel green;
	private JLabel red;
	Toolkit tk;
	Dimension d;
 	private JButton jButton1;
 	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	String lan="";
    Connection con;
	Statement stmt;
	ResultSet rs;
	private JTextArea t_sentmsg,t_sentmsg1;
	 JScrollPane js,js1;
	//JRadioButton aButton = new JRadioButton("A",true);
		JRadioButton rb1,rb2,rb3,rb4;
		 ButtonGroup myButtonGroup;
		//JRadioButton cButton = new JRadioButton("C");
	String name=null;
    Database db;
 	private JPanel contentPane;
	
	public Patientcontect(){
 		super();
		initializeComponent();
		db=new Database();

		setResizable(false);
 		this.setVisible(true);

 	}
 	private void initializeComponent(){
 	
		JLabel bgr;
		bgr = new JLabel();
		
		tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();

 		jLabel1 = new JLabel("Doctor Available");
		jLabel2 = new JLabel("Doctor NoAvailable");
		jLabel2.setBackground(Color.orange);
 //green.setBackground(Color.red);
 		jTextField1 = new JTextField();
		jButton1 = new JButton();
 		jButton2 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();
        myButtonGroup = new ButtonGroup();
		jButton5 = new JButton();
		rb1=new JRadioButton("Tamil");
		rb2=new JRadioButton("Engilish");
		rb3=new JRadioButton("Hindi");
		rb4=new JRadioButton("Telugu");
        t_sentmsg=new JTextArea();
		 t_sentmsg1=new JTextArea();
		js=new JScrollPane(t_sentmsg,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js1=new JScrollPane(t_sentmsg1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//p_main.add(js);
		bgr.setText("Doctor Contect");
		bgr.setFont(new Font("monotype corsiva",2,30));			
		contentPane = (JPanel)this.getContentPane();
        myButtonGroup.add(rb1);
       myButtonGroup.add(rb2);
       myButtonGroup.add(rb3);
       myButtonGroup.add(rb4);
		/*green=new JLabel("rr");
	    green.setBackground(Color.green);
       green.setBounds(50,150,100,100,30);
		red=new JLabel("rr");
		red.setBackground(Color.red);
		green.setBounds(150,150,100,100,30);
		this.add(green);
		this.add(red);*/
		// Cloud Computing

	//jButton1.setText("Doctor Contect");
 		rb1.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
				lan="Tamil";
				
			}
   		});
		rb2.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
				lan="English";
				
			}
   		});
		rb3.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
				lan="Hindi";
				
				
			}
   		});
		rb4.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e){
				
				 lan="Telugu";
			}
   		});


// Hospital
		
		jButton2.setText("Submit ");
 		jButton2.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
				try{
					//dispose();
					t_sentmsg.setText("");
					t_sentmsg1.setText("");

				 con=db.getConnection();
					 stmt=con.createStatement();
					 rs=stmt.executeQuery("select * from doc_registeration where status='login' and language='"+lan+"'");
                     while(rs.next()){
                      t_sentmsg.append(rs.getString("doc_name")+"\n");
					 }
                   rs=stmt.executeQuery("select * from doc_registeration where status='out' and language='"+lan+"'" );
                     while(rs.next()){
                      t_sentmsg1.append(rs.getString("doc_name")+"\n");
					 }


				}catch(Exception ex){
					ex.printStackTrace();
					System.out.println(ex);
				}
			}
		});

    	jButton4.setText("Call Doctor");
 		jButton4.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
				String calldoctor=t_sentmsg.getSelectedText();
				if(calldoctor!=null){
                   dispose();

			 new CallDoctor(calldoctor);
			 
				}else{
					JOptionPane.showMessageDialog(null,"Please select Doctor or Available Doctor only ");
				}
				
               
				/*try{
					dispose();
					 String str =  JOptionPane.showInputDialog(MainMenu.this,"Enter Bank Name:");
				    // JOptionPane.showMessageDialog(MainMenu.this,"Entered String is ..."+str);
					 str = "bank$"+str;
				     str = sendRequest(str);
					 AccDetails accDetails = new AccDetails(str);
				}catch(Exception ex){
					ex.printStackTrace();
					System.out.println(ex);
				}*/
			}
		});


		jButton5.setText("Back");
 		jButton5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
 			 dispose();
				  PatientMenu patientMenu=new PatientMenu();

			patientMenu.setLayout(null);
			patientMenu.setSize(300,450);
			patientMenu.setLocation(350,180);
			patientMenu.setVisible(true);
			patientMenu.setResizable(false);
				/*try{
					dispose();
					 String str =  JOptionPane.showInputDialog(MainMenu.this,"Enter Student Id:");
				     JOptionPane.showMessageDialog(MainMenu.this,"Entered String is ..."+str);
					  str = "student$"+str;
				      str = sendRequest(str);
					  StudentInforamtion ss = new StudentInforamtion(str);
				}catch(Exception ex){
					ex.printStackTrace();
					System.out.println(ex);
				}*/
			}
		});



	
		addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
							System.exit(0);
				}
			}
		);


		
		contentPane.setLayout(null);
    	addComponent(contentPane, bgr,10,30,300,30);
 		//addComponent(contentPane, jButton1,75,100,200,30);
 		addComponent(contentPane, rb1 , 5,70,80,30);
		addComponent(contentPane, rb2 , 80,70,80,30);
		addComponent(contentPane, rb3, 160,70,60,30);
		addComponent(contentPane, rb4, 230,70,80,30);
		addComponent(contentPane, jButton2, 55,100,200,30);
	//	addComponent(contentPane, green,50,150,100,100,30);
		//addComponent(contentPane, red,150,150,100,100,30);
	addComponent(contentPane,jLabel1 ,20,150,200,30);
	addComponent(contentPane,jLabel2 ,150,150,200,30);
		addComponent(contentPane,js,10,170,100,70);
		addComponent(contentPane,js1,150,170,100,70);
addComponent(contentPane,jButton4,75,250,200,30);
addComponent(contentPane,jButton5,75,300,200,30);

		this.setTitle("Patient Contact");
		int x = (d.height/2) - 200;
		int y = (d.width/2) - 250;
 		this.setLocation(new Point(y, x));
 		this.setSize(new Dimension(300, 400));
 	}
 	private void addComponent(Container container,Component c,int x,int y,int width,int height){
 		c.setBounds(x,y,width,height);
 		container.add(c);
 	}


 	private void jButton1_actionPerformed(ActionEvent e){
 		//System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
 	}

 	private void jButton2_actionPerformed(ActionEvent e){
 		//System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
 	}



  /** This method is used to send the request to the next Machine where lowest cpu usage machine
  *
  */

	/*private String sendRequest(String s){
		String res = "";
		try {
			Socket socket = new Socket("localhost",111); // Request will send to the main server
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());			
			dout.writeUTF(s);
			System.out.println("Sent the request to server getting VLC");
			DataInputStream din = new DataInputStream(socket.getInputStream());
			res = din.readUTF();
			System.out.println("Reply string from server...."+res);
		}catch(Exception e){e.printStackTrace();}
		return res;
			
		
	}

	private String sendRequestTrustedParty(String msg){
	try{
		 Socket socket = new Socket("localhost",222);
		 DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		 dout.writeUTF(msg);
		 return "SENT";
	}catch(Exception ex){
		ex.printStackTrace();
		System.out.println(ex);
	}
	return null;
}*/
public static void main(String ar[]){
	try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		  // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		  				new Patientcontect();
		}
		catch (Exception e) {System.out.println("UL-GE");}

     }
 }


