package Publishing;

import javax.mail.MessagingException;

public class Send {

	public static void main(String[] args) throws MessagingException {
		// TODO Auto-generated method stub

		String textSent = "Here i am testing";
		Mail.sendMail("nzosabaavit@gmail.com", textSent);
	}

}
