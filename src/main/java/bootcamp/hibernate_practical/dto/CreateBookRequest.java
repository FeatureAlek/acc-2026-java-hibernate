package bootcamp.hibernate_practical.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class CreateBookRequest {

    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(max = 255, message = "Author name cannot exceed 255 characters")
    @Pattern(regexp = "^\\p{L}+(?:[ .'-]\\p{L}+)*$", message = "Author name contains invalid characters")
    private String author;

    @NotBlank(message = "Genre is required")
    @Size(max = 100, message = "Genre cannot exceed 100 characters")
    @Pattern(
            regexp = "^\\p{L}+(?:[ .'-]\\p{L}+)*$",
            message = "Genre must contain only letters and spaces"
    )
    private String genre;

    @NotNull(message = "Publication year is required")
    @Min(value = 1440, message = "Publication year must be after the invention of printing")
    @Max(value = 2026, message = "Publication year cannot be in the future")
    private Integer publicationYear;
}