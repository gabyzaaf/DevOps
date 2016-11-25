import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zaafranigabriel on 26/11/2016.
 */
public class UnitTest {




    @Test
    public void shouldaddUser(){
        Webservices webservices = new Webservices();
        String values = webservices.sendPost("zaafrani","gabriel");
        Assert.assertTrue(values.contains("OK"));
    }


    @Test
    public void shouldRetournIdUser(){
        Webservices webservices = new Webservices();
        String values = webservices.sendGet("zaafrani","gabriel");
        Assert.assertTrue(values.contains("zaafrani") && values.contains("gabriel"));
    }



}
