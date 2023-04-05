package com.mecorp.mpphw.Controller;

import com.mecorp.mpphw.Api.Model.V1.MechanicEntityDTO;
import com.mecorp.mpphw.Service.MechanicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MechanicControllerTest {

    @Mock
    MechanicService mechanicService;

    MechanicController mechanicController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mechanicController = new MechanicController(mechanicService);
    }

    @Test
    void getFilteredMechanics() {
        ///given
        Integer filterSalaryValue = 3000;
        List<MechanicEntityDTO> mechanicEntityDTOS = new ArrayList<>();
        MechanicEntityDTO mechanicEntityDTO = new MechanicEntityDTO();
        mechanicEntityDTOS.add(mechanicEntityDTO);
        when(mechanicService.getFilteredMechanics(filterSalaryValue)).thenReturn(mechanicEntityDTOS);

        ///when
        List<MechanicEntityDTO> result = mechanicService.getFilteredMechanics(filterSalaryValue);

        ///then
        assertEquals(1, result.size());
    }
}