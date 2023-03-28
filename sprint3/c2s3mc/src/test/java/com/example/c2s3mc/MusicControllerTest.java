package com.example.c2s3mc;

import com.example.c2s3mc.controller.MusicController;
import com.example.c2s3mc.domain.Artist;
import com.example.c2s3mc.domain.Music;
import com.example.c2s3mc.exception.MusicAlreadyExistException;
import com.example.c2s3mc.services.MusicServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(MockitoExtension.class)
public class MusicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MusicServiceImpl customerService;

    @InjectMocks
    private MusicController customerController;
    private Music customer1, customer2;
    private Artist address1 , address2;
    List<Music> customerList;

    @BeforeEach
    void setUp() {
        address1 = new Artist(1234,"state1");
        customer1 = new Music(1001,"Johny",5,address1);
        address2 = new Artist(1010,"state2");
        customer2 = new Music(1002,"Harry",7,address2);
        customerList = Arrays.asList(customer1,customer2);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @AfterEach
    void tearDown() {
        customer1=null;
        customer2 = null;
    }
    @Test
    public void givenCustomerToSaveReturnSavedCustomer() throws Exception {
        when(customerService.saveMusic(any())).thenReturn(customer1);
        mockMvc.perform(post("/api/v1/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(customer1)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
        verify(customerService,times(1)).saveMusic(any());

    }
    @Test
    public void givenCustomerToSaveReturnSavedCustomerFailure() throws Exception {
        when(customerService.saveMusic(any())).thenThrow(MusicAlreadyExistException.class);
        mockMvc.perform(post("/api/v1/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(customer1)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(customerService,times(1)).saveMusic(any());

    }
    @Test
    public void givenCustomerIdDeleteCustomer() throws Exception {
        when(customerService.deleteMusic(anyInt())).thenReturn(true);
        mockMvc.perform(delete("/api/v1/customer/1001")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(customerService,times(1)).deleteMusic(anyInt());

    }

    private static String jsonToString(final Object ob) throws JsonProcessingException {
        String result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(ob);
            result = jsonContent;
        } catch(JsonProcessingException e) {
            result = "JSON processing error";
        }

        return result;
    }

}


