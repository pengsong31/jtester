/*
 * Copyright 2003 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ext.jtester.cglib.core;

import java.util.ArrayList;
import java.util.List;

import ext.jtester.asm.ClassAdapter;
import ext.jtester.asm.ClassReader;

// TODO: optimize (ClassReader buffers entire class before accept)
@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
public class ClassNameReader {
	private ClassNameReader() {
	}

	private static final EarlyExitException EARLY_EXIT = new EarlyExitException();

	private static class EarlyExitException extends RuntimeException {
	}

	public static String getClassName(ClassReader r) {

		return getClassInfo(r)[0];

	}

	public static String[] getClassInfo(ClassReader r) {
		final List array = new ArrayList();
		try {
			r.accept(new ClassAdapter(null) {
				public void visit(int version, int access, String name, String signature, String superName,
						String[] interfaces) {
					array.add(name.replace('/', '.'));
					if (superName != null) {
						array.add(superName.replace('/', '.'));
					}
					for (int i = 0; i < interfaces.length; i++) {
						array.add(interfaces[i].replace('/', '.'));
					}

					throw EARLY_EXIT;
				}
			}, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
		} catch (EarlyExitException e) {
		}

		return (String[]) array.toArray(new String[] {});
	}
}
