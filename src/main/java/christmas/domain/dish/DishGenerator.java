package christmas.domain.dish;

import static christmas.exception.constants.ErrorMessage.INVALID_ORDER;

import christmas.domain.dish.appetizer.CaesarSalad;
import christmas.domain.dish.appetizer.MushroomSoup;
import christmas.domain.dish.appetizer.Tapas;
import christmas.domain.dish.beverage.Champagne;
import christmas.domain.dish.beverage.Redwine;
import christmas.domain.dish.beverage.Zerocoke;
import christmas.domain.dish.dessert.ChocolateCake;
import christmas.domain.dish.dessert.Icecream;
import christmas.domain.dish.maindish.BarbecueLip;
import christmas.domain.dish.maindish.ChristmasPasta;
import christmas.domain.dish.maindish.SeafoodPasta;
import christmas.domain.dish.maindish.TBoneSteak;
import christmas.exception.EventPlannerException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DishGenerator {
    private static final Map<String, Supplier<Dish>> dishMap = new HashMap<>();

    static {
        dishMap.put("양송이수프", MushroomSoup::create);
        dishMap.put("타파스", Tapas::create);
        dishMap.put("시저샐러드", CaesarSalad::create);
        dishMap.put("티본스테이크", TBoneSteak::create);
        dishMap.put("바비큐립", BarbecueLip::create);
        dishMap.put("해산물파스타", SeafoodPasta::create);
        dishMap.put("크리스마스파스타", ChristmasPasta::create);
        dishMap.put("초코케이크", ChocolateCake::create);
        dishMap.put("아이스크림", Icecream::create);
        dishMap.put("제로콜라", Zerocoke::create);
        dishMap.put("레드와인", Redwine::create);
        dishMap.put("샴페인", Champagne::create);
    }

    public static Dish of(String name) {
        return dishMap.getOrDefault(name, () -> {
            // 있는 메뉴가 아닐 경우
            throw EventPlannerException.of(INVALID_ORDER);
        }).get();
    }
}
