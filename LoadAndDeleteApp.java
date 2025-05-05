package in.abc.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.abc.Model.Employee;
import in.abc.util.HibernateUtil;

public class LoadAndDeleteApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = true;
		Employee employee = null;

		try {
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, 21);
			if (employee != null) {
				session.delete(employee);
				flag = true;
			} else {
				System.out.println("Record not available to delete");
				System.exit(0);
			}
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
