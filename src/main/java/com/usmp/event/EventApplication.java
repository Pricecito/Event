package com.usmp.event;

import java.time.LocalDate;
import java.util.Set;

import com.usmp.event.persistence.models.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.usmp.event.persistence.models.Roles;
import com.usmp.event.persistence.models.Users;
import com.usmp.event.service.UserService.UserService;

@SpringBootApplication
public class EventApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
	}

	@Bean

	CommandLineRunner init(UserService service) {
		return args -> {

			Permissions crearEvento = Permissions.builder()
					.permissionEnum(PermissionEnum.CREAR_EVENTO)
					.build();

			Permissions editarEvento = Permissions.builder()
					.permissionEnum(PermissionEnum.EDITAR_EVENTO)
					.build();

			Permissions eliminarEvento = Permissions.builder()
					.permissionEnum(PermissionEnum.ELIMINAR_EVENTO)
					.build();

			Permissions verEvento = Permissions.builder()
					.permissionEnum(PermissionEnum.VER_EVENTO)
					.build();

			Permissions crearUsuario = Permissions.builder()
					.permissionEnum(PermissionEnum.CREAR_USUARIO)
					.build();

			Permissions gestionarUsuario = Permissions.builder()
					.permissionEnum(PermissionEnum.GESTIONAR_USUARIO)
					.build();

			Permissions eliminarUsuario = Permissions.builder()
					.permissionEnum(PermissionEnum.ELIMINAR_USUARIO)
					.build();

			Permissions verUsuario = Permissions.builder()
					.permissionEnum(PermissionEnum.VER_USUARIOS)
					.build();
			Permissions valorarEvento = Permissions.builder()
					.permissionEnum(PermissionEnum.VALORAR_EVENTO)
					.build();

			Roles adminRol = Roles.builder()
					.rolEnum(RolesEnum.ADMINISTRADOR)
					.permisos(Set.of(
							crearEvento,
							editarEvento,
							eliminarEvento,
							verEvento,
							verUsuario))
					.build();

			Roles developerRol = Roles.builder()
					.rolEnum(RolesEnum.DESARROLLADOR)
					.permisos(Set.of(
							crearEvento,
							editarEvento,
							eliminarEvento,
							verEvento,
							crearUsuario,
							eliminarUsuario,
							gestionarUsuario,
							verUsuario))
					.build();

			Roles userRol = Roles.builder()
					.rolEnum(RolesEnum.USUARIO)
					.permisos(Set.of(verEvento, valorarEvento))
					.build();

			Roles visitorRol = Roles.builder()
					.rolEnum(RolesEnum.VISITANTE)
					.permisos(Set.of(verEvento))
					.build();

			Users admin = Users.builder()
					.username("admin")
					.email("admin@gmail.com")
					.password("1254")
					.dni("72412912")
					.fechaNacimiento(LocalDate.of(2005, 1, 31).toString())
					.roles(Set.of(adminRol))
					.build();

					service.saveOrUpdateUser(admin);

		};
	}

}
