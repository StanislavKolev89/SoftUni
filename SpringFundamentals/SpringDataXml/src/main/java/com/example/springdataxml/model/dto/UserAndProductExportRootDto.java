package com.example.springdataxml.model.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement (name = "users")
@XmlAccessorType(XmlAccessType.FIELD)

public class UserAndProductExportRootDto {
    @XmlAttribute(name = "count")
    private int count;

    @XmlElement(name = "user")
    private List<UserAndProductExportDto> users;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<UserAndProductExportDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserAndProductExportDto> users) {
        this.users = users;
    }


}
