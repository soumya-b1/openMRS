package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
(       features="classpath:Feature/", // pick from src/test/resources
        glue="stepDef", //pick from src/test/java
        tags="not @Appointment ",
        plugin = {"pretty",  // produce verbose report  
                "html:target/cucumber-report/report.html", //generate HTML here
                "json:target/cucumber-report/cucumber.json", //to be post processed by user/other tools
                "junit:target/cucumber-report/cucumberJunit.xml",},
                //"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, //can be used to generate visual reports by user/other tools                
        monochrome=true,  //readable output in console, default false
        dryRun=false //execute the stepdef file, if true it will just map the feature file to step def file
        )

public class JRunnerTest extends AbstractTestNGCucumberTests{
	
}
