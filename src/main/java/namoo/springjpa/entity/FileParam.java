package namoo.springjpa.entity;

public class FileParam {
	private String fileName;
	private String originalFileName;
	private String contentType;
	
	public FileParam() {}
	
	public FileParam(String fileName, String originalFileName, String contentType) {
		this.fileName = fileName;
		this.originalFileName = originalFileName;
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "FileParam [fileName=" + fileName + ", originalFileName=" + originalFileName + ", contentType="
				+ contentType + "]";
	}

}
