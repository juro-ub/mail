package test.de.jro.moduls.mail;

import de.jro.moduls.mail.Posteo;
import de.jro.moduls.mail.Mail;
import utils.Properties;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class ModulPosteo {

    @Test
    public void test() throws Exception {

        Properties props = new Properties();
        Mail mail = new Posteo();

        try {
            mail.sendMailWithoutFile("Test Mail", "Test Header", props.getPosteo(), props.getToMail(), props.getPosteo(), props.getPosteoSecret());
        } catch (Exception exception) {
            fail(exception.getLocalizedMessage());
        }

    }
}
