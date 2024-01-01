package pro.vinyard.adventofcode.core;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import pro.vinyard.adventofcode.core.annotation.AdventOfCodeSolution;

import java.lang.annotation.Annotation;

public class SolutionResolver {

    public static SolutionInfo resolve(Solution<?> solution) {
        Annotation[] annotations = solution.getClass().getAnnotations();

        for (Annotation annotation : annotations) {
            Class<? extends Annotation> type = annotation.annotationType();
            if (type.equals(AdventOfCodeSolution.class)) {
                return SolutionInfo.builder()
                        .year(((AdventOfCodeSolution) annotation).year())
                        .day(((AdventOfCodeSolution) annotation).day())
                        .part(((AdventOfCodeSolution) annotation).part())
                        .description(((AdventOfCodeSolution) annotation).description())
                        .link(((AdventOfCodeSolution) annotation).link())
                        .tags(((AdventOfCodeSolution) annotation).tags())
                        .build();
            }
        }

        throw new RuntimeException("Solution must be annotated with AdventOfCodeSolution.class");
    }

    @RequiredArgsConstructor
    @Data
    @Builder
    @EqualsAndHashCode(exclude = {"description", "link", "tags"})
    public static class SolutionInfo {
        private final int year;
        private final int day;
        private final int part;
        private final String description;
        private final String link;
        private final String[] tags;
    }
}
