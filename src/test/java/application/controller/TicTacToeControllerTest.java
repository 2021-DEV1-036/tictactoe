package application.controller;

import application.model.GameBoardDto;
import application.service.GameBoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TicTacToeController.class)
class TicTacToeControllerTest {

    public static final String selection = "top-left";
    private ResponseEntity<String> responseFromController;

    @MockBean
    private GameBoardService gameBoardService;
    @MockBean
    private HttpSession httpSession;
    @MockBean
    private BindingResult result;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void sendsBackJsonWithBoardStatusOk() throws Exception {
        GameBoardDto gameBoardDto = new GameBoardDto();
        gameBoardDto.setSelection(selection);;

        mockMvc.perform(put("/play")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(gameBoardDto))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void sendsBackJsonWithBoardStatusBadRequest() throws Exception {
        GameBoardDto gameBoardDto = new GameBoardDto();
        gameBoardDto.setSelection(selection);;

        mockMvc.perform(put("/play")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(selection))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            System.out.println(jsonContent);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}