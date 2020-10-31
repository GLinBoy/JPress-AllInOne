package com.glinboy.jpress.util;

public final class CommonUtils {
	
	public static final String ClacSlug(String title) {
		return title.replaceAll("[^a-zA-Z0-9\\s]", "")
				.strip()
				.replaceAll("\\s+"," ")
				.replaceAll(" ","-")
				.toLowerCase();
	}

}
