package org.example.app.Tests;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.example.domain.Student;
import org.example.domain.Tema;
import org.example.validation.TemaValidator;
import org.junit.Test;
import org.example.validation.StudentValidator;
import org.example.validation.ValidationException;

import static org.junit.Assert.assertThrows;

public class TestService {
    @Test
    public void testAddStudentWithValidData() {
        // Arrange
        Student student = new Student("12345", "John Doe", 5, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act
        assertDoesNotThrow(() -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithEmptyID() {
        // Arrange
        Student student = new Student("", "John Doe", 5, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithEmptyName() {
        // Arrange
        Student student = new Student("12345", "", 5, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithNegativeGroup() {
        // Arrange
        Student student = new Student("12345", "John Doe", -5, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithPositiveGroup() {
        // Arrange
        Student student = new Student("12345", "John Doe", 1023, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithNullEmail() {
        // Arrange
        Student student = new Student("12345", "John Doe", 5, null);
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithEmptyEmail() {
        // Arrange
        Student student = new Student("12345", "John Doe", 5, "");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithMaxGroup() {
        // Arrange
        Student student = new Student("12345", "John Doe", Integer.MAX_VALUE, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithMaxGroupMinusOne() {
        // Arrange
        Student student = new Student("12345", "John Doe", Integer.MAX_VALUE - 1, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithMaxGroupPlusOne() {
        // Arrange
        Student student = new Student("12345", "John Doe", Integer.MAX_VALUE + 1, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithMinGroup() {
        // Arrange
        Student student = new Student("12345", "John Doe", 0, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithMinMinusOneGroup() {
        // Arrange
        Student student = new Student("12345", "John Doe", -1, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithMinPlusOneGroup() {
        // Arrange
        Student student = new Student("12345", "John Doe", 1, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validate(student));
    }

    @Test
    public void testAddStudentWithValidEmail() {
        // Arrange
        Student student = new Student("12345", "John Doe", 1, "john@example.com");
        StudentValidator validator = new StudentValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validate(student));
    }

    @Test
    public void testAddTemaWithValidData() {
        // Arrange
        Tema tema = new Tema("1", "Descriere tema", 5, 1);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validate(tema));
    }

    @Test
    public void testAddTemaWithEmptyNrTema() {
        // Arrange
        Tema tema = new Tema("", "Descriere tema", 5, 1);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(tema));
    }


    @Test
    public void testAddTemaWithEmptyDescriere() {
        // Arrange
        Tema tema = new Tema("1", "", 5, 1);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(tema));
    }

    @Test
    public void testAddTemaWithNegativeDeadline() {
        // Arrange
        Tema tema = new Tema("1", "Descriere tema", -5, 1);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(tema));
    }

    @Test
    public void testAddTemaWithZeroPrimire() {
        // Arrange
        Tema tema = new Tema("1", "Descriere tema", 5, 0);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(tema));
    }
    @Test
    public void testAddTemaWithDeadlineEqualToPrimire() {
        // Arrange
        Tema tema = new Tema("1", "Descriere tema", 5, 5);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(tema));
    }

    @Test
    public void testAddTemaWithDeadlineBeforePrimire() {
        // Arrange
        Tema tema = new Tema("1", "Descriere tema", 5, 10);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(tema));
    }

    @Test
    public void testAddTemaWithNullNrTema() {
        // Arrange
        Tema tema = new Tema(null, "Descriere tema", 5, 1);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(tema));
    }

    @Test
    public void testAddTemaWithNullDescriere() {
        // Arrange
        Tema tema = new Tema("1", null, 5, 1);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(tema));
    }
    @Test
    public void testAddTemaWithZeroDeadline() {
        // Arrange
        Tema tema = new Tema("1", "Descriere tema", 0, 1);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(tema));
    }

    @Test
    public void testAddTemaWithNegativePrimire() {
        // Arrange
        Tema tema = new Tema("1", "Descriere tema", 5, -1);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertThrows(ValidationException.class, () -> validator.validate(tema));
    }

    @Test
    public void testAddTemaWithMaxDeadline() {
        // Arrange
        Tema tema = new Tema("1", "Descriere tema", Integer.MAX_VALUE, 1);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validate(tema));
    }

    @Test
    public void testAddTemaWithMaxPrimire() {
        // Arrange
        Tema tema = new Tema("1", "Descriere tema", 5, Integer.MAX_VALUE);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validate(tema));
    }

    @Test
    public void testAddTemaWithMaxPrimireMinusOne() {
        // Arrange
        Tema tema = new Tema("1", "Descriere tema", 5, Integer.MAX_VALUE - 1);
        TemaValidator validator = new TemaValidator();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validate(tema));
    }

}
