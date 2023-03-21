import java.util.HashMap;
import java.util.Map;

class Person {
    private final String name;
    private final String surname;

    private int age = -1;

    private String address = null;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void happyBirthday() {
        if (!hasAge()) {
            throw new IllegalStateException("НИКАКОГО ДНЯ РОЖДЕНИЯ! =( , так как не был указан возраст");
        }
        age++;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getAddress() {
        if (!hasAddress()) {
            return "не указан";
        }
        return address;
    }

    public void setAge(int age) {
        if(!hasAge())
            this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }

    @Override
    public String toString() {
        StringBuilder personInfo = new StringBuilder();
        personInfo.append("Имя: " + name + '\n' + "Фамилия: " + surname + '\n');
        if(hasAge()) {
            personInfo.append("Возраст: " + age + '\n');
        } else {
            personInfo.append("Возраст: не указан" + '\n');
        }
        personInfo.append("Адрес: " + getAddress() + '\r' + '\n');

        return personInfo.toString();
    }
}