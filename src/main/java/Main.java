public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        Person dad = new PersonBuilder()
                .setName("Семён")
                .setSurname("Вольф")
                .build();

        System.out.println(mom);
        System.out.println("У " + mom.getName() + " есть сын, " + son);

        System.out.println("У " + son.getName() + " появился отец:" + '\n' + dad);
        dad.setAddress(mom.getAddress()); // Отец обрёл дом
        System.out.println("Теперь " + dad.getName() + " будет жить вместе со своей семьёй в г." + dad.getAddress());


        try {
            // С ДНЁМ РОЖДЕНИЯ!
            son.setAge(100);   // Далее увидим сколько лет 'son'

            System.out.println("Прошёл год");
            son.happyBirthday();
            System.out.println(son.getName() + " С ДНЁМ РОЖДЕНИЯ! Теперь тебе: " + son.getAge() + " год.");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Если возраст не был указан, то НИКАКОГО ДНЯ РОЖДЕНИЯ!
            dad.happyBirthday();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
