package test.java;
import static org.junit.Assert.*;

import main.java.DecoderRLEData;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UnitTests {

    @Test
    public void positiveScenarios(){
        assertEquals("AAAAaaaBBBBBB\\12", DecoderRLEData.decoding("4A3a6B\\\\\\1\\2"));
        assertEquals("AaaaBB2", DecoderRLEData.decoding("1A3a2B\\2"));
        assertEquals("AaaaBB\\\\2", DecoderRLEData.decoding("1A3a2B\\\\\\\\\\2"));
        assertEquals("AAAAaaaBBBBBB\\12", DecoderRLEData.decoding("4A3a6B\\\\\\1\\2"));
    }

    @Test
    public void negativeScenarios(){
        assertNotEquals("AAAAaaaBBBBBB\\12",DecoderRLEData.decoding("4F5S"));
        assertNotEquals("AaaaBB2", DecoderRLEData.decoding("3333\\2"));
        assertNotEquals("AaaaBB\\\\2", DecoderRLEData.decoding("55\\\\\\\\\\\\\\2"));
        assertNotEquals("2222", DecoderRLEData.decoding("4A3a6B\\\\\\1\\\2"));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
        public void catchStringExceptions () {
        thrown.expect(StringIndexOutOfBoundsException.class);
        thrown.expectMessage("String index out of range");
        DecoderRLEData.decoding("\\\\\\");
        DecoderRLEData.decoding("-");
        DecoderRLEData.decoding("5-6");
    }

}
