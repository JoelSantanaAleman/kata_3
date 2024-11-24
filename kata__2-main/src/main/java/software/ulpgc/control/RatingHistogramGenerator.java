package software.ulpgc.control;

import software.ulpgc.model.Histogram;
import software.ulpgc.model.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RatingHistogramGenerator {
    public Histogram generate(List<Rating> ratings){
        Map<String, Integer> map = new TreeMap<>();

        for(Rating rating : ratings){
            double averageRating = rating.getAverageRating();
            int numVotes = rating.getNumVotes();

            int range = (int) Math.floor(averageRating);
            if(range >= 10) range = 9;
            String rangeLabel = range +"-" +(range+1);

            map.putIfAbsent(rangeLabel, 0);
            map.compute(rangeLabel, (k, v)-> v + numVotes);
        }
        return new FromMapHistogram(map);
    }

    private static class FromMapHistogram implements Histogram{
        private final Map<String, Integer> histogram;

        private FromMapHistogram(Map<String, Integer> histogram) {
            this.histogram = histogram;
        }

        @Override
        public String title() {
            return "Votes Average";
        }

        @Override
        public List<String> labels() {
            return new ArrayList<>(histogram.keySet());
        }

        @Override
        public int valueOf(String label) {
            return histogram.get(label);
        }
    }
}
