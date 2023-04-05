export interface Mechanic {
    id: number;
    firstName: string;
    secondName: string;
    brandExpertise: string;
    dateHired: string;
    salary: number;
}

export interface MechanicEntityDTO {
    firstName: string;
    secondName: string;
    brandExpertise: string;
    dateHired: string;
    salary: number;
}

export interface Car {
    id: number;
    engineCC: number;
    engineType: string;
    engineHP: number;
    brand: string;
    model: string;
    color: string;
}

export interface MechanicWithCars {
    id: number;
    firstName: string;
    secondName: string;
    brandExpertise: string;
    dateHired: string;
    salary: number;
    carEntityDTOList: Array<Car>;
}