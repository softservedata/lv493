package com.softserve.edu.greencity.rest.data.econews;

public class FileUploadParameters {
    private String name;
    private String filename;
    private String filepath;

    public FileUploadParameters(String name, String filename, String filepath) {
        this.name = name;
        this.filename = filename;
        this.filepath = filepath;
        if (filepath.contains("/") || filepath.contains("\\")) {
            this.filepath = filepath;
        } else {
            this.filepath = FileUploadParameters.class.getResource("/" + filepath).getPath();
        }
    }

    public String getName() {
        return name;
    }
    public String getFilename() {
        return filename;
    }
    public String getFilepath() {
        return filepath;
    }

    @Override
    public String toString() {
        return "FileUploadParameters{" +
                "name='" + name + '\'' +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                '}';
    }
}
