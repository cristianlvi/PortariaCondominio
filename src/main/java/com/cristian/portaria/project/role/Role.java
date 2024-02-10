package com.cristian.portaria.project.role;

public enum Role {

    MORADOR("morador"),
    VISITANTE("visitante"),
    ADMIN("admin");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
