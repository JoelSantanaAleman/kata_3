package software.ulpgc.model;

public class Rating {
    private final String id;
    private final double averageRating;
    private final int numVotes;

    public Rating(String id, double averageRating, int numVotes) {
        this.id = id;
        this.averageRating = averageRating;
        this.numVotes = numVotes;
    }

    public String getId() {
        return id;
    }

    public int getNumVotes() {
        return numVotes;
    }

    public double getAverageRating() {
        return averageRating;
    }
}
