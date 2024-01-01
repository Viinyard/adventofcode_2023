package pro.vinyard.adventofcode.plugins.core;

import org.reflections.Reflections;
import pro.vinyard.adventofcode.core.Solution;
import pro.vinyard.adventofcode.core.annotation.AdventOfCodeSolution;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SolutionRetriever {

    public static List<Solution<?>> retrieve(SolutionFilter args) {
        Set<Class<?>> solutionClazz = new Reflections("pro.vinyard.adventofcode.soluce").getTypesAnnotatedWith(AdventOfCodeSolution.class);

        Predicate<Class<?>> annotationFilter = clazz -> clazz.isAnnotationPresent(AdventOfCodeSolution.class);
        Predicate<Class<?>> typeFilter = Solution.class::isAssignableFrom;
        Predicate<Class<?>> argsFilter = clazz -> args.filter(clazz.getAnnotation(AdventOfCodeSolution.class));

        Comparator<AdventOfCodeSolution> comparator = Comparator.comparingInt(AdventOfCodeSolution::year)
                .thenComparingInt(AdventOfCodeSolution::day)
                .thenComparingInt(AdventOfCodeSolution::part);

        return solutionClazz.stream().filter(Solution.class::isAssignableFrom)
                .filter(typeFilter.and(annotationFilter).and(argsFilter))
                .sorted((a, b) -> comparator.compare(a.getAnnotation(AdventOfCodeSolution.class), b.getAnnotation(AdventOfCodeSolution.class)))
                .map(clazz -> {
                    try {
                        return (Solution<?>) clazz.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
