package lesson.dao;

import lesson.models.Human;

import java.util.ArrayList;

public class DBmanager {
    //создаём статичный список из объектов Human
    private static ArrayList<Human> humans = new ArrayList<Human>();
    //заполняем его
    static {
        humans.add(new Human(1, 12, "John"));
        humans.add(new Human(2, 13, "Lennon"));
        humans.add(new Human(3, 14, "Is"));
        humans.add(new Human(4, 15, "Alive"));
    }
    /* для метода add создаём статичную переменную id
     чтобы с каждой итерацией статично обновлять её для конструктора */
    private static int id = 5;
    //пишем статичный метод для вытаскивания всех Human'ов
    public static ArrayList<Human> getAllHumans() {
        return humans;
    }
    //метода для длобавления в список humans
    public static void addHuman(Human human) {
        //добавили наш статичный id который равен 5 для нового объекта
        human.setId(id);
        //добавили сам объет, поля взяди из request которые вбил юзео
        humans.add(human);
        //+1 для нашего статичного id, что бы потом опять добавить его в поле id human (смотри на две строки выше)
        id++;
    }
    // метод удаления из списка по id
    public static void deleteHuman(int id) {
        //открыли цикл
        for (int i = 0; i < humans.size(); i++) {
            // условие => если id элемента из списка humans равно id в аргументе, то ->
            if (humans.get(i).getId() == id) {
                //удали этот элемент из списка
                humans.remove(i);
            }
        }

    }
    // метод, чтобы вытащить из списка объет по Id
    public static Human getHumanById(int id) {
        // открываем цикл
        for (Human human : humans) {
            // еслт элемент списка имеет id равный id из аргумента, то ->
            if (human.getId() == id) {
                //верни нам этот объект
                return human;
            }
            //если нет... жаль
        }return null;
    }
    //метод изменения полей у объета human
    public static void changeHuman(int id, String name, int age) {
        //открываем цикл
        for (int i = 0; i < humans.size() ; i++) {
            //условие => если Id элемента списка равен id из аргумента, то ->
            if(humans.get(i).getId() == id){
                // у этого объетка замени name на name из аргументов
                humans.get(i).setName(name);
                // и age аналогично смени
                humans.get(i).setAge(age);
                // если впишешь 666, то программа должан остановиться с ошибкой
                assert (age == 666);
            }
        }
    }

}
