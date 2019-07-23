package practice;

import org.mockito.ArgumentMatcher;
import vo.Student;

class StudentMatcher extends ArgumentMatcher<Student> {
    private Student expected;

    StudentMatcher(Student expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Object o) {
        Student actual = (Student) o;
        return expected.getName().equals(actual.getName()) &&
                expected.getScore() == actual.getScore();
    }
}
