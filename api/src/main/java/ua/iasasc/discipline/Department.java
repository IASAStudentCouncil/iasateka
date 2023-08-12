package ua.iasasc.discipline;

public enum Department {
    SD("Кафедра системного проектування"),
    MMSA("Кафедра математичних методів системного аналізу"),
    AI("Кафедра штучного інтелекту");

    private final String fullName;

    Department(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
