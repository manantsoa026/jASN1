/**
 * This class file was automatically generated by jASN1 v1.7.1 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.compile_test;

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


public class MyChoice2 {

	public byte[] code = null;
	public static class Element1 {

		public byte[] code = null;
		public BerInteger test = null;
		
		public Element1() {
		}

		public Element1(byte[] code) {
			this.code = code;
		}

		public Element1(BerInteger test) {
			this.test = test;
		}

		public int encode(BerByteArrayOutputStream os) throws IOException {

			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;
			}

			int codeLength = 0;
			if (test != null) {
				codeLength += test.encode(os, true);
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

			if (berTag.equals(BerInteger.tag)) {
				test = new BerInteger();
				codeLength += test.decode(is, false);
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
			if (test != null) {
				return "CHOICE{test: " + test + "}";
			}

			return "unknown";
		}

	}

	public static class Element4 {

		public byte[] code = null;
		public BerInteger test = null;
		public BerBoolean test2 = null;
		
		public Element4() {
		}

		public Element4(byte[] code) {
			this.code = code;
		}

		public Element4(BerInteger test, BerBoolean test2) {
			this.test = test;
			this.test2 = test2;
		}

		public int encode(BerByteArrayOutputStream os) throws IOException {

			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;
			}

			int codeLength = 0;
			if (test2 != null) {
				codeLength += test2.encode(os, true);
				return codeLength;
			}
			
			if (test != null) {
				codeLength += test.encode(os, true);
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

			if (berTag.equals(BerInteger.tag)) {
				test = new BerInteger();
				codeLength += test.decode(is, false);
				return codeLength;
			}

			if (berTag.equals(BerBoolean.tag)) {
				test2 = new BerBoolean();
				codeLength += test2.decode(is, false);
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
			if (test != null) {
				return "CHOICE{test: " + test + "}";
			}

			if (test2 != null) {
				return "CHOICE{test2: " + test2 + "}";
			}

			return "unknown";
		}

	}

	public Element1 element1 = null;
	public BerInteger element2 = null;
	public BerBoolean myboolean = null;
	public Element4 element4 = null;
	
	public MyChoice2() {
	}

	public MyChoice2(byte[] code) {
		this.code = code;
	}

	public MyChoice2(Element1 element1, BerInteger element2, BerBoolean myboolean, Element4 element4) {
		this.element1 = element1;
		this.element2 = element2;
		this.myboolean = myboolean;
		this.element4 = element4;
	}

	public int encode(BerByteArrayOutputStream os) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		if (element4 != null) {
			codeLength += element4.encode(os);
			return codeLength;
		}
		
		if (myboolean != null) {
			codeLength += myboolean.encode(os, true);
			return codeLength;
		}
		
		if (element2 != null) {
			codeLength += element2.encode(os, true);
			return codeLength;
		}
		
		if (element1 != null) {
			codeLength += element1.encode(os);
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

		element1 = new Element1();
		int choiceDecodeLength = element1.decode(is, berTag);
		if (choiceDecodeLength != 0) {
			return codeLength + choiceDecodeLength;
		}
		else {
			element1 = null;
		}

		if (berTag.equals(BerInteger.tag)) {
			element2 = new BerInteger();
			codeLength += element2.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerBoolean.tag)) {
			myboolean = new BerBoolean();
			codeLength += myboolean.decode(is, false);
			return codeLength;
		}

		element4 = new Element4();
		choiceDecodeLength = element4.decode(is, berTag);
		if (choiceDecodeLength != 0) {
			return codeLength + choiceDecodeLength;
		}
		else {
			element4 = null;
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
		if (element1 != null) {
			return "CHOICE{element1: " + element1 + "}";
		}

		if (element2 != null) {
			return "CHOICE{element2: " + element2 + "}";
		}

		if (myboolean != null) {
			return "CHOICE{myboolean: " + myboolean + "}";
		}

		if (element4 != null) {
			return "CHOICE{element4: " + element4 + "}";
		}

		return "unknown";
	}

}

