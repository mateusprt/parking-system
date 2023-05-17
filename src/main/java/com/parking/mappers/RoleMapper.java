package com.parking.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.parking.dtos.role.RoleDto;
import com.parking.models.Role;

@Mapper
public interface RoleMapper {
	
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	@Mapping(source = "name", target = "name")
	Role dtoToRole(RoleDto dto);
	
	@Mapping(source = "name", target = "name")
	RoleDto roleToDto(Role role);
}
