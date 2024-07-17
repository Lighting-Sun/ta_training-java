package ta.training.model;

import java.util.Objects;

public class CalculatorForm {

    private String numberOfInstances;
    private String operatingSystemSoftware;
    private String provisioningModel;
    private String machineFamily;
    private String series;
    private String machineType;
    private String gpuModel;
    private String numberOfGpus;
    private String localSsd;
    private String region;
    private String committedUseDiscountOptions;
    private String totalEstimatedCost;
    private String expectedMachineType;


    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystemSoftware() {
        return operatingSystemSoftware;
    }

    public void setOperatingSystemSoftware(String operatingSystemSoftware) {
        this.operatingSystemSoftware = operatingSystemSoftware;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    public String getNumberOfGpus() {
        return numberOfGpus;
    }

    public void setNumberOfGpus(String numberOfGpus) {
        this.numberOfGpus = numberOfGpus;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommittedUseDiscountOptions() {
        return committedUseDiscountOptions;
    }

    public void setCommittedUseDiscountOptions(String committedUseDiscountOptions) {
        this.committedUseDiscountOptions = committedUseDiscountOptions;
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCost;
    }

    public void setTotalEstimatedCost(String totalEstimatedCost) {
        this.totalEstimatedCost = totalEstimatedCost;
    }

    public String getExpectedMachineType() {
        return expectedMachineType;
    }

    public void setExpectedMachineType(String expectedMachineType) {
        this.expectedMachineType = expectedMachineType;
    }

    /**
     * Constructs a CalculatorForm with the specified parameters.
     *
     * @param numberOfInstances            the number of instances
     * @param operatingSystemSoftware      the operating system software
     * @param provisioningModel            the provisioning model
     * @param machineFamily                the machine family
     * @param series                       the series
     * @param machineType                  the machine type
     * @param gpuModel                     the GPU model
     * @param numberOfGpus                 the number of GPUs
     * @param localSsd                     the local SSD
     * @param region                       the region
     * @param committedUseDiscountOptions  the committed use discount options
     * @param totalEstimatedCost           the total estimated cost
     * @param expectedMachineType          the expected machine type - this is used for assertions
     */
    public CalculatorForm(String numberOfInstances, String operatingSystemSoftware, String provisioningModel,
                          String machineFamily, String series, String machineType, String gpuModel, String numberOfGpus,
                          String localSsd, String region, String committedUseDiscountOptions,
                          String totalEstimatedCost, String expectedMachineType) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemSoftware = operatingSystemSoftware;
        this.provisioningModel = provisioningModel;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.gpuModel = gpuModel;
        this.numberOfGpus = numberOfGpus;
        this.localSsd = localSsd;
        this.region = region;
        this.committedUseDiscountOptions = committedUseDiscountOptions;
        this.totalEstimatedCost = totalEstimatedCost;
        this.expectedMachineType = expectedMachineType;
    }

    @Override
    public String toString() {
        return "CalculatorForm{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystemSoftware='" + operatingSystemSoftware + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", machineFamily='" + machineFamily + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", gpuModel='" + gpuModel + '\'' +
                ", numberOfGpus='" + numberOfGpus + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", region='" + region + '\'' +
                ", committedUseDiscountOptions='" + committedUseDiscountOptions + '\'' +
                ", totalEstimatedCost='" + totalEstimatedCost + '\'' +
                ", expectedMachineType='" + expectedMachineType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorForm that = (CalculatorForm) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances)
                && Objects.equals(operatingSystemSoftware, that.operatingSystemSoftware)
                && Objects.equals(provisioningModel, that.provisioningModel)
                && Objects.equals(machineFamily, that.machineFamily)
                && Objects.equals(series, that.series)
                && Objects.equals(machineType, that.machineType)
                && Objects.equals(gpuModel, that.gpuModel)
                && Objects.equals(numberOfGpus, that.numberOfGpus)
                && Objects.equals(localSsd, that.localSsd)
                && Objects.equals(region, that.region)
                && Objects.equals(committedUseDiscountOptions, that.committedUseDiscountOptions)
                && Objects.equals(totalEstimatedCost, that.totalEstimatedCost)
                && Objects.equals(expectedMachineType, that.expectedMachineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystemSoftware, provisioningModel, machineFamily, series,
                machineType, gpuModel, numberOfGpus, localSsd, region, committedUseDiscountOptions,
                totalEstimatedCost, expectedMachineType);
    }
}
