package com.mecorp.mpphw.Service;

import com.mecorp.mpphw.Api.Mapper.CarDealershipMapper;
import com.mecorp.mpphw.Api.Model.V1.CarDealershipNewestPartsReportDTO;
import com.mecorp.mpphw.Domain.CarDealership;
import com.mecorp.mpphw.Domain.CarPart;
import com.mecorp.mpphw.Domain.CarPart_CarDealership;
import com.mecorp.mpphw.Repository.CarDealershipRepository;
import com.mecorp.mpphw.Repository.CarPartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CarDealershipServiceTest {
    @Mock
    private CarDealershipRepository carDealershipRepository;
    @Mock
    private CarPartRepository carPartRepository;
    @Mock
    private CarDealershipMapper carDealershipMapper;

    private CarDealershipService carDealershipService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        carDealershipService = new CarDealershipService(carDealershipRepository, carPartRepository, carDealershipMapper);
    }

    @Test
    void computeNewestPartsReport() {
        ///given
        List<CarDealership> carDealerships = new ArrayList<>();

        ///____________CarDealership1_________________///
        CarDealership carDealership1 = new CarDealership();
        carDealership1.setId(1);
        CarPart carPart1D1 = new CarPart();
        carPart1D1.setYearAppeared(1997);
        carPart1D1.setId(11);
        CarPart carPart2D1 = new CarPart();
        carPart2D1.setYearAppeared(1994);
        carPart2D1.setId(12);
        List<CarPart_CarDealership> carPart_carDealershipsD1 = new ArrayList<>();
        CarPart_CarDealership carPart_carDealership1D1 = new CarPart_CarDealership();
        carPart_carDealership1D1.setCarPart(carPart1D1);
        CarPart_CarDealership carPart_carDealership2D1 = new CarPart_CarDealership();
        carPart_carDealership2D1.setCarPart(carPart2D1);
        carPart_carDealershipsD1.add(carPart_carDealership1D1);
        carPart_carDealershipsD1.add(carPart_carDealership2D1);
        carDealership1.setCarParts(carPart_carDealershipsD1);
        ///____________________________________________///

        ///_____________CarDealership2____________________///
        CarDealership carDealership2 = new CarDealership();
        carDealership2.setId(2);
        CarPart carPart1D2 = new CarPart();
        carPart1D2.setYearAppeared(2000);
        carPart1D2.setId(21);
        CarPart carPart2D2 = new CarPart();
        carPart2D2.setYearAppeared(2005);
        carPart2D2.setId(22);
        List<CarPart_CarDealership> carPart_carDealershipsD2 = new ArrayList<>();
        CarPart_CarDealership carPart_carDealership1D2 = new CarPart_CarDealership();
        carPart_carDealership1D2.setCarPart(carPart1D2);
        CarPart_CarDealership carPart_carDealership2D2 = new CarPart_CarDealership();
        carPart_carDealership2D2.setCarPart(carPart2D2);
        carPart_carDealershipsD2.add(carPart_carDealership1D2);
        carPart_carDealershipsD2.add(carPart_carDealership2D2);
        carDealership2.setCarParts(carPart_carDealershipsD2);
        ///_____________________________________________///
        carDealerships.add(carDealership1);
        carDealerships.add(carDealership2);

        when(carDealershipRepository.findAll()).thenReturn(carDealerships);


        ///when
        List<CarDealershipNewestPartsReportDTO> result = carDealershipService.computeNewestPartsReport();

        ///then
        assertEquals(2, result.size());
        assertEquals(2, result.get(0).getId());
        assertEquals(1, result.get(1).getId());
        assertEquals(1995, result.get(1).getPartsAppearYearAverage());
        assertEquals(2002, result.get(0).getPartsAppearYearAverage());
    }
}