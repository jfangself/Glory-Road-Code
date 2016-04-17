package com.kernel.util;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import android.os.Environment;
import de.mindpipe.android.logging.log4j.LogConfigurator;

public class LogUtil {
	private static Logger logger;

	private static boolean configured = false;

	private LogUtil() {
		throw new AssertionError();
	}

	public static void setLogger(String pkg) {
		final LogConfigurator logConfigurator = new LogConfigurator();

		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			logConfigurator.setFileName(Environment
					.getExternalStorageDirectory() + "/Athrun/test.log");
		} else {
			String path = "/data/data/" + pkg + "/files/Athrun";
			File file = new File(path);
			if (!file.exists()) {
				file.mkdir();
			}
			logConfigurator.setFileName(path + "/test.log");
		}
		logConfigurator.setRootLevel(Level.INFO);
		logConfigurator.configure();
		configured = true;
	}

	public static Logger getLogger(Class<?> clazz) {
		if (!configured) {
			throw new AssertionError("not configured");
		}
		logger = Logger.getLogger(clazz);
		return logger;
	}
}
