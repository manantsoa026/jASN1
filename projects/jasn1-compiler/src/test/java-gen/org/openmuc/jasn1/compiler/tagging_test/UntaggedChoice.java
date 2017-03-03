/**
 * This class file was automatically generated by jASN1 v1.7.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.tagging_test;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;


public class UntaggedChoice {

	public byte[] code = null;
	private BerInteger myInteger = null;
	private BerBoolean myBoolean = null;
	
	public UntaggedChoice() {
	}

	public UntaggedChoice(byte[] code) {
		this.code = code;
	}

	public void setMyInteger(BerInteger myInteger) {
		this.myInteger = myInteger;
	}

	public BerInteger getMyInteger() {
		return myInteger;
	}

	public void setMyBoolean(BerBoolean myBoolean) {
		this.myBoolean = myBoolean;
	}

	public BerBoolean getMyBoolean() {
		return myBoolean;
	}

	public int encode(BerByteArrayOutputStream os) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		if (myBoolean != null) {
			codeLength += myBoolean.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 4
			os.write(0x84);
			codeLength += 1;
			return codeLength;
		}
		
		if (myInteger != null) {
			codeLength += myInteger.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			os.write(0x83);
			codeLength += 1;
			return codeLength;
		}
		
		throw new IOException("Error encoding BerChoice: No item in choice was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int codeLength = 0;
		BerTag passedTag = berTag;

		if (berTag == null) {
			berTag = new BerTag();
			codeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			myInteger = new BerInteger();
			codeLength += myInteger.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
			myBoolean = new BerBoolean();
			codeLength += myBoolean.decode(is, false);
			return codeLength;
		}

		if (passedTag != null) {
			return 0;
		}

		throw new IOException("Error decoding BerChoice: Tag matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os);
		code = os.getArray();
	}

	public String toString() {
		if (myInteger != null) {
			return "CHOICE{myInteger: " + myInteger + "}";
		}

		if (myBoolean != null) {
			return "CHOICE{myBoolean: " + myBoolean + "}";
		}

		return "unknown";
	}

}

