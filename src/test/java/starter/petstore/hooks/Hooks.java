package starter.petstore.hooks;

import lombok.Getter;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.BeforeClass;

@Getter
public class Hooks {

	public static String petUrl;
	public static String fakeUrl;

	//private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
	@BeforeClass
	public static void init() {

		EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
		petUrl = environmentVariables.getProperty("restapi.baseurl");
		fakeUrl = environmentVariables.getProperty("restapi.fakerBaseUrl");
	}

}
