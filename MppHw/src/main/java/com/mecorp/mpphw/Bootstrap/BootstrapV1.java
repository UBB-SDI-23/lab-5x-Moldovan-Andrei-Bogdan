package com.mecorp.mpphw.Bootstrap;
import com.mecorp.mpphw.Domain.*;
import com.mecorp.mpphw.Repository.CarDealershipRepository;
import com.mecorp.mpphw.Repository.CarPartRepository;
import com.mecorp.mpphw.Repository.CarRepository;
import com.mecorp.mpphw.Repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapV1 implements CommandLineRunner {
    private final CarRepository carRepository;
    private final MechanicRepository mechanicRepository;

    private final CarPartRepository carPartRepository;

    private final CarDealershipRepository carDealershipRepository;

    @Autowired
    public BootstrapV1(CarRepository carRepository, MechanicRepository mechanicRepository, CarPartRepository carPartRepository, CarDealershipRepository carDealershipRepository) {
        this.carRepository = carRepository;
        this.mechanicRepository = mechanicRepository;
        this.carPartRepository = carPartRepository;
        this.carDealershipRepository = carDealershipRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        /MECHANIC PART
//        Mechanic mechanic1 = new Mechanic("Silviu", "Zaharia", "Bmw", "12.12.2019", 9000);
//        Mechanic mechanic2 = new Mechanic("Andrei", "Moldovan", "Audi", "12.11.2018", 10500);
//        Mechanic mechanic3 = new Mechanic("Andrei", "Saguna", "Volvo", "12.10.2017", 5400);
//        Mechanic mechanic4 = new Mechanic("Liviu", "Teodor", "Volkswagen", "10.10.2020", 5000);
//        Mechanic mechanic5 = new Mechanic("Flavius", "Zaharia", "Peugeot", "08.09.2021", 4300);
//        Mechanic mechanic6 = new Mechanic("Daniel", "Sucevescu", "Dacia", "05.06.2015", 3400);
//        Mechanic mechanic7 = new Mechanic("Marius", "Andreescu", "Hyundai", "03.04.2012", 3700);
//        Mechanic mechanic8 = new Mechanic("Marius", "Popescu", "Mercedes", "01.01.2014", 7000);
//        Mechanic mechanic9 = new Mechanic("Gheorghe", "Crisan", "Ford", "03.04.2010", 5000);
//        Mechanic mechanic10 = new Mechanic("Adrian", "Cozma", "Opel", "12.12.2019", 5250);
//        this.mechanicRepository.save(mechanic1);
//        this.mechanicRepository.save(mechanic2);
//        this.mechanicRepository.save(mechanic3);
//        this.mechanicRepository.save(mechanic4);
//        this.mechanicRepository.save(mechanic5);
//        this.mechanicRepository.save(mechanic6);
//        this.mechanicRepository.save(mechanic7);
//        this.mechanicRepository.save(mechanic8);
//        this.mechanicRepository.save(mechanic9);
//        this.mechanicRepository.save(mechanic10);
//
//        ///CAR PART
//        Car car1 = new Car(3000, "I6", 320, "Bmw", "E60", "Black");
//        car1.setMechanic(mechanic1);
//        Car car2 = new Car(3000, "I6", 350, "Bmw", "F10", "White");
//        car2.setMechanic(mechanic1);
//        Car car3 = new Car(3000, "V6", 370, "Audi", "A5", "Yellow");
//        car3.setMechanic(mechanic2);
//        Car car4 = new Car(4500, "V8", 520, "Audi", "RS7", "Black");
//        car4.setMechanic(mechanic2);
//        Car car5 = new Car(2500, "I4", 260, "Volvo", "CX60", "Gray");
//        car5.setMechanic(mechanic3);
//        Car car6 = new Car(2000, "I4", 300, "Volkswagen", "Golf GTI", "Blue");
//        car6.setMechanic(mechanic4);
//        Car car7 = new Car(1500, "I4", 130, "Peugeot", "2008", "Red");
//        car7.setMechanic(mechanic5);
//        Car car8 = new Car(900, "I3", 90, "Dacia", "Logan", "White");
//        car8.setMechanic(mechanic6);
//        Car car9 = new Car(2000, "I4", 155, "Hyundai", "Tucson", "Black");
//        car9.setMechanic(mechanic7);
//        Car car10 = new Car(4800, "V8", 540, "Mercedes", "C63 AMG", "Black");
//        car10.setMechanic(mechanic8);
//        this.carRepository.save(car1);
//        this.carRepository.save(car2);
//        this.carRepository.save(car3);
//        this.carRepository.save(car4);
//        this.carRepository.save(car5);
//        this.carRepository.save(car6);
//        this.carRepository.save(car7);
//        this.carRepository.save(car8);
//        this.carRepository.save(car9);
//        this.carRepository.save(car10);
//
//        ///CAR-DEALERSHIP PART
//        CarDealership carDealership1 = new CarDealership("Bavaria Automobile", "+40123456789", "bvaut@gmail.com", 1998, "Str.Teiului 8");
//        CarDealership carDealership2 = new CarDealership("AutoWorld Audi", "+40123444333", "autowrldaudi@gmail.com", 1995, "Str.Teiului 12");
//        CarDealership carDealership3 = new CarDealership("Volvo Sweden", "+40123456999", "volvoswd@gmail.com", 1978, "Str.Albului 4");
//        CarDealership carDealership4 = new CarDealership("AutoWorld Volkswagen", "+40123456789", "autoworldvw@gmail.com", 1998, "Str.Maris 24");
//        CarDealership carDealership5 = new CarDealership("Peugeot Cluj", "+40123456222", "peugeotclj@gmail.com", 2004, "Str.Calea Turzii 29");
//        CarDealership carDealership6 = new CarDealership("Dacia Cluj", "+40123456111", "daciacj@gmail.com", 2007, "Str.Muncii 4");
//        CarDealership carDealership7 = new CarDealership("Hyundai Romania", "+40123456000", "hyro@gmail.com", 2010, "Str.Teodor Mihali 34");
//        CarDealership carDealership8 = new CarDealership("Mercedes AMG", "+40123456122", "merc-amg@gmail.com", 1980, "Str.Calea Dorobanti 76");
//        CarDealership carDealership9 = new CarDealership("Neste Automotive", "+40123456311", "neste@gmail.com", 1994, "Str.Micul Paris 26");
//        CarDealership carDealership10 = new CarDealership("Opel Auto", "+40123456212", "opel-auto@gmail.com", 2007, "Str. Militari 14");
//        this.carDealershipRepository.save(carDealership1);
//        this.carDealershipRepository.save(carDealership2);
//        this.carDealershipRepository.save(carDealership3);
//        this.carDealershipRepository.save(carDealership4);
//        this.carDealershipRepository.save(carDealership5);
//        this.carDealershipRepository.save(carDealership6);
//        this.carDealershipRepository.save(carDealership7);
//        this.carDealershipRepository.save(carDealership8);
//        this.carDealershipRepository.save(carDealership9);
//        this.carDealershipRepository.save(carDealership10);
//
//        ///CAR-PART PART
//        CarPart carPart1 = new CarPart("HKS Turbo", 1992);
//        CarPart carPart2 = new CarPart("HKS Intercooler", 1992);
//        CarPart carPart3 = new CarPart("HKS BlowOff Valve", 1994);
//        CarPart carPart4 = new CarPart("Sparco seats", 1980);
//        CarPart carPart5 = new CarPart("Sparco belts", 1978);
//        CarPart carPart6 = new CarPart("Kenwood Stereo", 1993);
//        CarPart carPart7 = new CarPart("Brembo Breaks", 1990);
//        CarPart carPart8 = new CarPart("HKS Filter", 2004);
//        CarPart carPart9 = new CarPart("B&O Audio System", 2010);
//        CarPart carPart10 = new CarPart("Harmann Kardon Audio System", 2008);
//        this.carPartRepository.save(carPart1);
//        this.carPartRepository.save(carPart2);
//        this.carPartRepository.save(carPart3);
//        this.carPartRepository.save(carPart4);
//        this.carPartRepository.save(carPart5);
//        this.carPartRepository.save(carPart6);
//        this.carPartRepository.save(carPart7);
//        this.carPartRepository.save(carPart8);
//        this.carPartRepository.save(carPart9);
//        this.carPartRepository.save(carPart10);
    }
}
