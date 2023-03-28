package com.example.c2s3mc;


import com.example.c2s3mc.domain.Artist;
import com.example.c2s3mc.domain.Music;
import com.example.c2s3mc.exception.MusicAlreadyExistException;
import com.example.c2s3mc.exception.MusicNotFound;
import com.example.c2s3mc.repository.MusicRepository;
import com.example.c2s3mc.services.MusicServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    private MusicRepository customerRepository;

    @InjectMocks
    private MusicServiceImpl customerService;



    private Music customer1, customer2;
    List<Music> customerList;
    Artist address1,address2;


    @BeforeEach
    void setUp() {
        address1 = new Artist(0111,"state1");
        customer1 = new Music(1001,"Johny",8,address1);
        address2 = new Artist(12345,"state2");
        customer2 = new Music(10034,"Joh4r",5,address2);
        customerList = Arrays.asList(customer1,customer2);
    }

    @AfterEach
    void tearDown() {
        customer1=null;
        customer2 = null;
    }
    @Test
    public void givenCustomerToSaveReturnSavedCustomerSuccess() throws MusicNotFound {
        when(customerRepository.findById(customer1.getTrackId())).thenReturn(Optional.ofNullable(null));
        when(customerRepository.save(any())).thenReturn(customer1);
        assertEquals(customer1,customerService.saveMusic(customer1));
        verify(customerRepository,times(1)).save(any());
        verify(customerRepository,times(1)).findById(any());
    }



    @Test
    public void givenCustomerToSaveReturnCustomerFailure(){
        when(customerRepository.findById(customer1.getTrackId())).thenReturn(Optional.ofNullable(customer1));
        assertThrows(MusicAlreadyExistException.class,()->customerService.saveMusic(customer1));
        verify(customerRepository,times(0)).save(any());
        verify(customerRepository,times(1)).findById(any());
    }

    @Test
    public void givenCustomerToDeleteShouldDeleteSuccess() throws MusicNotFound {
        when(customerRepository.findById(customer1.getTrackId())).thenReturn(Optional.ofNullable(customer1));
        boolean flag = customerService.deleteMusic(customer1.getTrackId());
        assertEquals(true,flag);

        verify(customerRepository,times(1)).deleteById(any());
        verify(customerRepository,times(1)).findById(any());
    }
}
