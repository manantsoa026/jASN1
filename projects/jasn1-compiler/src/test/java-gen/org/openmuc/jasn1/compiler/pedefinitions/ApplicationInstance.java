/**
 * This class file was automatically generated by jASN1 v1.7.1 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.pedefinitions;

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


public class ApplicationInstance {

	public static class ProcessData {

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
		public byte[] code = null;
		public List<BerOctetString> seqOf = null;

		public ProcessData() {
			seqOf = new ArrayList<BerOctetString>();
		}

		public ProcessData(byte[] code) {
			this.code = code;
		}

		public ProcessData(List<BerOctetString> seqOf) {
			this.seqOf = seqOf;
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
			for (int i = (seqOf.size() - 1); i >= 0; i--) {
				codeLength += seqOf.get(i).encode(os, true);
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

			if (length.val == -1) {
				while (true) {
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

					BerOctetString element = new BerOctetString();
					subCodeLength += element.decode(is, false);
					seqOf.add(element);
				}
			}
			while (subCodeLength < totalLength) {
				BerOctetString element = new BerOctetString();
				subCodeLength += element.decode(is, true);
				seqOf.add(element);
			}
			if (subCodeLength != totalLength) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

			}
			codeLength += subCodeLength;

			return codeLength;
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
			encode(os, false);
			code = os.getArray();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder("SEQUENCE OF{");

			if (seqOf == null) {
				sb.append("null");
			}
			else {
				Iterator<BerOctetString> it = seqOf.iterator();
				if (it.hasNext()) {
					sb.append(it.next());
					while (it.hasNext()) {
						sb.append(", ").append(it.next());
					}
				}
			}

			sb.append("}");

			return sb.toString();
		}

	}

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public ApplicationIdentifier applicationLoadPackageAID = null;
	public ApplicationIdentifier classAID = null;
	public ApplicationIdentifier instanceAID = null;
	public ApplicationIdentifier extraditeSecurityDomainAID = null;
	public BerOctetString applicationPrivileges = null;
	public BerOctetString lifeCycleState = null;
	public BerOctetString applicationSpecificParametersC9 = null;
	public ApplicationSystemParameters systemSpecificParameters = null;
	public UICCApplicationParameters applicationParameters = null;
	public ProcessData processData = null;
	
	public ApplicationInstance() {
	}

	public ApplicationInstance(byte[] code) {
		this.code = code;
	}

	public ApplicationInstance(ApplicationIdentifier applicationLoadPackageAID, ApplicationIdentifier classAID, ApplicationIdentifier instanceAID, ApplicationIdentifier extraditeSecurityDomainAID, BerOctetString applicationPrivileges, BerOctetString lifeCycleState, BerOctetString applicationSpecificParametersC9, ApplicationSystemParameters systemSpecificParameters, UICCApplicationParameters applicationParameters, ProcessData processData) {
		this.applicationLoadPackageAID = applicationLoadPackageAID;
		this.classAID = classAID;
		this.instanceAID = instanceAID;
		this.extraditeSecurityDomainAID = extraditeSecurityDomainAID;
		this.applicationPrivileges = applicationPrivileges;
		this.lifeCycleState = lifeCycleState;
		this.applicationSpecificParametersC9 = applicationSpecificParametersC9;
		this.systemSpecificParameters = systemSpecificParameters;
		this.applicationParameters = applicationParameters;
		this.processData = processData;
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
		if (processData != null) {
			codeLength += processData.encode(os, true);
		}
		
		if (applicationParameters != null) {
			codeLength += applicationParameters.encode(os, false);
			// write tag: PRIVATE_CLASS, CONSTRUCTED, 10
			os.write(0xEA);
			codeLength += 1;
		}
		
		if (systemSpecificParameters != null) {
			codeLength += systemSpecificParameters.encode(os, false);
			// write tag: PRIVATE_CLASS, CONSTRUCTED, 15
			os.write(0xEF);
			codeLength += 1;
		}
		
		codeLength += applicationSpecificParametersC9.encode(os, false);
		// write tag: PRIVATE_CLASS, PRIMITIVE, 9
		os.write(0xC9);
		codeLength += 1;
		
		if (lifeCycleState != null) {
			codeLength += lifeCycleState.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			os.write(0x83);
			codeLength += 1;
		}
		
		codeLength += applicationPrivileges.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 2
		os.write(0x82);
		codeLength += 1;
		
		if (extraditeSecurityDomainAID != null) {
			codeLength += extraditeSecurityDomainAID.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 15
			os.write(0x4F);
			codeLength += 1;
		}
		
		codeLength += instanceAID.encode(os, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 15
		os.write(0x4F);
		codeLength += 1;
		
		codeLength += classAID.encode(os, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 15
		os.write(0x4F);
		codeLength += 1;
		
		codeLength += applicationLoadPackageAID.encode(os, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 15
		os.write(0x4F);
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
			if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
				applicationLoadPackageAID = new ApplicationIdentifier();
				subCodeLength += applicationLoadPackageAID.decode(is, false);
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
			if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
				classAID = new ApplicationIdentifier();
				subCodeLength += classAID.decode(is, false);
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
			if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
				instanceAID = new ApplicationIdentifier();
				subCodeLength += instanceAID.decode(is, false);
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
			if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
				extraditeSecurityDomainAID = new ApplicationIdentifier();
				subCodeLength += extraditeSecurityDomainAID.decode(is, false);
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
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
				applicationPrivileges = new BerOctetString();
				subCodeLength += applicationPrivileges.decode(is, false);
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
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
				lifeCycleState = new BerOctetString();
				subCodeLength += lifeCycleState.decode(is, false);
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
			if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 9)) {
				applicationSpecificParametersC9 = new BerOctetString();
				subCodeLength += applicationSpecificParametersC9.decode(is, false);
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
			if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.CONSTRUCTED, 15)) {
				systemSpecificParameters = new ApplicationSystemParameters();
				subCodeLength += systemSpecificParameters.decode(is, false);
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
			if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.CONSTRUCTED, 10)) {
				applicationParameters = new UICCApplicationParameters();
				subCodeLength += applicationParameters.decode(is, false);
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
			if (berTag.equals(ProcessData.tag)) {
				processData = new ProcessData();
				subCodeLength += processData.decode(is, false);
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
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
			applicationLoadPackageAID = new ApplicationIdentifier();
			subCodeLength += applicationLoadPackageAID.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
			classAID = new ApplicationIdentifier();
			subCodeLength += classAID.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
			instanceAID = new ApplicationIdentifier();
			subCodeLength += instanceAID.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
			extraditeSecurityDomainAID = new ApplicationIdentifier();
			subCodeLength += extraditeSecurityDomainAID.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			applicationPrivileges = new BerOctetString();
			subCodeLength += applicationPrivileges.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			lifeCycleState = new BerOctetString();
			subCodeLength += lifeCycleState.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 9)) {
			applicationSpecificParametersC9 = new BerOctetString();
			subCodeLength += applicationSpecificParametersC9.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.CONSTRUCTED, 15)) {
			systemSpecificParameters = new ApplicationSystemParameters();
			subCodeLength += systemSpecificParameters.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.CONSTRUCTED, 10)) {
			applicationParameters = new UICCApplicationParameters();
			subCodeLength += applicationParameters.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ProcessData.tag)) {
			processData = new ProcessData();
			subCodeLength += processData.decode(is, false);
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
		sb.append("applicationLoadPackageAID: ").append(applicationLoadPackageAID);
		
		sb.append(", ");
		sb.append("classAID: ").append(classAID);
		
		sb.append(", ");
		sb.append("instanceAID: ").append(instanceAID);
		
		if (extraditeSecurityDomainAID != null) {
			sb.append(", ");
			sb.append("extraditeSecurityDomainAID: ").append(extraditeSecurityDomainAID);
		}
		
		sb.append(", ");
		sb.append("applicationPrivileges: ").append(applicationPrivileges);
		
		if (lifeCycleState != null) {
			sb.append(", ");
			sb.append("lifeCycleState: ").append(lifeCycleState);
		}
		
		sb.append(", ");
		sb.append("applicationSpecificParametersC9: ").append(applicationSpecificParametersC9);
		
		if (systemSpecificParameters != null) {
			sb.append(", ");
			sb.append("systemSpecificParameters: ").append(systemSpecificParameters);
		}
		
		if (applicationParameters != null) {
			sb.append(", ");
			sb.append("applicationParameters: ").append(applicationParameters);
		}
		
		if (processData != null) {
			sb.append(", ");
			sb.append("processData: ").append(processData);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

