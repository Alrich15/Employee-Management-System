import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Update extends JFrame{
	Container c;
	JButton btnSave,btnBack;
	JLabel lblId,lblName,lblSal;
	JTextField txtId,txtName,txtSal;
	Update(){
		c=getContentPane();
		c.setLayout(new FlowLayout());
		lblId= new JLabel("Eid");
		lblName = new JLabel("Ename");
		lblSal = new JLabel("Esalary");
		txtId = new JTextField(20);
		txtName = new JTextField(15);
		txtSal = new JTextField(15);
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		
		c.add(lblId);
		c.add(txtId);
		c.add(lblName);
		c.add(txtName);
		c.add(lblSal);
		c.add(txtSal);
		c.add(btnSave);
		c.add(btnBack);
		
		
		setTitle("Update");
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
class UpdateFrame
{
	public static void main(String agrs[])
	{
		Update u = new Update();
	}
}