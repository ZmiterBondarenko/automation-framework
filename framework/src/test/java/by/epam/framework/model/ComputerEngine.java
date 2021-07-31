package by.epam.framework.model;

import java.util.Objects;

public class ComputerEngine {
    private String numberOfInstance;
    private String OSAndSoftware;
    private String machineClass;
    private String machineSeries;
    private String machineType;
    private String numberOfGPUs;
    private String gpuType;
    private String localSSD;
    private String dataCenterLocation;
    private String committedUsage;

    public ComputerEngine (String numberOfInstance,
                           String OSAndSoftware,
                           String machineClass,
                           String machineSeries,
                           String machineType,
                           String numberOfGPUs,
                           String gpuType,
                           String localSSD,
                           String dataCenterLocation,
                           String committedUsage){
        this.numberOfInstance = numberOfInstance;
        this.OSAndSoftware = OSAndSoftware;
        this.machineClass = machineClass;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.numberOfGPUs = numberOfGPUs;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstance() {
        return numberOfInstance;
    }

    public String getOSAndSoftware() {
        return OSAndSoftware;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    @Override
    public String toString() {
        return "ComputerEngine{" +
                "numberOfInstance='" + numberOfInstance + '\'' +
                ", OSAndSoftware='" + OSAndSoftware + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineSeries='" + machineSeries + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerEngine that = (ComputerEngine) o;
        return numberOfInstance.equals(that.numberOfInstance) && OSAndSoftware.equals(that.OSAndSoftware)
                && machineClass.equals(that.machineClass) && machineSeries.equals(that.machineSeries)
                && machineType.equals(that.machineType) && numberOfGPUs.equals(that.numberOfGPUs)
                && gpuType.equals(that.gpuType) && localSSD.equals(that.localSSD) && dataCenterLocation.equals(that.dataCenterLocation)
                && committedUsage.equals(that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstance, OSAndSoftware, machineClass, machineSeries, machineType, numberOfGPUs, gpuType, localSSD, dataCenterLocation, committedUsage);
    }
}
