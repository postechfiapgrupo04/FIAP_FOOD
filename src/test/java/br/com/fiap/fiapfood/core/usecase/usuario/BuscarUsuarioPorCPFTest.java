package br.com.fiap.fiapfood.core.usecase.usuario;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class BuscarUsuarioPorCPFTest {

    AutoCloseable openMocks;

    @Mock
    private BuscarUsuarioPorCPF buscarUsuarioPorCPF;

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
        when(buscarUsuarioPorCPF.call(anyString())).thenReturn(usuarioDomain);
        //Act
        UsuarioDomain usuario = buscarUsuarioPorCPF.call(usuarioDomain.getCpf());
        //Assert
        assertThat(usuario).isEqualTo(usuarioDomain);
        assertThat(usuario.getCpf()).isEqualTo(usuarioDomain.getCpf());
        verify(buscarUsuarioPorCPF, times(1)).call(anyString());
    }

    UsuarioDomain usuarioMock = new UsuarioDomain(
            2L,
            "Milton",
            "milton@fiap.com",
            "01234567891",
            new ArrayList<>()
    );
}