package eticaretSimulasyon.business.abstracts;

import eticaretSimulasyon.entities.concretes.User;

public interface ValidationService {
	
	boolean validate(User user);

}
