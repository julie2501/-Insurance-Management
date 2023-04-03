@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private LocalDate dateOfBirth;

    @NotBlank
    private String address;

    @NotBlank
    private String contactInformation;

    // getters and setters
}

@Entity
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String policyNumber;

    @NotNull
    private BigDecimal coverageAmount;

    @NotNull
    private BigDecimal premium;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // getters and setters
}

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String claimNumber;

    @NotBlank
    private String description;

    @NotNull
    private LocalDate claimDate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ClaimStatus claimStatus;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private InsurancePolicy policy;

    // getters and setters
}

public enum ClaimStatus {
    OPEN, CLOSED
}
