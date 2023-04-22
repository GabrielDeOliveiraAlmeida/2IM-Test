package com.example.api2im.domain.type;


public enum ExperienceType {
    HIGHLY_EXPERIENCED("muito_experiente"),
    EXPERIENCED("experiente"),
    NORMAL("alguma_experiencia"),
    NONE("nenhuma_experiencia");

    private final String text;
    ExperienceType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
