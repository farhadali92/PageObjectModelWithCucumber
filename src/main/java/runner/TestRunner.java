package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\Automation\\Projects\\PageObjectModelWithCucumber\\src\\main\\java\\features"
        , glue = {"stepDefinitions"}
        //,format={"pretty", "html:testResult.html","json:testResultJson.json", "junit:testResultXml.xml"}
        //,dryRun = true
        //,monochrome = true   // it will generate output in readable format
        //,strict = true  // it will fail execution if undefined steps found.

)
public class TestRunner {



}