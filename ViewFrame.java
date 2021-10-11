import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class View extends JFrame{
	Container c;
	JButton btnBack;
	TextArea ta;	
	View(){
		c=getContentPane();
		c.setLayout(new FlowLayout());
		ta = new TextArea(5,20);
		btnBack = new JButton("Back");
		
		c.add(ta);
		c.add(btnBack);
		//DbHandler db = new DbHandler();
	  // ta.setText(db.getEmployee());
		
		setTitle("View");
		setSize(275,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		btnBack.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent ae){
															MainFrame m = new MainFrame();
															dispose();
														}
		});
		
		
	}
}
class ViewFrame
{
	public static void main(String agrs[])
	{
		View v = new View();
	}
}