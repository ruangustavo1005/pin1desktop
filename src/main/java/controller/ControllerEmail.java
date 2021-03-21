package controller;

import dao.Dao;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Model;
import view.View;

/**
 * @author Ruan
 */
public class ControllerEmail extends Controller {

    static public final String MAIL_GMAIL_SMTP_HOST                = "smtp.gmail.com";
    static public final String MAIL_GMAIL_SMTP_SOCKETFACTORY_PORT  = "465";
    static public final String MAIL_GMAIL_SMTP_SOCKETFACTORY_CLASS = "javax.net.ssl.SSLSocketFactory";
    static public final String MAIL_GMAIL_SMTP_AUTH                = "true";
    static public final String MAIL_GMAIL_SMTP_PORT                = "465";
    
    static public final String MAIL_HOTMAIL_TRANSPORT_PROTOCOL          = "smtp";
    static public final String MAIL_HOTMAIL_SMTP_HOST                   = "smtp.live.com";
    static public final String MAIL_HOTMAIL_SMTP_SOCKETFACTORY_PORT     = "587";
    static public final String MAIL_HOTMAIL_SMTP_SOCKETFACTORY_FALLBACK = "false";
    static public final String MAIL_HOTMAIL_SMTP_STARTTLS_ENABLE        = "true";
    static public final String MAIL_HOTMAIL_SMTP_AUTH                   = "true";
    static public final String MAIL_HOTMAIL_SMTP_PORT                   = "587";
    
    private static final String EMAIL_GMAIL       = "concessionaria.pin@gmail.com";
    private static final String SENHA_EMAIL_GMAIL = "Aw9Uw!9fWp36";
    
    private static final String EMAIL_HOTMAIL       = "concessionaria.pin@hotmail.com";
    private static final String SENHA_EMAIL_HOTMAIL = "Aw9Uw!9fWp36";

    private String destinatarios;
    private String titulo;
    private String conteudo;
    
    public ControllerEmail(Controller caller) {
        super(caller);
    }

    @Override
    public boolean processaDados() {
        boolean retorno = false;
        
        try {
            Message message = new MimeMessage(this.getInstanceSessionForHotmail());
            message.setFrom(new InternetAddress(EMAIL_HOTMAIL));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.getDestinatarios()));
            message.setSubject(this.getTitulo());
            message.setText(this.getConteudo());
            
            Transport.send(message);

            retorno = true;
        }
        catch (MessagingException e) {
            System.out.println(e.toString());
        }
        
        return retorno;
    }
    
    protected Session getInstanceSessionForGmail() {
        Properties props = new Properties();
        
        props.put("mail.smtp.host",                MAIL_GMAIL_SMTP_HOST);
        props.put("mail.smtp.socketFactory.port",  MAIL_GMAIL_SMTP_SOCKETFACTORY_PORT);
        props.put("mail.smtp.socketFactory.class", MAIL_GMAIL_SMTP_SOCKETFACTORY_CLASS);
        props.put("mail.smtp.auth",                MAIL_GMAIL_SMTP_AUTH);
        props.put("mail.smtp.port",                MAIL_GMAIL_SMTP_PORT);

        Session session = Session.getDefaultInstance(props, this.getInstanceAuthenticator());
        session.setDebug(true);

        return session;
    }
    
    protected Session getInstanceSessionForHotmail() {
        Properties props = new Properties();
        
        props.put("mail.transport.protocol",          MAIL_HOTMAIL_TRANSPORT_PROTOCOL);
        props.put("mail.smtp.host",                   MAIL_HOTMAIL_SMTP_HOST);
        props.put("mail.smtp.socketFactory.port",     MAIL_HOTMAIL_SMTP_SOCKETFACTORY_PORT);
        props.put("mail.smtp.socketFactory.fallback", MAIL_HOTMAIL_SMTP_SOCKETFACTORY_FALLBACK);
        props.put("mail.smtp.starttls.enable",        MAIL_HOTMAIL_SMTP_STARTTLS_ENABLE);
        props.put("mail.smtp.auth",                   MAIL_HOTMAIL_SMTP_AUTH);
        props.put("mail.smtp.port",                   MAIL_HOTMAIL_SMTP_PORT);

        Session session = Session.getDefaultInstance(props, this.getInstanceAuthenticator());
        session.setDebug(true);

        return session;
    }

    protected Authenticator getInstanceAuthenticator() {
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_HOTMAIL, SENHA_EMAIL_HOTMAIL);
            }
        };
                
        return authenticator;
    }
    
    @Override
    public Model getInstanceModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public View getInstanceView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Dao getInstanceDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getDestinatarios() {
        return destinatarios;
    }

    public ControllerEmail setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public ControllerEmail setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getConteudo() {
        return conteudo;
    }

    public ControllerEmail setConteudo(String conteudo) {
        this.conteudo = conteudo;
        return this;
    }
    
}