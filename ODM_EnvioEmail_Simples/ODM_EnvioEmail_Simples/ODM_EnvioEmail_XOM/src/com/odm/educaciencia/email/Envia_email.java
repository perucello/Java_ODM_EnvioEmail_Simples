package com.odm.educaciencia.email;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Envia_email {

	private String emailRemetente;
	private String emailDestino;
	private String assuntoEmail;
	private String corpoEmail;
	private java.util.ArrayList<String> observacoes = new java.util.ArrayList<String>();

	public Envia_email() {
		super();
	}

	public Envia_email(String emailRemetente, String emailDestino,
			String assuntoEmail, String corpoEmail,
			ArrayList<String> observacoes) {
		super();
		this.emailRemetente = emailRemetente;
		this.emailDestino = emailDestino;
		this.assuntoEmail = assuntoEmail;
		this.corpoEmail = corpoEmail;
		this.observacoes = observacoes;
	}

	public java.util.ArrayList<String> getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(java.util.ArrayList<String> observacoes) {
		this.observacoes = observacoes;
	}

	public String getEmailRemetente() {
		return emailRemetente;
	}

	public void setEmailRemetente(String emailRemetente) {
		this.emailRemetente = emailRemetente;
	}

	public String getEmailDestino() {
		return emailDestino;
	}

	public void setEmailDestino(String emailDestino) {
		this.emailDestino = emailDestino;
	}

	public String getAssuntoEmail() {
		return assuntoEmail;
	}

	public void setAssuntoEmail(String assuntoEmail) {
		this.assuntoEmail = assuntoEmail;
	}

	public String getCorpoEmail() {
		return corpoEmail;
	}

	public void setCorpoEmail(String corpoEmail) {
		this.corpoEmail = corpoEmail;
	}

	public void enviaEmailODM() {
		String seuEmail = "xxxxx@xxxxx.com"; // digite seu email
		String suaSenha = "xxxxxxxxxxx"; // digite sua senha de acesso

		// dados de validação do provedor
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(seuEmail, suaSenha);
					}
				});
		session.setDebug(true);

		// Bloco TryCatch para tratarmos em caso de erro !
		try {
			Message message = new MimeMessage(session);

			// Email do remetente
			message.setFrom(new InternetAddress("xxxxx@xxxxx.com")); // seu email

			// Email do Destinatario - vetor
			Address[] toUser = InternetAddress 
					.parse("xxx@xxx.com.br"); // Destinatário(s)
			message.setRecipients(Message.RecipientType.TO, toUser);

			// Assunto do email
			message.setSubject("Email via ODM");

			// Assunto no corpo do email
			message.setText("Teste de envio de email pelo ODM...");

			// enviar mensagem
			Transport.send(message);

			// Para imprimir no console em caso de sucesso
			System.out
					.println("enviado !!!");

		} catch (MessagingException e) {
			System.err.println("Ocorreu erro no processo !");
			throw new RuntimeException("Ocorreu erro : " + e);
		}

	}

		
	public void disparaEmail_ODM(String corpoEmail, String assuntoEmail,
			String emailDestino) {
		String seuEmail = "xxx-xxx@xxx.com"; // email do remetente
		String suaSenha = "xxxxxx"; // digite sua senha de acesso

		// dados de validação do provedor
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(seuEmail, suaSenha);
					}
				});
		session.setDebug(true);

		// Bloco TryCatch para tratarmos em caso de erro !
		try {
			Message message = new MimeMessage(session);

			// Email do remetente
			String remetente = seuEmail; // email do remetente
			
			message.setFrom(new InternetAddress(remetente));

			// Email do Destinatario - vetor
			String destino = emailDestino;
			Address[] toUser = InternetAddress.parse(destino);

			message.setRecipients(Message.RecipientType.TO, toUser);

			// Assunto do email
			String assunto = assuntoEmail;
			;
			message.setSubject(assunto);

			// Assunto no corpo do email
			String corpo = corpoEmail;
			message.setText(corpo);

			// enviar mensagem
			Transport.send(message);

			// Para imprimir no console em caso de sucesso
			String sucesso = "email enviado com sucesso";
			this.observacoes.add(sucesso);
			System.out.println(observacoes);

		} catch (MessagingException e) {
			System.err.println("Ocorreu erro no processo !");
			throw new RuntimeException("Ocorreu erro : " + e);
		}

	}

}
