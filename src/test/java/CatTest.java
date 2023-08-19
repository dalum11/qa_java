import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    Cat cat = new Cat(new Feline());

    @Test
    public void getSoundReturnMeowTrue(){
        Assert.assertEquals("У кошки ожидается другой звук", "Мяу", cat.getSound());
    }

    @Test
    public void getSoundReturnBarkFalse(){
        Assert.assertNotEquals("Звук у кошки соответствует указанному результату", "Гав", cat.getSound());
    }

    @Test
    public void checkFoodMeatTrue() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Для этого животного используется другой корм", food, cat.getFood());
    }

    @Test
    public void checkFoodGrassFalse() throws Exception {
        List<String> food = List.of("Трава", "Различные растения");
        Assert.assertNotEquals("Для этого животного используется другой корм", food, cat.getFood());
    }
}
