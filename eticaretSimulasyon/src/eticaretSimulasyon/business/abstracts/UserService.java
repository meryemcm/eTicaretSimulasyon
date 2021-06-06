package eticaretSimulasyon.business.abstracts;

import java.util.List;

import eticaretSimulasyon.entities.concretes.User;

public interface UserService {
	
	void add(User user);
	void update(User user);
	void delete(User user);
    void verifyUser(int id);
	User getId(int id);
    User getByEmail(String email);
    User getByEmailAndPassword(String email,String password);
	List<User> getAll();

}
