import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private List<String> food;
    private int kittensCount;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Spy
    Lion femaleLion = new Lion(new Feline(), "Самка");

    @Spy
    Lion maleLion = new Lion(new Feline(), "Самец");

    public LionTest(List<String> food, int kittensCount) throws Exception {
        this.food = food;
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {List.of("Животные", "Птицы", "Рыба"), 1}
        };
    }

    @Test
    public void checkFoodFemaleLion() throws Exception{
        Assert.assertEquals("Ожидается другая еда" , food, femaleLion.getFood());
        Assert.assertEquals("Ожидается другая еда" , food, maleLion.getFood());
    }

    @Test
    public void checkDependencyBetweenSexAndHasManeTrue(){
        boolean hasFemaleLionsMane = false;
        boolean hasMaleLionsMane = true;
        Assert.assertEquals("Ожидается другой результат наличия гривы", hasMaleLionsMane, maleLion.doesHaveMane());
        Assert.assertEquals("Ожидается другой результат наличия гривы", hasFemaleLionsMane, femaleLion.doesHaveMane());
    }

    @Test
    public void checkGettingExceptionWithLionOtherSex(){
        try {
            Lion otherLion = new Lion(new Feline(), "Other");
        } catch (Exception e) {
            System.out.println("Льва с таким полом не существует");
        }
    }

    @Test
    public void checkKittensCountByDefault() {
        Assert.assertEquals("Ожидается другое количество котят", kittensCount, femaleLion.getKittens());
        Assert.assertEquals("Ожидается другое количество котят", kittensCount ,maleLion.getKittens());
    }
}
