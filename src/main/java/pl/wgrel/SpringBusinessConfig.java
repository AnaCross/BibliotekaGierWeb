package pl.wgrel;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = { "pl.wgrel" }, excludeFilters = {
        @Filter(type = FilterType.REGEX, pattern = "pl\\.wgrel\\.web\\..*") })
public class SpringBusinessConfig {

}