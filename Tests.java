import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;
public class Tests{

    @Test
    public void shouldThrowNumberFormatException(){
        Exception exception = assertThrows(NumberFormatException.class, () -> Integer.decode(""));
        assert "Zero length string".equals(exception.getMessage());
    }

    @Test
    public void Test_InvalidFormatNumber(){
        var exception = assertThrows(NumberFormatException.class, () -> Integer.decode("#-25"));

        assert "Sign character in wrong position".equals(exception.getMessage());
    }

    @Test
    public void shouldDecodeNegativeNumber(){
        assert -21 == Integer.decode("-21");
    }
    @Test
    public void shouldDecodeSimpleNumber(){
        assert 21 == Integer.decode("21");
    }

    @Test
    public void shouldDecode16RadixNumber(){
        assert 0X12 == Integer.decode("0X12");
        assert 0x12 == Integer.decode("0x12");
        assert 0x12 == Integer.decode("0X12");
        assert 0X12 == Integer.decode("0x12");

        assert 0x12 == Integer.decode("#12");
    }

    @Test
    public void shouldDecode8RadixNumber(){
        assert 012 == Integer.decode("012");
    }


    @Test
    public void shouldDecodeNegativeNumbers(){
        assert -12 == Integer.decode("-12");
        assert -012 == Integer.decode("-012");
        assert -0x12 == Integer.decode("-0x12");
        assert -0x12 == Integer.decode("-#12");
    }

}

