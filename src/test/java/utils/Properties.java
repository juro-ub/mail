package utils;

import java.io.*;

public class Properties extends java.util.Properties {

    public Properties() throws Exception {
        load();
    }

    public void load() throws Exception {
        InputStream input = Properties.class.getClassLoader().getResourceAsStream("junit.properties");
        super.load(input);
    }

    public String getGmail() {
        return this.getProperty("gmail");
    }

    public String getGmailSecret() {
        return this.getProperty("gmailSecret");
    }

    public String getToMail() {
        return this.getProperty("toMail");
    }
}
