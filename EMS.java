import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class MainFrame extends JFrame{
	Container c;
	JButton btnAdd,btnView,btnUpdate,btnDelete;
	
	MainFrame(){
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		btnAdd = new JButton("Add");
		btnView= new JButton("View");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		c.add(btnAdd);
		c.add(btnView);
		c.add(btnUpdate);
		c.add(btnDelete);
		
		setTitle("EMS");
		setSize(250,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		btnAdd.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent ae){
															Add a = new Add();
															dispose();
														}
		});
		
		btnView.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent ae){
															View a = new View();
															dispose();
														}
		});
		
		btnUpdate.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent ae){
															Update a = new Update();
															dispose();
														}
		});
		
		btnDelete.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent ae){
															Delete a = new Delete();
															dispose();
														}
		});
	}
}
class EMS
{
	public static void main(String agrs[])
	{
		MainFrame m = new MainFrame();
	}
}

class DbHandler
{
	
	public void addEmployee(int id,String name,int sal)
	{
										Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = sfact.openSession();
		Transaction t = null;
		try{
			System.out.println("begin");
			t=session.beginTransaction();
			Employee e = new Employee();
			e.setId(id);
			e.setName(name);
			e.setSal(sal);
			session.save(e);
			t.commit();
			JOptionPane.showMessageDialog(new JDialog(),"Record Inserted");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JDialog(),e);
		}
		finally{
			session.close();
		}
		
	}
	/*
	public String getEmployee()
	{
	Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = sfact.openSession();
		
		try{
			System.out.println("begin");
			List<Employee> emp = new ArrayList<>();
			emp=session.createQuery("from Employee").list();
			for(Employee e:emp)
				emp.add("Emp Id:" + e.getId() + "\t Emp Name " + e.getName() + " \t Salary:" + e.getSal() );
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			session.close();
		}
	}
	*/
	
}
