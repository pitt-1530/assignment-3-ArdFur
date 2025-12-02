package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("bpms must not be null or empty");
        }

        double sum = 0.0;
        for (Integer b : bpms) {
            if (b == null) {
                throw new IllegalArgumentException("bpms must not contain null entries");
            }
            sum += b;
        }
        double avg = sum / bpms.size();

        if (avg >= 140.0) {
            return "HIGH";
        } else if (avg >= 100.0) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        if (title == null) return false;
        if (title.length() < 1 || title.length() > 30) return false;
        // Only letters and spaces allowed
        if (!title.matches("^[A-Za-z ]+$")) return false;
        // Must contain at least one alphabetic character (not only spaces)
        if (!title.matches(".*[A-Za-z].*")) return false;
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        if (volumeDb < 0) return 0;
        if (volumeDb > 100) return 100;
        return volumeDb;
    }
}
