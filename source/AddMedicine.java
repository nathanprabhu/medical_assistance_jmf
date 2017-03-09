import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddMedicine  extends JFrame{

	String no;
	Connection con;
	Statement stmt;
	ResultSet res;
	JLabel l_pmt, l_mname,l_quanity,l_expire,l_tray1,l_tray2,l_tray3;
	JTextField  t_mname,t_quanity,t_expire,t_tray1,t_tray2,t_tray3;
	
	JButton b_can,b_back;
	GridBagLayout gbl;
	Dimension d;
	Toolkit tk;
    Database db;
	public AddMedicine(){
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
	 l_mname = new JLabel();

	 l_quanity = new JLabel();
	 l_expire = new JLabel();

	 l_tray1 = new JLabel();
     l_tray2=new JLabel();
	  l_tray3=new JLabel();
	 t_mname = new JTextField(17);
	 t_quanity = new JTextField(17);
	 t_expire = new JTextField(17);
	 t_tray1 = new JTextField(17);
	  t_tray2 = new JTextField(17);
	  t_tray3 = new JTextField(17);
	 

	 b_can = new JButton("Back");
	 b_can.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				setVisible(false);
				new AdminMenu();
				
			}
		});
	
	 b_back = new JButton("Submit");	
	 b_back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
                try{ 
                con=db.getConnection();
				stmt=con.createStatement();
				if(t_mname.getText()!=null && t_quanity.getText()!=null && t_expire.getText()!=null && t_tray1.getText()!=null && t_tray2.getText()!=null && t_tray3!=null){
				int i=stmt.executeUpdate("insert into medicinetbl values('"+t_mname.getText()+"','"+t_quanity.getText()+"','"+t_expire.getText()+"','"+t_tray1.getText()+"','"+t_tray2.getText()+"','"+t_tray3.getText()+"')");

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
	 JLabel l_es=new JLabel("    ");

	 l_pmt.setText("Add Medinice Information");
     l_mname.setText(" Medicine Name             : ");  		
 	 l_quanity.setText(" Quanity                    : ");  	
  	 l_expire.setText(" Expire Date            : ");  	
  	 l_tray1.setText(" Tray1                      : ");  	
	 l_tray2.setText("Tray2                       : ");
	l_tray3.setText("Tray3                        : ");
		gbl= new GridBagLayout();
		setLayout(gbl);
		addComponent(this, l_pmt,1,0,4,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,1,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_mname,1,2,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_mname,3,2,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,3,5,1,GridBagConstraints.REMAINDER,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_quanity,1,4,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_quanity,3,4,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,5,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_expire,1,6,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_expire,3,6,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,7,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_tray1,1,8,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_tray1,3,8,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		
		addComponent(this, l_es,1,9,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_tray2,1,10,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_tray2,3,10,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,11,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_tray3,1,12,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, t_tray3,3,12,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, l_es,1,13,6,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);

		addComponent(this, b_can,3,14,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		addComponent(this, b_back,3,13,2,1,GridBagConstraints.EAST,GridBagConstraints.NORTH,0.1,0.0);
		this.setTitle("Medinice Information"); 
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