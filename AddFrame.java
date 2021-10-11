import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

class Add extends JFrame{
	Container c;
	String str="";
	private JButton btnSave,btnBack;
	private JLabel errorlabel,lblId,lblName,lblSal;
	private JTextField txtId,txtName,txtSal;
	Add(){
		c=getContentPane();
		c.setLayout(new FlowLayout());
		lblId= new JLabel("Eid");
		lblName = new JLabel("Ename");
		lblSal = new JLabel("Esalary");
		txtId = new JTextField(28);
		txtName = new JTextField(25);
		txtSal = new JTextField(23);
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		
		errorlabel = new JLabel("");
		c.add(errorlabel);
		
		c.add(lblId);
		c.add(txtId);
		c.add(lblName);
		c.add(txtName);
		c.add(lblSal);
		c.add(txtSal);
		c.add(btnSave);
		c.add(btnBack);
		
		
		setTitle("Add");
		setSize(375,450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
			errorlabel.setText(" ");
		btnBack.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent ae){
															MainFrame m = new MainFrame();
															dispose();
														}
		});
		btnSave.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent ae){
									String ID = txtId.getText().toString();
								    String NAME = txtName.getText().toString();
									String SAL = txtSal.getText().toString();
							try{
									if(ID.equals("") || NAME.equals("") || SAL.equals("")){
												JOptionPane.showMessageDialog(null,"Fields Cant be Empty!!");
										}
										else if(Integer.valueOf(ID) < 0){
											JOptionPane.showMessageDialog(null,"Employee ID cant be negative");
											}
										else if(NAME.length() <2){
											JOptionPane.showMessageDialog(null,"Enter a Valid Employee Name");
											}
										else if(Integer.valueOf(SAL) <8000){
											JOptionPane.showMessageDialog(null,"Enter a valid salary");
											}
									else{
										if(ID.matches("^[0-9]{1,12}$") && NAME.matches("^[a-zA-Z]*$") && SAL.matches("[0-9]{1,12}$"))
										{
										                    DbHandler db = new DbHandler();
															int id = Integer.parseInt(ID);
															int sal =Integer.parseInt(SAL);
															db.addEmployee(id,NAME,sal);
		
										JOptionPane.showMessageDialog(null,"Success!!");
										}
								}
							}
							catch(Exception e){
							JOptionPane.showMessageDialog(null,e);
							}
															
				}
		});
															
	}
	}
		
		


class AddFrame
{
	public static void main(String agrs[])
	{
		Add a = new Add();
	}
}
