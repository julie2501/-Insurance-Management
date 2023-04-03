@RestController
@RequestMapping("/api")
public class InsuranceController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    private ClaimRepository claimRepository;

    // Clients APIs
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + id));
    }

    @PostMapping("/clients")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable Long id, @Valid @RequestBody Client updatedClient) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + id));
        client.setName(updatedClient.getName());
        client.setDateOfBirth(updatedClient.getDateOfBirth());
        client.setAddress(updatedClient.getAddress());
        client.setContactInformation(updatedClient.getContactInformation());
        return clientRepository.save(client);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + id));
        clientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Insurance Policies APIs
    @GetMapping("/policies")
    public List<InsurancePolicy> getAllPolicies() {
        return insurancePolicyRepository.findAll();
    }

    @GetMapping("/policies/{id}")
    public Insurance
