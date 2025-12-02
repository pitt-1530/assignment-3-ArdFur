package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {

    @Test
    public void placeholder() {
        assertTrue(true);
    }

    @Test
    public void classifyEnergy_lowMediumHighAndInvalid() {
        // LOW
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(java.util.Arrays.asList(60, 80)));
        // MEDIUM (avg 120)
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(java.util.Arrays.asList(100, 140)));
        // HIGH (avg 150)
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(java.util.Arrays.asList(140, 160)));
        // invalid input
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(null));
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(new java.util.ArrayList<>()));
    }

    @Test
    public void isValidTrackTitle_validAndInvalid() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Hello World"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("A"));
        // 30 characters
        String thirty = "ABCDEFGHIJABCDEFGHIJABCDEFGHIJ".substring(0, 30);
        assertTrue(PlaylistRecommender.isValidTrackTitle(thirty));

        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
        assertFalse(PlaylistRecommender.isValidTrackTitle(""));
        assertFalse(PlaylistRecommender.isValidTrackTitle("This#Song"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("     "));
        assertFalse(PlaylistRecommender.isValidTrackTitle("This title is definitely way too long to be valid"));
    }

    @Test
    public void normalizeVolume_clampsCorrectly() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-10));
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
    }
}
