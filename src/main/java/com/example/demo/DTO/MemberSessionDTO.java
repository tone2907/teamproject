package com.example.demo.DTO;

import com.example.demo.entity.MembersEntity;
import lombok.Getter;

import javax.management.relation.Role;
import java.io.Serializable;

@Getter
public class MemberSessionDTO implements Serializable {
    private Long memberId;
    private String password;
    private String tel;
    private String email;
    private String name;
    private Boolean delectStatus;
    private Role role;

    public MemberSessionDTO(MembersEntity members){
        this.memberId = members.getMember();
        this.password = members.getPassword();
        this.tel = members.getTel();
        this.email = members.getEmail();
        this.name = members.getName();
        this.delectStatus = members.getDelectStatus();
        this.role = members.getRole();
    }
}
