package br.com.fiap.fiapfood.entrypoint.api;

import br.com.fiap.fiapfood.core.gateways.UsuarioRepository;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import br.com.fiap.fiapfood.entrypoint.facade.UsuarioFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioRestController.class)
class UsuarioRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioFacade usuarioFacade;

    @MockBean
    private UsuarioRepository usuarioRepository;

    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule()); // Registrando o módulo

    private String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void salvar() throws Exception {
        //Arrange
        UsuarioDTO usuarioDTO = new UsuarioDTO(1L, "Bruno", "bruno@fiap.com", "01234567890", null);
        when(usuarioFacade.salvar(any(UsuarioDTO.class))).thenReturn(usuarioDTO);
        //Act & Assert
        mockMvc.perform(post("/usuario").contentType(MediaType.APPLICATION_JSON).content(asJsonString(usuarioDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void buscarPorId() throws Exception {
        //Arrange
        when(usuarioFacade.buscarPorId(anyLong())).thenReturn(new UsuarioDTO(1L, "Bruno", "bruno@fiap.com", "01234567890", null));
        //Act & Assert
        mockMvc.perform(get("/usuario/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Bruno")))
                .andExpect(jsonPath("$.email", is("bruno@fiap.com")))
                .andExpect(jsonPath("$.cpf", is("01234567890")));
    }

    @Test
    void buscarTodos() throws Exception {
        //Arrange
        UsuarioDTO usuario1 = new UsuarioDTO(1L, "Bruno", "bruno@fiap.com", "01234567890", new ArrayList<>());
        UsuarioDTO usuario2 = new UsuarioDTO(2L, "Milton", "milton@fiap.com", "01234567891", new ArrayList<>());
        List<UsuarioDTO> usuarios = Arrays.asList(usuario1, usuario2);
        when(usuarioFacade.buscarTodos()).thenReturn(usuarios);

        //Act & Assert
        mockMvc.perform(get("/usuario").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("Bruno")))
                .andExpect(jsonPath("$[0].email", is("bruno@fiap.com")))
                .andExpect(jsonPath("$[0].cpf", is("01234567890")))

                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nome", is("Milton")))
                .andExpect(jsonPath("$[1].email", is("milton@fiap.com")))
                .andExpect(jsonPath("$[1].cpf", is("01234567891")));
    }

    @Test
    void buscarPorCPF() throws Exception {
        //Arrange
        UsuarioDTO usuarioDTO = new UsuarioDTO(1L, "Bruno", "bruno@fiap.com", "01234567890", null);
        when(usuarioFacade.buscarPorCPF(anyString())).thenReturn(usuarioDTO);
        //Act & Assert
        mockMvc.perform(get("/usuario/cpf/01234567890").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Bruno")))
                .andExpect(jsonPath("$.email", is("bruno@fiap.com")))
                .andExpect(jsonPath("$.cpf", is("01234567890")));
    }

    @Test
    void apagar() throws Exception {
        //Arrange
        doNothing().when(usuarioFacade).apagar(1L);

        //Act & Assert
        mockMvc.perform(delete("/usuario/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}