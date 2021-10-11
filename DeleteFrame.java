import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Delete extends JFrame{
	Container c;
	JButton btnSave,btnBack;
	JLabel lblId;
	JTextField txtId;
	Delete(){
		c=getContentPane();
		c.setLayout(new FlowLayout());
		lblId= new JLabel("Eid");
		txtId = new JTextField(20);
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		
		c.add(lblId);
		c.add(txtId);
		c.add(btnSave);
		c.add(btnBack);
		
		
		setTitle("Delete");
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
class DeleteFrame
{
	public static void main(String agrs[])
	{
		Delete d = new Delete();

	}
}