package software.ulpgc;

import software.ulpgc.control.RatingHistogramGenerator;
import software.ulpgc.control.TsvFileRatingReader;
import software.ulpgc.model.Histogram;
import software.ulpgc.model.Rating;
import software.ulpgc.view.MainFrame;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/26joe/Documents/is2_tsv/title.ratings.tsv");
        List<Rating> ratings = new TsvFileRatingReader(file).read();

        RatingHistogramGenerator generator = new RatingHistogramGenerator();
        Histogram histogram = generator.generate(ratings);

        System.out.println(histogram.title());
        for(String label : histogram.labels()){
            System.out.println("AverageRating" + label + ":" + histogram.valueOf(label) + "votes");
        }

        SwingUtilities.invokeLater(()->{
            MainFrame mainFrame = new MainFrame();
            mainFrame.put(histogram);
            mainFrame.setVisible(true);
        });
    }
}
