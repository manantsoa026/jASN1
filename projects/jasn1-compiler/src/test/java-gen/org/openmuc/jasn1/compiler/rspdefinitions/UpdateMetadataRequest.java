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

public class UpdateMetadataRequest {

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 42);

	public byte[] code = null;
	public BerUTF8String serviceProviderName = null;
	public BerUTF8String profileName = null;
	public IconType iconType = null;
	public BerOctetString icon = null;
	public PprIds profilePolicyRules = null;
	
	public UpdateMetadataRequest() {
	}

	public UpdateMetadataRequest(byte[] code) {
		this.code = code;
	}

	public UpdateMetadataRequest(BerUTF8String serviceProviderName, BerUTF8String profileName, IconType iconType, BerOctetString icon, PprIds profilePolicyRules) {
		this.serviceProviderName = serviceProviderName;
		this.profileName = profileName;
		this.iconType = iconType;
		this.icon = icon;
		this.profilePolicyRules = profilePolicyRules;
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
		if (profilePolicyRules != null) {
			codeLength += profilePolicyRules.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 25
			os.write(0x99);
			codeLength += 1;
		}
		
		if (icon != null) {
			codeLength += icon.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 20
			os.write(0x94);
			codeLength += 1;
		}
		
		if (iconType != null) {
			codeLength += iconType.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 19
			os.write(0x93);
			codeLength += 1;
		}
		
		if (profileName != null) {
			codeLength += profileName.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 18
			os.write(0x92);
			codeLength += 1;
		}
		
		if (serviceProviderName != null) {
			codeLength += serviceProviderName.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 17
			os.write(0x91);
			codeLength += 1;
		}
		
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
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 17)) {
				serviceProviderName = new BerUTF8String();
				subCodeLength += serviceProviderName.decode(is, false);
				subCodeLength += berTag.decode(is);
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
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 18)) {
				profileName = new BerUTF8String();
				subCodeLength += profileName.decode(is, false);
				subCodeLength += berTag.decode(is);
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
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 19)) {
				iconType = new IconType();
				subCodeLength += iconType.decode(is, false);
				subCodeLength += berTag.decode(is);
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
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 20)) {
				icon = new BerOctetString();
				subCodeLength += icon.decode(is, false);
				subCodeLength += berTag.decode(is);
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
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 25)) {
				profilePolicyRules = new PprIds();
				subCodeLength += profilePolicyRules.decode(is, false);
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

		if (totalLength == 0) {
			return codeLength;
		}
		subCodeLength += berTag.decode(is);
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 17)) {
			serviceProviderName = new BerUTF8String();
			subCodeLength += serviceProviderName.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 18)) {
			profileName = new BerUTF8String();
			subCodeLength += profileName.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 19)) {
			iconType = new IconType();
			subCodeLength += iconType.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 20)) {
			icon = new BerOctetString();
			subCodeLength += icon.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 25)) {
			profilePolicyRules = new PprIds();
			subCodeLength += profilePolicyRules.decode(is, false);
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
		boolean firstSelectedElement = true;
		if (serviceProviderName != null) {
			sb.append("serviceProviderName: ").append(serviceProviderName);
			firstSelectedElement = false;
		}
		
		if (profileName != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("profileName: ").append(profileName);
			firstSelectedElement = false;
		}
		
		if (iconType != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("iconType: ").append(iconType);
			firstSelectedElement = false;
		}
		
		if (icon != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("icon: ").append(icon);
			firstSelectedElement = false;
		}
		
		if (profilePolicyRules != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("profilePolicyRules: ").append(profilePolicyRules);
			firstSelectedElement = false;
		}
		
		sb.append("}");
		return sb.toString();
	}

}

