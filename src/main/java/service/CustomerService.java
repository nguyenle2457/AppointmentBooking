package service;

import model.Customer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCustomer(Customer customer){
        sessionFactory.getCurrentSession().save(customer);
    }

    public Customer getTeacher(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where id=:id");
        query.setInteger("id", id);
        return (Customer) query.uniqueResult();
    }


    public List<Customer> getAllCustomers(){
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer");
        return query.list();
    }

    public List<Customer> findTeachers(String name){
       Query query = sessionFactory.getCurrentSession().createQuery("from Customer s where s.name like :name");
       query.setString("name", "%"+name+"%");
       return query.list();
    }


    public void deleteCustomer(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where id=:id");
        query.setInteger("id", id);
        Customer customer = (Customer) query.uniqueResult();
        sessionFactory.getCurrentSession().delete(customer);
    }

}
