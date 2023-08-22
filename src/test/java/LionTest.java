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
public class LionTest {

    public LionTest() throws Exception {
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Spy
    Lion femaleLion = new Lion(new Feline(), "Самка");

    @Spy
    Lion maleLion = new Lion(new Feline(), "Самец");


    @Test
    public void checkFoodFemaleLion() throws Exception{
        Assert.assertEquals("Ожидается другая еда" , List.of("Животные", "Птицы", "Рыба"), femaleLion.getFood());
        Assert.assertEquals("Ожидается другая еда" , List.of("Животные", "Птицы", "Рыба"), maleLion.getFood());
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
            Assert.fail("Должно выбрасываться исключение");
        } catch (Exception e) {
            System.out.println("Льва с таким полом не существует");
            Assert.assertEquals("Сообщение об ошибке некорректно", e.getMessage(),
                    "Используйте допустимые значения пола животного - самей или самка");
        }
    }

    @Test
    public void checkKittensCountByDefault() {
        Assert.assertEquals("Ожидается другое количество котят", 1, femaleLion.getKittens());
        Assert.assertEquals("Ожидается другое количество котят", 1 ,maleLion.getKittens());
    }
}
