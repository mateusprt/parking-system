package com.parking.mappers;

import com.parking.dtos.role.RoleDto;
import com.parking.models.Role;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T13:13:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
*/
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role dtoToRole(RoleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setName( dto.getName() );

        return role;
    }

    @Override
    public RoleDto roleToDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setName( role.getName() );

        return roleDto;
    }
}
