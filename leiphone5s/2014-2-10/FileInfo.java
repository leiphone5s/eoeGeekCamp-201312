package se2.day05;

import java.io.Serializable;

public class FileInfo implements Serializable {
	private String fileName;
	private static final long serialVersionUID = 1L;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileInfo(String fileName) {
		this.fileName = fileName;
	}

}
