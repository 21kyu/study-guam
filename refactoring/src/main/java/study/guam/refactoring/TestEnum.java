package study.guam.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum TestEnum {
    TEST("test") {
        List getList() {
            return new ArrayList<>();
        }
    },
    NEW("new") {
        List getList() {
            return new LinkedList();
        }
    };

    private final String value;

    TestEnum(String value) {
        this.value = value;
    }

    abstract List getList();

    static TestEnum of(String value) {
        return Arrays.stream(values())
                .filter(v -> value.equals(v.value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong Value"));
    }
}
