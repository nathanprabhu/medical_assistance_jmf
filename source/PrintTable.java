import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;
import java.util.*;

public class PrintTable {

	public PrintTable(Vector rows,Vector col){
		JFrame frame = new JFrame("Table Printing");
   // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
DefaultTableModel model = new DefaultTableModel(rows, col);
    final JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    JButton print = new JButton("Print");
	JButton deliver = new JButton("Deliver");
	
    ActionListener printAction = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          table.print(JTable.PrintMode.NORMAL);
        } catch (PrinterException pe) {
          System.err.println("Error printing: " + pe.getMessage());
        }
      }
    };
	ActionListener deliverAction = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          JOptionPane.showMessageDialog(null,"Deliver");
        } catch (Exception pe) {
          System.err.println("Error printing: " + pe.getMessage());
        }
      }
    };
    print.addActionListener(printAction);
	deliver.addActionListener(deliverAction);
	JPanel p=new JPanel();
	p.add(print);
	p.add(deliver);
    //frame.add(print, BorderLayout.EAST);
     frame.add(p, BorderLayout.SOUTH);
    frame.setSize(300, 150);
    frame.setVisible(true);
	}
 /* public static void main(String args[]) {
    
     new 
    
  }*/
}
