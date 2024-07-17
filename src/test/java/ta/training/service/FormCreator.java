package ta.training.service;

import ta.training.model.CalculatorForm;

/**
 * Class responsible for creating and populating a CalculatorForm with test data.
 * @author Harvey C
 */
public class FormCreator {

    static final String NUMBER_OF_INSTANCES = "testdata.number.of.instances";
    static final String OPERATING_SYSTEM_SOFTWARE = "testdata.operating.system.software";
    static final String PROVISIONING_MODEL = "testdata.provisioning.model";
    static final String MACHINE_FAMILY = "testdata.machine.family";
    static final String SERIES = "testdata.series";
    static final String MACHINE_TYPE = "testdata.machine.type";
    static final String GPU_MODEL = "testdata.gpu.model";
    static final String NUMBER_OF_GPUS = "testdata.number.of.gpus";
    static final String LOCAL_SSD = "testdata.local.ssd";
    static final String REGION = "testdata.region";
    static final String COMMITTED_USE_DISCOUNT_OPTIONS = "testdata.committed.use.discount.options";
    static final String TOTAL_ESTIMATED_COST = "testdata.total.estimated.cost";
    static final String EXPECTED_MACHINE_TYPE = "testdata.expected.machine.type";


    /**
     * Creates a CalculatorForm object with fields filled from test data.
     *
     * @return a populated CalculatorForm object
     */
    public static CalculatorForm withFieldsFilled() {
        return new CalculatorForm(
                TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(OPERATING_SYSTEM_SOFTWARE),
                TestDataReader.getTestData(PROVISIONING_MODEL),
                TestDataReader.getTestData(MACHINE_FAMILY),
                TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(GPU_MODEL),
                TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(REGION),
                TestDataReader.getTestData(COMMITTED_USE_DISCOUNT_OPTIONS),
                TestDataReader.getTestData(TOTAL_ESTIMATED_COST),
                TestDataReader.getTestData(EXPECTED_MACHINE_TYPE)
        );
    }

}
