package com.example.springdataxml.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement (name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserExportRootDto {
    @XmlElement(name = "user")
    private List<UserExportDto> users;

    public List<UserExportDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserExportDto> users) {
        this.users = users;
    }
}
