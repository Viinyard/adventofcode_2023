package dev.vinyard.aoc.plugins.extensions;

import dev.vinyard.aoc.plugins.core.SolutionFilter;
import dev.vinyard.aoc.plugins.core.SolutionResult;
import dev.vinyard.aoc.plugins.core.SolutionRetriever;
import dev.vinyard.aoc.plugins.solution.api.Solution;
import dev.vinyard.bp.plugins.api.BluePrinterExtension;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.VelocityContext;
import org.pf4j.Extension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Extension
@Slf4j
public class AoCVelocityBlueprintSolutionExtension implements BluePrinterExtension {

    private static SolutionFilter args = new SolutionFilter();

    public void classLoader(String path) {
        log.debug("classLoader: {}", path);
        args.add(SolutionFilter.SolverArgumentType.CLASSLOADER, path);
    }

    @Override
    public void init(VelocityContext context) {
        args = new SolutionFilter();
        log.info("adding aocSolutions to velocity context.");
        context.put("aocSolutions", this);
    }

    public static void year(String year) {
        log.debug("year: {}", year);
        args.add(SolutionFilter.SolverArgumentType.YEAR, year);
    }

    public static void day(String day) {
        log.debug("day: {}", day);
        args.add(SolutionFilter.SolverArgumentType.DAY, day);
    }

    public static void part(String part) {
        log.debug("part: {}", part);
        args.add(SolutionFilter.SolverArgumentType.PART, part);
    }

    public static void tags(String tags) {
        log.debug("tags: {}", tags);
        args.add(SolutionFilter.SolverArgumentType.TAGS, tags);
    }

    public static void description(String description) {
        log.debug("description: {}", description);
        args.add(SolutionFilter.SolverArgumentType.DESCRIPTION, description);
    }

    public static void link(String link) {
        log.debug("link: {}", link);
        args.add(SolutionFilter.SolverArgumentType.LINK, link);
    }

    public static String nanoToSeconds(long nano) {
        BigDecimal seconds = BigDecimal.valueOf(nano).divide(BigDecimal.valueOf(1_000_000_000), 6, RoundingMode.HALF_UP);
        DecimalFormat df = new DecimalFormat("#,##0.######");
        return df.format(seconds);
    }

    public static String nanoToMillis(long nano) {
        BigDecimal millis = BigDecimal.valueOf(nano).divide(BigDecimal.valueOf(1_000_000), 6, RoundingMode.HALF_UP);
        DecimalFormat df = new DecimalFormat("#,##0.######");
        return df.format(millis);
    }

    public static List<SolutionResult<?>> getSolutions() {
        log.info("Solutions list requested");
        List<Solution<?>> solutionList = SolutionRetriever.retrieve(args);
        log.info("Solutions found : {}", solutionList.stream().map(Solution::getClass).map(Class::getSimpleName).collect(Collectors.joining(", ")));
        return solutionList.stream().map(SolutionResult::new)
                .collect(Collectors.toList());
    }
}
