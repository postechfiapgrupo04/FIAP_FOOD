package br.com.fiap.fiapfood.core.usecase.usuario;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.gateways.UsuarioRepository;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SalvarUsuarioTest {

    AutoCloseable openMocks;

    @Mock
    private UsuarioRepository usuarioRepository;

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
        UsuarioDomain usuarioDomain = usuarioMock;
        SalvarUsuario salvarUsuario = new SalvarUsuario(usuarioRepository);
        when(salvarUsuario.call(any(UsuarioDomain.class))).thenReturn(usuarioDomain);
        //Act
        UsuarioDomain usuario = salvarUsuario.call(usuarioDomain);
        //Assert
        assertThat(usuarioDomain.getId()).isEqualTo(usuario.getId());
        verify(usuarioRepository, times(1)).salvar(any(UsuarioDomain.class));
    }

    UsuarioDomain usuarioMock = new UsuarioDomain(
            1L,
            "Bruno",
            "bruno@fiap.com",
            "01234567890",
            new ArrayList<>()
    );
}