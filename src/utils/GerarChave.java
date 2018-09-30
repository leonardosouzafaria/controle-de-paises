package utils;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.swing.JOptionPane;

public class GerarChave 
{
	public static void main(String[] args) throws NoSuchAlgorithmException,
		InvalidAlgorithmParameterException, CertificateException, KeyStoreException, IOException
	{
		CryptoAES aes = new CryptoAES();
		aes.geraChave(new File("C:\\Users\\Renan Viana\\Desktop\\chave.simetrica"));
	}
}