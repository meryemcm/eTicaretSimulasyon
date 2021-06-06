package eticaretSimulasyon;

import eticaretSimulasyon.business.concretes.ValidationManager;
import eticaretSimulasyon.core.GoogleAuthManagerAdapter;
import eticaretSimulasyon.business.abstracts.AuthService;
import eticaretSimulasyon.business.abstracts.UserService;
import eticaretSimulasyon.business.concretes.AuthManager;
import eticaretSimulasyon.business.concretes.UserManager;
import eticaretSimulasyon.dataAccess.concretes.InDatabaseUserDao;
public class Main {

	public static void main(String[] args) {

		
		UserService userService = new UserManager(new InDatabaseUserDao());
		AuthService authService = new AuthManager(userService, new ValidationManager());
		authService.register(1, "mehmetaslan99@hotmail.com", "mehmet123", "Mehmet", "Aslan");//Başarılı
		authService.register(2, "zafer-aslan99@hotmail.com", "zafer123", "Zafer", "Aslan"); // 
		
		authService.login("mehmetaslan99@hotmail.com","mehmet123");// Başarısız üye doğrulama yapmamış
		userService.verifyUser(2);//Kullanıcı doğrulaması
		authService.login("zafer-aslan99@hotmail.com", "zafer1234");//Başarısız şifre yanlış
		authService.login("zafer-aslan99@hotmail.com","zafer123");//Başarılı
	
		
		AuthService googleAuthService=new GoogleAuthManagerAdapter();
		googleAuthService.register(3, "zeynepksys@gmail.com", "zeynep123", "Zeynep", "Kaya");
		googleAuthService.login("zeynepksys@gmail.com", "zeynep123");

	}

}
