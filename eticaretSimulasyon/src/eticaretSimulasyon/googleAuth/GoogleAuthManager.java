package eticaretSimulasyon.googleAuth;

public class GoogleAuthManager {
	public void register(String email, String password) {
	
		System.out.println("Google ile kay�t al�nd�: " + email );
	}
	
	public void login(String email,String password) {
		System.out.println("Google ile giri� yap�ld�: " + email);
	}
}
