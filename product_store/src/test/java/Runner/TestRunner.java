package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	

		    @CucumberOptions(
		    		 features = "src/test/resources/feature",
		    		    glue = {"stepdefinitions", "utils"},


		            plugin = {
		                    "pretty",
		                    "html:target/cucumberReports/cucumber-pretty.html",
		                    "json:target/cucumberReports/cucumber-TestReport.json",
		                    "rerun:target/cucumberReports/rerun.txt",
		                    "junit:target/cucumberReports/cukes.xml"	      
		                    
		            },
		            dryRun = false,
		            monochrome = true,
		            tags = "@Smoke"


		            )
						

		           
		    public class TestRunner extends AbstractTestNGCucumberTests  {

		    	

		    }

