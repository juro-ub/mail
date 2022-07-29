package test.de.jro.moduls.mail;

import de.jro.moduls.mail.Gmail;
import de.jro.moduls.mail.Mail;
import utils.Properties;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class ModulGmail {

    @Test
    public void test() throws Exception {

        Properties props = new Properties();
        Mail mail = new Gmail();

        try {
            mail.sendMailWithoutFile("Test Mail", "Test Header", props.getGmail(), props.getToMail(), props.getGmail(), props.getGmailSecret());
        } catch (Exception exception) {
            fail(exception.getLocalizedMessage());
        }

    }
}
