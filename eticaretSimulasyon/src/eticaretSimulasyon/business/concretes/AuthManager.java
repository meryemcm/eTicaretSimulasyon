package eticaretSimulasyon.business.concretes;

import eticaretSimulasyon.business.abstracts.AuthService;
import eticaretSimulasyon.business.abstracts.UserService;
import eticaretSimulasyon.business.abstracts.ValidationService;
import eticaretSimulasyon.core.utils.BusinessRules;
import eticaretSimulasyon.entities.concretes.User;

public class AuthManager implements AuthService{
	
	UserService userService;
	ValidationService validationService;
	

	public AuthManager(UserService userService, ValidationService validationService) {
		super();
		this.userService = userService;
		this.validationService = validationService;
		
	}


	@Override
	public void register(int id, String email, String password, String firstName, String lastName) {
		User userToRegister = new User(id, email, password, firstName, lastName, false);

		if (!validationService.validate(userToRegister)) {
			System.out.println("Validasyon islemi basarisiz. Lütfen tüm alanlari dogru girdiginizden emin olunuz.");
			return;
		}
		if(!BusinessRules.run(checkIfUserExists(email))) {
			System.out.println("Kayıt olma işlemi başarısız. Bu email ile bir başka üye mevcut.");
			return;
		}
		
		System.out.println("Başarıyla kayıt olundu. Üyeliğinizi doğrulamak için lütfen e-posta adresinizi kontrol ediniz.");
		
		userService.add(userToRegister);
		
	}

	@Override
	public void login(String email, String password) {
		
		if(!BusinessRules.run(checkIfAllFieldsFilled(email, password))) {
			System.out.println("Giriş başarısız. Inputlar doğru doldurulmadı.");
			return;
		}
		User userToLogin = userService.getByEmailAndPassword(email, password);
		if (userToLogin == null) {
			System.out.println("Giriþ baþarýsýz. E-posta adresiniz veya þifreniz yanlýþ.");
			return;
		}
		
		if(!checkIfUserVerified(userToLogin)) {
			System.out.println("Giriş başarısız. Üyeliğinizi doğrulamadınız.");
			return;
		}
		System.out.println(
				"Giris basarili. Hosgeldiniz : " + userToLogin.getFirstName() + " " + userToLogin.getLastName());

	}
	

	private boolean checkIfUserExists(String email) {
		return userService.getByEmail(email) == null;
	}
	private boolean checkIfUserVerified(User user) {
		return user.isVerify();
	}
	private boolean checkIfAllFieldsFilled(String email,String password) {
		if(email.length()<=0 || password.length() <=0) {
			return false;
		}
		return true;
	}

}
