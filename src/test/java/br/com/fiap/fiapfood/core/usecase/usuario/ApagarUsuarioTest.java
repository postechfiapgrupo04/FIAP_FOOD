package br.com.fiap.fiapfood.core.usecase.usuario;

import br.com.fiap.fiapfood.core.gateways.UsuarioRepository;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import br.com.fiap.fiapfood.entrypoint.api.mapper.UsuarioMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class ApagarUsuarioTest {

    AutoCloseable openMocks;

    @Mock
    private ApagarUsuario apagarUsuario;

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
        UsuarioDTO usuarioDTO = usuarioMock;
        doNothing().when(apagarUsuario).call(anyLong());
        //Act
        apagarUsuario.call(usuarioDTO.getId());
        //Assert
        verify(apagarUsuario, times(1)).call(anyLong());
    }

    UsuarioDTO usuarioMock = new UsuarioDTO(
            1L,
            "Bruno",
            "bruno@fiap.com",
            "01234567890",
            new ArrayList<>()
    );
}