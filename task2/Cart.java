package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Корзина
 *
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     *
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    //endregion

    /**
     * Балансировка корзины
     */

    public void cardBalancing1() {
        AtomicBoolean proteins = new AtomicBoolean(false);
        AtomicBoolean fats = new AtomicBoolean(false);
        AtomicBoolean carbohydrates = new AtomicBoolean(false);

        foodstuffs.stream().forEach(food -> {
            if (!proteins.get() && food.getProteins())
                proteins.set(true);
            else if (!fats.get() && food.getFats())
                fats.set(true);
            else if (!carbohydrates.get() && food.getCarbohydrates())
                carbohydrates.set(true);
            if (proteins.get() && fats.get() && carbohydrates.get())
                System.out.println("Корзина уже сбалансирована по БЖУ.");
            ;
        });
    }

    public void cardBalancing() {

        AtomicBoolean proteins1 = new AtomicBoolean(false);
        AtomicBoolean fats1 = new AtomicBoolean(false);
        AtomicBoolean carbohydrates1 = new AtomicBoolean(false);

        foodstuffs.stream().forEach(food -> {
            if (!proteins1.get() && food.getProteins()) {
                proteins1.set(true);
            } else if (!fats1.get() && food.getFats()) {
                fats1.set(true);
            } else if (!carbohydrates1.get() && food.getCarbohydrates()) {
                carbohydrates1.set(true);
            }
            if (proteins1.get() && fats1.get() && carbohydrates1.get()) {
                System.out.println("Корзина уже сбалансирована по БЖУ.");
            }
        });

        market.getThings(clazz).stream().forEach(thing -> {
            if (!proteins1.get() && thing.getProteins()) {
                proteins1.set(true);
                foodstuffs.add(thing);
            } else if (!fats1.get() && thing.getFats()) {
                fats1.set(true);
                foodstuffs.add(thing);
            } else if (!carbohydrates1.get() && thing.getCarbohydrates()) {
                carbohydrates1.set(true);
                foodstuffs.add(thing);
            }
            if (proteins1.get() && fats1.get() && carbohydrates1.get()) {
                System.out.println("Корзина сбалансирована по БЖУ.");
            } else {
                System.out.println("Невозможно сбалансировать корзину по БЖУ.");
            }
        });
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));

    }
}
