package org.jtester.json.decoder.single;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import org.jtester.json.JSON;
import org.jtester.json.helper.JSONFeature;
import org.jtester.json.helper.JSONMap;
import org.jtester.testng.JTester;
import org.testng.annotations.Test;

@Test(groups = { "jtester", "json" })
public class AtomicBooleanDecoderTest extends JTester {
	public void testAtomicBool() {
		AtomicBoolean expected = new AtomicBoolean(true);
		JSONMap json = new JSONMap() {
			private static final long serialVersionUID = 1L;

			{
				this.putJSON(JSONFeature.ValueFlag, 1);
			}
		};

		AtomicBoolean bool = JSON.toObject(json, AtomicBoolean.class, new HashMap<String, Object>());
		want.object(bool).reflectionEq(expected);
	}

	public void testAtomicBool_JSONString() {
		AtomicBoolean expected = new AtomicBoolean(true);

		AtomicBoolean bool = JSON.toObject("{'" + JSONFeature.ValueFlag + "':1}", AtomicBoolean.class);
		want.object(bool).reflectionEq(expected);
	}
}
