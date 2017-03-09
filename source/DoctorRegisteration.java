import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DoctorRegisteration  extends JFrame{

	String no;
	Connection con;
	Statement stmt;
	ResultSet res;
	JLabel l_pmt, l_name,l_pass,l_address,l_mobile,l_special,l_lan;
	JTextField  t_name,t_address,t_mobile,t_special,t_lan;
	JPasswordField t_pass;
	JButton b_can,b_back;
	GridBagLayout gbl;
	Dimension d;
	Toolkit tk;
    Database db;
	public DoctorRegisteration(){
		//this.no = no;
       
		setResizable(false);
		try{
			 db=new Database();
			initializeComponent();
			//showData(no);
			pack();
			show();
		}catch(Exception sql){System.out.println("SQL"+sql);}
	}

	private void initializeComponent() { 
		
     l_pmt = new JLabel();
	 l_name = new JLabel();

	 l_pass = new JLabel();
	 l_address = new JLabel();

	 l_mobile = new JLabel();
     l_special=new JLabel();
	 l_lan=new JLabel();
	 t_name = new JTextField(17);
	 t_pass = new JPasswordField(17);
	 t_address = new JTextField(17);
	 t_mobile = new JTextField(17);
	 t_special = new JTextField(17);
     t_lan = new JTextField(17);
	 b_can = new JButton("Back");
	 b_can.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				new AdminMenu();
			}
		});
	
	 b_back = new JButton("Submit");	
	 b_back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
                try{ 
                con=db.getConnection();
				stmt=con.createStatement();
				if(t_name.getText()!=null && t_pass.getText()!=null && t_address.getText()!=null && t_mobile.getText()!=null && t_special.getText()!=null && t_lan.getText()!=null){
				int i=stmt.executeUpdate("insert into doc_registeration values('"+t_name.getText()+"','"+t_special.getText()+"','"+t_address.getText()+"','"+t_mobile.getText()+"','"+t_pass.getText()+"','"+ t_lan.getText()+"','out')");

			    if(i>0){

				setVisible(false);
				new AdminMenu();
				}else{
                  JOptionPane.showMessageDialog(null,"Database Error");
				}
				}else{
					JOptionPane.showMessageDialog(null,"please Enter Correct Information");
				}
				}catch(Exception e){
					e.printStackTrace();
				}
		}
	 });
	 addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
							System.exit(0);
				}
			}
		);
	 JLabel l_es=new JLabel("    ");

	 l_pmt.setText("Doctor Registeration");
     l_name.setText(" Name     : ");  		
 	 l_pass.setText(" Password            : ");  	
  	 l_address.setText(" Address       : ");  	
  	 l_mobile.setText(" Mobile No..   : ");  	
	 l_special.setText("Specialization : ");
     l_lan.setText("Language : ");
	
		gbl= new GridBagLayout();
		setLayout(gbl);
		addComponent(this, l_pmt,1,0,4,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,1,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_name,1,2,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_name,3,2,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,3,5,1,GridBagConstraints.REMAINDER,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_pass,1,4,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_pass,3,4,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,5,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_address,1,6,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_address,3,6,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,7,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_mobile,1,8,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_mobile,3,8,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		
		addComponent(this, l_es,1,9,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_special,1,10,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_special,3,10,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,11,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_lan,1,12,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_lan,3,12,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,12,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, b_can,1,14,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, b_back,3,14,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		this.setTitle("Doctor Information"); 
		tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();
		int x = (d.height/2) - 175;
		int y = (d.width/2) - 125;
 		this.setLocation(new Point(y,x)); 
 		this.setSize(new Dimension(350,250)); 
 	}   


	public void showData(String message){

		try{
			/*java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(message,"&");
			stringTokenizer.nextToken();

			t_name.setText((String)stringTokenizer.nextToken());
	        t_account.setText((String)stringTokenizer.nextToken());
	        t_type.setText((String)stringTokenizer.nextToken());
	        t_branch.setText((String)stringTokenizer.nextToken());*/
		
		}catch(Exception e) {e.printStackTrace();System.out.println(e);}
	}
 	public void addComponent(Container con, Component com, int gridx,int gridy,int gridwidth,int gridheight, int fill, int anchor,double weightx, double weighty){
		

		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=gridx;
		gbc.gridy=gridy;
		gbc.gridwidth=gridwidth;
		gbc.gridheight=gridheight;
		gbc.weightx=weightx;
		gbc.weighty=weighty;
		gbc.fill=fill;
		gbc.anchor=anchor;
		gbl.setConstraints(com,gbc);
		con.add(com);

 	}   
}