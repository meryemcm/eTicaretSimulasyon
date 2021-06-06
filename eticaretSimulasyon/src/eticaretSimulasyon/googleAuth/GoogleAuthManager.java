package eticaretSimulasyon.googleAuth;

public class GoogleAuthManager {
	public void register(String email, String password) {
	
		System.out.println("Google ile kayýt alýndý: " + email );
	}
	
	public void login(String email,String password) {
		System.out.println("Google ile giriþ yapýldý: " + email);
	}
}
