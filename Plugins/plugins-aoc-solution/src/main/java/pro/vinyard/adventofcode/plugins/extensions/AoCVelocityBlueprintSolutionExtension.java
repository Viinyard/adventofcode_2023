package pro.vinyard.adventofcode.plugins.extensions;

import org.apache.velocity.VelocityContext;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.vinyard.adventofcode.core.Solution;
import pro.vinyard.adventofcode.plugins.core.SolutionFilter;
import pro.vinyard.adventofcode.plugins.core.SolutionResult;
import pro.vinyard.adventofcode.plugins.core.SolutionRetriever;
import pro.vinyard.plugins.api.VelocityBlueprintExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Extension
public class AoCVelocityBlueprintSolutionExtension implements VelocityBlueprintExtension {
    Logger logger = LoggerFactory.getLogger(AoCVelocityBlueprintSolutionExtension.class);

    private SolutionFilter args = new SolutionFilter();

    @Override
    public void init(VelocityContext context) {
        args = new SolutionFilter();
        context.put("aoc-solutions", this);
    }

    public void year(String year) {
        logger.debug("year: {}", year);
        args.add(SolutionFilter.SolverArgumentType.YEAR, year);
    }

    public void day(String day) {
        logger.debug("day: {}", day);
        args.add(SolutionFilter.SolverArgumentType.DAY, day);
    }

    public void part(String part) {
        logger.debug("part: {}", part);
        args.add(SolutionFilter.SolverArgumentType.PART, part);
    }

    public void tags(String tags) {
        logger.debug("tags: {}", tags);
        args.add(SolutionFilter.SolverArgumentType.TAGS, tags);
    }

    public void description(String description) {
        logger.debug("description: {}", description);
        args.add(SolutionFilter.SolverArgumentType.DESCRIPTION, description);
    }

    public void link(String link) {
        logger.debug("link: {}", link);
        args.add(SolutionFilter.SolverArgumentType.LINK, link);
    }

    public String nanoToSeconds(long nano) {
        BigDecimal seconds = BigDecimal.valueOf(nano).divide(BigDecimal.valueOf(1_000_000_000), 6, RoundingMode.HALF_UP);
        DecimalFormat df = new DecimalFormat("#,##0.######");
        return df.format(seconds);
    }

    public String nanoToMillis(long nano) {
        BigDecimal millis = BigDecimal.valueOf(nano).divide(BigDecimal.valueOf(1_000_000), 6, RoundingMode.HALF_UP);
        DecimalFormat df = new DecimalFormat("#,##0.######");
        return df.format(millis);
    }

    public List<SolutionResult<?>> getSolutions() {
        List<Solution<?>> solutionList = SolutionRetriever.retrieve(args);
        logger.info("Solutions found : {}", solutionList.stream().map(Solution::getClass).map(Class::getSimpleName).collect(Collectors.joining(", ")));
        return solutionList.stream().map(SolutionResult::new)
                .collect(Collectors.toList());
    }
}
