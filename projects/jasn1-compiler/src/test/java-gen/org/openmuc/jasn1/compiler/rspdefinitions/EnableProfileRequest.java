/**
 * This class file was automatically generated by jASN1 v1.7.1 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.rspdefinitions;

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

import org.openmuc.jasn1.compiler.pkix1explicit88.*;
import org.openmuc.jasn1.compiler.pkix1implicit88.*;

public class EnableProfileRequest {

	public static class ProfileIdentifier {

		public byte[] code = null;
		public OctetTo16 isdpAid = null;
		public Iccid iccid = null;
		
		public ProfileIdentifier() {
		}

		public ProfileIdentifier(byte[] code) {
			this.code = code;
		}

		public ProfileIdentifier(OctetTo16 isdpAid, Iccid iccid) {
			this.isdpAid = isdpAid;
			this.iccid = iccid;
		}

		public int encode(BerByteArrayOutputStream os) throws IOException {

			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;
			}

			int codeLength = 0;
			if (iccid != null) {
				codeLength += iccid.encode(os, true);
				return codeLength;
			}
			
			if (isdpAid != null) {
				codeLength += isdpAid.encode(os, false);
				// write tag: APPLICATION_CLASS, PRIMITIVE, 15
				os.write(0x4F);
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

			if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
				isdpAid = new OctetTo16();
				codeLength += isdpAid.decode(is, false);
				return codeLength;
			}

			if (berTag.equals(Iccid.tag)) {
				iccid = new Iccid();
				codeLength += iccid.decode(is, false);
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
			if (isdpAid != null) {
				return "CHOICE{isdpAid: " + isdpAid + "}";
			}

			if (iccid != null) {
				return "CHOICE{iccid: " + iccid + "}";
			}

			return "unknown";
		}

	}

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 49);

	public byte[] code = null;
	public ProfileIdentifier profileIdentifier = null;
	public BerBoolean refreshFlag = null;
	
	public EnableProfileRequest() {
	}

	public EnableProfileRequest(byte[] code) {
		this.code = code;
	}

	public EnableProfileRequest(ProfileIdentifier profileIdentifier, BerBoolean refreshFlag) {
		this.profileIdentifier = profileIdentifier;
		this.refreshFlag = refreshFlag;
	}

	public int encode(BerByteArrayOutputStream os) throws IOException {
		return encode(os, true);
	}

	public int encode(BerByteArrayOutputStream os, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			if (withTag) {
				return tag.encode(os) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		int sublength;

		codeLength += refreshFlag.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 1
		os.write(0x81);
		codeLength += 1;
		
		sublength = profileIdentifier.encode(os);
		codeLength += sublength;
		codeLength += BerLength.encodeLength(os, sublength);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
		os.write(0xA0);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(os, codeLength);

		if (withTag) {
			codeLength += tag.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		if (totalLength == -1) {
			subCodeLength += berTag.decode(is);

			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
				subCodeLength += length.decode(is);
				profileIdentifier = new ProfileIdentifier();
				int choiceDecodeLength = profileIdentifier.decode(is, null);
				if (choiceDecodeLength != 0) {
					subCodeLength += choiceDecodeLength;
					subCodeLength += berTag.decode(is);
				}
				else {
					profileIdentifier = null;
				}

			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
				refreshFlag = new BerBoolean();
				subCodeLength += refreshFlag.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			int nextByte = is.read();
			if (berTag.tagNumber != 0 || berTag.tagClass != 0 || berTag.primitive != 0
			|| nextByte != 0) {
				if (nextByte == -1) {
					throw new EOFException("Unexpected end of input stream.");
				}
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			codeLength += subCodeLength + 1;
			return codeLength;
		}

		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			subCodeLength += length.decode(is);
			profileIdentifier = new ProfileIdentifier();
			subCodeLength += profileIdentifier.decode(is, null);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			refreshFlag = new BerBoolean();
			subCodeLength += refreshFlag.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("profileIdentifier: ").append(profileIdentifier);
		
		sb.append(", ");
		sb.append("refreshFlag: ").append(refreshFlag);
		
		sb.append("}");
		return sb.toString();
	}

}

