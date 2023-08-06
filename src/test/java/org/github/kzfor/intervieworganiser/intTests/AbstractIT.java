package org.github.kzfor.intervieworganiser.intTests;


import org.github.kzfor.intervieworganiser.intTests.initializers.PostgresContainerInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = {PostgresContainerInitializer.class})
public abstract class AbstractIT {
}
