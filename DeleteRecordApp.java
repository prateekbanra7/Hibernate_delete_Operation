package in.abc.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.abc.Model.Employee;
import in.abc.util.HibernateUtil;

public class DeleteRecordApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = true;
		
			try {
				 transaction = session.beginTransaction();
			 Employee employee = new Employee();
			 employee.setEmpId(10);
			 session.delete(employee);
			 flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			} finally {
				if (flag) {
					transaction.commit();
					System.out.println("Object deleted...");
				} else {
					transaction.rollback();
					System.out.println("Object failed to delete...");
				}
			}
		

	}

}
