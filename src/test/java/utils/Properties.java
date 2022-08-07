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

    public String getPosteo() {
        return this.getProperty("posteo");
    }

    public String getPosteoSecret() {
        return this.getProperty("posteoSecret");
    }

    public String getToMail() {
        return this.getProperty("toMail");
    }
}
