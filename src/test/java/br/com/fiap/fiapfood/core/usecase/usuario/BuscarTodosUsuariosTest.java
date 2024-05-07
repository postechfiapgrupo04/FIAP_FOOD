package br.com.fiap.fiapfood.core.usecase.usuario;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.gateways.UsuarioRepository;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import br.com.fiap.fiapfood.entrypoint.api.mapper.UsuarioMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarTodosUsuariosTest {

    AutoCloseable openMocks;

    @Mock
    private BuscarTodosUsuarios buscarTodosUsuarios;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void call() {
        //Arrange
        List<UsuarioDomain> usuariosList = Arrays.asList(
                usuario1,
                usuario2
        );
        when(buscarTodosUsuarios.call()).thenReturn(usuariosList);

        //Act
        List<UsuarioDomain> usuarioDomainList = buscarTodosUsuarios.call();

        //Assert
        assertThat(usuarioDomainList)
                .hasSize(2)
                .containsExactlyInAnyOrder(usuario1, usuario2);

        verify(buscarTodosUsuarios, times(1)).call();

    }
    UsuarioDomain usuario1 = new UsuarioDomain(
            1L,
            "Bruno",
            "bruno@fiap.com",
            "01234567890",
            new ArrayList<>()
    );

    UsuarioDomain usuario2 = new UsuarioDomain(
            2L,
            "Milton",
            "milton@fiap.com",
            "01234567891",
            new ArrayList<>()
    );
}