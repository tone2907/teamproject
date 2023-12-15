package com.example.demo.DTO;

import com.example.demo.entity.MembersEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long member;
    private String password;
    private String tel;
    private String email;
    private String name;
    private Role role;

    public MembersEntity toEntity(){
        MembersEntity members = MembersEntity.builder()
                .member(member)
                .password(password)
                .tel(tel)
                .email(email)
                .name(name)
                .role(role)
                .build();
        return members;
    }
}
