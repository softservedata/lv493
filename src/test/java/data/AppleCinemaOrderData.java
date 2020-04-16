package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppleCinemaOrderData {

    private String size;
    private String checkbox;
    private String textField;
    private String textAreaField;
    private String uploadFileInputValue;
    private LocalDate dateField;
    private LocalTime timeField;
    private LocalDateTime dateTimeField;
    private String quantityField;
    private Faker faker = new Faker();

    public AppleCinemaOrderData(String size, String checkbox, String uploadFileInputValue) {
        this.size = size;
        this.checkbox = checkbox;
        this.textField = faker.paragraph(1);
        this.textAreaField = faker.paragraph(3);
        this.uploadFileInputValue = uploadFileInputValue;
        this.dateField = LocalDate.now();;
        this.timeField = LocalTime.now();
        this.dateTimeField = LocalDateTime.now();
        this.quantityField = "5";
    }

    public String getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public String getTextAreaField() {
        return textAreaField;
    }

    public void setTextAreaField(String textAreaField) {
        this.textAreaField = textAreaField;
    }

    public String getUploadFileInputValue() {
        return uploadFileInputValue;
    }

    public void setUploadFileInputValue(String uploadFileInputValue) {
        this.uploadFileInputValue = uploadFileInputValue;
    }

    public LocalDate getDateField() {
        return dateField;
    }

    public LocalTime getTimeField() {
        return timeField;
    }

    public LocalDateTime getDateTimeField() {
        return dateTimeField;
    }

    public String getQuantityField() {
        return quantityField;
    }

    public void setQuantityField(String quantityField) {
        this.quantityField = quantityField;
    }
}
