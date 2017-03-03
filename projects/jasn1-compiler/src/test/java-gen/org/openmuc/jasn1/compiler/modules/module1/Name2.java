/**
 * This class file was automatically generated by jASN1 v1.7.1 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.modules.module1;

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

import org.openmuc.jasn1.compiler.modules.module2.*;
import org.openmuc.jasn1.compiler.modules.module3.*;

public class Name2 extends Name {

	public Name2() {
	}

	public Name2(byte[] code) {
		super(code);
	}

	public Name2(BerVisibleString givenName, BerVisibleString initial, BerVisibleString familyName) {
		super(givenName, initial, familyName);
	}

}
