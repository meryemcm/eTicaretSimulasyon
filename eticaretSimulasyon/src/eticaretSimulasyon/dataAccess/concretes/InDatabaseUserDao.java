package eticaretSimulasyon.dataAccess.concretes;

import java.util.List;
import java.util.ArrayList;
import eticaretSimulasyon.dataAccess.abstracts.UserDao;
import eticaretSimulasyon.entities.concretes.User;

public class InDatabaseUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		
		
	}

	@Override
	public void update(User user) {
		User userToUpdate = getId(user.getId());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		users.removeIf(obj->obj.getId() == user.getId());
		
	}

	@Override
	public User getId(int id) {
		for(User user : users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		for(User user : users) {
			if(user.getEmail() == email)
				return user;
		}
		return null;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		for(User user : users) {
			if(user.getEmail() == email && user.getPassword() == password)
				return user;
		}
		return null;
	}

	@Override
	public List<User> getAll() {

		return users;
	}

}
