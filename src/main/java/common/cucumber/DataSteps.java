package common.cucumber;

import common.etl.ETLSteps;
import io.cucumber.java.en.Given;

import static common.setup.Hooks.AssertExecutedStep;
import static common.setup.Hooks.VerifyExecutedStep;

public class DataSteps extends ETLSteps{

    @Given("I read the {} file from {}")
    public void IReadFileFrom(String file, String path){
        VerifyExecutedStep(ETLSteps.readMyFile(file,path));
    }

    @Given("I diff {} and write into {} in {}")
    public void IDiffFilesAndWriteInto(String diff, String file, String path){
        VerifyExecutedStep(ETLSteps.diffMyFilesAndWriteInto(diff,file,path));
    }

    @Given("I open the {}" on {}" from the {}")
    public void IOpenFileOnWorkbook(String file, String workbook, String path) {
        AssertExecutedStep(ETLSteps.openMyWorkbook(file,workbook, path));
    }

    @Given("I close the {} on {}")
    public void ICloseWorkbook(String file, String workbook) {
        AssertExecutedStep(ETLSteps.closeMyWorkbook(file, workbook));
    }

    @Given("I save and close the {} on {}")
    public void ISaveAndCloseWorkbook(String file, String workbook) {
        AssertExecutedStep(ETLSteps.saveAndCloseMyWorkbook(file, workbook));
    }

    @Given("I save the {}" on {}")
    public void ISaveFileOnWorkbook(String file, String workbook) {
        AssertExecutedStep(ETLSteps.saveMyWorkbook(file, workbook));
    }

    @Given("I update the {} by the {} by {}")
    public void IUpdateTheDBFileByDBTheFile(String workbookName1, String workbookName2, String myKey) {
        AssertExecutedStep(ETLSteps.updateMyDatabaseWorkbook(workbookName1,workbookName2, myKey));
    }


}
