/*************************************************************************
 *                                                                       *
 *  EJBCA: The OpenSource Certificate Authority                          *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.ejbca.core.protocol.ws.client.gen;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.ejbca.util.Base64;

/**
 * Wrapper class for holding WS keystore data
 * 
 * @version $Id: KeyStore.java 10288 2010-10-26 11:27:21Z anatom $
 */
public class KeyStore extends TokenCertificateResponseWS {
	
	private byte[] keystoreData = null;
	
	/**
	 * WS Constructor
	 */
	public KeyStore(){
		
	}

	public KeyStore(java.security.KeyStore keystore, String password) throws KeyStoreException, NoSuchAlgorithmException, IOException, CertificateException{
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		keystore.store(baos,password.toCharArray());
		keystoreData = Base64.encode(baos.toByteArray());
	}


	
	/**
	 * Returns the keystoreData in Base64 format
	 * @return Returns the keystoreData, in Base64 encoded format.
	 */
	public byte[] getKeystoreData() {
		return keystoreData;
	}

	/**
	 * Returns the keystoreData in binary format
	 * @return the keystoreData in binary format
	 */
	public byte[] getRawKeystoreData() {
		return Base64.decode(keystoreData);
	}

	/**
	 * Set keystore data in Base64 format
	 * @param keystoreData The keystoreData to set, in Base64 encoded format.
	 */
	public void setKeystoreData(byte[] keystoreData) {
		this.keystoreData = keystoreData;
	}


}
