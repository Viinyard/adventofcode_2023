package com.adventofcode.soluce.day5;

import lombok.Data;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ASD {

    @Data
    public static class Almanach {
        private List<Long> seeds;
        private List<Mapping> seedToSoil;
        private final UnaryOperator<Long> seedToSoilFunction = seed -> mapping(seed, seedToSoil);
        private List<Mapping> soilToFertilizer;
        private final UnaryOperator<Long> soilToFertilizerFunction = soil -> mapping(soil, soilToFertilizer);
        private List<Mapping> fertilizerToWater;
        private final UnaryOperator<Long> fertilizerToWaterFunction = fertilizer -> mapping(fertilizer, fertilizerToWater);
        private List<Mapping> waterToLight;
        private final UnaryOperator<Long> waterToLightFunction = water -> mapping(water, waterToLight);
        private List<Mapping> lightToTemperature;
        private final UnaryOperator<Long> lightToTemperatureFunction = light -> mapping(light, lightToTemperature);
        private List<Mapping> temperatureToHumidity;
        private final UnaryOperator<Long> temperatureToHumidityFunction = temperature -> mapping(temperature, temperatureToHumidity);
        private List<Mapping> humidityToLocation;
        private final UnaryOperator<Long> humidityToLocationFunction = humidity -> mapping(humidity, humidityToLocation);

        private final Function<Long, Long> seedToLocationFunction = seedToSoilFunction.andThen(soilToFertilizerFunction).andThen(fertilizerToWaterFunction).andThen(waterToLightFunction).andThen(lightToTemperatureFunction).andThen(temperatureToHumidityFunction).andThen(humidityToLocationFunction);

        public static Long mapping(Long value, List<Mapping> mappings) {
            return mappings.stream().filter(m -> m.contains(value)).findAny().map(m -> m.getDestination(value)).orElse(value);
        }
    }

    @Data
    public static class Mapping {
        private long source;
        private long destination;
        private long range;

        public Mapping(long destination, long source, long range) {
            this.source = source;
            this.destination = destination;
            this.range = range;
        }

        public long getDestination(long value) {
            return value - source + destination;
        }

        public boolean contains(long value) {
            return value >= source && value < source + range;
        }
    }


}
