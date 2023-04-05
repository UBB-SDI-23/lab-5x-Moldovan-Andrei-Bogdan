package com.mecorp.mpphw.Service;

import com.mecorp.mpphw.Api.Mapper.CarMapper;
import com.mecorp.mpphw.Api.Mapper.MechanicMapper;
import com.mecorp.mpphw.Api.Model.V1.MechanicEntityDTO;
import com.mecorp.mpphw.Domain.Mechanic;
import com.mecorp.mpphw.Repository.CarRepository;
import com.mecorp.mpphw.Repository.MechanicRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MechanicServiceTest {

    private MechanicService mechanicService;
    @Mock
    private MechanicRepository mechanicRepository;
    @Mock
    private MechanicMapper mechanicMapper;
    @Mock
    private CarMapper carMapper;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mechanicService = new MechanicService(mechanicMapper, carMapper, mechanicRepository, carRepository);
    }

    @Test
    void getFilteredMechanics() {
        ///given
        List<Mechanic> mechanics = new ArrayList<>();
        Integer filterSalaryValue = 3000;
        Mechanic mechanic1 = new Mechanic("TestFirstName1", "TestSecondName1", "TestBrandExpertise1", "TestDateHired1", 5400);
        mechanic1.setId(1);
        Mechanic mechanic2 = new Mechanic("TestFirstName2", "TestSecondName2", "TestBrandExpertise2", "TestDateHired2", 2100);
        mechanic2.setId(2);
        Mechanic mechanic3 = new Mechanic("TestFirstName3", "TestSecondName3", "TestBrandExpertise3", "TestDateHired3", 3000);
        mechanic1.setId(3);
        mechanics.add(mechanic1);
        mechanics.add(mechanic2);
        mechanics.add(mechanic3);
        when(mechanicRepository.findAll()).thenReturn(mechanics);

        ///when
        List<MechanicEntityDTO> result = mechanicService.getFilteredMechanics(filterSalaryValue);

        ///then
        assertEquals(1, result.size());
        verify(mechanicRepository, times(1)).findAll();
    }
}