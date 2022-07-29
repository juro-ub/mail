package de.jro.moduls.mail;

public abstract class Mail {

    protected abstract void sendMail(String header, String content, String filePath,
            String fromMail, String toMail, String authName, String authPw) throws Exception;

    public void sendMailWithFile(String html, String header, String path,
            String fromMail, String toMail, String authName, String authPw) throws Exception {
        this.sendMail(header, html, path, fromMail, toMail, authName, authPw);

    }

    public void sendMailWithoutFile(String html, String header, String fromMail, String toMail, String authName, String authPw)
            throws Exception {
        this.sendMail(header, html, "", fromMail, toMail, authName, authPw);

    }
}
