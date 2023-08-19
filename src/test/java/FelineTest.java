import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {

    private List<String> food;
    private String family;
    private int kittensCountByDefault;
    private int kittensCountOverride;

    public FelineTest(List<String> food, String family, int kittensCountByDefault, int kittensCountOverride) {
        this.food = food;
        this.family = family;
        this.kittensCountByDefault = kittensCountByDefault;
        this.kittensCountOverride = kittensCountOverride;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {List.of("Животные", "Птицы", "Рыба"), "Кошачьи", 1, 3}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Spy
    Feline feline;

    @Test
    public void eatMeatReturnListOfMeatFood() throws Exception{
        Assert.assertEquals("Для этого животного указаны другие продукты питания", food, feline.eatMeat());
    }

    @Test
    public void getFamilyReturnFeline() {
        Assert.assertEquals("Возвращается другое семейство", family, feline.getFamily());
    }

    @Test
    public void getKittensCountEqualsOne() {
        Assert.assertEquals("Возвращается другое количество котят", kittensCountByDefault, feline.getKittens());
    }

    @Test
    public void getKittensCountEqualsExpected(){
        Assert.assertEquals("Возвращается другое количество котят", kittensCountOverride, feline.getKittens(kittensCountOverride));
    }
}
