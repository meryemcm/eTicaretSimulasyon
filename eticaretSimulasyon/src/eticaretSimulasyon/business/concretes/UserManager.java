package eticaretSimulasyon.business.concretes;

import java.util.List;

import eticaretSimulasyon.business.abstracts.UserService;
import eticaretSimulasyon.dataAccess.abstracts.UserDao;
import eticaretSimulasyon.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	 

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public void verifyUser(int id) {
		User user = userDao.getId(id);
		user.setVerify(true);
		System.out.println("Kullanýcý baþarýyla doðrulandý..");
		
	}

	@Override
	public User getId(int id) {
		
		return userDao.getId(id);
	}

	@Override
	public User getByEmail(String email) {
	
		return userDao.getByEmail(email);
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
	
		return userDao.getByEmailAndPassword(email, password);
	}

	@Override
	public List<User> getAll() {

		return userDao.getAll();
	}

}
