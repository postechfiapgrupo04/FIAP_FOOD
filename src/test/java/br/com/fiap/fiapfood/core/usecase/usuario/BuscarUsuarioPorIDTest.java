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

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BuscarUsuarioPorIDTest {

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
        UsuarioDTO usuarioDTO = usuarioMock;
        BuscarUsuarioPorID buscarUsuarioPorID = new BuscarUsuarioPorID(usuarioRepository);
        when(buscarUsuarioPorID.call(anyLong())).thenReturn(UsuarioMapper.toUsuarioDomainFromDTO(usuarioDTO));
        //Act
        UsuarioDomain usuarioDomain = buscarUsuarioPorID.call(1L);

        //Assert
        assertThat(usuarioDTO.getId()).isEqualTo(usuarioDomain.getId());
        verify(usuarioRepository, times(1)).buscarPorId(any(Long.class));
    }

    UsuarioDTO usuarioMock = new UsuarioDTO(
            1L,
            "Bruno",
            "bruno@fiap.com",
            "01234567890",
            new ArrayList<>()
    );


}