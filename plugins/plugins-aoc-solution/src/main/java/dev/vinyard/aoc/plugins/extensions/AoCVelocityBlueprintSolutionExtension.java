package dev.vinyard.aoc.plugins.extensions;

import dev.vinyard.aoc.plugins.core.SolutionFilter;
import dev.vinyard.aoc.plugins.core.SolutionInfo;
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
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Extension
@Slf4j
public class AoCVelocityBlueprintSolutionExtension implements BluePrinterExtension {

    private SolutionFilter args = new SolutionFilter();

    public AoCVelocityBlueprintSolutionExtension classLoader(String path) {
        log.info("classLoader: {}", path);
        args.add(SolutionFilter.SolverArgumentType.CLASSLOADER, path);
        return this;
    }

    @Override
    public void init(VelocityContext context) {
        args = new SolutionFilter();
        log.info("adding aocSolutions to velocity context.");
        context.put("aocSolutions", this);
    }

    public AoCVelocityBlueprintSolutionExtension year(String year) {
        log.info("year: {}", year);
        args.add(SolutionFilter.SolverArgumentType.YEAR, year);
        return this;
    }

    public AoCVelocityBlueprintSolutionExtension day(String day) {
        log.info("day: {}", day);
        args.add(SolutionFilter.SolverArgumentType.DAY, day);
        return this;
    }

    public AoCVelocityBlueprintSolutionExtension part(String part) {
        log.info("part: {}", part);
        args.add(SolutionFilter.SolverArgumentType.PART, part);
        return this;
    }

    public AoCVelocityBlueprintSolutionExtension tags(String tags) {
        log.info("tags: {}", tags);
        args.add(SolutionFilter.SolverArgumentType.TAGS, tags);
        return this;
    }

    public AoCVelocityBlueprintSolutionExtension description(String description) {
        log.info("description: {}", description);
        args.add(SolutionFilter.SolverArgumentType.DESCRIPTION, description);
        return this;
    }

    public AoCVelocityBlueprintSolutionExtension link(String link) {
        log.info("link: {}", link);
        args.add(SolutionFilter.SolverArgumentType.LINK, link);
        return this;
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
        log.info("Solutions list requested");
        List<Solution<?>> solutionList = SolutionRetriever.retrieve(args);
        log.info("Solutions found : {}", solutionList.stream().map(Solution::getClass).map(Class::getSimpleName).collect(Collectors.joining(", ")));
        return solutionList.stream().map(SolutionResult::new)
                .collect(Collectors.toList());
    }

    public SolutionResult<?> getLastSolution() {
        return getSolutions().stream().reduce((first, second) -> second).orElse(null);
    }

    public SolutionInfo getCurrentSolution() {
        return Optional.ofNullable(getLastSolution()).map(s -> new SolutionInfo(s.getYear(), s.getDay(), s.getPart())).orElseGet(() -> new SolutionInfo(Calendar.getInstance().get(Calendar.YEAR), 1, 1));
    }

    public SolutionInfo getNextSolution() {
        SolutionInfo currentSolution = getCurrentSolution();

        log.info("Current solution: {}", currentSolution);

        int year = currentSolution.year();
        int part = currentSolution.part();
        int day = currentSolution.day();

        part++;

        if (part > 2) {
            day++;
            part = 1;
        }

        if (day > 25) {
            year++;
            day = 1;
            part = 1;
        }

        SolutionInfo nextSolution = new SolutionInfo(year, day, part);

        log.info("Current solution: {}", currentSolution);

        return nextSolution;
    }
}
