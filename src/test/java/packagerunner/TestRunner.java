package packagerunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        glue="stepdefs",
        tags="",
        plugin = {"pretty", 
            "html:target/html/htmlreport.html",
            "json:target/json/file.json",
            },
        publish=true,
        monochrome=true,
        dryRun=false // to tell whether to test run(true) or actual run(false)
        )


public class TestRunner {
    //Class will be Emptity.
    //Nothing goes here
    //So do not get confused
}