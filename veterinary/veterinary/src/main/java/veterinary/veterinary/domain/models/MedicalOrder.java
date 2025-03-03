
package veterinary.veterinary.domain.models;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


public class MedicalOrder {

    private Long id;
    private Long petId;
    private String ownerIdNumber;
    private String veterinarianIdNumber;
    private String medication;
    private String dosage;
    private String generationDate;
}
