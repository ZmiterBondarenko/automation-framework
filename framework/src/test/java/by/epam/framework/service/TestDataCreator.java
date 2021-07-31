package by.epam.framework.service;

import by.epam.framework.model.ComputerEngine;

public class TestDataCreator {
    private static final String NUMBER_OF_INSTANCE = "calc.numberOfInstances";
    private static final String OS_AND_SOFTWARE = "calc.operatingSystem";
    private static final String MACHINE_CLASS = "calc.machineClass";
    private static final String MACHINE_SERIES = "calc.machineSeries";
    private static final String MACHINE_TYPE = "calc.machineType";
    private static final String NUMBER_OF_GPUS = "calc.numberOfGPUs";
    private static final String GPU_TYPE = "calc.gpuType";
    private static final String LOCAL_SSD = "calc.localSSD";
    private static final String DATA_CENTER_LOCATION = "calc.datacenterLocation";
    private static final String COMMITED_USAGE = "calc.committedUsage";


    public static ComputerEngine getTestingData() {
        return new ComputerEngine(TestDataReader.getTestData(NUMBER_OF_INSTANCE),
                TestDataReader.getTestData(OS_AND_SOFTWARE),
                TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_SERIES),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATA_CENTER_LOCATION),
                TestDataReader.getTestData(COMMITED_USAGE));
    }
}
