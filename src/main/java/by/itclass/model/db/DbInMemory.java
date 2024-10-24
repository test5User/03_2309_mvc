package by.itclass.model.db;

import by.itclass.model.entities.User;

import java.util.List;

public class DbInMemory {
    private static List<User> users = List.of(
            new User(1, "Vasia Pupkin", 25, "vasia@gmail.com"),
            new User(2, "Ivan Ivanov", 23, "vano@gmail.com"),
            new User(3, "Gena Genadievich", 55, "gena@gmail.com"),
            new User(4, "Svetlana Svetlaya", 22, "svetik@gmail.com")
    );

    public static boolean isPresent(String fio) {
        return users.stream()
                .anyMatch(it -> it.getFio().equalsIgnoreCase(fio));
    }
}